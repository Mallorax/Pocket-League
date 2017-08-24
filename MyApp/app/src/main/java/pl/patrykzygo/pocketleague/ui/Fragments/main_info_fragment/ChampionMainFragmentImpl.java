package pl.patrykzygo.pocketleague.ui.Fragments.main_info_fragment;


import pl.patrykzygo.pocketleague.repositories.RiotRepository;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

public class ChampionMainFragmentImpl implements ChampionMainFragmentPresenter {

    private ChampionMainFragmentView view;
    private RiotRepository repository;
    private CompositeSubscription subscription;

    public ChampionMainFragmentImpl(RiotRepository repository) {
        this.repository = repository;
        subscription = new CompositeSubscription();
    }

    @Override
    public void setView(ChampionMainFragmentView view) {
        this.view = view;
    }

    @Override
    public void showInfo(int id) {
        subscription.add(repository.getChampionById(id)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe((champion -> {
            view.showInfo(champion);
        })));
    }
}
