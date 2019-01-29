package rose.chenm6.roseinfo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import kotlinx.android.synthetic.main.login.view.*
import kotlinx.android.synthetic.main.row_prof.view.*

class FollowViewHolder (itemView: View, val adapter:FollowAdapter): RecyclerView.ViewHolder(itemView) {


    private var profNameTextView = itemView.findViewById<TextView>(R.id.prof_image)
    private var profOfficeTextView = itemView.findViewById<TextView>(R.id.prof_office)

    init {

    }
<<<<<<< HEAD
    fun bind(prof: Prof){
        nameTextView.text = prof.name
        officeTextView.text = prof.name
        freeView.text =prof.name
        followView.text = prof.name
=======


    fun bind(prof: Prof) {
        profNameTextView.text = prof.name
        profOfficeTextView.text = prof.office

>>>>>>> 0425697ac9753f7423a38d290ab5d8b5d57a157f
    }
}