package pl.patrykzygo.pocketleague.repositories;

import javax.inject.Inject;

import io.reactivex.Flowable;
import pl.patrykzygo.pocketleague.logic.ChampionDataParser;
import pl.patrykzygo.pocketleague.network.RiotApi;
import pl.patrykzygo.pocketleague.pojo.Champion;

public class RiotDataRepository implements RiotRepository {


    private RiotApi riotApi;
    private ChampionDataParser dataParser;

    @Inject
    public RiotDataRepository(RiotApi riotApi, ChampionDataParser dataParser){
        this.riotApi = riotApi;
        this.dataParser = dataParser;
    }

    @Override
    public Flowable<Champion> requestChampions() {
        return riotApi.getChampionsList()
                .flatMapIterable(response -> response.getData().getChampionsMap().values());
    }

    @Override
    public Flowable<Champion> getChampionByName(String name) {
        return riotApi.getChampionByName(name)
                .flatMap(response -> Flowable.just(response.getData().getChampionsMap().get(name)))
                .map(champion -> dataParser.parseThroughAll(champion));
    }
}
