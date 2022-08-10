package com.hahmetbuyukbesnili.landmarkbook;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hahmetbuyukbesnili.landmarkbook.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.RecyViewHolder> {

    ArrayList<Landmark> adapterArrayList;
    RecyclerRowBinding recyclerRowBinding;

    public RecyAdapter(ArrayList<Landmark> adapterArrayList) {
        this.adapterArrayList = adapterArrayList;
    }

    @NonNull
    @Override
    public RecyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new RecyViewHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyViewHolder holder, int position) {
        holder.binding.recyclerViewTextView.setText(adapterArrayList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
                intent.putExtra("landmark", adapterArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return adapterArrayList.size();
    }

    public class RecyViewHolder extends RecyclerView.ViewHolder {
        private RecyclerRowBinding binding;

        public RecyViewHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
