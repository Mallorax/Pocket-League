package pl.patrykzygo.pocketleague.repositories;



import io.reactivex.Flowable;
import pl.patrykzygo.pocketleague.ViewModels.ChampionViewModel;
import pl.patrykzygo.pocketleague.ViewModels.ChampionsViewModel;
import pl.patrykzygo.pocketleague.pojo.Champion;
import pl.patrykzygo.pocketleague.pojo.Item;
import pl.patrykzygo.pocketleague.pojo.ItemsResponse;


public interface RiotRepository {

    Flowable<ChampionsViewModel> requestChampions();

    Flowable<ChampionViewModel> getChampionByName(String name);

    Flowable<Item> getItems();



}
