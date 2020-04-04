package com.example.resf;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RCVA extends RecyclerView.Adapter<RCVA.MVH> {

    private List<item> items = new ArrayList<>();
    public  RCVA(List<item> items){
        this.items = items;
    }

    @NonNull
    @Override
    public MVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);

        return new MVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MVH holder, int position) {
        holder.itemName.setText(items.get(position).getItem_name());
        holder.itemImg.setImageResource(items.get(position).getItem_img_id());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MVH extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        ImageView itemImg;
        TextView itemName;
        CardView cardView;

        public MVH(@NonNull View itemView){
            super(itemView);

            itemImg = itemView.findViewById(R.id.imgview);
            itemName = itemView.findViewById(R.id.txtview);
            cardView =itemView.findViewById(R.id.mCard);
            cardView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(this.getAdapterPosition(),121,0,"delete this");
            menu.add(this.getAdapterPosition(),122,1,"add");
        }
    }

    public void removeItem(int posistion){
        items.remove(posistion);
        notifyDataSetChanged();
    }

    public void add(int posistion){

    }
}
