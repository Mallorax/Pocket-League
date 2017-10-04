package pl.patrykzygo.pocketleague.ui.activities.items_list;


import android.support.annotation.Nullable;

import javax.inject.Inject;

import pl.patrykzygo.pocketleague.repositories.RiotRepository;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class ItemsListPresenterImpl implements ItemsListPresenter {

    private RiotRepository repository;
    private CompositeSubscription subscription;

    @Nullable
    private ItemsListView view;

    @Inject
    public ItemsListPresenterImpl(RiotRepository repository){
        this.repository = repository;
        this.subscription = new CompositeSubscription();
    }

    @Override
    public void setView(@Nullable ItemsListView view) {
        this.view = view;
    }

    @Override
    public void showItems() {
        view.showLoading();
        getItems();
        view.hideLoading();
    }

    private void getItems(){
        subscription.add(repository.getItemsList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((itemsList) -> {
                    view.attachItems(itemsList);
                }, throwable -> {
                    throwable.printStackTrace();
                    view.showErrorMessage("Couldn't load items");
                }));
    }
}
