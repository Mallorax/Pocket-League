package pl.patrykzygo.pocketleague.ui.activities.champion;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.R;
import pl.patrykzygo.pocketleague.ui.Fragments.lore_tab.ChampionLoreTab;
import pl.patrykzygo.pocketleague.ui.Fragments.abilities_tab.ChampionAbilitiesTab;
import pl.patrykzygo.pocketleague.ui.Fragments.overview_tab.ChampionOverviewTab;
import pl.patrykzygo.pocketleague.ui.adapters.ViewPagerAdapter;

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

        Bundle args = getIntent().getBundleExtra("bundle");


        ChampionOverviewTab overviewTab = new ChampionOverviewTab();
        ChampionAbilitiesTab abilitiesTab = new ChampionAbilitiesTab();
        ChampionLoreTab loreTab = new ChampionLoreTab();


        adapter.addFragment(overviewTab, "Overview");
        adapter.addFragment(abilitiesTab, "Abilities");
        adapter.addFragment(loreTab, "Lore");


        viewPager.setAdapter(adapter);
    }
}
