package pl.patrykzygo.pocketleague.repositories;



import io.reactivex.Flowable;
import pl.patrykzygo.pocketleague.pojo.Champion;
import pl.patrykzygo.pocketleague.pojo.Item;
import pl.patrykzygo.pocketleague.pojo.ItemsResponse;


public interface RiotRepository {

    Flowable<Champion> requestChampions();

    Flowable<Champion> getChampionByName(String name);

    Flowable<Item> getItems();



}
