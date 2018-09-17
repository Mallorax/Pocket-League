package pl.patrykzygo.pocketleague.repositories;



import io.reactivex.Flowable;
import pl.patrykzygo.pocketleague.ViewModels.ChampionsViewModel;
import pl.patrykzygo.pocketleague.pojo.Champion;
import pl.patrykzygo.pocketleague.pojo.Item;


public interface RiotRepository {

    Flowable<ChampionsViewModel> requestChampions();

    Flowable<Champion> getChampionByName(String name);

    Flowable<Item> getItems();



}
