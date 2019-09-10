package Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.student.mywallet.R;

import java.util.ArrayList;

import Model.AddExpense;



public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseAdapterViewHolder>{
    private ArrayList<AddExpense> arrayList;

    public ExpenseAdapter(ArrayList<AddExpense> arrayList) {
        this.arrayList = arrayList;
        Log.i("Adapter" , "Called");
    }

    @Override
    public ExpenseAdapter.ExpenseAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from( viewGroup.getContext() ).inflate(R.layout.expenseview , viewGroup , false);
        return new ExpenseAdapter.ExpenseAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExpenseAdapterViewHolder holder, int i) {

        AddExpense expense = arrayList.get(i);
        holder.amount.setText( expense.getExpenseAmount() );
        holder.date.setText( expense.getDate() );
        holder.category.setText( expense.getCategory() );
        Log.i("Adapter" , "Hello");
    }

    @Override
    public int getItemCount() { return arrayList.size(); }

    public class ExpenseAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView date , amount , category;
        public ExpenseAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            amount = itemView.findViewById(R.id.amount);
            category = itemView.findViewById(R.id.category);
        }
    }
}
