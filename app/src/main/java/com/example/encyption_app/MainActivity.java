package com.example.encyption_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.InputQueue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView homeDisplay;
    Animation blink_text;
    TextView share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeDisplay=findViewById(R.id.homeText);
        blink_text= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.home_text_animation);
        homeDisplay.setText("Are your messaages safe?".toUpperCase());

        TextPaint paint = homeDisplay.getPaint();
        float width = paint.measureText("are your mess");

        Shader textShader = new LinearGradient(0, 0, width, homeDisplay.getTextSize(),
                new int[]{
                        Color.parseColor("#923CB5"),
                        Color.parseColor("#000000")
                }, null, Shader.TileMode.CLAMP);
        homeDisplay.getPaint().setShader(textShader);
        homeDisplay.startAnimation(blink_text);
        homeDisplay.setTextColor(Color.parseColor("#923CB5"));


        share=findViewById(R.id.shareMessages);
        share.setText("Share your messages securely with this app!!");
        TextPaint paint1 = share.getPaint();
        float width1 = paint1.measureText("shareyourmessageswiththisapp");

        Shader textShader1 = new LinearGradient(0, 0, width1, share.getTextSize(),
                new int[]{
                        Color.parseColor("#923CB5"),
                        Color.parseColor("#000000")
                }, null, Shader.TileMode.CLAMP);
        share.getPaint().setShader(textShader);

        share.setTextColor(Color.parseColor("#923CB5"));


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


    public void openExplore(View view)
    {
        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
        Log.d("onClickExplore","Explore worked successfully");
        startActivity(new Intent(this, ExploreActivity.class));
    }
}