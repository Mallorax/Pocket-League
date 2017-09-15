package pl.patrykzygo.pocketleague.ui.activities.champion;


import pl.patrykzygo.pocketleague.pojo.ChampionDto;

public interface ChampionView {

    void setTabs(ChampionDto champion);
    void showErrorMessage(String message);
    void showLoading();
    void hideLoading();
}
