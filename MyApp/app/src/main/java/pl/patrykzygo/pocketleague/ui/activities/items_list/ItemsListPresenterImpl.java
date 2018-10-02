package pl.patrykzygo.pocketleague.ui.activities.items_list;


import android.support.annotation.Nullable;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subscribers.DisposableSubscriber;
import pl.patrykzygo.pocketleague.ViewModels.ItemsViewModel;
import pl.patrykzygo.pocketleague.base.BaseView;
import pl.patrykzygo.pocketleague.logic.BaseSchedulerProvider;
import pl.patrykzygo.pocketleague.logic.ItemsListSorter;
import pl.patrykzygo.pocketleague.pojo.Item;
import pl.patrykzygo.pocketleague.repositories.RiotRepository;

public class ItemsListPresenterImpl implements ItemsListPresenter {

    private RiotRepository repository;
    private CompositeDisposable disposable;
    private ItemsListSorter sorter;
    private BaseSchedulerProvider schedulerProvider;

    private ItemsListView view;

    @Inject
    public ItemsListPresenterImpl(RiotRepository repository, BaseSchedulerProvider schedulerProvider){
        this.repository = repository;
        this.sorter = new ItemsListSorter();
        this.schedulerProvider = schedulerProvider;
        this.disposable = new CompositeDisposable();
    }

    @Override
    public void setView(ItemsListView view) {
        this.view = view;
    }

    @Override
    public void showItems() {
        getItems();
    }

    private void getItems(){
        disposable.add(repository.getItems()
                .observeOn(schedulerProvider.getUiScheduler())
                .startWith(ItemsViewModel.loading())
                .onErrorReturn(throwable -> {
                    throwable.printStackTrace();
                    return ItemsViewModel.error(throwable.getMessage());
                    })
                .subscribeWith(new DisposableSubscriber<ItemsViewModel>(){
                    @Override
                    public void onNext(ItemsViewModel itemsViewModel) {
                        if (itemsViewModel.hasError()){
                            view.showErrorMessage(itemsViewModel.getErrorMessage());
                        }else if (itemsViewModel.isLoading()){
                            view.showLoading();
                        }else {
                            List<Item> itemsList = sorter.getListByPriceAsc(itemsViewModel.getItems());
                            view.attachItems(itemsList);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        view.hideLoading();
                    }
                }));
    }

    @Override
    public void stop() {
        disposable.clear();
    }


    @Override
    public List<Item> sortItems(List<Item> items, int option) {
        switch (option){
            case 0:
                items = sorter.getListByNameAsc(items);
                break;
            case 1:
                items =  sorter.getListByNameDesc(items);
                break;
            case 2:
                items = sorter.getListByPriceAsc(items);
                break;
            case 3:
                items = sorter.getListByPriceDesc(items);
                break;
            default:
                items = null;
                break;
        }
        return items;
    }
}
