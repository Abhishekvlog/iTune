package com.music.itune.Model.repo

import androidx.lifecycle.LiveData
import com.music.itune.Model.remote.Network
import com.music.itune.Model.room.Tune
import com.music.itune.Model.room.TuneDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyRepo(val dao: TuneDAO) {


     fun getApi(): LiveData<List<Tune>> {
       CoroutineScope(Dispatchers.IO).launch {
           val data =  Network.getApi.getMusic()
               .results

           data.forEach {
               val tune = Tune(it.artistName,it.collectionCensoredName,it.artworkUrl60)
               dao.addMusic(tune)
           }
       }

        return dao.getMusic()
    }
    fun getCharByChar(text : String): LiveData<List<Tune>> {
        return dao.getMusicCharByChar(text)
    }









}