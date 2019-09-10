package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class IncomeCatSetting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_cat_setting);
    }
    public void goBack(View view){
        Intent intent =new Intent(IncomeCatSetting.this,DasboardIncomeCate.class);
        startActivity(intent);
    }
}
