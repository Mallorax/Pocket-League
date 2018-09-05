package pl.patrykzygo.pocketleague.network;

import io.reactivex.Flowable;
import pl.patrykzygo.pocketleague.BuildConfig;
import pl.patrykzygo.pocketleague.app.Constants;
import pl.patrykzygo.pocketleague.pojo.Champion;
import pl.patrykzygo.pocketleague.pojo.RiotResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;



public interface RiotApi {

    @GET(Constants.VERSION + Constants.CHAMPIONS_REQUEST + "champion.json")
    Flowable<RiotResponse> getChampionsList();

    @GET(Constants.VERSION + Constants.CHAMPIONS_REQUEST + "{name}.json")
    Flowable<RiotResponse> getChampionByName(@Path("name") String name);

}
