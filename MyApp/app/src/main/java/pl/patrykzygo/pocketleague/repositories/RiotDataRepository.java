package pl.patrykzygo.pocketleague.repositories;

import javax.inject.Inject;

import io.reactivex.Flowable;
import pl.patrykzygo.pocketleague.logic.ChampionDataParser;
import pl.patrykzygo.pocketleague.network.RiotApi;
import pl.patrykzygo.pocketleague.pojo.Champion;
import pl.patrykzygo.pocketleague.pojo.Item;

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
                .flatMapIterable(response -> response.getChampionData().getChampionsMap().values());
    }

    @Override
    public Flowable<Champion> getChampionByName(String name) {
        return riotApi.getChampionByName(name)
                .flatMap(response -> Flowable.just(response.getChampionData().getChampionsMap().get(name)))
                .map(champion -> dataParser.parseThroughAll(champion));
    }

    @Override
    public Flowable<Item> getItems() {
        return riotApi.getItems()
                .flatMapIterable(itemsResponse -> {
                    itemsResponse.getItemData().getItemMap().forEach((k, v) -> v.setId(k));
                    return itemsResponse.getItemData().getItemMap().values();
                });
    }
}
