
package com.example.android.findthemeaning.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example_ {

    @SerializedName("text")
    @Expose
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
