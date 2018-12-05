package com.example.android.findthemeaning;

public class Word {


    String word;
    String defintion;

    String category;

    String audiomp3;

    public Word(String word, String defintion, String category, String audiomp3) {
        this.word = word;
        this.defintion = defintion;
        this.category = category;
        this.audiomp3 = audiomp3;
    }

    @Override
    public String toString(){
        return "Word: "+ word +"\ndefinition:" + defintion +"\n Category: "+category +"\n audiomp3" +audiomp3+"";
    }











}
