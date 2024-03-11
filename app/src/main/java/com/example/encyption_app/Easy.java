package com.example.encyption_app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Easy extends AppCompatActivity {
    private EditText enterMessage;
    private EditText enterKey;
    private TextView result;
    private Button encrypt;

    CeasarCipher ceasarCipher=new CeasarCipher();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easy);

        enterMessage=findViewById(R.id.inputMessage);
        enterKey=findViewById(R.id.inputKey);
        result=findViewById(R.id.resultMono);
        encrypt=findViewById(R.id.decrypt);
        String msg=enterMessage.getText().toString();
        int key= Integer.parseInt(enterKey.getText().toString());

        String encryptedMsg=ceasarCipher.encrypt(msg,key);
        result.setText(encryptedMsg);

    }
}
