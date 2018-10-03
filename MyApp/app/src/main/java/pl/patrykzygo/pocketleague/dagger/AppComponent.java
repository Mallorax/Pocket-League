package pl.patrykzygo.pocketleague.dagger;

import javax.inject.Singleton;

import dagger.Component;
import pl.patrykzygo.pocketleague.ui.activities.champion.ChampionActivity;
import pl.patrykzygo.pocketleague.ui.activities.champions_list.ChampionsListActivity;
import pl.patrykzygo.pocketleague.ui.activities.items_list.ItemsListActivity;
import pl.patrykzygo.pocketleague.ui.fragments.abilities_fragment.ChampionAbilitiesFragment;
import pl.patrykzygo.pocketleague.ui.fragments.main_info.OverViewFragment;
import pl.patrykzygo.pocketleague.ui.fragments.tabs_fragments.static_info.StaticInfoFragment;


@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        AdapterModule.class,
        PresenterModule.class,
        PicassoModule.class,
        RepositoryModule.class,
        LogicModule.class
})
public interface AppComponent {

    void inject(ChampionsListActivity target);
    void inject(ChampionActivity target);
    void inject(StaticInfoFragment target);
    void inject(ItemsListActivity target);
    void inject(ChampionAbilitiesFragment target);
    void inject(OverViewFragment target);


}
