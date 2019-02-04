package rose.chenm6.roseinfo

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

private const val ARG_UID = "UID"

class MainPageFragment : Fragment() {
    private var uid: String? = null
    private var listener: OnDocSelectedListener? = null
    private lateinit var adapter:MainPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            uid = it.getString(ARG_UID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val recyclerView = inflater.inflate(R.layout.fragment_prof_list, container, false) as RecyclerView
        adapter = MainPageAdapter(activity, listener)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        return recyclerView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnDocSelectedListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnDocSelectedListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnDocSelectedListener {
        fun onDocSelected(prof: Prof)
    }

    companion object {
        @JvmStatic
        fun newInstance(uid: String) =
            MainPageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_UID, uid)
                }
            }
    }

}