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

import Adapters.AddAcountCategoryAdapter;
import Database.WalletDBhelper;
import Model.AddAcountCategory;



public class Account extends AppCompatActivity implements AddAcountCategoryAdapter.OnAcountListener {

    WalletDBhelper db;
    RecyclerView rv;
    AddAcountCategory ac;
    AddAcountCategory editexpenses;

    private ArrayList<AddAcountCategory> arrayList;
    AddAcountCategoryAdapter adapter;
    AddAcountCategory  addAcountCategory;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        db = new WalletDBhelper(this);
        arrayList =db.readAllInforAcount();

        rv = findViewById(R.id.recyclerview);
        adapter = new AddAcountCategoryAdapter(arrayList,this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        new ItemTouchHelper(itemTouchHelpercallback).attachToRecyclerView(rv);

        editText = findViewById(R.id.search);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });
    }

    @Override
    public void onAcountClick(int position){
        ac = arrayList.get(position);
        //editexpenses = arrayList.get(position);
        Intent intent = new Intent(Account.this,ExpensesEditAcount.class);
        intent.putExtra("id", ac.getID()+"");
        intent.putExtra("AccountType", ac.getAcount() );
        intent.putExtra("Amount", ac.getAmount() );
        startActivity(intent);
        //Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();


    }

    private void filter(String text){
        ArrayList<AddAcountCategory> filteredList = new ArrayList<>();

        for(AddAcountCategory item :  arrayList){
            if(item.getAcount().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        adapter.filteredList(filteredList);
    }

    ItemTouchHelper.SimpleCallback itemTouchHelpercallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder,int i) {
            int deleteId = arrayList.get(viewHolder.getAdapterPosition()).getID();
            db.deleteExpensesAcount(deleteId);
            arrayList.remove(viewHolder.getAdapterPosition());
            adapter.notifyDataSetChanged();
            //db.deleteExpensesAcount(deleteId);

            //arrayList.remove(viewHolder.getAdapterPosition());

           // arrayList.remove(deleteId);
            //adapter.notifyDataSetChanged();
            //adapter.setArrayList(arrayList);
            //adapter.setArrayList(arrayList);
           Toast.makeText(getApplicationContext(),"DELETED",Toast.LENGTH_LONG).show();


        }
    };

    @Override
    public void onEditClick(int position){



    }

    public void account(View view) {
        Intent intent = new Intent(Account.this, AddAccount.class);
        startActivity(intent);
    }

    /*public void accountaddupdatedelete(View view) {
        Intent intent = new Intent(Account.this, Acoounteditupdate.class);
        startActivity(intent);
    }*/

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

    public void addData5(View view) {
        Intent intent = new Intent(Account.this, AddExpenses.class);
        startActivity(intent);
    }
}
