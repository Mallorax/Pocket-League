package pl.patrykzygo.pocketleague.ui.activities.items_list;

import java.util.List;

import pl.patrykzygo.pocketleague.base.BaseView;
import pl.patrykzygo.pocketleague.pojo.Item;

public interface ItemsListView extends BaseView {

    void attachItems(List<Item> item);

}
