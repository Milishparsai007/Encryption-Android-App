package com.example.encyption_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.InetSocketAddress;

public class ExploreActivity extends AppCompatActivity {
    Button encryption;
    Button decrytpion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        encryption=findViewById(R.id.encryption);
        decrytpion=findViewById(R.id.decryption);
    }


    public void openEncryption(View view)
    {
        Toast.makeText(this,"Encryption",Toast.LENGTH_SHORT);
        Log.d("onClickEncryption", "Encryption worked successfully");
        startActivity(new Intent(this, EncryptionActivity.class));
    }
    public void openDecryption(View view)
    {
        Toast.makeText(this,"Decryption",Toast.LENGTH_SHORT);
        Log.d("onClickDecryption","Decryption worked successfully");
        startActivity(new Intent(this, DecryptionActivity.class));
    }
}