package pl.patrykzygo.pocketleague.ui.activities.champions_list;

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

    //TODO user needs to scroll list up into a top to see the search bar, fix that


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        ((App) getApplication()).getAppComponent().inject(this);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        presenter.setView(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.showChampions();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stop();
    }

    @Override
    public void attachChampions (List<Champion> champions) {
        progressBar.hide();
        championsRecyclerView.setVisibility(View.VISIBLE);
        adapter.setOnChampionClickListener(this);
        adapter.setChampions(champions);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        championsRecyclerView.setLayoutManager(layoutManager);
        championsRecyclerView.setAdapter(adapter);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(championsRecyclerView.getContext(), DividerItemDecoration.VERTICAL);
        championsRecyclerView.addItemDecoration(itemDecoration);
        championsRecyclerView.setNestedScrollingEnabled(false);

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
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
        return true;
    }


    //TODO don't know if code below should be inside activity, have to check it out
    //TODO you can't see filtered positions after deleting text, fix that fast

    @Override
    public boolean onQueryTextChange(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

}
