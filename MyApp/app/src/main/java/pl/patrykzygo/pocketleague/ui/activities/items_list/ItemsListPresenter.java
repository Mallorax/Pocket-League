package pl.patrykzygo.pocketleague.ui.activities.items_list;


import android.support.annotation.Nullable;

import java.util.List;

import pl.patrykzygo.pocketleague.pojo.ItemDto;

public interface ItemsListPresenter {

    void setView(@Nullable ItemsListView view);
    void showItems();
    List<ItemDto> sortItems(List<ItemDto> items, int option);
}
