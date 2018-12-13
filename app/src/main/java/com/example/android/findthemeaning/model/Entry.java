
package com.example.android.findthemeaning.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entry {

    @SerializedName("etymologies")
    @Expose
    private List<String> etymologies = null;
    @SerializedName("grammaticalFeatures")
    @Expose
    private List<com.example.android.findthemeaning.model.GrammaticalFeature> grammaticalFeatures = null;
    @SerializedName("homographNumber")
    @Expose
    private String homographNumber;
    @SerializedName("senses")
    @Expose
    private List<Sense> senses = null;

    public List<String> getEtymologies() {
        return etymologies;
    }

    public void setEtymologies(List<String> etymologies) {
        this.etymologies = etymologies;
    }

    public List<com.example.android.findthemeaning.model.GrammaticalFeature> getGrammaticalFeatures() {
        return grammaticalFeatures;
    }

    public void setGrammaticalFeatures(List<com.example.android.findthemeaning.model.GrammaticalFeature> grammaticalFeatures) {
        this.grammaticalFeatures = grammaticalFeatures;
    }

    public String getHomographNumber() {
        return homographNumber;
    }

    public void setHomographNumber(String homographNumber) {
        this.homographNumber = homographNumber;
    }

    public List<com.example.android.findthemeaning.model.Sense> getSenses() {
        return senses;
    }

    public void setSenses(List<com.example.android.findthemeaning.model.Sense> senses) {
        this.senses = senses;
    }

}
