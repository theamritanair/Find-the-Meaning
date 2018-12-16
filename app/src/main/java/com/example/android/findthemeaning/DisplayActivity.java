package com.example.android.findthemeaning;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.android.findthemeaning.model.Exa;
import com.example.android.findthemeaning.model.Result;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;

public class DisplayActivity extends AppCompatActivity {

    public static final String APP_ID = "fb3fc25c";
    public static final String APP_KEY = "92e3e400116f3a4f74c580496c3fe82a";

    private WordAdapter mAdapter;
    private Context context;
    private Bundle bun;
    private String word_id;


    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.entries)
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        ButterKnife.bind(this);
        context = this;
        try {
            bun = getIntent().getExtras();
            word_id = bun.getString("key");
            Log.i("BUNDLE DATA", word_id);
        }catch (Exception e){
            e.printStackTrace();
        }
        naacho();
    }

    public void naacho(){
        Api api = ApiClient.getClient().create(Api.class);
        Call<Exa> dictionaryEntries = api.getExa(APP_ID, APP_KEY, word_id);
        dictionaryEntries.enqueue(new Callback<Exa>() {
            @Override
            public void onResponse(Call<Exa> call, retrofit2.Response<Exa> response) {

                Exa info = response.body();
                Result result = null;
                try {
                    result = info.getResults().get(0);
                    Log.i("KEY",bun.getString("key"));
                    Log.i("LEXICAL ENTRIES", Arrays.asList(result.getLexicalEntries())
                            .toString());
                    mAdapter = new WordAdapter(result.getLexicalEntries(), context, word_id);
                    recyclerView.addItemDecoration(new DividerItemDecoration(context,
                            DividerItemDecoration.VERTICAL));
                    recyclerView.setAdapter(mAdapter);

                    progressBar.setVisibility(View.GONE);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<Exa> call, Throwable t) {
                Toast.makeText(DisplayActivity.this,"Error :(",Toast.LENGTH_SHORT);
            }
        });
    }

}

