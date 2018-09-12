package pl.patrykzygo.pocketleague.ui.fragments.abilities_fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.R;
import pl.patrykzygo.pocketleague.app.App;
import pl.patrykzygo.pocketleague.app.Constants;
import pl.patrykzygo.pocketleague.pojo.SpellsItem;
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

    @Inject
    Picasso picasso;


    @Override
    public void onAttach(Context context) {
        ((App) getActivity().getApplication()).getAppComponent().inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.champion_abilities_fragment, container, false);
        ButterKnife.bind(this, view);
        attachInfo();
        return view;
    }


    public void attachInfo(){
        List<SpellsItem> spellsList = getChampion().getSpells();
        picasso.load(Constants.BASE_CONSTANTS_URL+ Constants.VERSION + "/img/spell/" +getChampion().getPassive().getImage()+ ".png").into(passiveImage);
        picasso.load(Constants.BASE_CONSTANTS_URL+ Constants.VERSION + "/img/spell/" +spellsList.get(0).getImage()+ ".png").into(qImage);
        picasso.load(Constants.BASE_CONSTANTS_URL+ Constants.VERSION + "/img/spell/" +spellsList.get(1).getImage()+ ".png").into(wImage);
        picasso.load(Constants.BASE_CONSTANTS_URL+ Constants.VERSION + "/img/spell/" +spellsList.get(2).getImage()+ ".png").into(eImage);
        picasso.load(Constants.BASE_CONSTANTS_URL+ Constants.VERSION + "/img/spell/" +spellsList.get(3).getImage()+ ".png").into(rImage);

        passiveDescription.setText(getChampion().getPassive().getDescription());
        qDescription.setText(spellsList.get(0).getDescription());
        wDescription.setText(spellsList.get(1).getDescription());
        eDescription.setText(spellsList.get(2).getDescription());
        rDescription.setText(spellsList.get(3).getDescription());
    }
}
