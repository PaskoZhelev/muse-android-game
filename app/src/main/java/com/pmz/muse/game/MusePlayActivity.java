package com.pmz.muse.game;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.pmz.muse.game.enums.CardType;
import com.pmz.muse.game.utils.CardRandomizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MusePlayActivity extends AppCompatActivity {

    private static final String MASTERPIECE_NAME_PREFIX = "masterpiece";
    private static final String INSPIRATION_NAME_PREFIX = "inspiration";
    private static final int MASTERPIECES_SHOWN_NUMBER = 6;
    private static final int MASTERPIECE_ONE = 1;
    private static final int MASTERPIECE_TWO = 2;
    private static final int MASTERPIECE_THREE = 3;
    private static final int MASTERPIECE_FOUR = 4;
    private static final int MASTERPIECE_FIVE = 5;
    private static final int MASTERPIECE_SIX = 6;

    private static final int INSPIRATION_SHOWN_NUMBER = 2;
    private static final int INSPIRATION_ONE = 1;
    private static final int INSPIRATION_TWO = 2;
    private CardRandomizer cardRandomizer;


    Button startButton;
    ImageView masterpiece1;
    ImageView masterpiece2;
    ImageView masterpiece3;
    ImageView masterpiece4;
    ImageView masterpiece5;
    ImageView masterpiece6;

    ImageView inspiration1;
    ImageView inspiration2;

    ImageView[] masterPieces;
    ImageView[] inspirationCards;

    private boolean hasHiddenMasterpieces;
    private boolean hasHiddenInspirationCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muse_play_activity);

        cardRandomizer = new CardRandomizer();
        hasHiddenMasterpieces = false;
        hasHiddenInspirationCards = false;
        hideNavigationBar();
        setupStartButton();
        setupImageViews();
        setMasterpiecesClickListeners();
        setInspirationClickListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideNavigationBar();
    }


    public void generateRandomMasterpieceCards() {
        cardRandomizer.generateArrayOfRandomMasterpieceNumbers();
    }

    public void generateRandomInspirationCards() {
        cardRandomizer.generateArrayOfRandomInspirationNumbers();
    }

    //get resource drawable id
    public int generateDrawableMasterpieceImageId(int imageNumber) {
        String name = MASTERPIECE_NAME_PREFIX + imageNumber;
        return getResources().getIdentifier(name, "drawable", getPackageName());
    }

    public int generateDrawableInspirationImageId(int imageNumber) {
        String name = INSPIRATION_NAME_PREFIX + imageNumber;
        return getResources().getIdentifier(name, "drawable", getPackageName());
    }

    private void populateMasterpieceViews(Integer[] masterpieceNumArr) {
        masterpiece1.setImageResource(generateDrawableMasterpieceImageId(masterpieceNumArr[0]));
        masterpiece2.setImageResource(generateDrawableMasterpieceImageId(masterpieceNumArr[1]));
        masterpiece3.setImageResource(generateDrawableMasterpieceImageId(masterpieceNumArr[2]));
        masterpiece4.setImageResource(generateDrawableMasterpieceImageId(masterpieceNumArr[3]));
        masterpiece5.setImageResource(generateDrawableMasterpieceImageId(masterpieceNumArr[4]));
        masterpiece6.setImageResource(generateDrawableMasterpieceImageId(masterpieceNumArr[5]));

    }

    private void populateInspirationViews(Integer[] inspirationNumArr) {
        inspiration1.setImageResource(generateDrawableInspirationImageId(inspirationNumArr[0]));
        inspiration2.setImageResource(generateDrawableInspirationImageId(inspirationNumArr[1]));
    }

    private void randomizeMasterpieceViews(Integer[] masterpieceNumArr) {
        List randomizedList = Arrays.asList(masterpieceNumArr);
        Collections.shuffle(randomizedList);
        masterpieceNumArr = (Integer[]) randomizedList.toArray();
        populateMasterpieceViews(masterpieceNumArr);
    }


    private void hideMasterpiecesExceptTheChosen(int chosenImageNum){
        hideAllMasterpieces();
        masterPieces[chosenImageNum].setVisibility(View.VISIBLE);
    }

    private void showAllMasterpieces(){
        for (int j = 1; j < MASTERPIECES_SHOWN_NUMBER + 1;j++ ) {
            masterPieces[j].setVisibility(View.VISIBLE);
        }
        hasHiddenMasterpieces = false;
    }

    private void hideAllMasterpieces(){
        for (int j = 1; j < MASTERPIECES_SHOWN_NUMBER + 1;j++ ) {
            masterPieces[j].setVisibility(View.INVISIBLE);
        }
        hasHiddenMasterpieces = true;
    }

    private void hideAllInspirationCards(){
        for (int j = 1; j < INSPIRATION_SHOWN_NUMBER + 1;j++ ) {
            inspirationCards[j].setVisibility(View.INVISIBLE);
        }
        hasHiddenInspirationCards = true;
    }

    private void hideInspirationCardsExceptTheChosen(int chosenImageNum){
        hideAllInspirationCards();
        inspirationCards[chosenImageNum].setVisibility(View.VISIBLE);
    }

    private void showAllInspirationCards(){
        for (int j = 1; j < INSPIRATION_SHOWN_NUMBER + 1;j++ ) {
            inspirationCards[j].setVisibility(View.VISIBLE);
        }
        hasHiddenInspirationCards = false;
    }


    private void setMasterpiecesClickListeners(){
        defineClickListener(CardType.MASTERPIECE, MASTERPIECE_ONE);
        defineClickListener(CardType.MASTERPIECE, MASTERPIECE_TWO);
        defineClickListener(CardType.MASTERPIECE, MASTERPIECE_THREE);
        defineClickListener(CardType.MASTERPIECE, MASTERPIECE_FOUR);
        defineClickListener(CardType.MASTERPIECE, MASTERPIECE_FIVE);
        defineClickListener(CardType.MASTERPIECE, MASTERPIECE_SIX);
    }

    private void setInspirationClickListeners(){
        defineClickListener(CardType.INSPIRATION, INSPIRATION_ONE);
        defineClickListener(CardType.INSPIRATION, INSPIRATION_TWO);
    }

    private void defineClickListener(CardType cardType, final int cardNumber) {
        switch (cardType){
            case MASTERPIECE:
                masterPieces[cardNumber].setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        if( ! hasHiddenMasterpieces) {
                            hideMasterpiecesExceptTheChosen(cardNumber);
                        } else{
                            showAllMasterpieces();
                            randomizeMasterpieceViews(cardRandomizer.getGeneratedMasterpieceNumbers());
                        }
                    }
                });
                break;
            case INSPIRATION:
                inspirationCards[cardNumber].setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        if( ! hasHiddenInspirationCards) {
                            hideInspirationCardsExceptTheChosen(cardNumber);
                        } else{
                            showAllInspirationCards();
                        }
                    }
                });
                break;
        }
    }


    /*
     Setup
     */
    private void setupStartButton(){
        startButton =  findViewById(R.id.startBtn);

        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                generateRandomMasterpieceCards();
                generateRandomInspirationCards();
                showAllMasterpieces();
                showAllInspirationCards();
                populateMasterpieceViews(cardRandomizer.getGeneratedMasterpieceNumbers());
                populateInspirationViews(cardRandomizer.getGeneratedInspirationNumbers());
            }
        });
    }

    private void setupImageViews(){
        masterpiece1 =  findViewById(R.id.masterpiece1);
        masterpiece2 =  findViewById(R.id.masterpiece2);
        masterpiece3 =  findViewById(R.id.masterpiece3);
        masterpiece4 =  findViewById(R.id.masterpiece4);
        masterpiece5 =  findViewById(R.id.masterpiece5);
        masterpiece6 =  findViewById(R.id.masterpiece6);

        inspiration1 =  findViewById(R.id.inspiration1);
        inspiration2 =  findViewById(R.id.inspiration2);

        masterPieces = new ImageView[7];   //the 0th index would not be used to prevent confusion
        masterPieces[1] = masterpiece1;
        masterPieces[2] = masterpiece2;
        masterPieces[3] = masterpiece3;
        masterPieces[4] = masterpiece4;
        masterPieces[5] = masterpiece5;
        masterPieces[6] = masterpiece6;

        inspirationCards = new ImageView[3];
        inspirationCards[1] = inspiration1;
        inspirationCards[2] = inspiration2;
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
