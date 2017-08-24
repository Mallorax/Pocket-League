package pl.patrykzygo.pocketleague.ui.activities.champions_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.POJO.ChampionDto;
import pl.patrykzygo.pocketleague.R;
import pl.patrykzygo.pocketleague.app.App;
import pl.patrykzygo.pocketleague.ui.activities.champion.ChampionActivity;


public class ChampionsListActivity extends AppCompatActivity implements ChampionsListView, ChampionsListAdapter.OnChampionClickListener {

    @Inject
    ChampionsListPresenter presenter;

    @Inject
    ChampionsListAdapter adapter;

    @BindView(R.id.champions_recycler_view)
    RecyclerView championsRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champions_list);

        ((App) getApplication()).getAppComponent().inject(this);

        ButterKnife.bind(this);
        championsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter.setView(this);
        presenter.showChampions();
    }


    @Override
    public void attachChampions(List<ChampionDto> champions) {
        adapter.setChampions(champions);
        championsRecyclerView.setAdapter(adapter);
        championsRecyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onChampionClick(ChampionDto champion) {
        Intent i = new Intent(this, ChampionActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id", champion.getId());
        i.putExtra("bundle", bundle);
        startActivity(i);
    }
}
