package pl.patrykzygo.pocketleague.ui.activities.items_list;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.R;
import pl.patrykzygo.pocketleague.app.App;
import pl.patrykzygo.pocketleague.pojo.ItemDto;
import pl.patrykzygo.pocketleague.ui.adapters.ItemsListAdapter;

public class ItemsListActivity extends AppCompatActivity implements ItemsListView, ItemsListAdapter.OnListItemClickedListener, SearchView.OnQueryTextListener {

    @Inject
    ItemsListPresenter presenter;

    @Inject
    ItemsListAdapter adapter;

    @BindView(R.id.list_activity_recycler_view)
    RecyclerView itemsRecyclerView;

    @BindView(R.id.list_activity_progressBar)
    ProgressBar progressBar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        ((App) getApplication()).getAppComponent().inject(this);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        itemsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter.setView(this);
        presenter.showItems();

    }

    @Override
    public void attachItems(List<ItemDto> items) {
        adapter.setItemsList(items);
        adapter.setOnListItemClickListener(this);
        adapter.notifyDataSetChanged();
        itemsRecyclerView.setAdapter(adapter);
        itemsRecyclerView.addItemDecoration(new DividerItemDecoration(itemsRecyclerView.getContext(), DividerItemDecoration.VERTICAL));
        itemsRecyclerView.setNestedScrollingEnabled(false);
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onListItemClicked(ItemDto item) {
        Toast.makeText(this, "Item id: " + item.getId(), Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        adapter.filter(query);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        adapter.filter(query);
        return false;
    }
}
