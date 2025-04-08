package com.example.english_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView backgroundImage = findViewById(R.id.image);
        LinearLayout image = findViewById(R.id.ic);
        Animation slideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_slide);
        image.startAnimation(slideAnimation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);

                if(!prefs.getBoolean("completed", false)) {
                    startActivity(new Intent(SplashScreen.this, OnBoardingActivity.class));
                }
                else{
                    startActivity(new Intent(SplashScreen.this, SelectLanguageActivity.class));
                }
            }
        }, 2000);
    }
    }
