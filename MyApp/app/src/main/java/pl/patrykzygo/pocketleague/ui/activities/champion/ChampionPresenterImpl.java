package pl.patrykzygo.pocketleague.ui.activities.champion;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subscribers.DisposableSubscriber;
import pl.patrykzygo.pocketleague.ViewModels.ChampionViewModel;
import pl.patrykzygo.pocketleague.ViewModels.ChampionsViewModel;
import pl.patrykzygo.pocketleague.logic.BaseSchedulerProvider;
import pl.patrykzygo.pocketleague.repositories.RiotRepository;


public class ChampionPresenterImpl implements ChampionPresenter {

    private RiotRepository repository;
    private CompositeDisposable disposable;
    private ChampionView view;
    private BaseSchedulerProvider schedulerProvider;

    public ChampionPresenterImpl(RiotRepository repository, BaseSchedulerProvider schedulerProvider) {
        this.repository = repository;
        this.schedulerProvider = schedulerProvider;
        disposable = new CompositeDisposable();
    }

    @Override
    public void stop() {
        disposable.clear();
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
                .onErrorReturn(throwable -> ChampionViewModel.error(throwable.getMessage()))
                .subscribeWith(new DisposableSubscriber<ChampionViewModel>() {
                    @Override
                    public void onNext(ChampionViewModel championViewModel) {
                        view.setTabs(championViewModel.getChampion());
                    }

                    @Override
                    public void onError(Throwable t) {
                        view.showErrorMessage(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        view.hideLoading();
                    }
                }));

    }
}
