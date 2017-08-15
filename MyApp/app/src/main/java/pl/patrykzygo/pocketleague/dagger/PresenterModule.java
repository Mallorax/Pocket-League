package pl.patrykzygo.pocketleague.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.patrykzygo.pocketleague.repositories.RiotRepository;
import pl.patrykzygo.pocketleague.ui.champions.ChampionsListImpl;
import pl.patrykzygo.pocketleague.ui.champions.ChampionsListPresenter;

@Module
public class PresenterModule {

    @Provides
    @Singleton
    ChampionsListPresenter provideChampionsListPresenter(RiotRepository repository){
        return new ChampionsListImpl(repository);
    }
}
