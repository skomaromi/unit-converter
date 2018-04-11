package com.github.skomaromi.unitconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity {
    public static final String KEY_SRC = "source";
    public static final String KEY_DST = "destination";

    @BindView(R.id.tvResultSource) TextView tvSource;
    @BindView(R.id.tvResultDestination) TextView tvDestination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent startingIntent = getIntent();
        handleStartingIntent(startingIntent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void handleStartingIntent(Intent startingIntent) {
        if(startingIntent != null) {
            if(startingIntent.hasExtra(KEY_SRC)) {
                String src = startingIntent.getStringExtra(KEY_SRC) + " is";
                tvSource.setText(src);
            }

            if(startingIntent.hasExtra(KEY_DST)) {
                String dst = startingIntent.getStringExtra(KEY_DST);
                tvDestination.setText(dst);
            }
        }
    }
}
