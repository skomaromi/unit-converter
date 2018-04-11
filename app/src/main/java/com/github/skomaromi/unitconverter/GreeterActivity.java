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
    @BindView(R.id.btnOpenSpeedConvActivity) Button bSpeed;
    @BindView(R.id.btnOpenMassConvActivity) Button bMass;
    @BindView(R.id.btnOpenTemperatureConvActivtity) Button bTemperature;

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

    @OnClick(R.id.btnOpenSpeedConvActivity)
    public void openSpeedConvActivity() {
        Intent speedConvActivity = new Intent(this, SpeedConvActivity.class);
        startActivity(speedConvActivity);
    }

    @OnClick(R.id.btnOpenMassConvActivity)
    public void openMassConvActivity() {
        Intent massConvActivity = new Intent(this, MassConvActivity.class);
        startActivity(massConvActivity);
    }

    @OnClick(R.id.btnOpenTemperatureConvActivtity)
    public void openTemperatureConvActivity() {
        Intent temperatureConvActivity = new Intent(this, TemperatureConvActivity.class);
        startActivity(temperatureConvActivity);
    }
}
