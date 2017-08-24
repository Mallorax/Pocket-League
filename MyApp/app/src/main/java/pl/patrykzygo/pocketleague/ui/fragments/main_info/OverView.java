package pl.patrykzygo.pocketleague.ui.fragments.main_info;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.R;

public class OverView extends Fragment{

    @BindView(R.id.champion_list_icon)
    ImageView championIcon;
    @BindView(R.id.champion_name_text_view)
    TextView championName;
    @BindView(R.id.champion_title_text_view)
    TextView championTitle;


    private static OverView newInstance(int id){
        OverView fragment = new OverView();
        Bundle b = new Bundle();
        b.putInt("id", id);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.champions_list_item, container, false);
        ButterKnife.bind(this, view);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

}
