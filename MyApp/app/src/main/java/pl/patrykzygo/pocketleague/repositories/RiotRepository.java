package pl.patrykzygo.pocketleague.repositories;


import java.util.List;

import pl.patrykzygo.pocketleague.pojo.ChampionDto;
import rx.Observable;

public interface RiotRepository {

    Observable<List<ChampionDto>> requestChampions();

    Observable<ChampionDto> getChampionById(int id);

}
