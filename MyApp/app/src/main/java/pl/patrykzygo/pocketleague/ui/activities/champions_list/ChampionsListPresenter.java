package pl.patrykzygo.pocketleague.ui.activities.champions_list;


import pl.patrykzygo.pocketleague.base.BasePresenter;

public interface ChampionsListPresenter extends BasePresenter<ChampionsListView> {

    void setView(ChampionsListView view);
    void showChampions();


}
