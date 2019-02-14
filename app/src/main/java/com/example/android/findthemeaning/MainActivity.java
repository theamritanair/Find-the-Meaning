package com.example.android.findthemeaning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import android.os.AsyncTask;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.searchText)
    EditText searchArea;

    @BindView(R.id.searchButton)
    Button searchButton;
    @BindView(R.id.lan_spinner)
    Spinner langSpinner;


    private String word;
    private String lan;
    ArrayList<Language> lanList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        populateSpinner();
        lanList.add(new Language("",""));
        lanList.add(new Language("English","en"));
        lanList.add(new Language("Hindi ","hi"));







        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                word = searchArea.getText().toString();
                if(word.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please enter a word", Toast.LENGTH_SHORT)
                            .show();
                }else{
                    if (isASpecialCharacter(word)) {
                        Toast.makeText(getApplicationContext(), "Please check the word.", Toast.LENGTH_SHORT)
                                .show();
                    } else {
                        Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                        intent.putExtra("word_searched", word);
                        intent.putExtra("language",lan);
                        startActivity(intent);
                    }

                }


//                new CallbackTask().execute(dictionaryEntries());
            }
        });
    }

    public boolean isASpecialCharacter(String word) {
        int flag = 1;
        if(word.charAt(0)>97 && word.charAt(0)<122){
            for (int i = 0; i < word.length(); ++i) {
                if (word.charAt(i) < 97 || word.charAt(i) > 122) {
                    flag = 0;
                } else {
                    flag = 1;
                }
            }
        }else{
            for (int i = 0; i < word.length(); ++i) {
                if (word.charAt(i) > 0x900 || word.charAt(i) <0x097F) {
                    flag = 1;
                } else {
                    flag = 0;
                }
            }
        }

        if (flag == 0) {
            return true;
        } else {
            return false;
        }

    }

    public void populateSpinner(){
        langSpinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.languages,android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        langSpinner.setAdapter(arrayAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        lan = adapterView.getItemAtPosition(i).toString();
        lan = lanList.get(i).getLanCode();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(getApplicationContext(),"Please select a language",Toast.LENGTH_SHORT);
    }
}
