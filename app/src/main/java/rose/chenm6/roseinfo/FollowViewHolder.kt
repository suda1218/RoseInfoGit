package rose.chenm6.roseinfo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import kotlinx.android.synthetic.main.login.view.*
import kotlinx.android.synthetic.main.row_prof.view.*

class FollowViewHolder (itemView: View, val adapter:FollowAdapter, val context: Context): RecyclerView.ViewHolder(itemView){

    private val nameTextView = itemView.findViewById<TextView>(R.id.prof_name)
    private val officeTextView = itemView.findViewById<TextView>(R.id.)
    private val freeView = itemView.findViewById<TextView>(R.id.)
    private val followView = itemView.findViewById<TextView>(R.id.)
    //etc.......

    init {
        rateTextView.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            adapter.edit(adapterPosition,rateTextView.rating.toFloat())
            adapter.sortAnimal()
        }
        itemView.setOnClickListener {
            adapter.selectFollowProf(adapterPosition)
        }
    }
    fun bind(prof: Professor){
        nameTextView.text = prof.name
        officeTextView.text = prof.name
        freeView.text =prof.name
        followView.text = prof.name
    }
}