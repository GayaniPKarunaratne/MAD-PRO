package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Income_update_acount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_update_acount);
    }

    public void addData1(View view) {
        Intent intent = new Intent(Income_update_acount.this, Daily.class);
        startActivity(intent);
    }

    public void addData2(View view) {
        Intent intent = new Intent(Income_update_acount.this, DashboardExpensesCate.class);
        startActivity(intent);
    }

    public void addData3(View view) {
        Intent intent = new Intent(Income_update_acount.this, DasboardIncomeCate.class);
        startActivity(intent);
    }

    public void addData4(View view) {
        Intent intent = new Intent(Income_update_acount.this, My_Wallet_Repot.class);
        startActivity(intent);
    }

    public void addData7(View view) {
        Intent intent = new Intent(Income_update_acount.this, Income_account.class);
        startActivity(intent);
    }
}
