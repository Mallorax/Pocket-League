package pl.patrykzygo.pocketleague.ui.fragments.enemy_tips;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.POJO.ChampionDto;
import pl.patrykzygo.pocketleague.R;

public class ChampionEnemyTipsFragment extends Fragment{

    @BindView(R.id.champion_enemy_tips)
    TextView championTips;

    private ChampionDto champion;

    private static ChampionEnemyTipsFragment newInstance(@NonNull ChampionDto champion){
        ChampionEnemyTipsFragment fragment = new ChampionEnemyTipsFragment();
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
        View view = inflater.inflate(R.layout.champion_enemy_tips_fragment, container, false);
        ButterKnife.bind(this, view);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        attachInfo();
    }

    private void attachInfo(){
        StringBuilder tips = new StringBuilder();
        tips.append(TextUtils.join("\n", champion.getAllyTips()));
        tips.append("\n" + TextUtils.join("\n", champion.getEnemyTips()));
        championTips.setText(tips);
    }
}
