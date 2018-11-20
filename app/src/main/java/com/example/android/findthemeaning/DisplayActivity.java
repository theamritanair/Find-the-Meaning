package com.example.android.findthemeaning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DisplayActivity extends AppCompatActivity {

    @BindView(R.id.displayText)
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        ButterKnife.bind(this);

        Bundle bun = getIntent().getExtras();

        String jsonString = bun.getString("key");

        JSONObject jsonObject = null;
        JSONArray result = null;
       try{
            jsonObject = new JSONObject(jsonString);
        }catch (JSONException e) {
            e.printStackTrace();
        }


        try {
            result = jsonObject.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }




//        JSON json = fromStringToJSON(jsonString);
//
//        if(json.obj==null){
//
//            if(json.isJsonArray) {
//                JSONArray jsonArray = (JSONArray) json.obj;
//            }else{
//                JSONObject jsonObj = (JSONObject) json.obj;
//            }
//        }


    }

//    public static JSON fromStringToJSON(String jsonString){
//
//        boolean isJsonArray = false;
//        Object obj = null;
//
//        try {
//            JSONArray jsonArray = new JSONArray(jsonString);
//            Log.d("JSON", jsonArray.toString());
//            obj = jsonArray;
//            isJsonArray = true;
//        }
//        catch (Throwable t) {
//            Log.e("JSON", "Malformed JSON: \"" + jsonString + "\"");
//        }
//
//        if (obj == null) {
//            try {
//                JSONObject jsonObject = new JSONObject(jsonString);
//                Log.d("JSON", jsonObject.toString());
//                obj = jsonObject;
//                isJsonArray = false;
//            } catch (Throwable t) {
//                Log.e("JSON", "Malformed JSON: \"" + jsonString + "\"");
//            }
//        }
//
//        return new JSON(obj, isJsonArray);
//    }
}
