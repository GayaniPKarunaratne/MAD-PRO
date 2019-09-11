package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Income_accounteditdelete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_accounteditdelete);
    }

    public void account(View view) {
        Intent intent = new Intent(Income_accounteditdelete.this, Add.class);
        startActivity(intent);
    }

    public void addData1(View view) {
        Intent intent = new Intent(Income_accounteditdelete.this, Daily.class);
        startActivity(intent);
    }

    public void addData2(View view) {
        Intent intent = new Intent(Income_accounteditdelete.this, DashboardExpensesCate.class);
        startActivity(intent);
    }

    public void addData3(View view) {
        Intent intent = new Intent(Income_accounteditdelete.this, DasboardIncomeCate.class);
        startActivity(intent);
    }

    public void addData4(View view) {
        Intent intent = new Intent(Income_accounteditdelete.this, My_Wallet_Repot.class);
        startActivity(intent);
    }
}
