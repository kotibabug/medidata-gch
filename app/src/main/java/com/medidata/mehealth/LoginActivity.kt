package com.medidata.mehealth

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import kotlinx.android.synthetic.main.activity_login.*
import android.content.Intent
import android.R.attr.data
import android.support.v4.app.FragmentActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.google.android.gms.common.api.ApiException


class LoginActivity : AppCompatActivity() {

    private var googleSignInClient: GoogleSignInClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        val account = GoogleSignIn.getLastSignedInAccount(this)

        // if this is empty - user already signed in before to our app
        val gName = account?.account?.name
        updateUI(account)

        googleSignInClient?.revokeAccess()

        setClickListener()

    }

    private fun setClickListener() {
        btn_gsingin.setOnClickListener {
            val signInIntent = googleSignInClient?.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }

        btn_save.setOnClickListener {
            startActivity(Intent(this, BuildProfileActivity::class.java))
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)

            // Signed in successfully, show authenticated UI.
            updateUI(account)
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("LoginActivity", "signInResult:failed code=" + e.statusCode)
            Toast.makeText(this, "failure ${e.message}", Toast.LENGTH_SHORT).show()
            updateUI(null)
        }

    }

    private fun updateUI(gAccount: GoogleSignInAccount?) {
        // we have an account sign in from google
        if (gAccount != null) {
            Toast.makeText(this, "success ${gAccount.email}", Toast.LENGTH_SHORT).show()
            btn_gsingin.visibility = View.GONE
        } else {
            btn_gsingin.visibility = View.VISIBLE
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }


    companion object {
        private const val  RC_SIGN_IN = 100
    }


}
