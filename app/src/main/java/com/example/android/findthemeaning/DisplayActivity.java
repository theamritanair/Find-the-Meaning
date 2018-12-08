package com.example.android.findthemeaning;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.findthemeaning.model.Exa;
import com.example.android.findthemeaning.model.LexicalEntry;
import com.example.android.findthemeaning.model.Result;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.provider.UserDictionary.Words.APP_ID;
import static com.example.android.findthemeaning.Api.BASE_URL;

public class DisplayActivity extends AppCompatActivity {


    RecyclerView entriesList;

    public static final String APP_ID = "fb3fc25c";
    public static final String APP_KEY = "92e3e400116f3a4f74c580496c3fe82a";

    WordAdapter adapter;
    Context context;
    Bundle bun;
    String word_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        context = this;
        bun = getIntent().getExtras();

        word_id = bun.getString("key");
        entriesList = (RecyclerView) findViewById(R.id.entries);

        try {
            naacho();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void naacho(){
        Api api = ApiClient.getClient().create(Api.class);
        Call<Exa> dictionaryEntries = api.getExa(APP_ID, APP_KEY, word_id);
        dictionaryEntries.enqueue(new Callback<Exa>() {
            @Override
            public void onResponse(Call<Exa> call, retrofit2.Response<Exa> response) {



                Exa info = response.body();
                final Result result = info.getResults().get(0);
                Log.i("KEY",bun.getString("key"));
                Log.i("LEXICAL ENTRIES", Arrays.asList(result.getLexicalEntries()).toString());

                Handler handler = new Handler();

                handler.post(new Runnable() {
                    public void run() {
                        adapter = new WordAdapter(result.getLexicalEntries(), context, word_id);
                        entriesList.setAdapter(adapter);
                    }
                });

            }

            @Override
            public void onFailure(Call<Exa> call, Throwable t) {
                Toast.makeText(DisplayActivity.this,"Error :(",Toast.LENGTH_SHORT);
            }
        });
    }

}

