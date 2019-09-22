package Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.student.mywallet.AddExpenses;
import com.example.student.mywallet.R;

import java.util.ArrayList;

import Model.AddExpense;
import Model.AddIncome;


public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseAdapterViewHolder>{
    private ArrayList<AddExpense> arrayList;
    private onExpenceListner onExpenceListner;


    public ExpenseAdapter(ArrayList<AddExpense> arrayList , onExpenceListner onExpense) {
        this.arrayList = arrayList;
        this.onExpenceListner = onExpense;
        Log.i("Adapter" , "Called");
    }

    public void setArrayList(ArrayList<AddExpense> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }



    @Override
    public ExpenseAdapter.ExpenseAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from( viewGroup.getContext() ).inflate(R.layout.expenseview , viewGroup , false);
        return new ExpenseAdapter.ExpenseAdapterViewHolder(view,onExpenceListner);
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





    

    public class ExpenseAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView date , amount , category;
        onExpenceListner onExpense;

        public ExpenseAdapterViewHolder(@NonNull View itemView , onExpenceListner onExpense) {
            super(itemView);
            this.onExpense = onExpense;
            date = itemView.findViewById(R.id.date);
            amount = itemView.findViewById(R.id.amount);
            category = itemView.findViewById(R.id.category);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            onExpense.OnExpenseClick(getAdapterPosition());
        }
    }

    public interface onExpenceListner{
        void OnExpenseClick(int position);
    }
}
