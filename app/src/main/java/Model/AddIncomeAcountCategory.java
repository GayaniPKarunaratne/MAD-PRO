package Model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.student.mywallet.Income_account;

import java.util.ArrayList;

public class AddIncomeAcountCategory extends RecyclerView.Adapter {
    int ID;
    String incomeacount;
    String incomeamount;

    public AddIncomeAcountCategory() {
        this.ID = ID;
        this.incomeacount = incomeacount;
        this.incomeamount = incomeamount;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public AddIncomeAcountCategory(ArrayList<AddIncomeAcountCategory> arrayList, Income_account income_account) {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIncomeacount() {
        return incomeacount;
    }

    public void setIncomeacount(String incomeacount) {
        this.incomeacount = incomeacount;
    }

    public String getIncomeamount() {
        return incomeamount;
    }

    public void setIncomeamount(String incomeamount) {
        this.incomeamount = incomeamount;
    }


    public void filteredList(ArrayList<AddIncomeAcountCategory> filteredList) {
    }
}

