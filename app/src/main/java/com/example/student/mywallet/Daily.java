package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Daily extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);
    }

    public void addData1(View view){
        Intent intent = new Intent(Daily.this,Categories.class);
        startActivity(intent);
    }

    public void addData2(View view){
        Intent intent = new Intent(Daily.this,Categories.class);
        startActivity(intent);
    }

    public void addData3(View view){
        Intent intent = new Intent(Daily.this,My_Wallet_Repot.class);
        startActivity(intent);
    }

}
