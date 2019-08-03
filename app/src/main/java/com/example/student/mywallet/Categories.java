package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
    }

    public void addData6(View view){
        Intent intent =new Intent(Categories.this,Add.class);
        startActivity(intent);
    }

    public void addData7(View view){
        Intent intent =new Intent(Categories.this,AddExpenses.class);
        startActivity(intent);
    }
}
