package com.example.student.mywallet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import Adapters.AddIncomeAcountCategoryAdapter;
import Database.WalletDBhelper;
import Model.AddIncomeAcountCategory;

public class Income_account extends AppCompatActivity {

    WalletDBhelper db;
    RecyclerView rv;

    AddIncomeAcountCategory adapter;
    private ArrayList<AddIncomeAcountCategory> arrayList;
    EditText editText;
    ItemTouchHelper.Callback itemTouchhelpercallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_account);

//          db = new WalletDBhelper(this);
//          arrayList = db.readAllIncomeAcount();
//
//        rv = findViewById(R.id.recyclerview);
//        adapter = new AddIncomeAcountCategory(arrayList,this);
//        rv.setLayoutManager(new LinearLayoutManager(this));
//        rv.setAdapter(adapter);
//
//        new ItemTouchHelper(itemTouchhelpercallback).attachToRecyclerView(rv);
//
//        editText = findViewById(R.id.search);
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                filter(editable.toString());
//            }
//        });
    }

//    private void filter(String text){
//        ArrayList<AddIncomeAcountCategory> filteredList = new ArrayList<>();
//
//        for(AddIncomeAcountCategory item :  arrayList){
//            if(item.getIncomeacount().toLowerCase().contains(text.toLowerCase())){
//                filteredList.add(item);
//            }
//        }
//        adapter.filteredList(filteredList);
//    }

//    ItemTouchHelper.SimpleCallback itemTouchHelpercallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
//        @Override
//        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
//            return false;
//        }
//
//        @Override
//        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder,int i) {
//            int deleteId = arrayList.get(viewHolder.getAdapterPosition()).getID();
//            db.deleteExpensesAcount(deleteId);
//            arrayList.remove(viewHolder.getAdapterPosition());
//            adapter.notifyDataSetChanged();
//            //db.deleteExpensesAcount(deleteId);
//
//            //arrayList.remove(viewHolder.getAdapterPosition());
//
//            // arrayList.remove(deleteId);
//            //adapter.notifyDataSetChanged();
//            //adapter.setArrayList(arrayList);
//            //adapter.setArrayList(arrayList);
//            Toast.makeText(getApplicationContext(),"DELETED",Toast.LENGTH_LONG).show();
//
//
//        }
//    };


    public void account(View view) {
        Intent intent = new Intent(Income_account.this, AddAccount.class);
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

    public void addData5(View view) {
        Intent intent = new Intent(Income_account.this, Add.class);
        startActivity(intent);
    }

    public void addData6(View view) {
        Intent intent = new Intent(Income_account.this, Income_update_acount.class);
        startActivity(intent);
    }
}
