package pl.patrykzygo.pocketleague.dagger;


import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.patrykzygo.pocketleague.logic.BaseSchedulerProvider;
import pl.patrykzygo.pocketleague.logic.ChampionDataParser;
import pl.patrykzygo.pocketleague.logic.SchedulerProvider;

@Module
public class LogicModule {

    @Provides
    @Singleton
    ChampionDataParser providesChampionDataParser(){
        return new ChampionDataParser();
    }

    @Provides
    @Singleton
    BaseSchedulerProvider providesBaseSchedulerProvider(){
        return new SchedulerProvider();
    }
}
