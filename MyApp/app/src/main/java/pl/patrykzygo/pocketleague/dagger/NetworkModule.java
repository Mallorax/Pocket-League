package pl.patrykzygo.pocketleague.dagger;


import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import pl.patrykzygo.pocketleague.app.Constants;
import pl.patrykzygo.pocketleague.network.RiotApi;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;


@Module
public class NetworkModule {

    private static final String NAME_BASE_URL ="NAME_BASE_URL";

    @Provides
    @Named(NAME_BASE_URL)
    String provideBaseURLString(){
        return Constants.BASE_CONSTANTS_URL;
    }

    @Provides
    @Singleton
    Converter.Factory provideGsonConverter(){
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Converter.Factory converter, @Named(NAME_BASE_URL) String baseUrl){
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new ErrorInterceptor())
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(converter)
                .addCallAdapterFactory(RxJavaCallAdapterFactory
                        .createWithScheduler(Schedulers.newThread()))
                .build();
    }

    @Provides
    @Singleton
    RiotApi provideRiotApi(Retrofit retrofit){
        return retrofit.create(RiotApi.class);
    }

}
