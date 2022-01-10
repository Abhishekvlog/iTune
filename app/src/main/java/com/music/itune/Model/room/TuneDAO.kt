package com.music.itune.Model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TuneDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMusic(tune: Tune)

    @Query("Select * from iTune_Table")
    fun getMusic() : LiveData<List<Tune>>


    @Query("Select * from iTune_Table where subTitle like :text ")
    fun getMusicCharByChar(text : String) : LiveData<List<Tune>>

}