package com.example.diamond.bookmanager.adapater;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diamond.bookmanager.R;
import com.example.diamond.bookmanager.model.KindBook;

import java.util.List;

public class KindBookAdapter extends RecyclerView.Adapter<KindBookAdapter.ViewHolder> {
    private List<KindBook> listkind;
    public KindBookAdapter(List<KindBook> listkind){
        this.listkind=listkind;
    }
    @NonNull
    @Override
    public KindBookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_kindbook, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KindBookAdapter.ViewHolder holder, int position) {
KindBook kindBook= listkind.get(position);
holder.tvkindname.setText(kindBook.getKindname());
    }

    @Override
    public int getItemCount() {
        return listkind.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tvkindname;
        public ViewHolder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            tvkindname=itemView.findViewById(R.id.tvtname_kindbook);
        }
    }
}
