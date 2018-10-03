package pl.patrykzygo.pocketleague.repositories;



import io.reactivex.Flowable;
import pl.patrykzygo.pocketleague.ViewModels.ChampionsViewModel;
import pl.patrykzygo.pocketleague.ViewModels.ItemsViewModel;
import pl.patrykzygo.pocketleague.pojo.Champion;


public interface RiotRepository {

    Flowable<ChampionsViewModel> requestChampions();

    Flowable<Champion> getChampionByName(String name);

    Flowable<ItemsViewModel> getItems();



}
