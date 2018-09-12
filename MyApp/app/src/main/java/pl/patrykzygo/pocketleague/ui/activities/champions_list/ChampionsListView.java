package pl.patrykzygo.pocketleague.ui.activities.champions_list;

import java.util.List;

import pl.patrykzygo.pocketleague.pojo.Champion;

public interface ChampionsListView {

    void attachChampions(List<Champion> champions);
    void showErrorMessage(String errorMessage);
    void showLoading();
    void hideLoading();
}
