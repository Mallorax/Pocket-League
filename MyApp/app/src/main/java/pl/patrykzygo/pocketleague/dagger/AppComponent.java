package pl.patrykzygo.pocketleague.dagger;

import javax.inject.Singleton;

import dagger.Component;
import pl.patrykzygo.pocketleague.ui.Fragments.static_info.StaticInfoFragment;
import pl.patrykzygo.pocketleague.ui.activities.champions_list.ChampionsListActivity;
import pl.patrykzygo.pocketleague.ui.Fragments.main_info_fragment.ChampionMainFragment;


@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        AdapterModule.class,
        PresenterModule.class,
        PicassoModule.class,
        RepositoryModule.class
})
public interface AppComponent {

    void inject(ChampionsListActivity target);
    void inject(StaticInfoFragment target);
    void inject(ChampionMainFragment target);

}
