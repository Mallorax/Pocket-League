package pl.patrykzygo.pocketleague.dagger;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.patrykzygo.pocketleague.logic.BaseSchedulerProvider;
import pl.patrykzygo.pocketleague.logic.ChampionDataParser;
import pl.patrykzygo.pocketleague.network.RiotApi;
import pl.patrykzygo.pocketleague.repositories.RiotDataRepository;
import pl.patrykzygo.pocketleague.repositories.RiotRepository;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    RiotRepository providesRiotDataRepository(RiotApi riotApi, ChampionDataParser dataParser, BaseSchedulerProvider schedulerProvider){
        return new RiotDataRepository(riotApi, dataParser, schedulerProvider);
    }
}
