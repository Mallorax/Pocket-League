package pl.patrykzygo.pocketleague.repositories;


import java.util.List;

import pl.patrykzygo.pocketleague.POJO.ChampionDto;
import rx.Observable;

public interface RiotDataSource {

    Observable<List<ChampionDto>> getChampions();

    ChampionDto getChampion(int id);

}
