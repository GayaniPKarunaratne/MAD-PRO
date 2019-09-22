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
    private OnincomeAcountListener noincomeacountListener;

    public AddIncomeAcountCategoryAdapter(ArrayList<AddIncomeAcountCategory> arrayList){
        this.arrayList = arrayList;
        this.noincomeacountListener = noincomeacountListener;
        Log.i( "Adapter","Called");

    }

    public void setArrayList(ArrayList<AddIncomeAcountCategory> arrayList){
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AddIncomeAcountCategoryAdapter.AddIncomeAcountCategoryAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.addincomeacountview,viewGroup, false);
        return new AddIncomeAcountCategoryAdapterViewHolder(view,noincomeacountListener);
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

    public class AddIncomeAcountCategoryAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView incomeacount,incomeamount;
        OnincomeAcountListener onAcountListener;

        public AddIncomeAcountCategoryAdapterViewHolder(View itemView, OnincomeAcountListener onAcountListener){
            super(itemView);
            incomeacount = itemView.findViewById(R.id.textView9);
            incomeamount = itemView.findViewById(R.id.textView18);
            this.onAcountListener = onAcountListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onAcountListener.onAcountClick(getAdapterPosition());
        }
    }
    public interface OnincomeAcountListener{
        void onAcountClick(int position);

        void onEditClick(int position);
    }

    public void filteredList(ArrayList<AddIncomeAcountCategory> filteredList){
        arrayList = filteredList;
        notifyDataSetChanged();
    }




}

