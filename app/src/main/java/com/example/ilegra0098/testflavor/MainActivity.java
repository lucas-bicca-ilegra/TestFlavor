package com.example.ilegra0098.testflavor;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import com.github.library.bubbleview.BubbleTextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private Button getFocusButton;
    private BubbleTextView bubbleTextView;

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Bicca", "onStart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Bicca", "onCreate");

        setContentView(R.layout.activity_main);
        mTextView = (TextView)findViewById(R.id.activity_main_text);
        mTextView.setText(getString(R.string.description_concept) + " " + BuildConfig.FLAVOR);
        bubbleTextView = (BubbleTextView)findViewById(R.id.bubbleTextView);
        getFocusButton = (Button) findViewById(R.id.getFocusButton);
        getFocusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bubbleTextView.getVisibility() == View.VISIBLE)
                    hideBubble();
                else showBubble();

            }
        });
        if(!isTablet())
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    private void showBubble() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000);
        findViewById(R.id.bubbleTextView).startAnimation(alphaAnimation);
        bubbleTextView.setVisibility(View.VISIBLE);
        Log.i("Bicca", "showBubble");
    }

    private void hideBubble(){
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(1000);
        findViewById(R.id.bubbleTextView).startAnimation(alphaAnimation);
        bubbleTextView.setVisibility(View.INVISIBLE);
        Log.i("Bicca", "hideBubble");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Bicca", "onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Bicca", "onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Bicca", "onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Bicca", "onDestroy");
    }

    public boolean isTablet() {
        try {
            // Compute screen size
            DisplayMetrics dm = getResources().getDisplayMetrics();
            float screenWidth  = dm.widthPixels / dm.xdpi;
            float screenHeight = dm.heightPixels / dm.ydpi;
            double size = Math.sqrt(Math.pow(screenWidth, 2) +
                    Math.pow(screenHeight, 2));
            // Tablet devices should have a screen size greater than 6 inches
            return size >= 6;
        } catch(Throwable t) {
            Log.e("Bicca", "Failed to compute screen size", t);
            return false;
        }
    }
}
