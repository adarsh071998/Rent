package com.example.rent;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import de.hdodenhof.circleimageview.CircleImageView;

public class Register extends AppCompatActivity {

    private static final int PICK_IMAGE = 1 ;
    Button register ;
    CircleImageView imageView_btn ;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register = findViewById(R.id.btn_register);
        //imageView_btn = findViewById(R.id.image_view);

        imageUri = null;

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Register.this , MainActivity.class);
                startActivity(i);
                finish();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE)
        {
            imageUri=data.getData();
            imageView_btn.setImageURI(imageUri);
        }
    }
}
