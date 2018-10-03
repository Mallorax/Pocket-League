package pl.patrykzygo.pocketleague.ui.fragments.info;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.R;
import pl.patrykzygo.pocketleague.base.BaseChampionFragment;

public class ChampionInfoFragment extends BaseChampionFragment {

    @BindView(R.id.champion_health)
    TextView championHealth;

    @BindView(R.id.champion_mana)
    TextView championMana;

    @BindView(R.id.champion_health_regen)
    TextView championHealthRegen;

    @BindView(R.id.champion_mana_regen)
    TextView championManaRegen;

    @BindView(R.id.champion_ad)
    TextView championAd;

    @BindView(R.id.champion_ar)
    TextView championAr;

    @BindView(R.id.champion_armor)
    TextView championArmor;

    @BindView(R.id.champion_mr)
    TextView championMr;

    @BindView(R.id.champion_as)
    TextView championAs;

    @BindView(R.id.champion_ms)
    TextView championMs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.champion_stats_fragment, container, false);
        ButterKnife.bind(this, view);
        attachInfo();
        return view;
    }

    public void attachInfo(){
        championHealth.append(Double.toString(getChampion().getStats().getHp()) + " (+" + Double.toString(getChampion().getStats().getHpperlevel()) + " per level)");
        championMana.append(Double.toString(getChampion().getStats().getMp()) + " (+" + Double.toString(getChampion().getStats().getMpperlevel()) + " per level)");
        championHealthRegen.append(Double.toString(getChampion().getStats().getHpregen()) + " (+" + Double.toString(getChampion().getStats().getHpregenperlevel()) + " per level)");
        championManaRegen.append(Double.toString(getChampion().getStats().getMpregen()) + " (+" + Double.toString(getChampion().getStats().getMpregenperlevel()) + " per level)");
        championAd.append(Double.toString(getChampion().getStats().getAttackdamage()) + " (+" + Double.toString(getChampion().getStats().getAttackdamageperlevel()) + " per level)");
        championAr.append(Double.toString(getChampion().getStats().getAttackrange()));
        championArmor.append(Double.toString(getChampion().getStats().getArmor()) + " (+" + Double.toString(getChampion().getStats().getArmorperlevel()) + " per level)");
        championMr.append(Double.toString(getChampion().getStats().getSpellblock()) + " (+" + Double.toString(getChampion().getStats().getSpellblockperlevel()) + " per level)");
        championAs.append(Double.toString(getChampion().getStats().getAttackspeed()) + " (+" + Double.toString(getChampion().getStats().getAttackspeedperlevel()) + "% per level)");
        championMs.append(Double.toString(getChampion().getStats().getMovespeed()));
    }
}
