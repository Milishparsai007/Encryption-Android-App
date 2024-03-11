package com.example.encyption_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.InputQueue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EncryptionActivity extends AppCompatActivity {
    TextView welcome;
    Button easy;
    Button medium;
    Button hard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryption);

//        easy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent;
//                intent=new Intent(this, EasyActivity.class);
//                startActivity(intent);
//            }
//        });
        Window window=this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.black));


    }


    public void openEasy(View view)
    {
        Toast.makeText(this, "Ceasar Cipher", Toast.LENGTH_SHORT).show();
        Log.d("onClickEasy","Easy worked successfully");
        startActivity(new Intent(this, EasyActivity.class));
    }
    public void openMedium(View view)
    {
        Toast.makeText(this, "Mono Alphabetic", Toast.LENGTH_SHORT).show();
        Log.d("onClickMedium","Medium worked successfully");
        startActivity(new Intent(this, MediumActivity.class));
    }
    public void openHardDesc(View view)
    {
        Toast.makeText(this, "RSA Cipher", Toast.LENGTH_SHORT).show();
        Log.d("onClickHard","Hard worked successfully");
        startActivity(new Intent(this, RSADescription.class));
    }
}