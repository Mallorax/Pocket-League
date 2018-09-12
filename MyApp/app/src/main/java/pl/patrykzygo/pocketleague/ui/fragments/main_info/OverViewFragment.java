package pl.patrykzygo.pocketleague.ui.fragments.main_info;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.R;
import pl.patrykzygo.pocketleague.app.App;
import pl.patrykzygo.pocketleague.app.Constants;
import pl.patrykzygo.pocketleague.ui.fragments.base_fragments.BaseChampionFragment;

public class OverViewFragment extends BaseChampionFragment{

    @BindView(R.id.champion_list_icon)
    ImageView championIcon;
    @BindView(R.id.champion_name_text_view)
    TextView championName;
    @BindView(R.id.champion_title_text_view)
    TextView championTitle;

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
        View view = inflater.inflate(R.layout.champions_list_position, container, false);
        ButterKnife.bind(this, view);
        attachInfo();
        return view;
    }

    public void attachInfo(){
        picasso.load(Constants.BASE_CONSTANTS_URL + Constants.VERSION + "/img/champion/" + getChampion().getName()).into(championIcon);
        championName.setText(getChampion().getName());
        championTitle.setText(getChampion().getTitle());
    }

}
