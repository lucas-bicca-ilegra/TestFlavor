package com.example.ilegra0098.testflavor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mTextView = (TextView)findViewById(R.id.activity_main_text);
        mTextView.setText(getString(R.string.description_concept) + " " + BuildConfig.FLAVOR);
    }
}
