package com.pmz.muse.game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseModeActivity extends AppCompatActivity {

    Button normalButton;
    Button randomButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode);

        hideNavigationBar();

        setupButtons();
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideNavigationBar();
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

    private void setupButtons(){
        normalButton =  findViewById(R.id.normalBtn);
        randomButton =  findViewById(R.id.randomBtn);

        normalButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start MusePlayActivity.class
                Intent myIntent = new Intent(ChooseModeActivity.this,
                        MusePlayActivity.class);
                startActivity(myIntent);
            }
        });



        randomButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start MuseRandomPlayActivity.class
                Intent myIntent = new Intent(ChooseModeActivity.this,
                        MuseRandomPlayActivity.class);
                startActivity(myIntent);
            }
        });
    }


}
