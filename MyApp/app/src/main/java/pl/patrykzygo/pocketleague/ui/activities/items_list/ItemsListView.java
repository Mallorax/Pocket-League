package pl.patrykzygo.pocketleague.ui.activities.items_list;

import pl.patrykzygo.pocketleague.pojo.Item;

public interface ItemsListView {

    void attachItem(Item item);
    void showErrorMessage(String errorMessage);
    void showLoading();
    void hideLoading();
}
