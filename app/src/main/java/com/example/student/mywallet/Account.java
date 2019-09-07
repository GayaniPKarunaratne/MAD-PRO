package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
    }

    public void account(View view) {
        Intent intent = new Intent(Account.this, AddAccount.class);
        startActivity(intent);
    }

    public void accountaddupdatedelete(View view) {
        Intent intent = new Intent(Account.this, Acoounteditupdate.class);
        startActivity(intent);
    }

    public void addData1(View view) {
        Intent intent = new Intent(Account.this, Daily.class);
        startActivity(intent);
    }

    public void addData2(View view) {
        Intent intent = new Intent(Account.this, expenses_category.class);
        startActivity(intent);
    }

    public void addData3(View view) {
        Intent intent = new Intent(Account.this, income_category.class);
        startActivity(intent);
    }

    public void addData4(View view) {
        Intent intent = new Intent(Account.this, My_Wallet_Repot.class);
        startActivity(intent);
    }
}
