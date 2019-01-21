package rose.chenm6.roseinfo

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [LoginFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 *
 */
class LoginFragment : Fragment() {
    private var listener: OnStudentSelectedListener ?= null
    private var listener2: OnProfSelectedListener ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.login, container, false)
    }

    interface OnStudentSelectedListener {
        fun onStudentSelected(uri: Uri)
    }

    interface OnProfSelectedListener {
        fun onProfSelected(uri: Uri)
    }

}
