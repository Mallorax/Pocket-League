package pl.patrykzygo.pocketleague.dagger;


import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.patrykzygo.pocketleague.ui.adapters.ChampionsListAdapter;
import pl.patrykzygo.pocketleague.ui.adapters.ItemsListAdapter;
import pl.patrykzygo.pocketleague.ui.adapters.StaticInfoAdapter;

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

    @Provides
    @Singleton
    ItemsListAdapter providesItemsListAdapter(){
        return new ItemsListAdapter();
    }

}
