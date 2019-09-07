package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Acoounteditupdate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acoounteditupdate);
    }

    public void account(View view){
        Intent intent = new Intent(Acoounteditupdate.this,AddExpenses.class);
        startActivity(intent);
    }
}
