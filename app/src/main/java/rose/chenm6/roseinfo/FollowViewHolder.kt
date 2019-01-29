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

    fun bind(prof: Prof) {
        profNameTextView.text = prof.name
        profOfficeTextView.text = prof.office

    }
}