package pl.patrykzygo.pocketleague.ui.champions.champion.overview_tab;


import android.graphics.Bitmap;

import pl.patrykzygo.pocketleague.POJO.ChampionDto;

public interface OverView {

    void showInfo(ChampionDto champion, Bitmap image);
    void showErrorMessage(String errorMessage);
}
