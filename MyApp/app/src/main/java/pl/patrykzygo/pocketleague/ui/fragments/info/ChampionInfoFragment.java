package pl.patrykzygo.pocketleague.ui.fragments.info;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.POJO.ChampionDto;
import pl.patrykzygo.pocketleague.R;

public class ChampionInfoFragment extends Fragment {

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

    private ChampionDto champion;

    public static ChampionInfoFragment newInstance(@NonNull ChampionDto champion){
        ChampionInfoFragment fragment = new ChampionInfoFragment();
        fragment.setChampion(champion);
        return fragment;
    }

    public void setChampion(ChampionDto champion){
        this.champion = champion;
    }

    public ChampionDto getChampion() {
        return champion;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.champion_stats_fragment, container, false);
        ButterKnife.bind(this, view);
        attachInfo();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    private void attachInfo(){
        championHealth.append(Double.toString(champion.getStats().getHp()) + " (+" + Double.toString(champion.getStats().getHpperlevel()) + " per level)");
        championMana.append(Double.toString(champion.getStats().getMp()) + " (+" + Double.toString(champion.getStats().getMpperlevel()) + " per level)");
        championHealthRegen.append(Double.toString(champion.getStats().getHpregen()) + " (+" + Double.toString(champion.getStats().getHpregenperlevel()) + " per level)");
        championManaRegen.append(Double.toString(champion.getStats().getMpregen()) + " (+" + Double.toString(champion.getStats().getMpregenperlevel()) + " per level)");
        championAd.append(Double.toString(champion.getStats().getAttackdamage()) + " (+" + Double.toString(champion.getStats().getAttackdamageperlevel()) + " per level)");
        championAr.append(Double.toString(champion.getStats().getAttackrange()));
        championArmor.append(Double.toString(champion.getStats().getArmor()) + " (+" + Double.toString(champion.getStats().getArmorperlevel()) + " per level)");
        championMr.append(Double.toString(champion.getStats().getSpellblock()) + " (+" + Double.toString(champion.getStats().getSpellblockperlevel()) + " per level)");
        championAs.append(Double.toString(champion.getStats().getAttackspeedoffset()) + " (+" + Double.toString(champion.getStats().getAttackspeedperlevel()) + "% per level)"); //TODO attack speed offset is not attack speed value, need to insert it to specific formula in order to get attack speed
        championMs.append(Double.toString(champion.getStats().getMovespeed()));
    }
}
