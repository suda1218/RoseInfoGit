package rose.chenm6.roseinfo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import edu.rosehulman.rosefire.Rosefire
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_main.*

class MainActivity : AppCompatActivity(),MainPageFragment.OnDocSelectedListener, FollowFragment.OnFollowProfSelectedListener,
    SplashFragment.OnLoginButtonPressedListener, SplashFragment.OnRoseButtonPressedListener{


    val auth = FirebaseAuth.getInstance()
    lateinit var authListener: FirebaseAuth.AuthStateListener

    lateinit var uid:String

    private val RC_SIGN_IN = 1
    private val RC_ROSEFIRE_LOGIN = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        if(savedInstanceState==null) {
            val ft = supportFragmentManager.beginTransaction()
            ft.add(R.id.fragment_container, MainPageFragment(), "about")
            ft.commit()
        }
        initializeListeners()
    }


    private fun switchToRoseFragment(uid:String) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container, MainPageFragment.newInstance(uid))
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
                this.switchToRoseFragment(this.uid)
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

    override fun onStart() {
        super.onStart()
        auth.addAuthStateListener(authListener)
    }

    override fun onStop() {
        super.onStop()
        auth.removeAuthStateListener(authListener)
    }


    private fun initializeListeners() {
        authListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            val user = auth.currentUser
            Log.d(Constants.TAG, "User: $user")
            if(user == null){
                switchToSplashFragment()
            }else{
                switchToRoseFragment(user.uid)
                this.uid = user.uid
            }
        }
    }

    private fun switchToSplashFragment() {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container, SplashFragment())
        ft.commit()
    }

    override fun onLoginButtonPressed() {
        launchLoginUI()
    }

    private fun launchLoginUI() {
        // For details, see https://firebase.google.com/docs/auth/android/firebaseui#sign_in
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.PhoneBuilder().build()
        )

        val loginIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .setLogo(R.drawable.abc_btn_radio_material)
            .build()

        startActivityForResult(loginIntent, RC_SIGN_IN)
    }


    fun onRosefireLogin() {
        val signInIntent = Rosefire.getSignInIntent(this,"bf999ecb-f11b-4d0d-88af-a1860eedaea3")
        startActivityForResult(signInIntent, RC_ROSEFIRE_LOGIN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == RC_ROSEFIRE_LOGIN) {
            val result = Rosefire.getSignInResultFromIntent(data)
            if (result.isSuccessful) {
                auth.signInWithCustomToken(result.token)
            } else {
                Log.d(Constants.TAG, "Rosefire failed")
            }
        }
    }

    override fun onRoseButtonPressed() {
        this.onRosefireLogin()
    }
}
