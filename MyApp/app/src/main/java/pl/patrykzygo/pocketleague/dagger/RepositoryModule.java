package pl.patrykzygo.pocketleague.dagger;


import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.patrykzygo.pocketleague.network.RiotApi;
import pl.patrykzygo.pocketleague.repositories.RiotDataRepository;
import pl.patrykzygo.pocketleague.repositories.RiotRepository;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    RiotRepository providesRiotDataRepository(RiotApi riotApi, Picasso picasso){
        return new RiotDataRepository(riotApi, picasso);
    }
}
