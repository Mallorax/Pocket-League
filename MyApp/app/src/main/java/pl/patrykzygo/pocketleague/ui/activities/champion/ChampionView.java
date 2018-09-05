package pl.patrykzygo.pocketleague.ui.activities.champion;


import pl.patrykzygo.pocketleague.pojo.Champion;

public interface ChampionView {

    void setTabs(Champion champion);
    void showErrorMessage(String message);
    void showLoading();
    void hideLoading();
}
