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

import Model.AddIncome;

public class IncomeAdapter extends RecyclerView.Adapter<IncomeAdapter.IncomeAdapterViewHolder> {

    private ArrayList<AddIncome> arrayList;
    private  onIncomeListner onIncomeListner;

    public IncomeAdapter(ArrayList<AddIncome> arrayList,  onIncomeListner onIncome) {
        this.arrayList = arrayList;
        this.onIncomeListner = onIncome;
        Log.i("Adapter" , "Called");
    }


    public void setArrayList(ArrayList<AddIncome> arrayList  ) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public IncomeAdapter.IncomeAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( viewGroup.getContext() ).inflate(R.layout.incomeview , viewGroup , false);
        return new IncomeAdapterViewHolder(view , onIncomeListner );
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

    public class IncomeAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView date , amount , category;
        onIncomeListner onIncome;

        public IncomeAdapterViewHolder(@NonNull View itemView , onIncomeListner onIncome ) {
            super(itemView);
            this.onIncome = onIncome;
            date = itemView.findViewById(R.id.date);
            amount = itemView.findViewById(R.id.amount);
            category = itemView.findViewById(R.id.category);
            itemView.setOnClickListener( this);
        }

        @Override
        public void onClick(View view) {
            onIncome.OnIncomeClick(getAdapterPosition() );
        }
    }

    public interface onIncomeListner{
        void OnIncomeClick(int position);
    }
    public void filterList(ArrayList<AddIncome> filteredList){
        arrayList = filteredList;
        notifyDataSetChanged();
    }
}
