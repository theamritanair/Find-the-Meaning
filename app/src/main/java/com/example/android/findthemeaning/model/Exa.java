
package com.example.android.findthemeaning.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Exa {

    @SerializedName("metadata")
    @Expose
    private com.example.android.findthemeaning.model.Metadata metadata;
    @SerializedName("results")
    @Expose
    private List<com.example.android.findthemeaning.model.Result> results = null;

    public com.example.android.findthemeaning.model.Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(com.example.android.findthemeaning.model.Metadata metadata) {
        this.metadata = metadata;
    }

    public List<com.example.android.findthemeaning.model.Result> getResults() {
        return results;
    }

    public void setResults(List<com.example.android.findthemeaning.model.Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Exa{" +
                "metadata=" + metadata +
                ", results=" + results +
                '}';
    }
}
