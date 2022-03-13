package com.ersubhadip.sawo_bulletin.activities.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.ersubhadip.sawo_bulletin.R
import com.ersubhadip.sawo_bulletin.activities.MainActivity
import com.ersubhadip.sawo_bulletin.databinding.ActivityAuthBinding
import com.ersubhadip.sawo_bulletin.utils.Constants
import com.sawolabs.androidsdk.Sawo

class AuthActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthBinding
    lateinit var animation: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //setting animation
        animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        binding.loginBtn.startAnimation(animation)
        binding.icIcon.startAnimation(animation)
        binding.title.startAnimation(animation)


        //login setup
        binding.loginBtn.setOnClickListener {
            val sawo = Sawo(
                this,
                Constants.API_KEY, Constants.SECRET_KEY
            )

            sawo.login("email", MainActivity::class.java.name)
        }

    }
}