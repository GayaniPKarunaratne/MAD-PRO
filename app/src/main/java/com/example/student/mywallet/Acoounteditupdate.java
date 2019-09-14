package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import Database.WalletDBhelper;
import Model.AddAcountCategory;
import Model.Users;

public class Acoounteditupdate extends AppCompatActivity {

    private ArrayList<AddAcountCategory> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acoounteditupdate);


    }

    public void account(View view) {
        Intent intent = new Intent(Acoounteditupdate.this, AddExpenses.class);
        startActivity(intent);
    }

    public void addData1(View view) {
        Intent intent = new Intent(Acoounteditupdate.this, Daily.class);
        startActivity(intent);
    }

    public void addData2(View view) {
        Intent intent = new Intent(Acoounteditupdate.this, DashboardExpensesCate.class);
        startActivity(intent);
    }

    public void addData3(View view) {
        Intent intent = new Intent(Acoounteditupdate.this, DasboardIncomeCate.class);
        startActivity(intent);
    }

    public void addData4(View view) {
        Intent intent = new Intent(Acoounteditupdate.this, My_Wallet_Repot.class);
        startActivity(intent);
    }

    public void addData8(View view) {
        Intent intent = new Intent(Acoounteditupdate.this, ExpensesEditAcount.class);
        startActivity(intent);
    }

    /*@Override
    public void onEditClick(int position){
        AddAcountCategory editexpenses = arrayList.get(position);
        Intent intent = new Intent(Acoounteditupdate.this,ExpensesEditAcount.class);
        intent.putExtra("Acount type", intent.getAcount() );
        intent.putExtra("Amount", intent.getAmount() );
        startActivity(intent);


    }*/
}
