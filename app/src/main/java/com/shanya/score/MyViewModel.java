package com.shanya.score;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> aTeamScore; //a队的分数
    private MutableLiveData<Integer> bTeamScore; //b队的分数
    private int aBack,bBack; //用于Undo操作的上一次各队分数

    //普通的Get方法
    public MutableLiveData<Integer> getaTeamScore() {
        if (aTeamScore == null){ //处理空指针异常
            aTeamScore = new MutableLiveData<>();
            aTeamScore.setValue(0);
        }
        return aTeamScore;
    }

    public MutableLiveData<Integer> getbTeamScore() {
        if (bTeamScore == null){
            bTeamScore = new MutableLiveData<>();
            bTeamScore.setValue(0);
        }
        return bTeamScore;
    }

    //加分操作，该方法通过DataBinding与按键绑定
    public void aTeamAdd(int p){
        aBack = aTeamScore.getValue();
        bBack = bTeamScore.getValue();
        aTeamScore.setValue(aTeamScore.getValue() + p);
    }

    public void bTeamAdd(int p){
        aBack = aTeamScore.getValue();
        bBack = bTeamScore.getValue();
        bTeamScore.setValue(bTeamScore.getValue() + p);
    }

    //重置操作
    public void reset(){
        aBack = aTeamScore.getValue();
        bBack = bTeamScore.getValue();
        aTeamScore.setValue(0);
        bTeamScore.setValue(0);
    }
    //撤销操作
    public void undo(){
        aTeamScore.setValue(aBack);
        bTeamScore.setValue(bBack);
    }
}
