package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DeleteCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_category);
    }

    public void onBack(View view) {
        Intent myHome = new Intent(this, Delete_Update.class);
        startActivity(myHome);

    }

    public void addData1(View view){
        Intent intent = new Intent(DeleteCategory.this,Daily.class);
        startActivity(intent);
    }
    public void addData2(View view){
        Intent intent = new Intent(DeleteCategory.this,expenses_category.class);
        startActivity(intent);
    }

    public void addData3(View view){
        Intent intent = new Intent(DeleteCategory.this,income_category.class);
        startActivity(intent);
    }

    public void addData4(View view){
        Intent intent = new Intent(DeleteCategory.this,My_Wallet_Repot.class);
        startActivity(intent);
    }
}