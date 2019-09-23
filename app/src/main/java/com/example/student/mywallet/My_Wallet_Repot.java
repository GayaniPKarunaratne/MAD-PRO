package com.example.student.mywallet;

import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import Database.WalletDBhelper;
import Model.AddExpense;
import Model.AddIncome;

public class My_Wallet_Repot extends AppCompatActivity {

    private TextView TotalIncome;
    private TextView TotalExpense;
    private TextView Balance;
    WalletDBhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__wallet__repot);

        TotalIncome = findViewById(R.id.editText4);
        db = new WalletDBhelper(this);
        ArrayList<AddIncome> arrayList = db.readAllIncome();
        TotalIncome.setText( "Rs "+ getTotalIncome(arrayList));

        TotalExpense = findViewById(R.id.editText);
        db = new WalletDBhelper(this);
        ArrayList<AddExpense> arrayList1 = db.readAllExpense();
        TotalExpense.setText("Rs "+ getTotalExpense(arrayList1));

        Balance = findViewById(R.id.editText5);
        Balance.setText( "Rs "+ (Double.valueOf(getTotalIncome(arrayList)) - Double.valueOf(getTotalExpense(arrayList1))) );

    }

    public void expensDetails(View view){
        Intent intent = new Intent(My_Wallet_Repot.this,Expensses_details.class);
        startActivity(intent);
    }

    public void incomeDetails2(View view){
        Intent intent = new Intent(My_Wallet_Repot.this,Income_details.class);
        startActivity(intent);
    }
    public void addData1(View view){
        Intent intent = new Intent(My_Wallet_Repot.this,Daily.class);
        startActivity(intent);
    }
    public void addData2(View view){
        Intent intent = new Intent(My_Wallet_Repot.this,DashboardExpensesCate.class);
        startActivity(intent);
    }

    public void addData3(View view){
        Intent intent = new Intent(My_Wallet_Repot.this,DasboardIncomeCate.class);
        startActivity(intent);
    }

    public void addData4(View view){
        Intent intent = new Intent(My_Wallet_Repot.this,My_Wallet_Repot.class);
        startActivity(intent);
    }

    public String getTotalIncome(ArrayList<AddIncome> incomelist ){
        double total = 0;
        for(AddIncome item : incomelist){
             total += Double.valueOf( item.getIncomeAmount() );
        }
        return String.valueOf(total);
    }

    public String getTotalExpense(ArrayList<AddExpense> expenselist ){
        double total = 0;
        for(AddExpense item : expenselist){
            total += Double.valueOf( item.getExpenseAmount() );
        }
        return String.valueOf(total);
    }


}
