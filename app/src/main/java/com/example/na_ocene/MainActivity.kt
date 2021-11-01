package com.example.na_ocene

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var CheckBox = findViewById<CheckBox>(R.id.checkBox)
        var ImageView = findViewById<ImageView>(R.id.Obraz)
        var ImageButton_next = findViewById<ImageButton>(R.id.Nastepny)
        var ImageButton_poprzedni = findViewById<ImageButton>(R.id.Poprzedni)
        var ImageButton_wyczysc = findViewById<ImageButton>(R.id.wyczyść)
        var ImageButton_kamera = findViewById<ImageButton>(R.id.Kamera)

        CheckBox.setOnClickListener() {
            if (ImageView.getVisibility() == View.INVISIBLE) {
                ImageView.setVisibility(View.VISIBLE); } else {
                ImageView.setVisibility(View.INVISIBLE);
            }

        }


        var image = "one"
        ImageButton_next.setOnClickListener {
            when (image) {
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
        ImageButton_poprzedni.setOnClickListener {
            when (image) {
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

        ImageButton_wyczysc.setOnClickListener {
            ImageView.setImageResource(R.drawable.ic_launcher_background)
        }
        ImageButton_kamera.isEnabled = false


        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 111)
        } else {
            ImageButton_kamera.isEnabled = true
        }

        ImageButton_kamera.setOnClickListener{
            var i =Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(i, 101)
        }


    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==101){
           var pic: Bitmap?
           pic = data?.getParcelableExtra<Bitmap>("data")
            findViewById<ImageView>(R.id.Obraz).setImageBitmap(pic)
        }
    }

        override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
        ) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            if (requestCode == 111 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            findViewById<ImageButton>(R.id.Kamera).isEnabled=true
            }
        }
    }


