package pl.patrykzygo.pocketleague.ui.activities.items_list;


import android.support.annotation.Nullable;

public interface ItemsListPresenter {

    void setView(@Nullable ItemsListView view);
    void showItems();
}
