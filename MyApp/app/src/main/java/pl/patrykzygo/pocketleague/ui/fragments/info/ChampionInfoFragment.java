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

    private static final String CHAMPION_KEY = "champion_key";

    private ChampionDto champion;

    private static ChampionInfoFragment newInstance(@NonNull ChampionDto champion){
        ChampionInfoFragment fragment = new ChampionInfoFragment();
        fragment.setChampion(champion);
        return fragment;
    }

    public void setChampion(ChampionDto champion){
        this.champion = champion;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.champion_stats_fragment, container, false);
        ButterKnife.bind(this, view);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        attachInfo();
    }

    private void attachInfo(){
        championHealth.append(Double.toString(champion.getStats().getHp()) + " (+" + Double.toString(champion.getStats().getHpPerLevel()) + " per level");
        championMana.append(Double.toString(champion.getStats().getMp()) + " (+" + Double.toString(champion.getStats().getMpPerLevel()) + " per level");
        championHealthRegen.append(Double.toString(champion.getStats().getHpRegen()) + " (+" + Double.toString(champion.getStats().getHpRegenPerLevel()) + " per level");
        championManaRegen.append(Double.toString(champion.getStats().getMpRegen()) + " (+" + Double.toString(champion.getStats().getMpRegenPerLevel()) + " per level");
        championAd.append(Double.toString(champion.getStats().getAttackDamage()) + " (+" + Double.toString(champion.getStats().getAttackDamagePerLevel()) + " per level");
        championAr.append(Double.toString(champion.getStats().getAttackRange()));
        championArmor.append(Double.toString(champion.getStats().getArmor()) + " (+" + Double.toString(champion.getStats().getArmorPerLevel()) + " per level");
        championMr.append(Double.toString(champion.getStats().getSpellBlock()) + " (+" + Double.toString(champion.getStats().getSpellBlockPerLevel()) + " per level");
        championAs.append(Double.toString(champion.getStats().getAttackSpeedOffset()) + " (+" + Double.toString(champion.getStats().getAttackSpeedPerLevel()) + " per level");
        championHealth.append(Double.toString(champion.getStats().getMoveSpeed()));
    }
}
