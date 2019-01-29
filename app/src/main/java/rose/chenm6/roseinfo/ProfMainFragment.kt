package rose.chenm6.roseinfo

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



private const val ARG_PROF = "ARG_PROF"

class ProfMainFragment : Fragment() {
    private var param1: String? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getParcelable(ARG_PROF)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.prof_main, container, false)
    }




//    companion object {
//
//        @JvmStatic
//        fun newInstance(param1: String) =
//            ProfMainFragment().apply {
//                arguments = Bundle().apply {
//                    putParcelable(ARG_PROF, param1)
//                }
//            }
//    }
}
