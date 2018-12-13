package com.example.android.findthemeaning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.searchText)
    EditText searchArea;

    @BindView(R.id.searchButton)
    Button searchButton;


    String word;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                word = searchArea.getText().toString();

                if(isASpecialCharacter(word)){
                    Toast.makeText(getApplicationContext(), "Not an English word", Toast.LENGTH_SHORT)
                            .show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                    intent.putExtra("key",word);
                    startActivity(intent);
                }
//                new CallbackTask().execute(dictionaryEntries());
            }
        });
    }


    public boolean isASpecialCharacter(String word){
        int flag= 1;
        for(int i=0;i<word.length();++i){
            if(word.charAt(i)<97 || word.charAt(i)>122) {
                flag=0;
            }
            else {
                flag =1;
            }
        }
        if(flag==0){
            return true;
        }else{
            return false;
        }

    }

//    private String dictionaryEntries() {
//        final String language = "en";
//        word = searchArea.getText().toString();
//        final String word_id = word.toLowerCase(); //word id is case sensitive and lowercase is required
//        return "https://od-api.oxforddictionaries.com:443/api/v1/entries/" + language + "/" + word_id;
//    }
//
//
//    private class CallbackTask extends AsyncTask<String, Integer, String> {
//
//        @Override
//        protected String doInBackground(String... params) {
//
//            //TODO: replace with your own app id and app key
//            final String app_id = "fb3fc25c";
//            final String app_key = "92e3e400116f3a4f74c580496c3fe82a";
//            try {
//                URL url = new URL(params[0]);
//                HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
//                urlConnection.setRequestProperty("Accept","application/json");
//                urlConnection.setRequestProperty("app_id",app_id);
//                urlConnection.setRequestProperty("app_key",app_key);
//
//                // read the output from the server
//                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//                StringBuilder stringBuilder = new StringBuilder();
//
//                String line = null;
//                while ((line = reader.readLine()) != null) {
//                    stringBuilder.append(line + "\n");
//                }
//
//                return stringBuilder.toString();
//
//            }
//            catch (Exception e) {
//                e.printStackTrace();
//                return e.toString();
//            }
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            super.onPostExecute(result);
//            Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
//            intent.putExtra("key",word);
//            startActivity(intent);
//        }
//    }

}
