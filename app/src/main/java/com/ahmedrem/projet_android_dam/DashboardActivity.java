package com.ahmedrem.projet_android_dam;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DashboardActivity extends AppCompatActivity {

    RelativeLayout panel;
    CardView card1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        panel = findViewById(R.id.panel);
        card1 = findViewById(R.id.card1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation slideup = AnimationUtils.loadAnimation(DashboardActivity.this,R.anim.slideup);
                slideup.setFillAfter(true);
                slideup.setDuration(300);
                panel.startAnimation(slideup);
            }
        },1000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation fadeslideup = AnimationUtils.loadAnimation(DashboardActivity.this,R.anim.slideup);
                card1.startAnimation(fadeslideup);
                card1.setVisibility(View.VISIBLE);
            }
        },1500);
    }
}