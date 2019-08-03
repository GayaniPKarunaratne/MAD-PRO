package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void addData5(View view){
        Intent intent =new Intent(Add.this,Income_details.class);
        startActivity(intent);
    }

    public void addData1(View view){
        Intent intent = new Intent(Add.this,Daily.class);
        startActivity(intent);
    }
    public void addData2(View view){
        Intent intent = new Intent(Add.this,Categories.class);
        startActivity(intent);
    }

    public void addData3(View view){
        Intent intent = new Intent(Add.this,Categories.class);
        startActivity(intent);
    }

    public void addData4(View view){
        Intent intent = new Intent(Add.this,My_Wallet_Repot.class);
        startActivity(intent);
    }
}
