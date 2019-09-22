package Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.student.mywallet.R;

import java.util.ArrayList;

import Model.AddAcountCategory;
import Model.ExpensesCategory;

public class ExpensesCategoryAdapter extends RecyclerView.Adapter<ExpensesCategoryAdapter.CategoryAdapterViewHolder> {
    private ArrayList<ExpensesCategory> arrayList;
    //private OnReadingListener OsaOnReadingListner;

    public ExpensesCategoryAdapter(ArrayList<ExpensesCategory> arrayList) {
        this.arrayList = arrayList;
        //this.OsaOnReadingListner = OsaOnReadingListner;
    }

    @NonNull
    @Override
    public ExpensesCategoryAdapter.CategoryAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.expensescategorylist , viewGroup , false);
        return new CategoryAdapterViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapterViewHolder categoryAdapterViewHolder, int i) {
        ExpensesCategory object = arrayList.get(i);
        categoryAdapterViewHolder.name.setText(object.getUname() );

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class CategoryAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        //OnReadingListener OsaOnReadingListner;
        public CategoryAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_nameOSA);
            //this.OsaOnReadingListner = OsaOnReadingListner;

            //itemView.setOnClickListener(this);
        }
    } public void filteredList(ArrayList<ExpensesCategory> filteredList){
        arrayList = filteredList;
        notifyDataSetChanged();
    }

}
