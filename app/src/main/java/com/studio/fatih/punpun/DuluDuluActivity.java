package com.studio.fatih.punpun;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class DuluDuluActivity extends AppCompatActivity {
    int[] imageArray = { R.drawable.photo1, R.drawable.photo2,
            R.drawable.photo3, R.drawable.photo4,
            R.drawable.photo5 };

    ImageView photo;
    Handler handler;

    private Animation animFade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dulu_dulu);

        animFade = AnimationUtils.loadAnimation(this, R.anim.fade_out);

        photo = findViewById(R.id.imageView3);

        handler = new Handler();
        Runnable runnable = new Runnable() {
            int i = 0;

            public void run() {
                i++;
                if (i > imageArray.length - 1) {
                    i = 0;
                }
                animFade.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationStart(Animation animation) {}
                    public void onAnimationRepeat(Animation animation) {}
                    public void onAnimationEnd(Animation animation) {
                        // when fadeout animation ends, fade in your second image

                    }
                });
                photo.setImageResource(imageArray[i]);
                handler.postDelayed(this, 3000);
                photo.startAnimation(animFade);

            }
        };
        handler.postDelayed(runnable, 3000);

        ImageView close = findViewById(R.id.imageView);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
