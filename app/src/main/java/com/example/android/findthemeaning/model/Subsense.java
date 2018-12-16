
package com.example.android.findthemeaning.model;

import java.util.List;

import com.example.android.findthemeaning.model.Example_;
import com.example.android.findthemeaning.model.Note;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subsense {

    @SerializedName("definitions")
    @Expose
    private List<String> definitions = null;
    @SerializedName("domains")
    @Expose
    private List<String> domains = null;
    @SerializedName("examples")
    @Expose
    private List<Example_> examples = null;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("short_definitions")
    @Expose
    private List<String> shortDefinitions = null;
    @SerializedName("registers")
    @Expose
    private List<String> registers = null;
    @SerializedName("notes")
    @Expose
    private List<Note> notes = null;

    public List<String> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<String> definitions) {
        this.definitions = definitions;
    }

    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    public List<Example_> getExamples() {
        return examples;
    }

    public void setExamples(List<Example_> examples) {
        this.examples = examples;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getShortDefinitions() {
        return shortDefinitions;
    }

    public void setShortDefinitions(List<String> shortDefinitions) {
        this.shortDefinitions = shortDefinitions;
    }

    public List<String> getRegisters() {
        return registers;
    }

    public void setRegisters(List<String> registers) {
        this.registers = registers;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }


    @Override
    public String toString() {
        return "Subsense{" +
                "definitions=" + definitions +
                ", domains=" + domains +
                ", examples=" + examples +
                ", id='" + id + '\'' +
                ", shortDefinitions=" + shortDefinitions +
                ", registers=" + registers +
                ", notes=" + notes +
                '}';
    }
}
