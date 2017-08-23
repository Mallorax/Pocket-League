package pl.patrykzygo.pocketleague.ui.champions;


import javax.inject.Inject;

import pl.patrykzygo.pocketleague.repositories.RiotRepository;
import pl.patrykzygo.pocketleague.repositories.RiotDataRepository;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;


public class ChampionsListImpl implements ChampionsListPresenter {


    private ChampionsListView view;
    private RiotRepository riotRepository;
    private CompositeSubscription subscriptions;

    @Inject
    public ChampionsListImpl(RiotDataRepository riotDataRepository) {
        this.riotRepository = riotDataRepository;
        this.subscriptions = new CompositeSubscription();
    }

    @Override
    public void setView(ChampionsListView view) {
        this.view = view;
    }

    @Override
    public void showChampions() {
        subscriptions.add(riotRepository.getChampions()
                .observeOn(AndroidSchedulers.mainThread())
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

