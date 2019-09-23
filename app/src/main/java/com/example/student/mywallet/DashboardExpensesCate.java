package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import Adapters.ExpensesCategoryAdapter;
import Database.WalletDBhelper;
import Model.ExpensesCategory;

public class DashboardExpensesCate extends AppCompatActivity {

    private ArrayList<ExpensesCategory> arrayList;
    WalletDBhelper db;
    RecyclerView rvosa;
    ExpensesCategoryAdapter adapter;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_expenses_cate);

        db = new WalletDBhelper(this);

        arrayList = db.readAllCategoriesOsa();
        rvosa = findViewById(R.id.rviewIshu);
        adapter = new ExpensesCategoryAdapter(arrayList);
        rvosa.setLayoutManager(new LinearLayoutManager(this));
        rvosa.setAdapter(adapter);

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

    //search //
    private void filter(String text){
        ArrayList<ExpensesCategory> filteredList = new ArrayList<>();

        for(ExpensesCategory item :  arrayList){
            if(item.getUname().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        adapter.filteredList(filteredList);
    }
    public void gosettings(View view){
        Intent intent =new Intent(DashboardExpensesCate.this,ExpensesCatSetings.class);
        startActivity(intent);
    }
    public void goBack(View view){
        Intent intent =new Intent(DashboardExpensesCate.this,Categories.class);
        startActivity(intent);
    }
    public void addData5(View view) {
        Intent intent = new Intent(DashboardExpensesCate.this, Account.class);
        startActivity(intent);
    }
}
