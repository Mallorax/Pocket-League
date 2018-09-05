package pl.patrykzygo.pocketleague.ui.activities.items_list;


import android.support.annotation.Nullable;
import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import pl.patrykzygo.pocketleague.logic.BaseSchedulerProvider;
import pl.patrykzygo.pocketleague.logic.ItemsListSorter;
import pl.patrykzygo.pocketleague.repositories.RiotRepository;

public class ItemsListPresenterImpl implements ItemsListPresenter {

    private RiotRepository repository;
    private CompositeDisposable disposable;
    private ItemsListSorter sorter;
    private BaseSchedulerProvider schedulerProvider;

    @Nullable
    private ItemsListView view;

    @Inject
    public ItemsListPresenterImpl(RiotRepository repository, BaseSchedulerProvider schedulerProvider){
        this.repository = repository;
        this.sorter = new ItemsListSorter();
        this.schedulerProvider = schedulerProvider;
        this.disposable = new CompositeDisposable();
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
        disposableadd(repository.getItemsList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((itemsList) -> {
                    view.attachItems(itemsList);
                }, throwable -> {
                    throwable.printStackTrace();
                    view.showErrorMessage("Couldn't load items");
                }));
    }

    @Override
    public List<ItemDto> sortItems(List<ItemDto> items, int option) {
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
