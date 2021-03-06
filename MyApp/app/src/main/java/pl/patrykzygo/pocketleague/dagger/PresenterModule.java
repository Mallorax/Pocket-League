package pl.patrykzygo.pocketleague.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.patrykzygo.pocketleague.logic.BaseSchedulerProvider;
import pl.patrykzygo.pocketleague.repositories.RiotRepository;
import pl.patrykzygo.pocketleague.ui.activities.champion.ChampionPresenter;
import pl.patrykzygo.pocketleague.ui.activities.champion.ChampionPresenterImpl;
import pl.patrykzygo.pocketleague.ui.activities.champions_list.ChampionsListImpl;
import pl.patrykzygo.pocketleague.ui.activities.champions_list.ChampionsListPresenter;
import pl.patrykzygo.pocketleague.ui.activities.items_list.ItemsListPresenter;
import pl.patrykzygo.pocketleague.ui.activities.items_list.ItemsListPresenterImpl;

@Module
public class PresenterModule {

    @Provides
    @Singleton
    ChampionsListPresenter provideChampionsListPresenter(RiotRepository repository, BaseSchedulerProvider schedulerProvider){
        return new ChampionsListImpl(repository, schedulerProvider);
    }

    @Provides
    @Singleton
    ChampionPresenter providesChampionPresenter(RiotRepository repository, BaseSchedulerProvider schedulerProvider){
        return new ChampionPresenterImpl(repository, schedulerProvider);
    }

    @Provides
    @Singleton
    ItemsListPresenter providesItemsListPresenter (RiotRepository repository, BaseSchedulerProvider schedulerProvider){
        return  new ItemsListPresenterImpl(repository, schedulerProvider);
    }
}
