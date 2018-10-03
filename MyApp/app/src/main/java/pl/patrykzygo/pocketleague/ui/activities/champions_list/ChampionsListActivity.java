package pl.patrykzygo.pocketleague.ui.activities.champions_list;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.R;
import pl.patrykzygo.pocketleague.app.App;
import pl.patrykzygo.pocketleague.pojo.Champion;
import pl.patrykzygo.pocketleague.ui.activities.champion.ChampionActivity;
import pl.patrykzygo.pocketleague.ui.adapters.ChampionsListAdapter;


public class ChampionsListActivity extends AppCompatActivity implements ChampionsListView, ChampionsListAdapter.OnChampionClickListener, SearchView.OnQueryTextListener{

    @Inject
    ChampionsListPresenter presenter;

    @Inject
    ChampionsListAdapter adapter;

    @BindView(R.id.list_activity_recycler_view)
    RecyclerView championsRecyclerView;

    @BindView(R.id.list_activity_progressBar)
    ContentLoadingProgressBar progressBar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private String query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        ((App) getApplication()).getAppComponent().inject(this);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        setupRecyclerViewAndAdapter();

    }

    private void setupRecyclerViewAndAdapter(){
        championsRecyclerView.setVisibility(View.VISIBLE);
        adapter.setOnChampionClickListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        championsRecyclerView.setLayoutManager(layoutManager);
        championsRecyclerView.setAdapter(adapter);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(championsRecyclerView.getContext(), DividerItemDecoration.VERTICAL);
        championsRecyclerView.addItemDecoration(itemDecoration);
        championsRecyclerView.setNestedScrollingEnabled(false);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.setView(this);
        if (query == null) {
            presenter.showChampions();
        }else {
            adapter.getFilter().filter(query);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stop();
    }

    @Override
    protected void onDestroy() {
        championsRecyclerView.setAdapter(null);
        super.onDestroy();
    }

    @Override
    public void attachChampions (List<Champion> champions) {
        adapter.setChampions(champions);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onChampionClicked(Champion champion) {
        Intent i = new Intent(this, ChampionActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("id", champion.getId());
        i.putExtra("bundle", bundle);
        startActivity(i);
    }


    @Override
    public void showLoading() {
        progressBar.show();
    }

    @Override
    public void hideLoading() {
        progressBar.hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        this.query = query;
        adapter.getFilter().filter(query);
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        adapter.getFilter().filter(query);
        return false;
    }

}
