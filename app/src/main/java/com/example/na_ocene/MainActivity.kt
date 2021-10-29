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
        var ImageView =findViewById<ImageView>(R.id.Obraz)
        CheckBox.setOnClickListener(){
            ImageView.visibility = View.VISIBLE;
            }

        }

    }

