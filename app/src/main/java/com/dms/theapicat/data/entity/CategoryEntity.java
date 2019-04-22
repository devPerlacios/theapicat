package com.dms.theapicat.data.entity;

import com.dms.theapicat.util.Constans;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = Constans.NAME_TABLE_CATEGORY)
public class CategoryEntity {

    @SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey
    @NonNull
    private int id;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    @NonNull
    private String name;

    public CategoryEntity() {
    }

    @Ignore
    public CategoryEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
