package com.example.newprojectninos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private final List<Avenger> imageLists;
    private final Context context;

    public CustomAdapter(List<Avenger> imageLists, Context context) {
        this.imageLists = imageLists;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Avenger imageList = imageLists.get(position);
        holder.tvname.setText(imageList.getName());
        Glide.with(context)
                .load(imageList.getImageurl())
                .into(holder.img);
        holder.itemView.setOnClickListener(view -> {
            Intent i = new Intent(context, MainActivity2.class);
            i.putExtra("id", imageList.getName());
            i.putExtra("name", imageList.getImageurl());
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return imageLists.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvname;
        private ImageView img;
        private LinearLayout LL;

        public ViewHolder(View itemView) {
            super(itemView);
            tvname = (TextView) itemView.findViewById(R.id.TVtext);
            img = (ImageView) itemView.findViewById(R.id.idEdtCourseName);
            LL = itemView.findViewById(R.id.LL);

        }
    }
}
