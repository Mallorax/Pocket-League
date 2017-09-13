package pl.patrykzygo.pocketleague.ui.fragments.lore_fragment;


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

public class ChampionLoreFragment extends Fragment{

    @BindView(R.id.champion_lore)
    TextView championLore;

    private ChampionDto champion;

    public static ChampionLoreFragment newInstance(@NonNull ChampionDto champion){
        ChampionLoreFragment fragment = new ChampionLoreFragment();
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
        View view = inflater.inflate(R.layout.champion_lore_fragment, container, false);
        ButterKnife.bind(this, view);
        attachInfo();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    private void attachInfo(){
        String lore = champion.getLore().replace("<br>", "\n");
        championLore.setText(lore);
    }

}
