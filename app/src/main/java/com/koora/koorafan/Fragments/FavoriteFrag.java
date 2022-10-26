package com.koora.koorafan.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koora.koorafan.R;
import com.koora.koorafan.adapters.TeamAdapter;
import com.koora.koorafan.dao.TeamDao;
import com.koora.koorafan.database.AppDatabase;
import com.koora.koorafan.model.Team;

import java.util.List;

public class FavoriteFrag extends Fragment {
    private List<Team> teamList;
    private View view;
    private TeamAdapter teamAdapter;

    public FavoriteFrag() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_favorite, container, false);
        getListOfTeams();
        return view;
    }
    private void getListOfTeams() {
        AppDatabase db = AppDatabase.getInstance(getActivity());
        TeamDao teamDao = db.teamDao();
        teamList = teamDao.getFavAll(true);
        initListOfTeams();
    }

    private void initListOfTeams() {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        teamAdapter = new TeamAdapter(teamList, getActivity(), true);
        recyclerView.setAdapter(teamAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }
}