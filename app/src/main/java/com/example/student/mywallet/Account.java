package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
    }

    public void account(View view){
        Intent intent = new Intent(Account.this,AddAccount.class);
        startActivity(intent);
    }

    public void accountaddupdatedelete(View view){
        Intent intent = new Intent(Account.this,Acoounteditupdate.class);
        startActivity(intent);
    }
}
