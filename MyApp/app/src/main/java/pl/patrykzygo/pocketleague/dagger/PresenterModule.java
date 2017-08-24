package pl.patrykzygo.pocketleague.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.patrykzygo.pocketleague.repositories.RiotRepository;
import pl.patrykzygo.pocketleague.ui.activities.champions_list.ChampionsListImpl;
import pl.patrykzygo.pocketleague.ui.activities.champions_list.ChampionsListPresenter;
import pl.patrykzygo.pocketleague.ui.Fragments.main_info_fragment.ChampionMainFragmentImpl;
import pl.patrykzygo.pocketleague.ui.Fragments.main_info_fragment.ChampionMainFragmentPresenter;

@Module
public class PresenterModule {

    @Provides
    @Singleton
    ChampionsListPresenter provideChampionsListPresenter(RiotRepository repository){
        return new ChampionsListImpl(repository);
    }

    @Provides
    @Singleton
    ChampionMainFragmentPresenter providesChampionMainFragmentPresenter(RiotRepository repository){
        return new ChampionMainFragmentImpl(repository);
    }
}
