package pl.patrykzygo.pocketleague.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.patrykzygo.pocketleague.R;
import pl.patrykzygo.pocketleague.app.Constants;


public class StaticInfoAdapter extends RecyclerView.Adapter<StaticInfoAdapter.StaticInfoViewHolder> {

    private String[] menuPositions = Constants.STATIC_MENU_POSITIONS;
    private OnMenuPositionClickListener menuPositionClickListener;

    public void setOnMenuPositionClickLiostener(OnMenuPositionClickListener listener){
        this.menuPositionClickListener = listener;
    }

    @Override
    public StaticInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View staticMenuView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.static_menu_position, parent, false);
        return new StaticInfoViewHolder(staticMenuView);
    }

    @Override
    public void onBindViewHolder(StaticInfoViewHolder holder, int position) {
        holder.text.setText(menuPositions[position]);
    }

    @Override
    public int getItemCount() {
        return menuPositions.length;
    }


    public interface OnMenuPositionClickListener{
        void onMenuPositionClicked(String positionName);
    }

    public class StaticInfoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.static_menu_text)
        TextView text;

        public StaticInfoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            menuPositionClickListener.onMenuPositionClicked(menuPositions[getLayoutPosition()]);
        }
    }
}
