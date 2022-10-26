package com.koora.koorafan.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.koora.koorafan.R;
import com.koora.koorafan.database.AppDatabase;
import com.koora.koorafan.model.Team;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private List<Team> teamList;
    private Context mContext;
    private boolean isDeleteMode;

    public TeamAdapter(List<Team> teamList, Context mContext) {
        this.teamList = teamList;
        this.mContext = mContext;
    }

    public TeamAdapter(List<Team> teamList, Context mContext, boolean isDeleteMode) {
        this.teamList = teamList;
        this.mContext = mContext;
        this.isDeleteMode = isDeleteMode;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.single_team_row, parent, false);
        return new TeamViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {

        Team singleTeam = teamList.get(position);
        holder.teamName.setText(singleTeam.getNom());
        Resources resources = mContext.getResources();
        int resourceId = resources.getIdentifier(singleTeam.getImage().replace(".png", ""), "drawable", mContext.getPackageName());
        holder.teamImg.setImageResource(resourceId);
        if (isDeleteMode) {
            holder.addToFav.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.delete_forever));
        }
        holder.addToFav.setOnClickListener(view -> {
            if (singleTeam.isFavorite() && !isDeleteMode){
                Toast.makeText(mContext, "Team is already a favorite", Toast.LENGTH_SHORT).show();
            }else if (!singleTeam.isFavorite() && !isDeleteMode){
                singleTeam.setFavorite(true);
                Toast.makeText(mContext, "Added to favorites", Toast.LENGTH_SHORT).show();
            }

            if (isDeleteMode) {
                singleTeam.setFavorite(false);
                teamList.remove(position);
                //notifyItemChanged(position);
                notifyDataSetChanged();
                Toast.makeText(mContext, "Team removed from favorites", Toast.LENGTH_SHORT).show();
            }
            AppDatabase.getInstance(mContext).teamDao().updateTeam(singleTeam);
        });
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    class TeamViewHolder extends RecyclerView.ViewHolder {

        private ImageView teamImg, addToFav;
        private TextView teamName;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);

            teamName = itemView.findViewById(R.id.team_name);
            teamImg = itemView.findViewById(R.id.team_image);
            addToFav = itemView.findViewById(R.id.add_to_fav);

        }
    }
}
