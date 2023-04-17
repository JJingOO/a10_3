package com.cookandroid.a10_3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Second 액티비티");

        Intent inIntent = getIntent();
        String resultVal = (inIntent.getStringExtra("Calc"));

        int Result = 0;
        if (resultVal.equals("+")) {
            Result = inIntent.getIntExtra("Num1", 0) + inIntent.getIntExtra("Num2", 0);
        } else if (resultVal.equals("-")) {
            Result = inIntent.getIntExtra("Num1", 0) - inIntent.getIntExtra("Num2", 0);
        } else if (resultVal.equals("*")) {
            Result = inIntent.getIntExtra("Num1", 0) * inIntent.getIntExtra("Num2", 0);
        } else {
            Result = inIntent.getIntExtra("Num1", 0) / inIntent.getIntExtra("Num2", 0);
        }

        int hapValue = Result;

        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(),
                        MainActivity.class);
                outIntent.putExtra("Hap", hapValue);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}