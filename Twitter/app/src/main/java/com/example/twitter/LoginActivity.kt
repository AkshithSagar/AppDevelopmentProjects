package com.example.twitter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.widget.addTextChangedListener
import com.example.twitter.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
//import kotlinx.android.synthetic.main_activity_login.*;

class LoginActivity : AppCompatActivity() {
    lateinit var bind:ActivityLoginBinding


    private val firebaseAuth=FirebaseAuth.getInstance()
    private val firebaseAuthListener=FirebaseAuth.AuthStateListener {
        Toast.makeText(this@LoginActivity, "kesgooo", Toast.LENGTH_SHORT).show()

        val user=firebaseAuth.currentUser?.uid
        user?.let{
            startActivity(HomeActivity.newIntent(this))
            finish()

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        bind= ActivityLoginBinding.inflate(layoutInflater)
        val view=bind.root
        setContentView(view)
        setTextChangedListener(bind.emailET,bind.emailTIL)
        setTextChangedListener(bind.passwordET,bind.passwordTIL)
        //this.bind.loginProgressLayout.setOnTouchListener{ view, event-> true}


    }
    fun setTextChangedListener(et:EditText,til:TextInputLayout){
        et.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
           til.isErrorEnabled=false

            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
    }
    fun onLogin(v:View){
        var proceed=true
        if(bind.emailET.text.isNullOrEmpty()){
            bind.emailTIL.error="Email is required"
            bind.emailTIL.isErrorEnabled=true
            proceed=false
        }
        if(bind.passwordET.text.isNullOrEmpty()){
            bind.passwordTIL.error="Password is required"
            bind.passwordTIL.isErrorEnabled=true
            proceed=false
        }
        if(proceed==true){
            //bind.loginProgressLayout.visibility=View.VISIBLE
            firebaseAuth.signInWithEmailAndPassword(bind.emailET.text.toString(),bind.passwordET.text.toString())
                .addOnCompleteListener { task ->
                    if(!task.isSuccessful){
                        //bind.loginProgressLayout.visibility=View.GONE
                        Toast.makeText(this@LoginActivity, "LogIn error${task.exception?.localizedMessage}", Toast.LENGTH_SHORT).show()

                    }
//                    else{
//                        Toast.makeText(this@LoginActivity, "successss", Toast.LENGTH_SHORT).show()
//
//                    }
                }
                .addOnFailureListener{e ->
                    e.printStackTrace()
                    //bind.loginProgressLayout.visibility=View.GONE

                }
        }




    }
    fun goToSignup(v:View){


    }

    override fun onStart() {
        super.onStart()
        firebaseAuth.addAuthStateListener(firebaseAuthListener)
    }

    override fun onStop() {
        super.onStop()
        firebaseAuth.removeAuthStateListener(firebaseAuthListener)
    }
}