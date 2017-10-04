package pl.patrykzygo.pocketleague.network;

import pl.patrykzygo.pocketleague.BuildConfig;
import pl.patrykzygo.pocketleague.pojo.ChampionDto;
import pl.patrykzygo.pocketleague.pojo.ChampionListDto;
import pl.patrykzygo.pocketleague.app.Constants;
import pl.patrykzygo.pocketleague.pojo.ItemListDto;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


public interface RiotApi {

    @GET(Constants.STATIC_DATA + Constants.CHAMPIONS_WITH_IMAGES_REQUEST + "&api_key=" + BuildConfig.RIOT_API_KEY)
    Observable<ChampionListDto> getChampionsList();

    @GET("lol/static-data/v3/champions/{id}?locale=en_US&tags=all&api_key=" +BuildConfig.RIOT_API_KEY)
    Observable<ChampionDto> getChampionById(@Path("id") String id);

    @GET("/lol/static-data/v3/items?locale=en_US" +Constants.ITEMS_LIST_TAGS+ "&api_key=" +BuildConfig.RIOT_API_KEY)
    Observable<ItemListDto> getItemsList();
}
