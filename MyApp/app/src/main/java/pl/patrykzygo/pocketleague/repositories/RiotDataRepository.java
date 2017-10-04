package pl.patrykzygo.pocketleague.repositories;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import pl.patrykzygo.pocketleague.logic.ChampionDataParser;
import pl.patrykzygo.pocketleague.network.RiotApi;
import pl.patrykzygo.pocketleague.pojo.ChampionDto;
import pl.patrykzygo.pocketleague.pojo.ItemDto;
import rx.Observable;
import rx.schedulers.Schedulers;

public class RiotDataRepository implements RiotRepository {


    private RiotApi riotApi;
    private ChampionDataParser dataParser;

    @Inject
    public RiotDataRepository(RiotApi riotApi, ChampionDataParser dataParser){
        this.riotApi = riotApi;
        this.dataParser = dataParser;
    }

    @Override
    public Observable<List<ChampionDto>> requestChampions() {
        return riotApi.getChampionsList()
                .subscribeOn(Schedulers.io())
                .flatMap(riotResponse -> Observable.just(new ArrayList<>(riotResponse.getData().values())))
                .flatMap((list) -> {
                    Collections.sort(list, (p1, p2) -> p1.getName().compareTo(p2.getName()));
                    for (int i=0; i < list.size(); i++){
                        try {
                            list.set(i, dataParser.setChampionIcon(list.get(i)));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
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

    @Override
    public Observable<List<ItemDto>> getItemsList() {
        return riotApi.getItemsList()
                .subscribeOn(Schedulers.io())
                .flatMap(riotResponse -> Observable.just(new ArrayList<>(riotResponse.getData().values())))
                .flatMap(itemsList -> {
                    Collections.sort(itemsList, (p1, p2) -> Integer.compare(p1.getGold().getTotal(), p2.getGold().getTotal()));
                    itemsList.removeIf(itemDto -> itemDto.getGold().getTotal() == 1625 || itemDto.getGold().getTotal() == 1425 || !itemDto.getGold().isPurchasable());
                    for (int i=0; i < itemsList.size(); i++){
                        try {
                            itemsList.set(i, dataParser.setItemIcon(itemsList.get(i)));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return Observable.just(itemsList);
                });
    }
}
