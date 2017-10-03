package pl.patrykzygo.pocketleague.ui.activities.items_list;

import java.util.List;

import pl.patrykzygo.pocketleague.pojo.ItemDto;

public interface ItemsListView {

    void attachItems(List<ItemDto> items);
    void showErrorMessage(String errorMessage);
    void showLoading();
    void hideLoading();
}
