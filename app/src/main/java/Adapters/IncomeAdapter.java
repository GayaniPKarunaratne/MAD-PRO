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
import java.util.zip.Inflater;

import Model.AddIncome;

public class IncomeAdapter extends RecyclerView.Adapter<IncomeAdapter.IncomeAdapterViewHolder> {

    private ArrayList<AddIncome> arrayList;

    public IncomeAdapter(ArrayList<AddIncome> arrayList) {
        this.arrayList = arrayList;
        Log.i("Adapter" , "Called");
    }

    public void setArrayList(ArrayList<AddIncome> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public IncomeAdapter.IncomeAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( viewGroup.getContext() ).inflate(R.layout.incomeview , viewGroup , false);
        return new IncomeAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IncomeAdapterViewHolder holder, int i) {
        AddIncome income = arrayList.get(i);
        holder.amount.setText( income.getIncomeAmount() );
        holder.date.setText( income.getDate() );
        holder.category.setText( income.getCategory() );
        Log.i("Adapter" , "Hello");

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class IncomeAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView date , amount , category;
        public IncomeAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            amount = itemView.findViewById(R.id.amount);
            category = itemView.findViewById(R.id.category);
        }
    }

    public interface onIncomeListner{
        void OnIncomeClick(int position);
    }
}
