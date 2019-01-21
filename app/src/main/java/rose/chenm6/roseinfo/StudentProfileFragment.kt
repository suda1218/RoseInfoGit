package rose.chenm6.roseinfo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

private const val ARG_DOC = "doc"

class StudnetProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.prof_profile, container, false)
//        view.detail_name.text = animal?.name
//        view.detail_funFact.text = animal?.funFact
//        view.detail_url.text = animal?.url
//        val imageResource = resources.getIdentifier(animal?.imageResourceString, "drawable", activity?.packageName)
//        view.detail_image.setBackgroundResource(imageResource)
//        view.detail_raitngBar.rating = animal!!.rating
//
//        view.detail_url.setOnClickListener {
//            val webpage = Uri.parse(animal?.url)
//            val intent = Intent(Intent.ACTION_VIEW,webpage)
//            startActivity(intent)
//
//        }
//
//        view.detail_funFact.setOnClickListener{
//            val builder = AlertDialog.Builder(context!!)
//            builder.setTitle(getString(R.string.DialogTitle))
//
//            builder.setMessage(getString(R.string.DialogMessage))
//            builder.create().show()
//        }

        return view
    }
}