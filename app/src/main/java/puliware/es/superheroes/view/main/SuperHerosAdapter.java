package puliware.es.superheroes.view.main;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import puliware.es.superheroes.R;
import puliware.es.superheroes.model.Profile;
import puliware.es.superheroes.util.CircleTransform;

public class SuperHerosAdapter extends RecyclerView.Adapter<SuperHerosAdapter.SuperHeroViewHolder> {

    private List<Profile> msuperhero_avs;

    private OnListFragmentInteractionListener mListener;

    @Inject
    public SuperHerosAdapter() {
        msuperhero_avs = new ArrayList<>();
    }

    public void setHeroes(List<Profile> superhero_avs) {
        msuperhero_avs = superhero_avs;
    }

    public void setListener(OnListFragmentInteractionListener listener) {
        mListener = listener;
    }

    @Override
    public SuperHeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_superhero, parent, false);
        return new SuperHeroViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SuperHeroViewHolder holder, final int position) {
        final Profile superhero = msuperhero_avs.get(position);
        holder.nameTextView.setText(String.format("%s",
                superhero.name()));
        holder.resume.setText(superhero.realName() + " ("+ superhero.height() +")");
        Glide.with(holder.avatar.getContext())
                .load(superhero.photo())
                .diskCacheStrategy(DiskCacheStrategy.NONE).centerCrop().
                bitmapTransform(new CircleTransform(holder.avatar.getContext()))
                .skipMemoryCache(true)
                .into(holder.avatar);
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    mListener.onListFragmentInteraction(superhero);
            }
        });
    }

    @Override
    public int getItemCount() {
        return msuperhero_avs.size();
    }

    class SuperHeroViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.profileView)ImageView avatar;
        @BindView(R.id.name) TextView nameTextView;
        @BindView(R.id.resume) TextView resume;
        @BindView(R.id.card_view)
        CardView rootView;


        public SuperHeroViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Profile hero);
    }
}
