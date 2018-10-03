package pl.patrykzygo.pocketleague.ui.activities.champions_list;


import android.util.Log;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subscribers.DisposableSubscriber;
import pl.patrykzygo.pocketleague.ViewModels.ChampionsViewModel;
import pl.patrykzygo.pocketleague.logic.BaseSchedulerProvider;
import pl.patrykzygo.pocketleague.repositories.RiotRepository;


public class ChampionsListImpl implements ChampionsListPresenter {

    private ChampionsListView view;
    private RiotRepository riotRepository;
    private CompositeDisposable disposable;
    private BaseSchedulerProvider schedulerProvider;

    @Inject
    public ChampionsListImpl(RiotRepository riotDataRepository,
                             BaseSchedulerProvider schedulerProvider) {
        this.riotRepository = riotDataRepository;
        this.schedulerProvider = schedulerProvider;
        this.disposable = new CompositeDisposable();
    }

    @Override
    public void setView(ChampionsListView view) {
        this.view = view;
    }

    @Override
    public void showChampions() {
        getChampions();
    }

    @Override
    public void stop() {
        disposable.clear();
    }

    private void getChampions() {
        disposable.add(riotRepository.requestChampions()
                .observeOn(schedulerProvider.getUiScheduler())
                .startWith(ChampionsViewModel.loading())
                .onErrorReturn(throwable -> ChampionsViewModel.error(throwable.getMessage()))
                .subscribeWith(new DisposableSubscriber<ChampionsViewModel>() {
                    @Override
                    public void onNext(ChampionsViewModel championsViewModel) {
                        if (championsViewModel.hasError()) {
                            view.showErrorMessage(championsViewModel.getErrorMessage());
                        } else if (championsViewModel.isLoading()) {
                            view.showLoading();
                        } else {
                            view.attachChampions(championsViewModel.getChampionsList());
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.d("ERROR", t.getMessage() + " " + t.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {
                        view.hideLoading();
                    }
                }));
    }

}
//TODO presenterImpl leaks view(activity) instance, have to fix that

