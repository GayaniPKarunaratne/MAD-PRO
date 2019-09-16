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

public class EditIncome extends AppCompatActivity {

    EditText cost;
    ImageButton imaBtn;

    WalletDBhelper db;
    EditText addincome ,note ;
    TextView category ;
    private String AddIncome ,Note , Category ;
    String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_income);

        db = new WalletDBhelper(this);
        addincome = findViewById( R.id.editText8);
        note = findViewById( R.id.editText12);
        category = findViewById( R.id.textView70);

        Intent intent = getIntent();
        ID = intent.getIntExtra( "ID" , 0 ) + "";
        String Note = intent.getStringExtra("Note");
        String Amount = intent.getStringExtra("Amount");

        addincome.setText( Amount );
        note.setText( Note);
    }

    public  void editIncome(View view){
        AddIncome  = addincome.getText().toString().trim();
        Note = note.getText().toString().trim();


            if ( AddIncome.length() == 0  ) {
                Toast.makeText( this, "Amount should be filled", Toast.LENGTH_LONG).show();

            }else if (  Note.length() == 0 ) {
                Toast.makeText(getApplicationContext(), "Note Should be filled", Toast.LENGTH_LONG).show();
            } else {
                db.editIncome(ID, AddIncome, Note);
                Toast.makeText(getApplicationContext(), "Data Edited ", Toast.LENGTH_LONG).show();
            }

    }

    public void addData5(View view){
        Intent intent =new Intent(EditIncome.this,Income_details.class);
        startActivity(intent);
    }

    public void addData1(View view){
        Intent intent = new Intent(EditIncome.this,Daily.class);
        startActivity(intent);
    }
    public void addData2(View view){
        Intent intent = new Intent(EditIncome.this,DashboardExpensesCate.class);
        startActivity(intent);
    }

    public void addData3(View view){
        Intent intent = new Intent(EditIncome.this,DasboardIncomeCate.class);
        startActivity(intent);
    }

    public void addData4(View view){
        Intent intent = new Intent(EditIncome.this,My_Wallet_Repot.class);
        startActivity(intent);
    }
}
