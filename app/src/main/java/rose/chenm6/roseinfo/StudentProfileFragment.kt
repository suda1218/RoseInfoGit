package rose.chenm6.roseinfo

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import kotlinx.android.synthetic.main.add_dialog.view.*
import kotlinx.android.synthetic.main.student_profile.*
import kotlinx.android.synthetic.main.student_profile.view.*

private const val ARG_STUDENT = "STUDENT"

class StudentProfileFragment : Fragment() {
    private var student:Student? = Student()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            student = it.getParcelable(ARG_STUDENT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.student_profile, container, false)
        view.student_name.text = student!!.name
        view.major.text = student!!.major
        view.email.text = student!!.email
        view.email.setOnClickListener{
            edit("email")
        }
        view.student_name.setOnClickListener{
            edit("name")
        }
        view.major.setOnClickListener{
            edit("major")
        }
        return view
    }

    fun edit(type:String){
        val builder = AlertDialog.Builder(context!!)
        //configure builder:title, Icon, message or custom view or list. Buttons (pos, neg, neutral)
        builder.setTitle("edit")
        val view = LayoutInflater.from(context).inflate(R.layout.add_dialog, null, false)
        view.edit_context.setText("edit")
        builder.setView(view)
        builder.setPositiveButton(android.R.string.ok,{_,_->
            val text = view.edit_context.text.toString()
            when(type){
                "name"->{
                    student_name.text = text
                }
                "major"->{
                    major.text = text
                }
                "email"->{
                    email.text = text
                }
            }

        } )
        builder.setNegativeButton(android.R.string.cancel, null)
        builder.create().show()
    }

    companion object {
        @JvmStatic
        fun newInstance(student:Student) =
            StudentProfileFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_STUDENT, student)
                }
            }
    }
}