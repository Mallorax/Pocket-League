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

import javax.inject.Inject;

import pl.patrykzygo.pocketleague.R;
import pl.patrykzygo.pocketleague.app.Constants;
import pl.patrykzygo.pocketleague.pojo.Champion;


public class ChampionsListAdapter extends RecyclerView.Adapter<ChampionsListAdapter.ChampionsViewHolder> {

    private List<Champion> champions;
    private List<Champion> championsCopy;
    private OnChampionClickListener onChampionClickListener;
    private Picasso picasso;


    @Inject
    public ChampionsListAdapter(Picasso picasso){
        this.picasso = picasso;
        this.champions = new ArrayList<>();
        this.championsCopy = new ArrayList<>();
    }

    public void setOnChampionClickListener(OnChampionClickListener championClickListener){
        this.onChampionClickListener = championClickListener;
    }

    public void setChampions(List<Champion> champions){
        this.champions = champions;
        championsCopy.addAll(champions);
    }

    public void addChampion(Champion champion){
        champions.add(champion);
        championsCopy.add(champion);
    }

    public void filter(String text) {
        champions.clear();
        if(text.isEmpty()){
            champions.addAll(championsCopy);
        } else{
            text = text.toLowerCase();
            for(Champion champion: championsCopy){
                if(champion.getName().toLowerCase().contains(text) || champion.getTitle().toLowerCase().contains(text)){
                    champions.add(champion);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public ChampionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View championView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.champions_list_position, parent, false);
        return new ChampionsViewHolder(championView);
    }

    @Override
    public void onBindViewHolder(ChampionsViewHolder holder, int position) {
        Champion champ = champions.get(position);
        holder.nameView.setText(champ.getName());
        holder.titleView.setText(champ.getTitle());
        picasso.load(Constants.BASE_CONSTANTS_URL + Constants.VERSION + "/img/champion/" + champ.getImage().getFull()).into(holder.imageView);
    }



    @Override
    public int getItemCount() {
        return champions.size();
    }

    public interface OnChampionClickListener {
        void onChampionClicked(Champion champion);
    }

    public class ChampionsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

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
            onChampionClickListener.onChampionClicked(champions.get(getLayoutPosition()));
        }
    }
}
