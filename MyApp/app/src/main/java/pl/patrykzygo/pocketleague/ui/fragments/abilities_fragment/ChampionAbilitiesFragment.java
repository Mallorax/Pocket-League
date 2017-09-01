package pl.patrykzygo.pocketleague.ui.fragments.abilities_fragment;


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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.POJO.ChampionDto;
import pl.patrykzygo.pocketleague.POJO.ChampionSpellDto;
import pl.patrykzygo.pocketleague.R;

public class ChampionAbilitiesFragment extends Fragment {

    @BindView(R.id.passive_image)
    ImageView passiveImage;

    @BindView(R.id.q_image)
    ImageView qImage;

    @BindView(R.id.w_image)
    ImageView wImage;

    @BindView(R.id.e_image)
    ImageView eImage;

    @BindView(R.id.r_image)
    ImageView rImage;

    @BindView(R.id.passive_description)
    TextView passiveDescription;

    @BindView(R.id.q_description)
    TextView qDescription;

    @BindView(R.id.w_description)
    TextView wDescription;

    @BindView(R.id.e_description)
    TextView eDescription;

    @BindView(R.id.r_description)
    TextView rDescription;

    private ChampionDto champion;

    public static ChampionAbilitiesFragment newInstance(@NonNull ChampionDto champion){
        ChampionAbilitiesFragment fragment = new ChampionAbilitiesFragment();
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
        View view = inflater.inflate(R.layout.champion_abilities_fragment, container, false);
        ButterKnife.bind(this, view);
        attachInfo();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    private void attachInfo(){
        List<ChampionSpellDto> spellsList = champion.getSpells();
        passiveImage.setImageBitmap(champion.getPassive().getImage().getBitmap());
        qImage.setImageBitmap(spellsList.get(0).getImage().getBitmap());
        wImage.setImageBitmap(spellsList.get(1).getImage().getBitmap());
        eImage.setImageBitmap(spellsList.get(2).getImage().getBitmap());
        rImage.setImageBitmap(spellsList.get(3).getImage().getBitmap());

        passiveDescription.setText(champion.getPassive().getSanitizedDescription());
        qDescription.setText(spellsList.get(0).getSanitizedDescription());
        wDescription.setText(spellsList.get(1).getSanitizedDescription());
        eDescription.setText(spellsList.get(2).getSanitizedDescription());
        rDescription.setText(spellsList.get(3).getSanitizedDescription());
    }
}
