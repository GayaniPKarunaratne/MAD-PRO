package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import Adapters.IncomeCategoryAdapter;
import Database.WalletDBhelper;
import Model.IncomeCategory;

public class DasboardIncomeCate extends AppCompatActivity {

    private ArrayList<IncomeCategory> arrayListishu;
    WalletDBhelper db;
    RecyclerView rvishu;
    IncomeCategoryAdapter ishuadapter;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard_income_cate);

        db = new WalletDBhelper(this);
        arrayListishu = db.readAllCategoriesIshu();
        rvishu = findViewById(R.id.Rview2);
        ishuadapter = new IncomeCategoryAdapter(arrayListishu);
        rvishu.setLayoutManager(new LinearLayoutManager(this));
        rvishu.setAdapter(ishuadapter);

        editText = findViewById(R.id.search);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });
    }
    private void filter(String text){
        ArrayList<IncomeCategory> filteredList = new ArrayList<>();

        for(IncomeCategory item :  arrayListishu){
            if(item.getUname().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        ishuadapter.filteredList(filteredList);
    }
    public void gosettings(View view){
        Intent intent =new Intent(DasboardIncomeCate.this,IncomeCatSetting.class);
        startActivity(intent);
    }
    public void goBack(View view){
        Intent intent =new Intent(DasboardIncomeCate.this,Categories.class);
        startActivity(intent);
    }
    public void addData5(View view) {
       // Log.i( "DB" , view.getId()+"" );
        Intent intent = new Intent(DasboardIncomeCate.this, Income_account.class);
        startActivity(intent);
    }
}
