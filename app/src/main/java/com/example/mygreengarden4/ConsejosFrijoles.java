package com.example.mygreengarden4;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.Timer;
import java.util.TimerTask;

public class ConsejosFrijoles extends AppCompatActivity {

    private TextView textViewTipFrijol;
    private ViewPager2 viewPager2;
    private ImageButton buttonBack;  // Asegúrate de que esta variable esté declarada
    private int[] imageIds = {R.drawable.frijol1, R.drawable.frijol2, R.drawable.frijol3, R.drawable.frijol4};
    private int currentPage = 0;
    private Timer timer;
    private final long DELAY_MS = 500;
    private final long PERIOD_MS = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos_frijoles);

        textViewTipFrijol = findViewById(R.id.textViewTipFrijol);
        viewPager2 = findViewById(R.id.ViewPager2);  // Asegúrate de que este ID sea correcto
        buttonBack = findViewById(R.id.buttonBack);  // Asegúrate de que este ID sea correcto

        loadDailyTip();
        setupViewPager2();

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void loadDailyTip() {
        SharedPreferences preferences = getSharedPreferences("DailyTips", MODE_PRIVATE);
        String dailyTip = preferences.getString("currentTip", "¡Consejo no disponible!");

        textViewTipFrijol.setText(dailyTip);
    }

    private void setupViewPager2() {
        ImagePagerAdapter adapter = new ImagePagerAdapter(this, imageIds);
        viewPager2.setAdapter(adapter);  // Usando viewPager2 aquí

        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            public void run() {
                if (currentPage == imageIds.length) {
                    currentPage = 0;
                }
                viewPager2.setCurrentItem(currentPage++, true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, DELAY_MS, PERIOD_MS);
    }
}
