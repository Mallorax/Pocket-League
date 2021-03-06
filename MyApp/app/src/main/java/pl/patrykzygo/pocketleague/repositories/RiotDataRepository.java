package pl.patrykzygo.pocketleague.repositories;

import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import pl.patrykzygo.pocketleague.ViewModels.ChampionsViewModel;
import pl.patrykzygo.pocketleague.ViewModels.ItemsViewModel;
import pl.patrykzygo.pocketleague.logic.BaseSchedulerProvider;
import pl.patrykzygo.pocketleague.logic.ChampionDataParser;
import pl.patrykzygo.pocketleague.network.RiotApi;
import pl.patrykzygo.pocketleague.pojo.Champion;
import pl.patrykzygo.pocketleague.pojo.ChampionsResponse;
import pl.patrykzygo.pocketleague.pojo.Item;
import pl.patrykzygo.pocketleague.pojo.ItemsResponse;

public class RiotDataRepository implements RiotRepository {


    private RiotApi riotApi;
    private ChampionDataParser dataParser;
    private BaseSchedulerProvider provider;

    @Inject
    public RiotDataRepository(RiotApi riotApi, ChampionDataParser dataParser, BaseSchedulerProvider provider ){
        this.riotApi = riotApi;
        this.dataParser = dataParser;
        this.provider = provider;
    }

    @Override
    public Flowable<ChampionsViewModel> requestChampions() {
        return riotApi.getChampionsList()
                .flatMap(
                        (Function<ChampionsResponse, Publisher<ChampionsViewModel>>) championsResponse -> {
                            List<Champion> champions = new ArrayList<>(championsResponse.getData().values());
                            return Flowable.just(ChampionsViewModel.succes(champions));
                        }).subscribeOn(provider.getIOScheduler());
    }

    @Override
    public Flowable<Champion> getChampionByName(String name) {
        return riotApi.getChampionByName(name)
                .flatMap( championsResponse -> {
                    Map.Entry<String, Champion> championEntry = championsResponse.getData().entrySet().iterator().next();
                    Champion champion = dataParser.parseThroughAll(championEntry.getValue());
                    return Flowable.just(champion);
        }).subscribeOn(provider.getIOScheduler());
    }

    @Override
    public Flowable<ItemsViewModel> getItems() {
        return riotApi.getItems()
                .flatMap(
                        (Function<ItemsResponse, Publisher<ItemsViewModel>>) itemsResponse ->{
                            List<Item> itemsList = new ArrayList<>();
                            for (Map.Entry<String, Item> itemEntry : itemsResponse.getItemDataMap().entrySet() ){
                                itemEntry.getValue().setId(itemEntry.getKey());
                                itemsList.add(itemEntry.getValue());
                            }
                            return Flowable.just(ItemsViewModel.succes(itemsList));
                }).subscribeOn(provider.getIOScheduler());
    }
}
