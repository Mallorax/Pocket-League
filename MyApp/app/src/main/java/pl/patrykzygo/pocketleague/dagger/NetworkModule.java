package pl.patrykzygo.pocketleague.dagger;


import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import pl.patrykzygo.pocketleague.app.Constants;
import pl.patrykzygo.pocketleague.error.ErrorInterceptor;
import pl.patrykzygo.pocketleague.network.RiotApi;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class NetworkModule {


    @Provides
    @Singleton
    Converter.Factory provideGsonConverter(){
        return GsonConverterFactory .create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Converter.Factory converter){
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new ErrorInterceptor())
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();

        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_CONSTANTS_URL)
                .client(client)
                .addConverterFactory(converter)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
    }

    @Provides
    @Singleton
    RiotApi provideRiotApi(Retrofit retrofit){
        return retrofit.create(RiotApi.class);
    }

}
