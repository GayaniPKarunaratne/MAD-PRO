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

public class AddAcountCategoryAdapter extends RecyclerView.Adapter<AddAcountCategoryAdapter.AddAcountCategoryAdapterVeiwHolder> {
    private ArrayList<AddAcountCategory> arrayList;



    public AddAcountCategoryAdapter(ArrayList<AddAcountCategory> arrayList){
        this.arrayList = arrayList;
        Log.i( "Adapter","Called");
    }
    @NonNull
    @Override
    public AddAcountCategoryAdapter.AddAcountCategoryAdapterVeiwHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.incomeview , viewGroup , false);
        return new AddAcountCategoryAdapterVeiwHolder(view);
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

    public class AddAcountCategoryAdapterVeiwHolder extends RecyclerView.ViewHolder {

        TextView acount , amount ;
        public AddAcountCategoryAdapterVeiwHolder(View itemView){
            super(itemView);
            acount = itemView.findViewById(R.id.textView9);
            amount = itemView.findViewById(R.id.textView18);
        }
    }
}
