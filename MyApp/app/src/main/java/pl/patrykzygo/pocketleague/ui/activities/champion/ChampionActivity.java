package pl.patrykzygo.pocketleague.ui.activities.champion;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.function.ToDoubleBiFunction;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.POJO.ChampionDto;
import pl.patrykzygo.pocketleague.R;
import pl.patrykzygo.pocketleague.app.App;
import pl.patrykzygo.pocketleague.ui.fragments.tabs_fragments.lore_tab.ChampionLoreTab;
import pl.patrykzygo.pocketleague.ui.fragments.tabs_fragments.abilities_tab.ChampionAbilitiesTab;
import pl.patrykzygo.pocketleague.ui.fragments.tabs_fragments.overview_tab.ChampionOverviewTab;
import pl.patrykzygo.pocketleague.ui.adapters.ViewPagerAdapter;

public class ChampionActivity extends AppCompatActivity implements ChampionView{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @Inject
    ChampionPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_activity_layout);

        ((App) getApplication()).getAppComponent().inject(this);

        ButterKnife.bind(this);

        presenter.setView(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {

    }

    @Override
    public void setTabs(ChampionDto champion) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //TODO set tabs by adding specific champion to required fragments


        adapter.addFragment(overviewTab, "Overview");
        adapter.addFragment(abilitiesTab, "Abilities");
        adapter.addFragment(loreTab, "Lore");


        viewPager.setAdapter(adapter);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        //TODO implement
    }

    @Override
    public void hideLoading() {
        //TODO implement
    }
}
