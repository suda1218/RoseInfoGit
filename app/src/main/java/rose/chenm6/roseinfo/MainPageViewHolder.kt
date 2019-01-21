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

    private val profNameTextView = itemView.findViewById<TextView>(R.id.ProfNameTextView)
    private val profOfficeTextView = itemView.findViewById<TextView>(R.id.profOfficeTextView)
    private val profImage = itemView.findViewById<ImageView>(R.id.prof_image)

    init {
        itemView.setOnClickListener {
            adapter.selectDocAt(adapterPosition)
        }
    }


    fun bind(prof: Prof) {



//        ratingBar.setOnRatingBarChangeListener { bar, rating1, fromUser ->
//            if (fromUser) {
//
//            }
//        }
    }





}