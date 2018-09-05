package pl.patrykzygo.pocketleague.ui.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import pl.patrykzygo.pocketleague.R;
import pl.patrykzygo.pocketleague.app.Constants;
import pl.patrykzygo.pocketleague.pojo.Item;

public class ItemsListAdapter extends RecyclerView.Adapter<ItemsListAdapter.ItemsListViewHolder> {

    private List<Item> itemsList;
    private List<Item> itemsListCopy;
    private OnListItemClickedListener listener;
    private Picasso picasso;

    public ItemsListAdapter(Picasso picasso){
        this.picasso = picasso;
    }

    public void addItem(Item item){
        itemsList.add(item);
        itemsListCopy.add(item);
    }

    public void setItemsList(List<Item> itemsList){
        this.itemsList = itemsList;
        this.itemsListCopy = new ArrayList<>();
        itemsListCopy.addAll(itemsList);
    }

    public List<Item> getItemsList(){
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
            for(Item champion: itemsListCopy){
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
        Item item = itemsList.get(position);
        holder.nameView.setText(item.getName());
        holder.priceView.setText(Integer.toString(item.getGold().getTotal()));
        picasso.load("http://ddragon.leagueoflegends.com/cdn/"+ Constants.VERSION + "/img/item/" +item.getId()+ ".png").into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public interface OnListItemClickedListener {
        void onListItemClicked(Item item);
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
