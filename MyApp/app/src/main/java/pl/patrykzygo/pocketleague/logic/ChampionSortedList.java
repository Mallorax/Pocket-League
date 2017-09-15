package pl.patrykzygo.pocketleague.logic;

import android.support.v7.util.SortedList;

import pl.patrykzygo.pocketleague.pojo.ChampionDto;
import pl.patrykzygo.pocketleague.ui.activities.champions_list.ChampionsListAdapter;


public class ChampionSortedList extends SortedList.Callback<ChampionDto> {

    private ChampionsListAdapter adapter;

    public ChampionSortedList(ChampionsListAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public int compare(ChampionDto o1, ChampionDto o2) {
        return o1.getName().compareTo(o1.getName());
    }

    @Override
    public void onChanged(int position, int count) {
        adapter.notifyItemRangeChanged(position, count);
    }

    @Override
    public boolean areContentsTheSame(ChampionDto oldItem, ChampionDto newItem) {
        return oldItem.getName().equalsIgnoreCase(newItem.getName());
    }

    @Override
    public boolean areItemsTheSame(ChampionDto item1, ChampionDto item2) {
        return item1.getId() == item2.getId();
    }

    @Override
    public void onInserted(int position, int count) {
        adapter.notifyItemRangeInserted(position, count);
    }

    @Override
    public void onRemoved(int position, int count) {
        adapter.notifyItemRangeRemoved(position, count);
    }

    @Override
    public void onMoved(int fromPosition, int toPosition) {
        adapter.notifyItemMoved(fromPosition, toPosition);
    }
}
