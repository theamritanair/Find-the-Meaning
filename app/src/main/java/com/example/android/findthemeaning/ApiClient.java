package com.example.android.findthemeaning;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.provider.UserDictionary.Words.APP_ID;

public class ApiClient {


    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
//        OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
//            @Override
//            public Response intercept(@NonNull Chain chain) throws IOException {
//                Request original = chain.request();
//
//                Request request = original.newBuilder()
//                        .addHeader("Accept","application/json")
//                        .addHeader("app_id", DisplayActivity.APP_ID)
//                        .addHeader("app_key", DisplayActivity.APP_KEY)
//                        .method(original.method(),original.body())
//                        .build();
//                return chain.proceed(request);
//            }
//        }).build();

        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Api.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }


}
