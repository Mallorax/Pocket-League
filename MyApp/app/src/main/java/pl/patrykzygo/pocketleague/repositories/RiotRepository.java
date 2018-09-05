package pl.patrykzygo.pocketleague.repositories;



import io.reactivex.Flowable;
import pl.patrykzygo.pocketleague.pojo.Champion;


public interface RiotRepository {

    Flowable<Champion> requestChampions();

    Flowable<Champion> getChampionByName(String name);



}
