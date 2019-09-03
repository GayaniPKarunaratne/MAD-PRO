package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Delete_Update extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete__update);
    }

    public void onBack(View view) {
        Intent myHome = new Intent(this, expenses_category.class);
        startActivity(myHome);

    }

    public void deleteGo(View view) {
        Intent myHome = new Intent(this, DeleteCategory.class);
        startActivity(myHome);

    }

    public void updateGo(View view) {
        Intent myHome = new Intent(this, UpdateCategory.class);
        startActivity(myHome);

    }
}
