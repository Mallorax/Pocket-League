package pl.patrykzygo.pocketleague.ui.activities.champion;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subscribers.DisposableSubscriber;
import pl.patrykzygo.pocketleague.logic.BaseSchedulerProvider;
import pl.patrykzygo.pocketleague.pojo.Champion;
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
    }

    private void getChampion(String name) {
        disposable.add(repository.getChampionByName(name)
                .observeOn(schedulerProvider.getUiScheduler())
                .subscribeWith(new DisposableSubscriber<Champion>() {
                    @Override
                    public void onNext(Champion champion) {
                        view.setTabs(champion);
                    }

                    @Override
                    public void onError(Throwable t) {
                        view.showErrorMessage(t.getMessage());
                        t.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        view.hideLoading();
                    }
                }));

    }
}
