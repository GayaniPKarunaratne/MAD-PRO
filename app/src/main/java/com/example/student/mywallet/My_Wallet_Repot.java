package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class My_Wallet_Repot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__wallet__repot);
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
}
