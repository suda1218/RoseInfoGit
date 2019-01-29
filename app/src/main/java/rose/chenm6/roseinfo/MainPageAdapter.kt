package rose.chenm6.roseinfo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class MainPageAdapter(
    var context: Context?,
    var listener: MainPageFragment.OnDocSelectedListener?
) : RecyclerView.Adapter<MainPageViewHolder>() {
    var profs = ArrayList<Prof>()

    init {
        profs.add(0,Prof("Test","Test","Test","Test","Test",0.toFloat(),0.toFloat(),0.toFloat(),"Test"))
    }


    override fun getItemCount() = profs.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainPageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_prof, parent, false)
        return MainPageViewHolder(view, this)
    }

    override fun onBindViewHolder(holder: MainPageViewHolder, position: Int) {
        holder.bind(profs[position])
    }

//    fun read() {
//        if (profs.isEmpty()) {
//            profs = utils.loadFromJsonArray(context)
//            profs = profs.sortedWith(compareByDescending<Prof> { it.rating }.thenBy { it.name })
//            notifyDataSetChanged()
//        }
//    }

    fun testadd(){
        profs.add(0,Prof("Test","Test","Test","Test","Test",0.toFloat(),0.toFloat(),0.toFloat(),"Test"))
        notifyItemInserted(0)
    }

    fun selectDocAt(position: Int) {
        listener?.onDocSelected(profs[position])
    }

}

