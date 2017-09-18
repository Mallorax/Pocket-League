package pl.patrykzygo.pocketleague.ui.fragments.abilities_fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.R;
import pl.patrykzygo.pocketleague.pojo.ChampionSpellDto;
import pl.patrykzygo.pocketleague.ui.fragments.base_fragments.BaseChampionFragment;

public class ChampionAbilitiesFragment extends BaseChampionFragment {

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


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.champion_abilities_fragment, container, false);
        ButterKnife.bind(this, view);
        attachInfo();
        return view;
    }


    public void attachInfo(){
        List<ChampionSpellDto> spellsList = getChampion().getSpells();
        passiveImage.setImageBitmap(getChampion().getPassive().getImage().getBitmap());
        qImage.setImageBitmap(spellsList.get(0).getImage().getBitmap());
        wImage.setImageBitmap(spellsList.get(1).getImage().getBitmap());
        eImage.setImageBitmap(spellsList.get(2).getImage().getBitmap());
        rImage.setImageBitmap(spellsList.get(3).getImage().getBitmap());

        passiveDescription.setText(getChampion().getPassive().getSanitizedDescription());
        qDescription.setText(spellsList.get(0).getSanitizedDescription());
        wDescription.setText(spellsList.get(1).getSanitizedDescription());
        eDescription.setText(spellsList.get(2).getSanitizedDescription());
        rDescription.setText(spellsList.get(3).getSanitizedDescription());
    }
}
