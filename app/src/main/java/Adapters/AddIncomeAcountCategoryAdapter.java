package Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.student.mywallet.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import Model.AddIncomeAcountCategory;

public class AddIncomeAcountCategoryAdapter extends RecyclerView.Adapter<AddIncomeAcountCategoryAdapter.AddIncomeAcountCategoryAdapterViewHolder> {

    private ArrayList<AddIncomeAcountCategory> arrayList;

    public AddIncomeAcountCategoryAdapter(ArrayList<AddIncomeAcountCategory> arrayList){
        this.arrayList = arrayList;
        Log.i( "Adapter","Called");

    }

    @NonNull
    @Override
    public AddIncomeAcountCategoryAdapter.AddIncomeAcountCategoryAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.addincomeacountview,viewGroup, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AddIncomeAcountCategoryAdapter.AddIncomeAcountCategoryAdapterViewHolder addIncomeAcountCategoryAdapterViewHolder, int i) {
        AddIncomeAcountCategory AddIncomeAcount = arrayList.get(i);
        addIncomeAcountCategoryAdapterViewHolder.incomeacount.setText(AddIncomeAcount.getIncomeacount());
        addIncomeAcountCategoryAdapterViewHolder.incomeamount.setText(AddIncomeAcount.getIncomeamount());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();

    }

    public class AddIncomeAcountCategoryAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView incomeacount,incomeamount;
        public AddIncomeAcountCategoryAdapterViewHolder(View itemView){
            super(itemView);
            incomeacount = itemView.findViewById(R.id.textView9);
            incomeamount = itemView.findViewById(R.id.textView18);
        }
    }
}

