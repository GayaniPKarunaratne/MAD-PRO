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

    public void addData1(View view){
        Intent intent = new Intent(Categories.this,Daily.class);
        startActivity(intent);
    }
    public void addData2(View view){
        Intent intent = new Intent(Categories.this,expenses_category.class);
        startActivity(intent);
    }

    public void addData3(View view){
        Intent intent = new Intent(Categories.this,income_category.class);
        startActivity(intent);
    }

    public void addData4(View view){
        Intent intent = new Intent(Categories.this,My_Wallet_Repot.class);
        startActivity(intent);
    }

    public void addData6(View view){
        Intent intent =new Intent(Categories.this,DasboardIncomeCate.class);
        startActivity(intent);
    }

    public void addData7(View view){
        Intent intent =new Intent(Categories.this,DashboardExpensesCate.class);
        startActivity(intent);
    }
}
