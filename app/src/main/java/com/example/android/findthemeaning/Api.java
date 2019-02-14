package com.example.android.findthemeaning;


import com.example.android.findthemeaning.model.Exa;
import com.example.android.findthemeaning.model.LexicalEntry;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface Api {

    String BASE_URL = "https://od-api.oxforddictionaries.com/api/v1/";

    @GET("entries/{lan}/{word_id}")
    Call<Exa> getExa(@Header("app_id") String id,
                                              @Header("app_key") String key,
                                              @Path("lan") String language,
                                              @Path("word_id") String word_id);




}
