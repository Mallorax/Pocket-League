package pl.patrykzygo.pocketleague.ui.activities.items_list;


import android.support.annotation.Nullable;

import java.util.List;

import pl.patrykzygo.pocketleague.pojo.Item;

public interface ItemsListPresenter {

    void stop();
    void setView(@Nullable ItemsListView view);
    void showItems();
    List<Item> sortItems(List<Item> items, int option);
}
