package rose.chenm6.roseinfo

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


//private const val ARG_STUDENT = "ARG_STUDENT"

class FollowFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var student: Student? = null
    private var listener: OnFollowProfSelectedListener? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            student = it.getParcelable(ARG_STUDENT)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = FollowAdapter(activity,listener)
        val recyclerView =  inflater.inflate(R.layout.fragment_prof_list, container, false) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        return recyclerView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFollowProfSelectedListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


//    companion object {
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            FollowFragment().apply {
//                arguments = Bundle().apply {
//                    putParcelable(ARG_STUDENT,student)
//                }
//            }
//    }

    interface OnFollowProfSelectedListener{
        fun onFollowProfSelected(prof:Professor)
    }
}
