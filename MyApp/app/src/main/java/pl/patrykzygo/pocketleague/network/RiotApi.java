package pl.patrykzygo.pocketleague.network;

import io.reactivex.Flowable;
import pl.patrykzygo.pocketleague.BuildConfig;
import pl.patrykzygo.pocketleague.app.Constants;
import pl.patrykzygo.pocketleague.pojo.Champion;
import pl.patrykzygo.pocketleague.pojo.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;



public interface RiotApi {

    @GET(Constants.VERSION + Constants.CHAMPIONS_REQUEST)
    Flowable<Response> getChampionsList();

    @GET("lol/static-data/v3/champions/{id}?locale=en_US&tags=all&api_key=" +BuildConfig.RIOT_API_KEY)
    Flowable<Champion> getChampionById(@Path("id") String id);

}
