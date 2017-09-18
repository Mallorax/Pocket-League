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
import pl.patrykzygo.pocketleague.pojo.ChampionDto;


public class ChampionsListAdapter extends RecyclerView.Adapter<ChampionsListAdapter.ChampionsViewHolder> {

    private List<ChampionDto> champions;
    private List<ChampionDto> championsCopy;
    private OnChampionClickListener onChampionClickListener;

    public void setOnChampionClickListener(OnChampionClickListener championClickListener){
        this.onChampionClickListener = championClickListener;
    }


    public void setChampions(List<ChampionDto> champions){
        this.champions = champions;
        this.championsCopy = new ArrayList<>();
        championsCopy.addAll(champions);
    }

    public void filter(String text) {
        champions.clear();
        if(text.isEmpty()){
            champions.addAll(championsCopy);
        } else{
            text = text.toLowerCase();
            for(ChampionDto champion: championsCopy){
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
                .inflate(R.layout.champions_list_item, parent, false);
        return new ChampionsViewHolder(championView);
    }

    @Override
    public void onBindViewHolder(ChampionsViewHolder holder, int position) {
        ChampionDto champ = champions.get(position);
        holder.nameView.setText(champ.getName());
        holder.titleView.setText(champ.getTitle());
        holder.imageView.setImageBitmap(champ.getImage().getBitmap());
    }



    @Override
    public int getItemCount() {
        return champions.size();
    }

    public interface OnChampionClickListener {
        void onChampionClick(ChampionDto champion);
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
            onChampionClickListener.onChampionClick(champions.get(getLayoutPosition()));
        }
    }
}
