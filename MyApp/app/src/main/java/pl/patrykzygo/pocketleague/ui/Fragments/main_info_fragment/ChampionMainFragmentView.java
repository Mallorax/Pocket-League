package pl.patrykzygo.pocketleague.ui.Fragments.main_info_fragment;


import pl.patrykzygo.pocketleague.POJO.ChampionDto;

public interface ChampionMainFragmentView {

    void showInfo(ChampionDto champion);
    void showErrorMessage(String errorMessage);
}
