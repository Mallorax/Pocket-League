package pl.patrykzygo.pocketleague.ui.champions.champion;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.R;
import pl.patrykzygo.pocketleague.ui.ViewPagerAdapter;
import pl.patrykzygo.pocketleague.ui.champions.champion.abilities_tab.ChampionAbilitiesTab;
import pl.patrykzygo.pocketleague.ui.champions.champion.lore_tab.ChampionLoreTab;
import pl.patrykzygo.pocketleague.ui.champions.champion.overview_tab.ChampionOverviewTab;

public class ChampionActivity extends AppCompatActivity{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_activity_layout);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ChampionOverviewTab(), "Overview");
        adapter.addFragment(new ChampionAbilitiesTab(), "Abilities");
        adapter.addFragment(new ChampionLoreTab(), "Lore");


        viewPager.setAdapter(adapter);
    }
}
