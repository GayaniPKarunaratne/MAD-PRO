package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import Adapters.ExpenseAdapter;
import Adapters.IncomeAdapter;
import Database.WalletDBhelper;
import Model.AddExpense;
import Model.AddIncome;

public class Expensses_details extends AppCompatActivity implements ExpenseAdapter.onExpenceListner{

    WalletDBhelper db;
    RecyclerView rv;
    private ArrayList<AddExpense> arrayList;
    ExpenseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expensses_details);

        db = new WalletDBhelper(this);

        rv = findViewById(R.id.recycleV2);
        rv.setLayoutManager( new LinearLayoutManager(this));
        arrayList = db.readAllExpense();

        adapter = new ExpenseAdapter(arrayList);
        rv.setAdapter(adapter);

        new ItemTouchHelper(itemTouchHelpercallback).attachToRecyclerView(rv);


    }

    public void addData1(View view){
        Intent intent = new Intent(Expensses_details.this,Daily.class);
        startActivity(intent);
    }
    public void addData2(View view){
        Intent intent = new Intent(Expensses_details.this,DashboardExpensesCate.class);
        startActivity(intent);
    }

    ItemTouchHelper.SimpleCallback itemTouchHelpercallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            int deleteid = arrayList.get(viewHolder.getAdapterPosition()).getID();
            db.deleteExpense(deleteid);
            arrayList.remove(deleteid);
            //adapter.notifyDataSetChanged();
            adapter.setArrayList(arrayList);
            Toast.makeText(getApplicationContext(),"DELETED!" +  deleteid  ,Toast.LENGTH_LONG).show();

        }
    };

    public void addData3(View view){
        Intent intent = new Intent(Expensses_details.this,DasboardIncomeCate.class);
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

    @Override
    public void OnExpenseClick(int position) {

    }
}
