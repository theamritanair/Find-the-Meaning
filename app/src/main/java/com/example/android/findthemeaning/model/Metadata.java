
package com.example.android.findthemeaning.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata {

    @SerializedName("provider")
    @Expose
    private String provider;

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "provider='" + provider + '\'' +
                '}';
    }
}
