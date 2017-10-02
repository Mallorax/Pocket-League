package pl.patrykzygo.pocketleague.ui.activities.items_list;

public interface ItemsListView {

    void attachItems(List<ItemDto> items);
    void showErrorMessage(String errorMessage);
    void showLoading();
    void hideLoading();
}
