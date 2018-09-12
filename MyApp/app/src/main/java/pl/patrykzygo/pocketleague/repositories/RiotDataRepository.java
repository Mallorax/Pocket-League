package pl.patrykzygo.pocketleague.repositories;

import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import pl.patrykzygo.pocketleague.ViewModels.ChampionsViewModel;
import pl.patrykzygo.pocketleague.logic.ChampionDataParser;
import pl.patrykzygo.pocketleague.network.RiotApi;
import pl.patrykzygo.pocketleague.pojo.Champion;
import pl.patrykzygo.pocketleague.pojo.ChampionsResponse;
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
    public Flowable<ChampionsViewModel> requestChampions() {
        return riotApi.getChampionsList()
                .flatMap(
                        (Function<ChampionsResponse, Publisher<ChampionsViewModel>>) championsResponse -> {
                            List<Champion> champions = new ArrayList<>(championsResponse.getData().values());
                            return Flowable.just(ChampionsViewModel.succes(champions));
                        }).subscribeOn(Schedulers.io());
    }

    @Override
    public Flowable<Champion> getChampionByName(String name) {
        return riotApi.getChampionByName(name)
                .flatMap(response -> Flowable.just(response.getData().get(name)))
                .map(champion -> dataParser.parseThroughAll(champion));
    }

    @Override
    public Flowable<Item> getItems() {
        return riotApi.getItems()
                .flatMapIterable(itemsResponse -> {
                    itemsResponse.getItemMap().forEach((k, v) -> v.setId(k));
                    return itemsResponse.getItemMap().values();
                });
    }
}
