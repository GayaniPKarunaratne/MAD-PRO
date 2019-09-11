package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import Adapters.AddAcountCategoryAdapter;
import Database.WalletDBhelper;
import Model.AddAcountCategory;

public class Account extends AppCompatActivity {

    WalletDBhelper db;
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

   db = new WalletDBhelper(this);

      rv = findViewById(R.id.recyclerview);
        rv.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<AddAcountCategory> array = new ArrayList<>();//db.readAllInforAcount();
        AddAcountCategoryAdapter adapter = new AddAcountCategoryAdapter(array);
        rv.setAdapter(adapter);
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
        Intent intent = new Intent(Account.this, DashboardExpensesCate.class);
        startActivity(intent);
    }

    public void addData3(View view) {
        Intent intent = new Intent(Account.this, DasboardIncomeCate.class);
        startActivity(intent);
    }

    public void addData4(View view) {
        Intent intent = new Intent(Account.this, My_Wallet_Repot.class);
        startActivity(intent);
    }
}
