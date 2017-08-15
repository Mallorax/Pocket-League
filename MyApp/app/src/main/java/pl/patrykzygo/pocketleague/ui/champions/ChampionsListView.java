package pl.patrykzygo.pocketleague.ui.champions;


import java.util.List;

import pl.patrykzygo.pocketleague.POJO.ChampionDto;

public interface ChampionsListView {

    void showLoading();
    void hideLoading();
    void attachChampions(List<ChampionDto> champions);
    void showErrorMessage(String errorMessage);
}
