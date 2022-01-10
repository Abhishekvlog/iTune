package com.music.itune.Model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Tune::class], version = 1)
abstract class TuneRoomDataBase : RoomDatabase() {

    abstract fun getMusicDao(): TuneDAO

    companion object {

        private var INSTANSE: TuneRoomDataBase? = null

        fun getDataBaseObject(context: Context): TuneRoomDataBase {
            if (INSTANSE == null) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    TuneRoomDataBase::class.java,
                    "tune_db"
                )
                builder.fallbackToDestructiveMigration()

                INSTANSE = builder.build()

                return INSTANSE!!
            }
            else{
                return INSTANSE!!
            }
        }

    }
}