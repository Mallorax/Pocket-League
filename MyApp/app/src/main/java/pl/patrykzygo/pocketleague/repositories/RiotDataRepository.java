package pl.patrykzygo.pocketleague.repositories;


import android.net.Uri;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import pl.patrykzygo.pocketleague.POJO.ChampionDto;
import pl.patrykzygo.pocketleague.app.Constants;
import pl.patrykzygo.pocketleague.network.RiotApi;
import rx.Observable;
import rx.schedulers.Schedulers;

public class RiotDataRepository implements RiotRepository {


    private RiotApi riotApi;
    private Picasso picasso;

    @Inject
    public RiotDataRepository(RiotApi riotApi, Picasso picasso){
        this.riotApi = riotApi;
        this.picasso = picasso;
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
    public Observable<ChampionDto> getChampionById(int id) {
        return riotApi.getChampionById(Integer.toString(id))
                .subscribeOn(Schedulers.io())
                .flatMap(championDto -> {
                    try {
                        championDto.getImage().setBitmap(picasso.load(Uri.parse("http://ddragon.leagueoflegends.com/cdn/"+ Constants.VERSION+"/img/champion/"+championDto.getImage().getFull())).get());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return Observable.just(championDto);
                });
    }
}
