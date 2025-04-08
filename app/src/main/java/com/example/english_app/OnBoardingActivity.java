package com.example.english_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OnBoardingActivity extends AppCompatActivity {

    private Integer promoIndex = 0;
    ImageView image;
    TextView title;
    TextView desc;
    ImageView scroll;
    Button button_next;
    TextView skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
        button_next = findViewById(R.id.next);
        image = findViewById(R.id.main_image);
        title = findViewById(R.id.title);
        desc =findViewById(R.id.desription);
        scroll = findViewById(R.id.dots);
        skip = findViewById(R.id.skip);

        SharedPreferences settings = getSharedPreferences("ON_BOARD", 0);
        int promo = settings.getInt("ON_BOARD", 0);
        promoIndex = new Integer(promo);
        setPromoIndex(promoIndex);

        //Обработка нажатия на кнопку next и переход к следующему привественному экрану
        button_next.setOnClickListener(v -> {
            promoIndex++;
            if(promoIndex < PromoData.values.length) {
                setPromoIndex(promoIndex);
                SharedPreferences set = getSharedPreferences("ON_BOARD", 0);
                SharedPreferences.Editor editor = set.edit();
                editor.putInt("ON_BOARD", promoIndex);
                editor.commit();
            }  else {
                SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
                prefs.edit().putBoolean("completed", true).apply();

                Intent intent = new Intent(getApplicationContext(), SelectLanguageActivity.class);
                finish();
                startActivity(intent);
            }
        });

        //Обработка нажатия на кнопку skip, переход к странице holder
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
                prefs.edit().putBoolean("completed", true).apply();
                finish();
                startActivity(new Intent(getApplicationContext(), SelectLanguageActivity.class));
            }
        });

    }

    private void setPromoIndex(Integer index){
        PromoData current = PromoData.values[index];
        image.setImageResource(current.imageId);
        title.setText(current.title);
        desc.setText(current.description);
        scroll.setImageResource(current.scrollId);
        button_next.setText(current.button);

    }
}
