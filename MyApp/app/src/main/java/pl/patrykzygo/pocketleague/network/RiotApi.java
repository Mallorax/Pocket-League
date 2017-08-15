package pl.patrykzygo.pocketleague.network;

import pl.patrykzygo.pocketleague.BuildConfig;
import pl.patrykzygo.pocketleague.POJO.ChampionListDto;
import pl.patrykzygo.pocketleague.app.Constants;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Mallorax on 15.08.2017.
 */

public interface RiotApi {

    @GET(Constants.STATIC_DATA + Constants.CHAMPIONS_WITH_IMAGES_REQUEST + "&api_key=" + BuildConfig.RIOT_API_KEY)
    Observable<ChampionListDto> getChampionsList();
}
