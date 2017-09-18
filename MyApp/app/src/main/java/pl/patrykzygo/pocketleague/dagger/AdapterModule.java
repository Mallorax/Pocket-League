package pl.patrykzygo.pocketleague.dagger;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.patrykzygo.pocketleague.ui.adapters.ChampionsListAdapter;
import pl.patrykzygo.pocketleague.ui.adapters.StaticInfoAdapter;

@Module
public class AdapterModule {

    @Provides
    @Singleton
    ChampionsListAdapter providesChampionsListAdapter(){
        return new ChampionsListAdapter();
    }

    @Provides
    @Singleton
    StaticInfoAdapter providesStaticInfoAdapter(){
        return new StaticInfoAdapter();
    }

}
