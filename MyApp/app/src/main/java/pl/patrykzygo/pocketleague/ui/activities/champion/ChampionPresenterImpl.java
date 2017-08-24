package pl.patrykzygo.pocketleague.ui.activities.champion;


import pl.patrykzygo.pocketleague.repositories.RiotRepository;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

public class ChampionPresenterImpl implements ChampionPresenter {

    private RiotRepository repository;
    private CompositeSubscription subscription;
    private ChampionView view;

    public ChampionPresenterImpl(RiotRepository repository){
        this.repository = repository;
        subscription = new CompositeSubscription();
    }

    @Override
    public void setView(ChampionView view) {
        this.view = view;
    }

    @Override
    public void presentChampion(int id) {
        view.showLoading();
        getChampion(id);
        view.hideLoading();
    }

    private void getChampion(int id) {
        subscription.add(repository.getChampionById(id)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(champion ->{
            view.setTabs(champion);
        }, throwable -> {
            throwable.printStackTrace();
            view.showErrorMessage("Couldn't load champion");
        }));
    }
}
