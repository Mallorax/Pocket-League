package pl.patrykzygo.pocketleague.repositories;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import pl.patrykzygo.pocketleague.POJO.ChampionDto;
import pl.patrykzygo.pocketleague.network.RiotApi;
import rx.Observable;
import rx.schedulers.Schedulers;

public class RiotDataRepository implements RiotRepository {


    private RiotApi riotApi;

    @Inject
    public RiotDataRepository(RiotApi riotApi){
        this.riotApi = riotApi;
    }

    @Override
    public Observable<List<ChampionDto>> getChampions() {
        return riotApi.getChampionsList()
                .subscribeOn(Schedulers.io())
                .flatMap(riotResponse -> Observable.just(new ArrayList<>(riotResponse.getData().values())))
                .flatMap((list) -> {
                    Collections.sort(list, (p1, p2) -> p1.getName().compareTo(p2.getName()));
                    return Observable.just(list);
                });
    }

    @Override
    public ChampionDto getChampion(int id) {
        //TODO implement
        return null;
    }
}
