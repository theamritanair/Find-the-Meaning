package com.example.android.findthemeaning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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

        display.setText(bun.getString("key"));


    }
}
