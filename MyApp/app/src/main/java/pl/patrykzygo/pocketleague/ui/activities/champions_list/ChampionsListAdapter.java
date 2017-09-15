package pl.patrykzygo.pocketleague.ui.activities.champions_list;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

    public List<ChampionDto> getChampions() {
        return champions;
    }


    public void setChampions(List<ChampionDto> champions){
        this.champions = champions;
        this.championsCopy = champions;
    }


    public void animateTo(List<ChampionDto> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }

    public ChampionDto removeItem(int position) {
        final ChampionDto model = champions.remove(position);
        notifyItemRemoved(position);
        return model;
    }

    public void addItem(int position, ChampionDto model) {
        champions.add(position, model);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final ChampionDto model = champions.remove(fromPosition);
        champions.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }

    private void applyAndAnimateRemovals(List<ChampionDto> newModels) {
        for (int i = champions.size() - 1; i >= 0; i--) {
            final ChampionDto model = champions.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<ChampionDto> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final ChampionDto model = newModels.get(i);
            if (!champions.contains(model)) {
                addItem(i, model);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<ChampionDto> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final ChampionDto model = newModels.get(toPosition);
            final int fromPosition = champions.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
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

    interface OnChampionClickListener {
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
