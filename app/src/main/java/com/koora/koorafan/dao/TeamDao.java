package com.koora.koorafan.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import com.koora.koorafan.model.Team;

@Dao
public interface TeamDao {
    @Query("SELECT * FROM team where is_deleted = 0")
    List<Team> getAll();


    @Insert
    void insertAllTeams(List<Team> teams);

    @Update
    void updateTeam(Team team);

    @Query("SELECT * FROM team where is_favorite = :isFav")
    List<Team> getFavAll(boolean isFav);

}
