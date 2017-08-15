package pl.patrykzygo.pocketleague.dagger;


import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.patrykzygo.pocketleague.ui.StaticInfoAdapter;
import pl.patrykzygo.pocketleague.ui.champions.ChampionsListAdapter;

@Module
public class AdapterModule {

    @Provides
    @Singleton
    ChampionsListAdapter providesChampionsListAdapter(Picasso picasso){
        return new ChampionsListAdapter(picasso);
    }

    @Provides
    @Singleton
    StaticInfoAdapter providesStaticInfoAdapter(){
        return new StaticInfoAdapter();
    }
}
