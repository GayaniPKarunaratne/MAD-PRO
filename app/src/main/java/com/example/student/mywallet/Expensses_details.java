package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import Adapters.ExpenseAdapter;
import Adapters.IncomeAdapter;
import Database.WalletDBhelper;
import Model.AddExpense;
import Model.AddIncome;

public class Expensses_details extends AppCompatActivity {

    WalletDBhelper db;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expensses_details);

        db = new WalletDBhelper(this);

        rv = findViewById(R.id.recycleV2);
        rv.setLayoutManager( new LinearLayoutManager(this));
        ArrayList<AddExpense> array = db.readAllExpense();

        ExpenseAdapter adapter = new ExpenseAdapter(array);
        rv.setAdapter(adapter);
    }

    public void addData1(View view){
        Intent intent = new Intent(Expensses_details.this,Daily.class);
        startActivity(intent);
    }
    public void addData2(View view){
        Intent intent = new Intent(Expensses_details.this,expenses_category.class);
        startActivity(intent);
    }

    public void addData3(View view){
        Intent intent = new Intent(Expensses_details.this,income_category.class);
        startActivity(intent);
    }

    public void addData4(View view){
        Intent intent = new Intent(Expensses_details.this,My_Wallet_Repot.class);
        startActivity(intent);
    }

    public void addData5(View view){
        Intent intent = new Intent(Expensses_details.this,AddExpenses.class);
        startActivity(intent);
    }

    public void addData6(View view){
        Intent intent = new Intent(Expensses_details.this,Expensses_details.class);
        startActivity(intent);
    }
}
