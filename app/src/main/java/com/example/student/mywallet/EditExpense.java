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

public class EditExpense extends AppCompatActivity {

    EditText cost;
    ImageButton imaBtn;

    WalletDBhelper db;
    EditText addexpences ,note ;
    TextView category ;
    private String AddExpenses ,Note , Category ;
    String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_expense);

        db = new WalletDBhelper(this);
        addexpences = findViewById( R.id.editText3);
        note = findViewById( R.id.editText13);
        category = findViewById( R.id.textView71);

        Intent intent = getIntent();
        ID = intent.getIntExtra( "ID" , 0 ) + "";
        String Note = intent.getStringExtra("Note");
        String Amount = intent.getStringExtra("Amount");

        addexpences.setText( Amount );
        note.setText( Note );
    }

    public  void editExpense(View view){
        AddExpenses = addexpences.getText().toString().trim();
        Note = note.getText().toString().trim();


            if(AddExpenses.length() == 0){
                Toast.makeText(getApplicationContext(),"Amount should be filled",Toast.LENGTH_LONG).show();
            }else if (  Note.length() == 0 ) {
                Toast.makeText(getApplicationContext(), "Note Should be filled", Toast.LENGTH_LONG).show();
            } else {
                db.editExpense(ID, AddExpenses, Note);
                Toast.makeText(getApplicationContext(), "Data Edited ", Toast.LENGTH_LONG).show();
            }
    }

    public void addData1(View view){
        Intent intent = new Intent(EditExpense.this,Daily.class);
        startActivity(intent);
    }
    public void addData2(View view){
        Intent intent = new Intent(EditExpense.this,DashboardExpensesCate.class);
        startActivity(intent);
    }

    public void addData3(View view){
        Intent intent = new Intent(EditExpense.this,DasboardIncomeCate.class);
        startActivity(intent);
    }

    public void addData4(View view){
        Intent intent = new Intent(EditExpense.this,My_Wallet_Repot.class);
        startActivity(intent);
    }

    public void addData5(View view){
        Intent intent =new Intent(EditExpense.this,Expensses_details.class);
        startActivity(intent);
    }
}
