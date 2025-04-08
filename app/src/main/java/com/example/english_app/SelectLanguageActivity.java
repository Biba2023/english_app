package com.example.english_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SelectLanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_select_language);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Window window = getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(getApplicationContext().getResources().getColor(R.color.deep_blue));
        Button english = findViewById(R.id.english);
        Button russian = findViewById(R.id.russian);
        TextView text = findViewById(R.id.text);
        Button belarus = findViewById(R.id.belarus);
        Button choose = findViewById(R.id.choose);
        if (LocaleHelper.getLanguage(SelectLanguageActivity.this).equalsIgnoreCase("ru")) {
            Context context;
            Resources resources;
            context = LocaleHelper.setLocale(SelectLanguageActivity.this, "ru");
            resources = context.getResources();
            text.setText(resources.getString(R.string.select_language));
            russian.setBackground(getResources().getDrawable(R.drawable.button_lang_checked));
            english.setBackground(getResources().getDrawable(R.drawable.button_lang));
            belarus.setEnabled(false);
        } else{
            Context context;
            Resources resources;
            context = LocaleHelper.setLocale(SelectLanguageActivity.this, "en");
            resources = context.getResources();
            text.setText(resources.getString(R.string.select_language));
            english.setBackground(getResources().getDrawable(R.drawable.button_lang_checked));
            russian.setBackground(getResources().getDrawable(R.drawable.button_lang));

        }
            russian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context;
                    Resources resources;
                    context = LocaleHelper.setLocale(SelectLanguageActivity.this, "ru");
                    resources = context.getResources();
                    text.setText(resources.getString(R.string.select_language));
                    russian.setBackground(getResources().getDrawable(R.drawable.button_lang_checked));
                    english.setBackground(getResources().getDrawable(R.drawable.button_lang));
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            });

            english.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context;
                    Resources resources;
                    context = LocaleHelper.setLocale(SelectLanguageActivity.this, "en");
                    resources = context.getResources();
                    text.setText(resources.getString(R.string.select_language));
                    english.setBackground(getResources().getDrawable(R.drawable.button_lang_checked));
                    russian.setBackground(getResources().getDrawable(R.drawable.button_lang));
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
            });

            choose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    startActivity(new Intent(SelectLanguageActivity.this, LoginActivity.class));
                }
            });
        }
    }
