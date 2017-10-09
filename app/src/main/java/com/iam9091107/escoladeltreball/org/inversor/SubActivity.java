package com.iam9091107.escoladeltreball.org.inversor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {

    private EditText editSub;
    Intent originalIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        editSub = (EditText) findViewById(R.id.editSub);

        originalIntent = getIntent();

        showText();

    }

    private void showText(){

        String text = originalIntent.getStringExtra(Intent.EXTRA_COMPONENT_NAME);
        editSub.setText(text);

    }

    @Override
    public void finish() {
        Intent localIntent = new Intent();
        localIntent.putExtra(Intent.EXTRA_REFERRER,editSub.getText().toString());
        setResult(RESULT_OK,localIntent);
        super.finish();
    }

}
