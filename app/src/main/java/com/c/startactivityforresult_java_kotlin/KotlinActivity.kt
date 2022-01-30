package com.c.startactivityforresult_java_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts

class KotlinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        title="Kotlin Activity"

        val image=findViewById<ImageView>(R.id.imageView);
        val button=findViewById<Button>(R.id.button);

        val galleryLauncher=registerForActivityResult(ActivityResultContracts.GetContent(),
            ActivityResultCallback {
                image.setImageURI(it)
            })

        button.setOnClickListener {
            galleryLauncher.launch("image/*")
        }
    }
}