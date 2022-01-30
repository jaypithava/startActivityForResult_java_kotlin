package com.c.startactivityforresult_java_kotlin;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;

    ActivityResultLauncher<String> galleryLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);


        galleryLauncher=registerForActivityResult(new ActivityResultContracts.GetContent()
                , new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {
                        imageView.setImageURI(result);
                    }
                });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                galleryLauncher.launch("image/*");
            }
        });
    }
}