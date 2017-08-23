package pl.patrykzygo.pocketleague.dagger;

import javax.inject.Singleton;

import dagger.Component;
import pl.patrykzygo.pocketleague.ui.StaticInfoFragment;
import pl.patrykzygo.pocketleague.ui.champions.ChampionsListActivity;


@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        AdapterModule.class,
        PresenterModule.class,
        PicassoModule.class
})
public interface AppComponent {

    void inject(ChampionsListActivity target);
    void inject(StaticInfoFragment target);

}
