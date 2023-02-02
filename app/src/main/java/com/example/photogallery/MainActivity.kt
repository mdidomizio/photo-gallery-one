package com.example.photogallery

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.photogallery.SecondActivity.Companion.KEY_PICTURE_MAIN_ACTIVITY

class MainActivity :  AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val nextButton = findViewById<Button>(R.id.next_button)
        var picture = findViewById<ImageView>(R.id.picture)
        var description = findViewById<TextView>(R.id.description)


        val contentFood = Content(R.drawable.food, "A plate of food")
        val contentCity = Content(R.drawable.city, "City with lights at night")
        val contentReporter = Content(R.drawable.reporter, "A man taking a picture of himself with a camera")
        val listContent = arrayOf (contentFood, contentCity, contentReporter)

        var counter = 0
        description.setText(listContent[0].description)
        picture.setImageResource(listContent[0].picture)


        nextButton.setOnClickListener {

            if (counter < listContent.size-1){
                counter++
                description.text = listContent[counter].description
                picture.setImageResource(listContent[counter].picture)
                if(counter == listContent.size){
                    counter = 0
                }
            }

        }
        picture.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(KEY_PICTURE_MAIN_ACTIVITY, listContent[counter].picture)
            startActivity(intent)
        }

    }

}




class Content (val picture: Int, val description: String)