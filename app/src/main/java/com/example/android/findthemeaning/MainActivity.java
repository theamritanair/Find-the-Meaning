package com.example.android.findthemeaning;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.searchText)
    EditText searchArea;

    @BindView(R.id.searchButton)
    Button searchButton;

    String language = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String res = dictionaryEntries();
                if(res=="false_eng"){
                    Toast.makeText(getApplicationContext(), "Not an English word", Toast.LENGTH_SHORT)
                            .show();
                }
                else if(res=="false_hin"){
                    Toast.makeText(getApplicationContext(), "यह एक हिंदी शब्द नहीं है।", Toast.LENGTH_SHORT)
                            .show();
                }
                else if(res=="No input"){
                    Toast.makeText(getApplicationContext(), "Please enter a word", Toast.LENGTH_SHORT)
                            .show();
                }
                else
                    new CallbackTask().execute(res);
            }
        });

        RelativeLayout menu=(RelativeLayout) findViewById(R.id.langauge);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFilterPopup(v);
            }
        });
    }

    private void showFilterPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        final TextView text=(TextView)findViewById(R.id.text);
        popup.inflate(R.menu.lan_menu);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.i1:
                        language = "en";
                        text.setText("en");
                        return true;
                    case R.id.i2:
                        language = "hi";
                        text.setText("hi");
                        return true;
                    default:
                        return false;
                }
            }
        });

        popup.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                AlertDialog.Builder aboutDialog = new AlertDialog.Builder(MainActivity.this);
                final View aboutDialogLayout = getLayoutInflater().inflate(R.layout.dialog_about, null);
                final TextView docLink = (TextView) aboutDialogLayout.findViewById(R.id.doc_link);

                aboutDialog.setView(aboutDialogLayout);

                aboutDialog.setCancelable(true);
                AlertDialog about = aboutDialog.create();
                about.getWindow().setLayout(200,200);
                about.show();

                docLink.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        Intent browser= new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.oxforddictionaries.com/documentation"));
                        startActivity(browser);
                    }

                });

        }
        return true;
    }

    private String dictionaryEntries() {
        final String word = searchArea.getText().toString();
        if(TextUtils.isEmpty(word))
            return "No input";
        final String word_id = word.toLowerCase(); //word id is case sensitive and lowercase is required
        if(language == "en") {
            for (int i = 0; i < word_id.length(); ++i) {
                if (word_id.charAt(i) < 97 || word_id.charAt(i) > 122) {
                    return "false_eng";
                }
            }
        }
        else{
            for (int i = 0; i < word_id.length(); ++i) {
                if (word_id.charAt(i) < 0x0900 || word_id.charAt(i) > 0x097F) {
                    return "false_hin";
                }
            }
        }
        return "https://od-api.oxforddictionaries.com:443/api/v1/entries/" + language + "/" + word_id;
    }


    private class CallbackTask extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {

            //TODO: replace with your own app id and app key
            final String app_id = "fb3fc25c";
            final String app_key = "92e3e400116f3a4f74c580496c3fe82a";
            try {
                URL url = new URL(params[0]);
                HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                urlConnection.setRequestProperty("Accept","application/json");
                urlConnection.setRequestProperty("app_id",app_id);
                urlConnection.setRequestProperty("app_key",app_key);

                // read the output from the server
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();

                String line = null;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }

                return stringBuilder.toString();

            }
            catch (Exception e) {
                e.printStackTrace();
                return e.toString();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
            intent.putExtra("key",result);
            startActivity(intent);

            System.out.println(result);
        }
    }

}
