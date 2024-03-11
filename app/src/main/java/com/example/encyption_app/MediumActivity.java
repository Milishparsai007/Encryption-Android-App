package com.example.encyption_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MediumActivity extends AppCompatActivity {

    private EditText enterMessage;
    private EditText enterKey;
    private TextView result;
    private Button encrypt;
    boolean isAllFieldsChecked=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium);
        enterMessage=findViewById(R.id.inputMessage);
        enterKey=findViewById(R.id.inputKey);
        result=findViewById(R.id.resultMono);
        encrypt=findViewById(R.id.decrypt);

        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAllFieldsChecked=CheckAllFields();

                if(isAllFieldsChecked)
                {
                    encryptMedium(enterMessage.getText().toString(),enterKey.getText().toString());
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

    public void encryptMedium(String msg,String key)
    {
        result.setText(MonoAplhabetic.encrypt(msg,key));
    }
}