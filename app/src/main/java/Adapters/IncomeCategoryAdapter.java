package Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.student.mywallet.R;

import java.util.ArrayList;

import Model.IncomeCategory;

public class IncomeCategoryAdapter extends RecyclerView.Adapter<IncomeCategoryAdapter.CategoryAdapterViewHolder2> {
    private ArrayList<IncomeCategory> arrayList2;
    //private OnReadingListener OsaOnReadingListner;

    public IncomeCategoryAdapter(ArrayList<IncomeCategory> arrayList2) {
        this.arrayList2 = arrayList2;
        //this.OsaOnReadingListner = OsaOnReadingListner;
    }

    @NonNull
    @Override
    public IncomeCategoryAdapter.CategoryAdapterViewHolder2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.incomecatergorylist , viewGroup , false);
        return new CategoryAdapterViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IncomeCategoryAdapter.CategoryAdapterViewHolder2 categoryAdapterViewHolder, int i) {
        IncomeCategory object2 = arrayList2.get(i);
        categoryAdapterViewHolder.name2.setText(object2.getUname() );
    }

    @Override
    public int getItemCount() {
        return arrayList2.size();
    }

    public class CategoryAdapterViewHolder2 extends RecyclerView.ViewHolder {
        TextView name2;

        //OnReadingListener OsaOnReadingListner;
        public CategoryAdapterViewHolder2(@NonNull View itemView) {
            super(itemView);
            name2 = itemView.findViewById(R.id.listViewIshu);
            //this.OsaOnReadingListner = OsaOnReadingListner;

            //itemView.setOnClickListener(this);
        }
    }
}
