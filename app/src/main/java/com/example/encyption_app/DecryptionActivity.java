package com.example.encyption_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DecryptionActivity extends AppCompatActivity {
    Button ceasar;
    Button monoAplha;
    Button rsa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decryption);
        ceasar=findViewById(R.id.ceasar);
        monoAplha=findViewById(R.id.monoAlpha);
        rsa=findViewById(R.id.rsa);
    }

    public void openCeasarDecryp(View view)
    {
        Toast.makeText(this,"Ceasar Decryption",Toast.LENGTH_SHORT);
        Log.d("onClickCeasar","Ceasar Decryption worked successfully");
        startActivity(new Intent(this, CeasarDecryptionActivity.class));
    }
    public void openMonoAlphaDecryp(View view)
    {
        Toast.makeText(this,"Mono Alphabetic Decryption",Toast.LENGTH_SHORT);
        Log.d("onClickMonoAplha","Mono Alphabetic Decryption worked successfully");
        startActivity(new Intent(this, MonoAplhaDecrypActivity.class));
    }
//    public void openRsaDecryp(View view)
//    {
//        Toast.makeText(this,"Ceasar Decryption",Toast.LENGTH_SHORT);
//        Log.d("onClickCeasar","Ceasar Decryption worked successfully");
//        startActivity(new Intent(this, CeasarDecryptionActivity.class));
//    }
}