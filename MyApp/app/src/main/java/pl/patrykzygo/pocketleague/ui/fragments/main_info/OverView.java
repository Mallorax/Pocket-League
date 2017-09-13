package pl.patrykzygo.pocketleague.ui.fragments.main_info;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.POJO.ChampionDto;
import pl.patrykzygo.pocketleague.R;

public class OverView extends Fragment{

    @BindView(R.id.champion_list_icon)
    ImageView championIcon;
    @BindView(R.id.champion_name_text_view)
    TextView championName;
    @BindView(R.id.champion_title_text_view)
    TextView championTitle;

    private ChampionDto champion;


    public static OverView newInstance(@NonNull ChampionDto champion){
        OverView fragment = new OverView();
        fragment.setChampion(champion);
        return fragment;
    }

    public ChampionDto getChampion() {
        return champion;
    }

    public void setChampion(ChampionDto champion){
        this.champion = champion;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.champions_list_item, container, false);
        ButterKnife.bind(this, view);
        attachInfo();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    private void attachInfo(){
        championIcon.setImageBitmap(champion.getImage().getBitmap());
        championName.setText(champion.getName());
        championTitle.setText(champion.getTitle());
    }

}
