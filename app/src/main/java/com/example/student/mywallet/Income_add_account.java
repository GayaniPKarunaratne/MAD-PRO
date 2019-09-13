package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import Database.WalletDBhelper;

public class Income_add_account extends AppCompatActivity {

    EditText cost1,cost2;
    ImageButton imaBtn;

     WalletDBhelper db;
     EditText txt_name_income_acount,txt_name_income_amount;
     //TextView data_Income_acount;

    private String income_acount_type, income_amount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_add_account);

        txt_name_income_acount = findViewById(R.id.editText19);
        txt_name_income_amount = findViewById(R.id.editText20);
        db = new WalletDBhelper(this);

        cost1 = (EditText) findViewById(R.id.editText19);
        cost2 = (EditText) findViewById(R.id.editText20);
        imaBtn = (ImageButton) findViewById(R.id.button17);


    }

    public void AddIncomeAcountCategory(View view){
        income_acount_type = txt_name_income_acount.getText().toString().trim();
        income_amount = txt_name_income_amount.getText().toString().trim();

        boolean result = db.addIncomeAcountCategory(income_acount_type,income_amount);
        if(result){
            Toast.makeText(getApplicationContext(),"Data Added ",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Data failed",Toast.LENGTH_LONG).show();
        }
    }

    public void addaccount(View view) {
        Intent intent = new Intent(Income_add_account.this, Income_account.class);
        startActivity(intent);
    }

    public void addData1(View view) {
        Intent intent = new Intent(Income_add_account.this, Daily.class);
        startActivity(intent);
    }

    public void addData2(View view) {
        Intent intent = new Intent(Income_add_account.this, DashboardExpensesCate.class);
        startActivity(intent);
    }

    public void addData3(View view) {
        Intent intent = new Intent(Income_add_account.this, DasboardIncomeCate.class);
        startActivity(intent);
    }

    public void addData4(View view) {
        Intent intent = new Intent(Income_add_account.this, My_Wallet_Repot.class);
        startActivity(intent);
    }
}
