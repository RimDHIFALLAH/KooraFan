package com.koora.koorafan.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Team {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nom;
    private String image;
    @ColumnInfo(name = "is_favorite")
    private boolean isFavorite=false;
    @ColumnInfo(name = "is_deleted")
    private boolean isDeleted=false;

    public Team() {
    }

    public Team(String nom, String image) {
        this.nom = nom;
        this.image = image;
        this.isDeleted = isDeleted;
        this.isFavorite = isFavorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "team{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", image=" + image +
                '}';
    }
}
