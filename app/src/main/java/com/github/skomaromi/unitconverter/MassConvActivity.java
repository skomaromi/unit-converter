package com.github.skomaromi.unitconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MassConvActivity extends AppCompatActivity {

    @BindView(R.id.btnConvert) Button btnConvert;
    @BindView(R.id.etMassSource) EditText etMassSource;
    @BindView(R.id.sUnitPickerSource) Spinner sUnitPickerSource;
    @BindView(R.id.sUnitPickerDestination) Spinner sUnitPickerDestination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass_conv);

        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    @OnClick(R.id.btnConvert)
    public void showResult() {
        double result, srcValue;
        String srcValueText, srcType, destType, srcMsg, destMsg;

        // get field values
        srcValueText = etMassSource.getText().toString();
        if (srcValueText.length() == 0) {
            Toast.makeText(
                    this,
                    getString(R.string.global_mass) + " must not be empty!",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        srcValue = Double.parseDouble(srcValueText);
        srcType = sUnitPickerSource.getSelectedItem().toString();
        destType = sUnitPickerDestination.getSelectedItem().toString();

        // convert
        result = UnitConverter.Convert(srcType, srcValue, destType);

        // send it to the resultActivity
        Intent resultActivity = new Intent(this, ResultActivity.class);

        srcMsg = String.format("%g %s", srcValue, srcType);
        destMsg = String.format("%g %s", result, destType);
        resultActivity.putExtra(ResultActivity.KEY_SRC, srcMsg);
        resultActivity.putExtra(ResultActivity.KEY_DST, destMsg);

        startActivity(resultActivity);
    }

}
