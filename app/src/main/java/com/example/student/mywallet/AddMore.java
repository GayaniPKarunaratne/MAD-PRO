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

public class AddMore extends AppCompatActivity {

    WalletDBhelper db;
    EditText txt_name;
    TextView data;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_more);

        txt_name = findViewById(R.id.editText10);
        data = findViewById(R.id.data);
        db = new WalletDBhelper(this);

        data.setText("");
        int count = 1;

        ArrayList<Users> u = db.readAllInfor();
        for(Users users : u){
            data.append( count + " " + users.getUname() + "\n");
            count++;
        }
    }

    public  void addIncomeCat(View view){
        name = txt_name.getText().toString();

        boolean result = db.addIncomeCategory(name);
        if(result == true){
            Toast.makeText(getApplicationContext(),"Data Added ",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Data failed",Toast.LENGTH_LONG).show();
        }
        displayIncomeInfro(view);
    }

    public void displayIncomeInfro(View view){
        data.setText("");
        int count = 1;

        ArrayList<Users> u = db.readAllInfor();
        for(Users users : u){
            data.append( count + " " + users.getUname() + "\n");
            count++;
        }
    }

    public void deleteIncomeCat(View view){
        name = txt_name.getText().toString();
        db.incomecatDelete(name);
        displayIncomeInfro(view);
    }

    public void updateCatIncome(View view){
        name = txt_name.getText().toString();
        db.incomeCatUpdate(name);
        displayIncomeInfro(view);
    }







    public void addData1(View view){
        Intent intent = new Intent(AddMore.this,Daily.class);
        startActivity(intent);
    }
    public void addData2(View view){
        Intent intent = new Intent(AddMore.this,expenses_category.class);
        startActivity(intent);
    }

    public void addData3(View view){
        Intent intent = new Intent(AddMore.this,income_category.class);
        startActivity(intent);
    }

    public void addData4(View view){
        Intent intent = new Intent(AddMore.this,My_Wallet_Repot.class);
        startActivity(intent);
    }
    public void addData5(View view){
        Intent intent = new Intent(AddMore.this,expenses_category.class);
        startActivity(intent);
    }
}
