package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Database.WalletDBhelper;

public class ExpensesEditAcount extends AppCompatActivity {

    EditText cost,cost2;
    WalletDBhelper db;
    //EditText txt_name_acount,txt_name_amount;

    private String acount_type, amount;
    String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses_edit_acount);

        db = new WalletDBhelper(this);
        cost = findViewById(R.id.editText19);
        cost2 = findViewById(R.id.editText20);
        cost2.setInputType(InputType.TYPE_CLASS_NUMBER);

       Intent intent = getIntent();
       ID = intent.getStringExtra("id");
        acount_type = intent.getStringExtra("AccountType");
        amount = intent.getStringExtra("Amount");


        cost.setText(acount_type);
        cost2.setText(amount);
    }
    public void Edit(View view){
        if(TextUtils.isEmpty(cost.getText()) || TextUtils.isEmpty(cost2.getText())){
            cost.setError("Enter The Account Type!");
           cost2.setError("Enter The Amount!");
        }
        else {


           acount_type = cost.getText().toString().trim();
           amount = cost2.getText().toString().trim();

           Log.i("ID :   ", ID);
           boolean result = db.expensesEditAcount(ID, acount_type, amount);
           //cost.getText().clear();
            //cost2.getText().clear();

            if (result == true) {
               Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
               Intent in = new Intent(this, Account.class);
                startActivity(in);

           } else {
                Toast.makeText(getApplicationContext(), "Not Updated", Toast.LENGTH_LONG).show();
           }
       }
    }

    public void addaccount(View view) {
        Intent intent = new Intent(ExpensesEditAcount.this, Account.class);
        startActivity(intent);
    }

    public void addData1(View view) {
        Intent intent = new Intent(ExpensesEditAcount.this, Daily.class);
        startActivity(intent);
    }

    public void addData2(View view) {
        Intent intent = new Intent(ExpensesEditAcount.this, DashboardExpensesCate.class);
        startActivity(intent);
    }

    public void addData3(View view) {
        Intent intent = new Intent(ExpensesEditAcount.this, DasboardIncomeCate.class);
        startActivity(intent);
    }

    public void addData4(View view) {
        Intent intent = new Intent(ExpensesEditAcount.this, My_Wallet_Repot.class);
        startActivity(intent);
    }
}
