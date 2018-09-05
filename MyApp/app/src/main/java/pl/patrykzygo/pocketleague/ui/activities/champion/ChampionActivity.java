package pl.patrykzygo.pocketleague.ui.activities.champion;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.pojo.Champion;
import pl.patrykzygo.pocketleague.R;
import pl.patrykzygo.pocketleague.app.App;
import pl.patrykzygo.pocketleague.ui.adapters.ViewPagerAdapter;
import pl.patrykzygo.pocketleague.ui.fragments.base_fragments.BaseChampionFragment;
import pl.patrykzygo.pocketleague.ui.fragments.tabs_fragments.abilities_tab.ChampionAbilitiesTab;
import pl.patrykzygo.pocketleague.ui.fragments.tabs_fragments.lore_tab.ChampionLoreTab;
import pl.patrykzygo.pocketleague.ui.fragments.tabs_fragments.overview_tab.ChampionOverviewTab;

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

        presenter.presentChampion(getIntent().getBundleExtra("bundle").getString("id"));
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public void setTabs(Champion champion) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        BaseChampionFragment overViewTab = new ChampionOverviewTab();
        BaseChampionFragment abilitiesTab = new ChampionAbilitiesTab();
        BaseChampionFragment loreTab = new ChampionLoreTab();

        overViewTab.setChampion(champion);
        abilitiesTab.setChampion(champion);
        loreTab.setChampion(champion);

        adapter.addFragment(overViewTab, "Overview");
        adapter.addFragment(abilitiesTab, "Abilities");
        adapter.addFragment(loreTab, "Lore");

        viewPager.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.setView(null);
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
