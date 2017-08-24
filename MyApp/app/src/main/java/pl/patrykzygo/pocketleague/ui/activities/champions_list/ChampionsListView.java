package pl.patrykzygo.pocketleague.ui.activities.champions_list;


import java.util.List;

import pl.patrykzygo.pocketleague.POJO.ChampionDto;

public interface ChampionsListView {

    void attachChampions(List<ChampionDto> champions);
    void showErrorMessage(String errorMessage);
}
