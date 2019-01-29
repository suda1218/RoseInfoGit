package rose.chenm6.roseinfo

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_main.*

class MainActivity : AppCompatActivity(),MainPageFragment.OnDocSelectedListener, FollowFragment.OnFollowProfSelectedListener{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        if(savedInstanceState==null) {
            val ft = supportFragmentManager.beginTransaction()
            ft.add(R.id.fragment_container, MainPageFragment(), "about")
            ft.commit()
        }

        switchToRoseFragment()
    }

    fun switchToSplashFragment(){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container, LoginFragment())
        ft.commit()
    }

    private fun switchToRoseFragment() {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container, MainPageFragment())
        ft.commit()
    }

    private fun switchToFollowFragment() {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container, FollowFragment())
        ft.commit()
    }

    private fun switchToProfileFragment() {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container, StudentProfileFragment())
        ft.commit()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.MainNavigation -> {
                this.switchToRoseFragment()
            }
            R.id.FollowNavigation -> {
                this.switchToFollowFragment()
            }
            R.id.ProfileNavigation -> {
                this.switchToProfileFragment()

            }
        }
        false
    }

    override fun onDocSelected(prof: Prof) {
        val fragment = ProfProfileFragment.newInstance(prof)
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container, fragment)
        ft.addToBackStack("detail")
        ft.commit()
    }

    override fun onFollowProfSelected(prof: Prof) {
        val fragment = ProfProfileFragment.newInstance(prof)
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container, fragment)
        ft.addToBackStack("detail")
        ft.commit()
    }
}
