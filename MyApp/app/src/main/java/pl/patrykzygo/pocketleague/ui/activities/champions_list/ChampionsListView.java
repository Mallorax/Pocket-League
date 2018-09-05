package pl.patrykzygo.pocketleague.ui.activities.champions_list;

import pl.patrykzygo.pocketleague.pojo.Champion;

public interface ChampionsListView {

    void attachChampion(Champion champions);
    void showErrorMessage(String errorMessage);
    void showLoading();
    void hideLoading();
}
