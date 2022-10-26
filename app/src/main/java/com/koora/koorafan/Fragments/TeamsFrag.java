package com.koora.koorafan.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.koora.koorafan.R;
import com.koora.koorafan.adapters.TeamAdapter;
import com.koora.koorafan.database.AppDatabase;
import com.koora.koorafan.model.Team;
import com.koora.koorafan.dao.TeamDao;


public class TeamsFrag extends Fragment {

    private List<Team> teamList;
    private View view;
    private TeamAdapter teamAdapter;
    public TeamsFrag() {
    }
    private List<Team> teams = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_teams, container, false);
        getListOfTeams();
        return view;
    }

    private void getListOfTeams() {
        AppDatabase db = AppDatabase.getInstance(getActivity());
        TeamDao teamDao = db.teamDao();
        teamList = teamDao.getAll();
        initListOfTeams();
    }

    private void initListOfTeams() {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        teamAdapter = new TeamAdapter(teamList, getActivity(), false);
        recyclerView.setAdapter(teamAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }


}