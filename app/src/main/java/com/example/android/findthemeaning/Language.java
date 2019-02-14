package com.example.android.findthemeaning;

public class Language {
    private String language;
    private String lanCode;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanCode() {
        return lanCode;
    }

    public void setLanCode(String lanCode) {
        this.lanCode = lanCode;
    }

    public Language(String language, String lanCode) {
        this.language = language;
        this.lanCode = lanCode;
    }
}
