package pl.patrykzygo.pocketleague.ui.activities.champions_list;


import javax.inject.Inject;

import pl.patrykzygo.pocketleague.logic.BaseSchedulerProvider;
import pl.patrykzygo.pocketleague.repositories.RiotRepository;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;


public class ChampionsListImpl implements ChampionsListPresenter {


    private ChampionsListView view;
    private RiotRepository riotRepository;
    private CompositeSubscription subscriptions;
    private BaseSchedulerProvider schedulerProvider;

    @Inject
    public ChampionsListImpl(RiotRepository riotDataRepository,
                             BaseSchedulerProvider schedulerProvider) {
        this.riotRepository = riotDataRepository;
        this.schedulerProvider = schedulerProvider;
        this.subscriptions = new CompositeSubscription();
    }

    @Override
    public void setView(ChampionsListView view) {
        this.view = view;
    }

    @Override
    public void showChampions() {
        view.showLoading();
        getChampions();
        view.hideLoading();
    }

    private void getChampions(){
        subscriptions.add(riotRepository.requestChampions()
                .observeOn(schedulerProvider.getUiScheduler())
                .subscribe((championsList) ->{
                    view.attachChampions(championsList);
                }, throwable -> {
                    throwable.printStackTrace();
                    view.showErrorMessage("Failed to load the champions");
                }));
    }

}
//TODO presenterImpl leaks view(activity) instance, have to fix that
//TODO 2 handle the progress bar

