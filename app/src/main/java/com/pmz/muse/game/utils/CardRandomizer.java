package com.pmz.muse.game.utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class CardRandomizer {

    private static final int TOTAL_MASTERPIECE_CARDS_NUMBER = 257;
    private static final int TOTAL_INSPIRATION_CARDS_NUMBER = 30;
    private Deque<Integer> masterpieceCardsNumberStack;
    private Deque<Integer> inspirationCardsNumberStack;
    private Integer[] generatedMasterpieceNumbers;
    private Integer[] generatedInspirationNumbers;


    public CardRandomizer() {
        initializeMasterpieceStack();
        initializeInspirationStack();
    }

    private void initializeMasterpieceStack() {
        masterpieceCardsNumberStack = new ArrayDeque<>(
                generateShuffledList(TOTAL_MASTERPIECE_CARDS_NUMBER));
    }

    private void initializeInspirationStack() {
        inspirationCardsNumberStack = new ArrayDeque<>(
                generateShuffledList(TOTAL_INSPIRATION_CARDS_NUMBER));
    }

    //shuffle list with numbers of the images
    private List<Integer> generateShuffledList(int numOfCards) {
        List<Integer> listForShuffling = new ArrayList<>();
        for(int i = 1; i < numOfCards + 1; i++ ){
            listForShuffling.add(i);
        }
        Collections.shuffle(listForShuffling);
        return listForShuffling;
    }

    //pop a random image number from the respective stack
    public int popRandomMasterpieceImageNumber(){
        if(masterpieceCardsNumberStack.isEmpty()){
            initializeMasterpieceStack();
        }
        return masterpieceCardsNumberStack.pop();
    }

    public int popRandomInspirationImageNumber(){
        if(inspirationCardsNumberStack.isEmpty()){
            initializeInspirationStack();
        }
        return inspirationCardsNumberStack.pop();
    }

    public void generateArrayOfRandomMasterpieceNumbers(){
        Integer[] arrNumbers = new Integer[6];
        for(int i = 0; i < 6; i++){
            arrNumbers[i] = popRandomMasterpieceImageNumber();
        }
        generatedMasterpieceNumbers = arrNumbers;
    }

    public void generateArrayOfRandomInspirationNumbers(){
        Integer[] arrNumbers = new Integer[2];
        for(int i = 0; i < 2; i++){
            arrNumbers[i] = popRandomInspirationImageNumber();
        }
        generatedInspirationNumbers = arrNumbers;
    }

    public Deque<Integer> getMasterpieceCardsNumberStack() {
        return masterpieceCardsNumberStack;
    }

    public void setMasterpieceCardsNumberStack(Deque<Integer> masterpieceCardsNumberStack) {
        this.masterpieceCardsNumberStack = masterpieceCardsNumberStack;
    }

    public Deque<Integer> getInspirationCardsNumberStack() {
        return inspirationCardsNumberStack;
    }

    public void setInspirationCardsNumberStack(Deque<Integer> inspirationCardsNumberStack) {
        this.inspirationCardsNumberStack = inspirationCardsNumberStack;
    }

    public Integer[] getGeneratedMasterpieceNumbers() {
        return generatedMasterpieceNumbers;
    }

    public void setGeneratedMasterpieceNumbers(Integer[] generatedMasterpieceNumbers) {
        this.generatedMasterpieceNumbers = generatedMasterpieceNumbers;
    }

    public Integer[] getGeneratedInspirationNumbers() {
        return generatedInspirationNumbers;
    }

    public void setGeneratedInspirationNumbers(Integer[] generatedInspirationNumbers) {
        this.generatedInspirationNumbers = generatedInspirationNumbers;
    }
}
