package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class expenses_category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses_category);
    }

    public void addData1(View view) {
        Intent intent = new Intent(expenses_category.this, Daily.class);
        startActivity(intent);
    }

    public void addData2(View view) {
        Intent intent = new Intent(expenses_category.this, expenses_category.class);
        startActivity(intent);
    }

    public void addData3(View view) {
        Intent intent = new Intent(expenses_category.this, income_category.class);
        startActivity(intent);
    }

    public void addData4(View view) {
        Intent intent = new Intent(expenses_category.this, My_Wallet_Repot.class);
        startActivity(intent);
    }

    public void addData5(View view) {
        Intent intent = new Intent(expenses_category.this, Account.class);
        startActivity(intent);
    }

    public void goExpensesIshu(View view) {
        Toast.makeText(view.getContext() , "this is okay" , Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, addmore2.class);
        startActivity(intent);
    }

    public void onBots(View view) {
        Intent myHome = new Intent(this, Delete_Update.class);
        startActivity(myHome);

    }

    public void onBack(View view) {
        Intent myHome = new Intent(this, Categories.class);
        startActivity(myHome);

    }
}