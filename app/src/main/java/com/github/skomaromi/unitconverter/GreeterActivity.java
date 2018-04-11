package com.github.skomaromi.unitconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GreeterActivity extends AppCompatActivity {

    @BindView(R.id.btnOpenLengthConvActivity) Button bLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeter);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnOpenLengthConvActivity)
    public void openLengthConvActivity() {
        Intent lengthConvActivity = new Intent(this, LengthConvActivity.class);
        startActivity(lengthConvActivity);
    }
}
