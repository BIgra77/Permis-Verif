package com.example.login;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import android.os.Bundle;
import android.os.Handler;

public class IntroductionActivity extends AppCompatActivity{

    ImageView logo,splashImg;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        logo = findViewById(R.id.logo);
        splashImg = findViewById(R.id.image);
        lottieAnimationView = findViewById(R.id.lottie);

        splashImg.animate().translationY(-3600).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(2400).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(2400).setDuration(1000).setStartDelay(4000);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(IntroductionActivity.this,MainActivity.class));
            }
        }, 4900);
    }
}