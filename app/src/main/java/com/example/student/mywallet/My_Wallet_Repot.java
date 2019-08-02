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
}
