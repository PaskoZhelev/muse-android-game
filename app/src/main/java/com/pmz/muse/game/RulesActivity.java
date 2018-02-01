package com.pmz.muse.game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RulesActivity extends AppCompatActivity {

    Button backButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rules_activity);

        setupButtons();
        hideNavigationBar();

        textView = (TextView) findViewById(R.id.rulesTextView);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideNavigationBar();
    }

    private void setupButtons() {
        backButton = findViewById(R.id.backBtn);

        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                finish();
            }
        });

    }

    private void hideNavigationBar() {
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
}
