package pl.patrykzygo.pocketleague.ui.activities.items_list;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import pl.patrykzygo.pocketleague.pojo.ItemDto;

public class ItemsListActivity extends AppCompatActivity implements ItemsListView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void attachItems(List<ItemDto> items) {

    }

    @Override
    public void showErrorMessage(String errorMessage) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
