package com.example.encyption_app;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EasyActivity extends AppCompatActivity {
    private EditText enterMessage;
    private EditText enterKey;
    private TextView result;
    private Button encrypt;
    boolean isAllFieldsChecked=false;

//    CeasarCipher ceasarCipher=new CeasarCipher();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);
        enterMessage=findViewById(R.id.inputMessage);
        enterKey=findViewById(R.id.inputKey);
        result=findViewById(R.id.resultMono);
        encrypt=findViewById(R.id.decrypt);
        String text=enterMessage.getText().toString().trim();
        String key=enterKey.getText().toString().trim();

//        registerForContextMenu(enterMessage);


        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAllFieldsChecked=CheckAllFields();

                if(isAllFieldsChecked)
                {
                    encryptEasy(enterMessage.getText().toString(),Integer.parseInt(enterKey.getText().toString()));
//                    enterMessage.setText("");
//                    enterKey.setText("");
                    clearForm((ViewGroup) findViewById(R.id.ceasarEncryption));
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


        // after all validation return true.
        return true;
    }

    public void encryptEasy(String msg,int key)
    {
        result.setText(CeasarCipher.encrypt(msg,key));
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


