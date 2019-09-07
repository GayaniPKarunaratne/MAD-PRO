package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Income_add_account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_add_account);
    }
    public void addaccount(View view){
        Intent intent = new Intent(Income_add_account.this,Income_account.class);
        startActivity(intent);
    }
}
