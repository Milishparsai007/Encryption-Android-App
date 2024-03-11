package com.example.encyption_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HardActivity extends AppCompatActivity {

    public  EditText enterMessage;
    public  EditText prime1;
    public  EditText prime2;
    public EditText prime3;
    public  TextView result;
    private Button encrypt;
    private boolean isAllFieldsChecked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard);
        enterMessage=findViewById(R.id.inputMessage);
        prime1=findViewById(R.id.inputPrime1);
        prime2=findViewById(R.id.inputPrime2);
        prime3=findViewById(R.id.inputPrime3);
        result=findViewById(R.id.resultRsa);
        encrypt=findViewById(R.id.decrypt);

        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAllFieldsChecked=CheckAllFields();

                if(isAllFieldsChecked)
                {
                    encryptRSA(Integer.parseInt(prime1.getText().toString()),Integer.parseInt(prime2.getText().toString()),
                            Integer.parseInt(prime3.getText().toString()),enterMessage.getText().toString());
                }

            }
        });
    }

    private boolean CheckAllFields() {
        if (enterMessage.length() == 0) {
            enterMessage.setError("This field is required");
            return false;
        }

        if (prime1.length() == 0) {
            prime1.setError("This field is required");
            return false;
        }
        if (prime2.length() == 0) {
            prime2.setError("This field is required");
            return false;
        }
        if (prime3.length() == 0) {
            prime3.setError("This field is required");
            return false;
        }
        return true;
    }

    public void encryptRSA(int prime1,int prime2,int prime3,String msg)
    {

        RsaCipher rsaCipher=new RsaCipher(prime1,prime2,prime3);
        rsaCipher.setP(prime1);
        rsaCipher.setQ(prime2);
        String ascii=rsaCipher.toAsciiString(msg);
        String cipherText=rsaCipher.encrypt(ascii);
//        result.setText(cipherText);
//        result.setText(prime1+" "+prime2+" "+prime3);
        result.setText(cipherText);
    }
//    public String toAsciiString(String message) {
//        StringBuilder sb = new StringBuilder();
//        for (char c : message.toCharArray()) {
//            int asciiCode = (int) c;
//            sb.append(asciiCode);
//        }
//        return sb.toString();
//    }
}