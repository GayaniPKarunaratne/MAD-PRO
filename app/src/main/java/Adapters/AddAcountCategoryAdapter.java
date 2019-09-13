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

import Model.AddAcountCategory;
import Model.AddIncome;

public class AddAcountCategoryAdapter extends RecyclerView.Adapter<AddAcountCategoryAdapter.AddAcountCategoryAdapterVeiwHolder> {
    private ArrayList<AddAcountCategory> arrayList;
    private OnAcountListener noacountListener;



    public AddAcountCategoryAdapter(ArrayList<AddAcountCategory> arrayList,OnAcountListener onAcountListener){
        this.arrayList = arrayList;
        this.noacountListener = noacountListener;
        Log.i( "Adapter","Called");
    }

    public void setArrayList(ArrayList<AddAcountCategory> arrayList){
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public AddAcountCategoryAdapter.AddAcountCategoryAdapterVeiwHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.addacountview , viewGroup , false);
        return new AddAcountCategoryAdapterVeiwHolder(view,noacountListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AddAcountCategoryAdapterVeiwHolder addAcountCategoryAdapterVeiwHolder, int i) {
        AddAcountCategory AddAcount = arrayList.get(i);
        addAcountCategoryAdapterVeiwHolder.acount.setText(AddAcount.getAcount());
        addAcountCategoryAdapterVeiwHolder.amount.setText(AddAcount.getAmount());
    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class AddAcountCategoryAdapterVeiwHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView acount , amount ;
        OnAcountListener onAcountListener;

        public AddAcountCategoryAdapterVeiwHolder(View itemView, OnAcountListener onAcountListener){
            super(itemView);
            acount = itemView.findViewById(R.id.textView9);
            amount = itemView.findViewById(R.id.textView18);
            this.onAcountListener = onAcountListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onAcountListener.onAcountClick(getAdapterPosition());
        }
    }

    public interface OnAcountListener{
        void onAcountClick(int position);
    }
}
