package pl.patrykzygo.pocketleague.ui.activities.champions_list;


import java.util.List;

import pl.patrykzygo.pocketleague.pojo.ChampionDto;

public interface ChampionsListView {

    void attachChampions(List<ChampionDto> champions);
    void showErrorMessage(String errorMessage);
    void showLoading();
    void hideLoading();
}
