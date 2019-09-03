package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class UpdateCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_category);

        Spinner myspin = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> myadap = new ArrayAdapter<String>(UpdateCategory.this ,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.UpdateCat));

        myadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspin.setAdapter(myadap);



    }

    public void onBack(View view){
        Intent myHome = new Intent(this,Delete_Update.class);
        startActivity(myHome);

    }
}
