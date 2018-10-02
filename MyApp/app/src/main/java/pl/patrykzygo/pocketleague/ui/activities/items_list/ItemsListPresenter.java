package pl.patrykzygo.pocketleague.ui.activities.items_list;


import java.util.List;

import pl.patrykzygo.pocketleague.base.BasePresenter;
import pl.patrykzygo.pocketleague.pojo.Item;

public interface ItemsListPresenter extends BasePresenter<ItemsListView>{

    void showItems();
    List<Item> sortItems(List<Item> items, int option);
}
