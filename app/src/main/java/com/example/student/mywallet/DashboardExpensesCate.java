package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import Adapters.ExpensesCategoryAdapter;
import Database.WalletDBhelper;
import Model.ExpensesCategory;

public class DashboardExpensesCate extends AppCompatActivity {

    private ArrayList<ExpensesCategory> arrayList;
    WalletDBhelper db;
    RecyclerView rvosa;
    ExpensesCategoryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_expenses_cate);

        db = new WalletDBhelper(this);

        arrayList = db.readAllCategoriesOsa();
        rvosa = findViewById(R.id.rviewOsa);
        adapter = new ExpensesCategoryAdapter(arrayList);
        rvosa.setLayoutManager(new LinearLayoutManager(this));
        rvosa.setAdapter(adapter);


    }
    public void gosettings(View view){
        Intent intent =new Intent(DashboardExpensesCate.this,ExpensesCatSetings.class);
        startActivity(intent);
    }
    public void goBack(View view){
        Intent intent =new Intent(DashboardExpensesCate.this,Categories.class);
        startActivity(intent);
    }
}
