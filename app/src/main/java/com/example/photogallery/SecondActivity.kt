package com.example.photogallery

import android.annotation.SuppressLint
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView


class SecondActivity : AppCompatActivity() {

    companion object {
        const val KEY_PICTURE_MAIN_ACTIVITY = "KEY_PICTURE_MAIN_ACTIVITY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var fullScreenPicture = findViewById<ImageView>(R.id.fullScreenPicture)

        var selectedPicture = intent.getIntExtra(KEY_PICTURE_MAIN_ACTIVITY, -1)

        if(selectedPicture != -1  ){
            fullScreenPicture.setImageResource(selectedPicture)
        }

    }

}