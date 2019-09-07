package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class income_category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_category);
    }

    public void addData1(View view) {
        Intent intent = new Intent(income_category.this, Daily.class);
        startActivity(intent);
    }

    public void addData2(View view) {
        Intent intent = new Intent(income_category.this, expenses_category.class);
        startActivity(intent);
    }

    public void addData3(View view) {
        Intent intent = new Intent(income_category.this, income_category.class);
        startActivity(intent);
    }

    public void addData4(View view) {
        Intent intent = new Intent(income_category.this, My_Wallet_Repot.class);
        startActivity(intent);
    }

    public void addData5(View view) {
        Intent intent = new Intent(income_category.this, Income_account.class);
        startActivity(intent);
    }

    public void addData6(View view) {
        Intent intent = new Intent(income_category.this, AddMore.class);
        startActivity(intent);
    }

    public void onBots2(View view) {
        Intent myHome = new Intent(this, Delete_Update.class);
        startActivity(myHome);


    }
}
