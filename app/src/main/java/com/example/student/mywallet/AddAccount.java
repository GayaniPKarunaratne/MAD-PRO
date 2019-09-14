package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import Adapters.AddAcountCategoryAdapter;
import Database.WalletDBhelper;
import Model.AddAcountCategory;

public class AddAccount extends AppCompatActivity {

    EditText cost,cost2;
    ImageButton imaBtn;

    WalletDBhelper db;
    EditText txt_name_acount,txt_name_amount;
    //TextView data_acount;
    private String acount_type, amount;

    private ArrayList<AddAcountCategory> arrayList;
    AddAcountCategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);

        txt_name_acount = findViewById(R.id.editText19);
        txt_name_amount = findViewById(R.id.editText20);
        //data_acount = findViewById(R.id.textView10);
        txt_name_amount.setInputType(InputType.TYPE_CLASS_NUMBER);
        db = new WalletDBhelper(this);



        cost = (EditText) findViewById(R.id.editText19);
        cost2 = (EditText) findViewById(R.id.editText20);
        imaBtn = (ImageButton)findViewById(R.id.imageButton4);

        /*data_acount.setText("");
        int count = 1;



        ArrayList<AddAcountCategory> u = db.readAllInforAcount();
        for (AddAcountCategory users : u) {
            txt_name_amount.append(txt_name_amount + " " + users.getAmount() + "\n");
            EditText editText = txt_name_amount++;
        }*/
    }
    public void AddAcountCategorye(View view){
        if(TextUtils.isEmpty(cost.getText()) || TextUtils.isEmpty(cost2.getText())){
            cost.setError("Enter The Account Type!");
            cost2.setError("Enter The Amount!");
        }
        else {


            acount_type = txt_name_acount.getText().toString().trim();
            amount = txt_name_amount.getText().toString().trim();

            boolean result = db.addAccountCategory(acount_type, amount);
            cost.getText().clear();
            cost2.getText().clear();

            if (result == true) {
                Toast.makeText(getApplicationContext(), "Data Added ", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, Account.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Data failed", Toast.LENGTH_LONG).show();
            }
        }
    }



       /* public void displayAddAcountCategorye(View view ){
            data_acount.setText("");
            int counte = 1;

            ArrayList<Users> ac = db.readAllInforAcount();
            for(AddAcountCategory  : ac){
                data_acount.append( counte + " " + AddAcountCategory.getAmount() + "\n");
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
            displayAddAcountCategorye(view);
        }*/




    public void addaccount(View view) {
        Intent intent = new Intent(AddAccount.this, Account.class);
        startActivity(intent);
    }

    public void addData1(View view) {
        Intent intent = new Intent(AddAccount.this, Daily.class);
        startActivity(intent);
    }

    public void addData2(View view) {
        Intent intent = new Intent(AddAccount.this, DashboardExpensesCate.class);
        startActivity(intent);
    }

    public void addData3(View view) {
        Intent intent = new Intent(AddAccount.this, DasboardIncomeCate.class);
        startActivity(intent);
    }

    public void addData4(View view) {
        Intent intent = new Intent(AddAccount.this, My_Wallet_Repot.class);
        startActivity(intent);
    }
}
