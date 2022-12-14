package com.example.livedataapp;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class MyScoreModel extends ViewModel {
    MutableLiveData<Integer> myScore = new MutableLiveData<>();

    public MyScoreModel() {
        myScore.setValue(0);
    }

    public void IncrementScore() {
        myScore.setValue(myScore.getValue() + 1);
    }

    public void DeccrementScore() {
        myScore.setValue(myScore.getValue() - 1);
    }
}
