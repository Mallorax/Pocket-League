package pl.patrykzygo.pocketleague.ui.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pl.patrykzygo.pocketleague.R;
import pl.patrykzygo.pocketleague.pojo.ItemDto;

public class ItemsListAdapter extends RecyclerView.Adapter<ItemsListAdapter.ItemsListViewHolder> {

    private List<ItemDto> itemsList;
    private List<ItemDto> itemsListCopy;
    private OnListItemClickedListener listener;

    public void setItemsList(List<ItemDto> itemsList){
        this.itemsList = itemsList;
        this.itemsListCopy = new ArrayList<>();
        itemsListCopy.addAll(itemsList);
    }

    public List<ItemDto> getItemsList(){
        return itemsList;
    }

    public void setOnListItemClickListener(OnListItemClickedListener listener){
        this.listener = listener;

    }

    public void filter(String text) {
        itemsList.clear();
        if(text.isEmpty()){
            itemsList.addAll(itemsListCopy);
        } else{
            text = text.toLowerCase();
            for(ItemDto champion: itemsListCopy){
                if(champion.getName().toLowerCase().contains(text)){
                    itemsList.add(champion);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public ItemsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_list_position, parent, false);
        return new ItemsListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemsListViewHolder holder, int position) {
        ItemDto item = itemsList.get(position);
        holder.imageView.setImageBitmap(item.getImage().getBitmap());
        holder.nameView.setText(item.getName());
        holder.priceView.setText(Integer.toString(item.getGold().getTotal()));
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public interface OnListItemClickedListener {
        void onListItemClicked(ItemDto item);
    }

    public class ItemsListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView nameView;
        private TextView priceView;
        private ImageView imageView;

        public ItemsListViewHolder(View itemView) {
            super(itemView);
            nameView = (TextView) itemView.findViewById(R.id.item_name);
            priceView = (TextView) itemView.findViewById(R.id.item_price);
            imageView = (ImageView) itemView.findViewById(R.id.item_icon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onListItemClicked(itemsList.get(getLayoutPosition()));
        }
    }
}