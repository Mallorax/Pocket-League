package pl.patrykzygo.pocketleague.network;

import io.reactivex.Flowable;
import pl.patrykzygo.pocketleague.app.Constants;
import pl.patrykzygo.pocketleague.pojo.ChampionsResponse;
import pl.patrykzygo.pocketleague.pojo.ItemsResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;



public interface RiotApi {

    @GET(Constants.VERSION + Constants.BASE_STATIC_REQUEST + "champion.json")
    Flowable<ChampionsResponse> getChampionsList();

    @GET(Constants.VERSION + Constants.BASE_STATIC_REQUEST + Constants.SINGLE_CHAMPION_REQUEST + "{name}.json")
    Flowable<ChampionsResponse> getChampionByName(@Path("name") String name);

    @GET(Constants.VERSION + Constants.BASE_STATIC_REQUEST + "item.json")
    Flowable<ItemsResponse> getItems();

}
