package com.example.na_ocene

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var CheckBox = findViewById<CheckBox>(R.id.checkBox)
        var ImageView = findViewById<ImageView>(R.id.Obraz)
        var ImageButton_next = findViewById<ImageButton>(R.id.Nastepny)
        var ImageButton_poprzedni = findViewById<ImageButton>(R.id.Poprzedni)
        var ImageButton_wyczysc = findViewById<ImageButton>(R.id.wyczyść)

        CheckBox.setOnClickListener() {
            if (ImageView.getVisibility() == View.INVISIBLE) {
                ImageView.setVisibility(View.VISIBLE); }
            else{
                ImageView.setVisibility(View.INVISIBLE);
            }

        }
        var image= "one"
        ImageButton_next.setOnClickListener{
            when(image){
                "one" -> {
                    ImageView.setImageResource(R.drawable.czarny)
                    image = "two"
                }
                "two" -> {
                    ImageView.setImageResource(R.drawable.czerwony)
                    image = "three"
                }
                "three" -> {
                    ImageView.setImageResource(R.drawable.niebieski)
                    image = "four"
                }
                "four" -> {
                    ImageView.setImageResource(R.drawable.zielony)
                    image = "one"
                }
            }

        }
        ImageButton_poprzedni.setOnClickListener{
            when(image){
                "one" -> {
                    ImageView.setImageResource(R.drawable.niebieski)
                    image = "four"
                }
                "four" -> {
                    ImageView.setImageResource(R.drawable.czerwony)
                    image = "three"
                }
                "three" -> {
                    ImageView.setImageResource(R.drawable.czarny)
                    image = "two"
                }
                "two" -> {
                    ImageView.setImageResource(R.drawable.zielony)
                    image = "one"
                }
            }

        }

        ImageButton_wyczysc.setOnClickListener{
            ImageView.setImageResource(R.drawable.ic_launcher_background)
        }

    }
}

