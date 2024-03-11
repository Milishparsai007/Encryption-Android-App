package com.example.encyption_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CeasarDecryptionActivity extends AppCompatActivity {

    EditText enterMessage;
    EditText enterKey;
    Button decrypt;
    TextView resultDecyp;

    private boolean isAllFieldsChecked=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceasar_decryption);

        enterMessage=findViewById(R.id.inputMessage);
        enterKey=findViewById(R.id.inputKey);
        decrypt=findViewById(R.id.decrypt);
        resultDecyp=findViewById(R.id.resultMono);

        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAllFieldsChecked=CheckAllFields();
                if (isAllFieldsChecked)
                {
                    decryptCeasar(enterMessage.getText().toString(),Integer.parseInt(enterKey.getText().toString()));
                    clearForm((ViewGroup) findViewById(R.id.decryptMono));
                }
            }
        });

        Window window=this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.black));
    }

    private boolean CheckAllFields() {
        if (enterMessage.length() == 0) {
            enterMessage.setError("This field is required");
            return false;
        }

        if (enterKey.length() == 0) {
            enterKey.setError("This field is required");
            return false;
        }
        return true;
    }

    public void decryptCeasar(String msg,int key)
    {
        resultDecyp.setText(CeasarCipher.decrypt(msg,key));
    }

    private void clearForm(ViewGroup group) {
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                ((EditText)view).setText("");
            }

            if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
                clearForm((ViewGroup)view);
        }
    }
}