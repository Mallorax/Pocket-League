package pl.patrykzygo.pocketleague.repositories;


import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import pl.patrykzygo.pocketleague.logic.ChampionDataParser;
import pl.patrykzygo.pocketleague.network.RiotApi;
import pl.patrykzygo.pocketleague.pojo.ChampionDto;
import rx.Observable;
import rx.schedulers.Schedulers;

public class RiotDataRepository implements RiotRepository {


    private RiotApi riotApi;
    private Picasso picasso;
    private ChampionDataParser dataParser;

    @Inject
    public RiotDataRepository(RiotApi riotApi, Picasso picasso, ChampionDataParser dataParser){
        this.riotApi = riotApi;
        this.picasso = picasso;
        this.dataParser = dataParser;
    }

    @Override
    public Observable<List<ChampionDto>> requestChampions() {
        return riotApi.getChampionsList()
                .subscribeOn(Schedulers.io())
                .flatMap(riotResponse -> Observable.just(new ArrayList<>(riotResponse.getData().values())))
                .flatMap((list) -> {
                    Collections.sort(list, (p1, p2) -> p1.getName().compareTo(p2.getName()));
                    return Observable.just(list);
                });
    }

    @Override
    public Observable<ChampionDto> getChampionById(int id) {
        return riotApi.getChampionById(Integer.toString(id))
                .subscribeOn(Schedulers.io())
                .flatMap(championDto -> {
                    try {
                        ChampionDto champion = dataParser.parseThroughAll(championDto);
                        return Observable.just(champion);
                    }catch (IOException e){
                        e.printStackTrace();
                        return null;
                    }
                });
    }
}
