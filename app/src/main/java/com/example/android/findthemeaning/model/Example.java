
package com.example.android.findthemeaning.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("registers")
    @Expose
    private List<String> registers = null;
    @SerializedName("text")
    @Expose
    private String text;

    public List<String> getRegisters() {
        return registers;
    }

    public void setRegisters(List<String> registers) {
        this.registers = registers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Example{" +
                "registers=" + registers +
                ", text='" + text + '\'' +
                '}';
    }
}
