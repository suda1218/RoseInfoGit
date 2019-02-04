package rose.chenm6.roseinfo

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_splash.view.*


class SplashFragment : Fragment() {

    var listener: OnLoginButtonPressedListener? = null
    var listener2: OnRoseButtonPressedListener? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        view.rose_button.setOnClickListener{
            listener2?.onRoseButtonPressed()
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnLoginButtonPressedListener) {
            listener = context
            if(context is OnRoseButtonPressedListener){
                listener2 = context
            }
        } else {
            throw RuntimeException(context.toString() + " must implement OnLoginButtonPressedListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
        listener2 = null
    }


    interface OnLoginButtonPressedListener {
        fun onLoginButtonPressed()
    }

    interface  OnRoseButtonPressedListener{
        fun onRoseButtonPressed()
    }
}
