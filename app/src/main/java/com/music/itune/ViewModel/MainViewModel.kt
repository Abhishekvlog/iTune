package com.music.itune.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.music.itune.Model.repo.MyRepo
import com.music.itune.Model.room.Tune

class MainViewModel(val repo: MyRepo) : ViewModel(){

    fun getMusic(): LiveData<List<Tune>> {
        return repo.getApi()

    }
    fun getMusicCharByChar(text : String): LiveData<List<Tune>> {
        return repo.getCharByChar(text)
    }

}
class MainViewModelF(val repo: MyRepo) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repo) as T
    }

}