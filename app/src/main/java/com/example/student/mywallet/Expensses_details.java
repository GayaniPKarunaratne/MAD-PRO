package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Expensses_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expensses_details);
    }

    public void addData1(View view){
        Intent intent = new Intent(Expensses_details.this,Daily.class);
        startActivity(intent);
    }
    public void addData2(View view){
        Intent intent = new Intent(Expensses_details.this,expenses_category.class);
        startActivity(intent);
    }

    public void addData3(View view){
        Intent intent = new Intent(Expensses_details.this,income_category.class);
        startActivity(intent);
    }

    public void addData4(View view){
        Intent intent = new Intent(Expensses_details.this,My_Wallet_Repot.class);
        startActivity(intent);
    }

    public void addData5(View view){
        Intent intent = new Intent(Expensses_details.this,AddExpenses.class);
        startActivity(intent);
    }

    public void addData6(View view){
        Intent intent = new Intent(Expensses_details.this,Expensses_details.class);
        startActivity(intent);
    }
}
