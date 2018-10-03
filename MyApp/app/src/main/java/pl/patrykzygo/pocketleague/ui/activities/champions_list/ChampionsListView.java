package pl.patrykzygo.pocketleague.ui.activities.champions_list;

import java.util.List;

import pl.patrykzygo.pocketleague.base.BaseView;
import pl.patrykzygo.pocketleague.pojo.Champion;

public interface ChampionsListView extends BaseView {

    void attachChampions(List<Champion> champions);
}
