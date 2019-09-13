package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;

import Adapters.AddAcountCategoryAdapter;
import Adapters.AddIncomeAcountCategoryAdapter;
import Database.WalletDBhelper;
import Model.AddIncomeAcountCategory;

public class Income_account extends AppCompatActivity {

    WalletDBhelper db;
    RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_account);

        db = new WalletDBhelper(this);

        rv = findViewById(R.id.recyclerview);
        rv.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<AddIncomeAcountCategory> array;
        array = db.readAllIncomeAcount();

        AddIncomeAcountCategoryAdapter adapter = new AddIncomeAcountCategoryAdapter(array);
        rv.setAdapter(adapter);

        //new ItemTouchHelper(itemTouchhelpercallback).attachToRecyclerView(array);
    }

    public void account(View view) {
        Intent intent = new Intent(Income_account.this, Income_add_account.class);
        startActivity(intent);
    }

    public void accountaddupdatedelete(View view) {
        Intent intent = new Intent(Income_account.this, Income_accounteditdelete.class);
        startActivity(intent);
    }

    public void addData1(View view) {
        Intent intent = new Intent(Income_account.this, Daily.class);
        startActivity(intent);
    }

    public void addData2(View view) {
        Intent intent = new Intent(Income_account.this, DashboardExpensesCate.class);
        startActivity(intent);
    }

    public void addData3(View view) {
        Intent intent = new Intent(Income_account.this, DasboardIncomeCate.class);
        startActivity(intent);
    }

    public void addData4(View view) {
        Intent intent = new Intent(Income_account.this, My_Wallet_Repot.class);
        startActivity(intent);
    }
}
