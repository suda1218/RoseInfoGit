package rose.chenm6.roseinfo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class FollowAdapter(var context: Context?, var listener:FollowFragment.OnFollowProfSelectedListener?) : RecyclerView.Adapter<FollowViewHolder>(){
    private var profs = ArrayList<Prof>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_prof, parent, false)
        return FollowViewHolder(view, this)
    }

    override fun onBindViewHolder(holder: FollowViewHolder, position: Int) {
        holder.bind(profs[position])
    }
    override fun getItemCount() = profs.size


    fun selectFollowProf(position: Int){
        listener?.onFollowProfSelected(profs[position])
    }

    fun edit(){
    //todo: need further discussion to implement
    }


}