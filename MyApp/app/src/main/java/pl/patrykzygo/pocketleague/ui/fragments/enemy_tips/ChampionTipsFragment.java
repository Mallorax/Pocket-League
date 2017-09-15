package pl.patrykzygo.pocketleague.ui.fragments.enemy_tips;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.pojo.ChampionDto;
import pl.patrykzygo.pocketleague.R;

public class ChampionTipsFragment extends Fragment{

    @BindView(R.id.champion_enemy_tips)
    TextView championTips;

    private ChampionDto champion;

    public static ChampionTipsFragment newInstance(@NonNull ChampionDto champion){
        ChampionTipsFragment fragment = new ChampionTipsFragment();
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
        View view = inflater.inflate(R.layout.champion_tips_fragment, container, false);
        ButterKnife.bind(this, view);
        attachInfo();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    private void attachInfo(){
        StringBuilder tips = new StringBuilder();
        List<String> tipsList = champion.getAllytips();
        tipsList.addAll(champion.getEnemytips());
        for (String tip : tipsList){
            tips.append(tip + "\n\n");
        }
        championTips.setText(tips.toString());
    }
}
