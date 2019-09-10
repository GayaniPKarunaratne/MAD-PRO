package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DasboardIncomeCate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard_income_cate);
    }
    public void gosettings(View view){
        Intent intent =new Intent(DasboardIncomeCate.this,IncomeCatSetting.class);
        startActivity(intent);
    }
    public void goBack(View view){
        Intent intent =new Intent(DasboardIncomeCate.this,Categories.class);
        startActivity(intent);
    }
}
