package com.example.encyption_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RSADescription extends AppCompatActivity {
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsadescription);
        next=findViewById(R.id.next);
    }

    public void openHard(View view)
    {
        Toast.makeText(this,"RSA Description", Toast.LENGTH_SHORT).show();
        Log.d("onCLickHard", "Hard worked successfully");
        startActivity(new Intent(this, HardActivity.class));
    }
}