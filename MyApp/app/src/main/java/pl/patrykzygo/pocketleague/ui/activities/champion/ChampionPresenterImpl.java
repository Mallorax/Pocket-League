package pl.patrykzygo.pocketleague.ui.activities.champion;


import io.reactivex.disposables.CompositeDisposable;
import pl.patrykzygo.pocketleague.logic.BaseSchedulerProvider;
import pl.patrykzygo.pocketleague.repositories.RiotRepository;


public class ChampionPresenterImpl implements ChampionPresenter {

    private RiotRepository repository;
    private CompositeDisposable disposable;
    private ChampionView view;
    private BaseSchedulerProvider schedulerProvider;

    public ChampionPresenterImpl(RiotRepository repository, BaseSchedulerProvider schedulerProvider){
        this.repository = repository;
        this.schedulerProvider = schedulerProvider;
        disposable = new CompositeDisposable();
    }

    @Override
    public void setView(ChampionView view) {
        this.view = view;
    }

    @Override
    public void presentChampion(String name) {
        view.showLoading();
        getChampion(name);
        view.hideLoading();
    }

    private void getChampion(String name) {
        disposable.add(repository.getChampionByName(name)
        .observeOn(schedulerProvider.getUiScheduler())
        .subscribe(champion -> view.setTabs(champion)
        , throwable -> {
            throwable.printStackTrace();
            view.showErrorMessage("Couldn't load champion");
        }));
    }
}
