package com.music.itune.Model.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "iTune_Table")
data class Tune(
    @ColumnInfo(name = "artistName") var artistName :String,
    @ColumnInfo(name = "subTitle") var SubTitle : String,
    @ColumnInfo(name = "image") var Image : String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int? = null
}