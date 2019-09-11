package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import Database.WalletDBhelper;

public class Add extends AppCompatActivity {

    EditText cost;
    ImageButton imaBtn;

    WalletDBhelper db;
    EditText addincome ,note ;
    TextView category ;
    private String AddIncome ,Note , Category ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        db = new WalletDBhelper(this);
        addincome = findViewById( R.id.editText8);
        note = findViewById( R.id.editText12);
        category = findViewById( R.id.textView70);


        cost = (EditText)findViewById(R.id.editText8);
        imaBtn = (ImageButton)findViewById(R.id.imageButton4);

//        imaBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(!cost.getText().toString().isEmpty()){
//                    Toast.makeText(Add.this,"Thank you",Toast.LENGTH_LONG).show();
//                    Intent intent =new Intent(Add.this,Income_details.class);
//                    startActivity(intent);
//                }
//                else{
//                    Toast.makeText(Add.this,"Please Input Value",Toast.LENGTH_SHORT).show();
//                    Intent intent =new Intent(Add.this,Income_details.class);
//                    startActivity(intent);
//                }
//            }
//        });
    }

    public  void addIncome(View view){
        AddIncome  = addincome.getText().toString().trim();
        Note = note.getText().toString().trim();
        Category = category.getText().toString().trim();

        boolean result = db.addIncome( AddIncome , Note , Category );
        if(result == true){
            Toast.makeText(getApplicationContext(),"Data Added ",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Data failed",Toast.LENGTH_LONG).show();
        }

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
        Intent intent = new Intent(Add.this,DashboardExpensesCate.class);
        startActivity(intent);
    }

    public void addData3(View view){
        Intent intent = new Intent(Add.this,DasboardIncomeCate.class);
        startActivity(intent);
    }

    public void addData4(View view){
        Intent intent = new Intent(Add.this,My_Wallet_Repot.class);
        startActivity(intent);
    }
}
