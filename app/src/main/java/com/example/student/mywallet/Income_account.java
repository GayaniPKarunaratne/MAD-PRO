package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Income_account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_account);
    }

    public void account(View view){
        Intent intent = new Intent(Income_account.this,Income_add_account.class);
        startActivity(intent);
    }

    public void accountaddupdatedelete(View view){
        Intent intent = new Intent(Income_account.this,Income_accounteditdelete.class);
        startActivity(intent);
    }
}
