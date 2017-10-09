package com.iam9091107.escoladeltreball.org.inversor;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int SECOND_ACTIVITY_REQUEST = 45879;
    private Button sendme;
    private EditText editText;
    private CheckBox inverse;
    private CheckBox capLet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendme = (Button) findViewById(R.id.sendme);
        editText = (EditText) findViewById(R.id.editText);
        inverse = (CheckBox) findViewById(R.id.inverse);
        capLet = (CheckBox) findViewById(R.id.capLet);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity();
            }
        };

        sendme.setOnClickListener(listener);


    }

    private void switchActivity() {

        String text = editText.getText().toString();
        Intent intent = new Intent(this, SubActivity.class);

        if (inverse.isChecked()) {
            text = inverseText(text);
        }

        if (capLet.isChecked()) {
            text = upperText(text);
        }

        intent.putExtra(Intent.EXTRA_COMPONENT_NAME, text);

        startActivityForResult(intent,SECOND_ACTIVITY_REQUEST);

    }

    private String upperText(String text) {

        return text.toUpperCase();
    }

    private String inverseText(String text) {
        text = new StringBuffer(text).reverse().toString();
        return text;
    }

    /*
  Aquest métode es cridarà automàticament quan acabi la sub-activity (Second Activity)
   */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SECOND_ACTIVITY_REQUEST) {
            if (resultCode == RESULT_OK) {
                if (data.hasExtra(Intent.EXTRA_REFERRER)) {
                    //Toast.makeText(this, data.getCharSequenceExtra(Intent.EXTRA_COMPONENT_NAME), Toast.LENGTH_LONG).show();
                    editText.setText(data.getCharSequenceExtra(Intent.EXTRA_REFERRER));
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);

    }
}
