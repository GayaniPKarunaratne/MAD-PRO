package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Database.WalletDBhelper;
import Model.Users;

public class AddAccount extends AppCompatActivity {

    WalletDBhelper db;
    EditText txt_name_acount,txt_name_amount;
    TextView data_acount;
    private String acount_type, amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);

        txt_name_acount = findViewById(R.id.editText7);
        txt_name_amount = findViewById(R.id.editText11);
        data_acount = findViewById(R.id.textView10);
        db = new WalletDBhelper(this);

        data_acount.setText("");
        int count = 1;

        ArrayList<Users> u = db.readAllInforAcount();
        for (Users users : u) {
            data_acount.append(count + " " + users.getUname() + "\n");
            count++;
        }
    }
        public void AddAcountCategorye(View view){
            acount_type = txt_name_acount.getText().toString();
            amount = txt_name_amount.getText().toString();

            boolean result = db.addAccountCategory(acount_type,amount);
            if(result == true){
                Toast.makeText(getApplicationContext(),"Data Added ",Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getApplicationContext(),"Data failed",Toast.LENGTH_LONG).show();
            }
           // displayAddAcountCategorye(view);
        }



        public void displayAddAcountCategorye(View view ){
            data_acount.setText("");
            int counte = 1;

            ArrayList<Users> ac = db.readAllInfor2();
            for(Users users : ac){
                data_acount.append( counte + " " + users.getUname() + "\n");
                counte++;
            }
        }

        public void deleteAddAcountCategory(View view){
            acount_type = txt_name_acount.getText().toString();
            amount = txt_name_amount.getText().toString();
            db.ExpensescatDelete(acount_type);
            db.ExpensescatDelete(amount);
            displayAddAcountCategorye(view);
        }

        public void updateAddAcountCategory(View view){
            acount_type = txt_name_acount.getText().toString();
            amount = txt_name_amount.getText().toString();
            db.ExpensesCatUpdate(acount_type);
            db.ExpensesCatUpdate(amount);
            //displayAddAcountCategorye(view);
        }

















    public void addaccount(View view) {
        Intent intent = new Intent(AddAccount.this, Account.class);
        startActivity(intent);
    }

    public void addData1(View view) {
        Intent intent = new Intent(AddAccount.this, Daily.class);
        startActivity(intent);
    }

    public void addData2(View view) {
        Intent intent = new Intent(AddAccount.this, expenses_category.class);
        startActivity(intent);
    }

    public void addData3(View view) {
        Intent intent = new Intent(AddAccount.this, income_category.class);
        startActivity(intent);
    }

    public void addData4(View view) {
        Intent intent = new Intent(AddAccount.this, My_Wallet_Repot.class);
        startActivity(intent);
    }
}
