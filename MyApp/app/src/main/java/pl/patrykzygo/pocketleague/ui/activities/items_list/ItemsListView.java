package pl.patrykzygo.pocketleague.ui.activities.items_list;

import java.util.List;

import pl.patrykzygo.pocketleague.pojo.Item;

public interface ItemsListView {

    void attachItems(List<Item> item);
    void showErrorMessage(String errorMessage);
    void showLoading();
    void hideLoading();
}
