package pl.patrykzygo.pocketleague.repositories;


import android.content.ClipData;

import java.util.List;

import pl.patrykzygo.pocketleague.pojo.ChampionDto;
import pl.patrykzygo.pocketleague.pojo.ItemDto;
import rx.Observable;

public interface RiotRepository {

    Observable<List<ChampionDto>> requestChampions();

    Observable<ChampionDto> getChampionById(int id);

    Observable<List<ItemDto>> getItemsList();

}
