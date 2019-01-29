package rose.chenm6.roseinfo

import android.graphics.drawable.Drawable
import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class MainPageViewHolder(itemView: View, val adapter: MainPageAdapter) :
    RecyclerView.ViewHolder(itemView) {

    private var profNameTextView = itemView.findViewById<TextView>(R.id.prof_name)
    private var profOfficeTextView = itemView.findViewById<TextView>(R.id.prof_office)

    init {
        itemView.setOnClickListener {
            adapter.selectDocAt(adapterPosition)
        }
    }


    fun bind(prof: Prof) {
        profNameTextView.text = prof.name
        profOfficeTextView.text = prof.office

    }





}