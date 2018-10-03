package pl.patrykzygo.pocketleague.ui.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import pl.patrykzygo.pocketleague.R;
import pl.patrykzygo.pocketleague.app.Constants;
import pl.patrykzygo.pocketleague.pojo.Champion;


public class ChampionsListAdapter extends RecyclerView.Adapter<ChampionsListAdapter.ChampionsViewHolder> implements Filterable {

    private List<Champion> champions;
    private List<Champion> filteredChampions;
    private OnChampionClickListener onChampionClickListener;
    private Picasso picasso;


    @Inject
    public ChampionsListAdapter(Picasso picasso) {
        this.picasso = picasso;
        this.champions = new ArrayList<>();
        this.filteredChampions = new ArrayList<>();
    }
    public List<Champion> getFilteredChampions(){
        return filteredChampions;
    }

    public boolean hasChampions(){
        return !filteredChampions.isEmpty();
    }

    public void setOnChampionClickListener(OnChampionClickListener championClickListener) {
        this.onChampionClickListener = championClickListener;
    }

    public void setChampions(List<Champion> champions) {
        this.champions = champions;
        filteredChampions = champions;
    }

    public void addChampion(Champion champion) {
        champions.add(champion);
        filteredChampions.add(champion);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                String charString = constraint.toString();
                if (charString.isEmpty()) {
                    filteredChampions = champions;
                } else {
                    List<Champion> filteredList = new ArrayList<>();
                    for (Champion row : champions) {
                        if (row.getName().toLowerCase().contains(charString.toLowerCase()) || row.getTitle().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    filteredChampions = filteredList;
                }
                results.count = filteredChampions.size();
                results.values = filteredChampions;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredChampions = (List<Champion>) results.values;
                notifyDataSetChanged();
            }
        };


    }


    @Override
    public ChampionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View championView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.champions_list_position, parent, false);
        return new ChampionsViewHolder(championView);
    }

    @Override
    public void onBindViewHolder(ChampionsViewHolder holder, int position) {
        Champion champ = filteredChampions.get(position);
        holder.nameView.setText(champ.getName());
        holder.titleView.setText(champ.getTitle());
        picasso.load(Constants.BASE_CONSTANTS_URL + Constants.VERSION + "/img/champion/" + champ.getImage().getFull()).into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return filteredChampions.size();
    }

    public interface OnChampionClickListener {
        void onChampionClicked(Champion champion);
    }

    public class ChampionsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView nameView;
        private TextView titleView;
        private ImageView imageView;

        public ChampionsViewHolder(View itemView) {
            super(itemView);
            nameView = (TextView) itemView.findViewById(R.id.champion_name_text_view);
            titleView = (TextView) itemView.findViewById(R.id.champion_title_text_view);
            imageView = (ImageView) itemView.findViewById(R.id.champion_list_icon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onChampionClickListener.onChampionClicked(filteredChampions.get(getLayoutPosition()));
        }
    }
}
