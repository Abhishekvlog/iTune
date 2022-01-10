package com.music.itune.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arlib.floatingsearchview.FloatingSearchView
import com.music.itune.Model.repo.MyRepo
import com.music.itune.Model.room.Tune
import com.music.itune.Model.room.TuneDAO
import com.music.itune.Model.room.TuneRoomDataBase
import com.music.itune.R
import com.music.itune.View.adapter.TuneAdapter
import com.music.itune.ViewModel.MainViewModel
import com.music.itune.ViewModel.MainViewModelF
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var tuneRoomDataBase: TuneRoomDataBase
    lateinit var tuneDAO: TuneDAO
    lateinit var tuneAdapter: TuneAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tuneRoomDataBase = TuneRoomDataBase.getDataBaseObject(this)
        tuneDAO = tuneRoomDataBase.getMusicDao()
        val repo = MyRepo(tuneDAO)

        mainViewModel = ViewModelProvider(this, MainViewModelF(repo)).get(MainViewModel::class.java)

        mainViewModel.getMusic().observe(this, Observer {
            setAdapter(it)
        })

        search_View.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                val New_list = mainViewModel.getMusicCharByChar(p0!!)
                New_list.observe(this@MainActivity, Observer {
                    setAdapter(it)
                })
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val New_list = mainViewModel.getMusicCharByChar(newText!!)
                New_list.observe(this@MainActivity, Observer {
                    setAdapter(it)
                })
                return false
            }

        })

    }

    private fun setAdapter(tuneList: List<Tune>) {
        tuneAdapter = TuneAdapter(tuneList as MutableList<Tune>)
        val linearLayoutManager = LinearLayoutManager(this)
        Recycler_View.apply {
            layoutManager = linearLayoutManager
            this.adapter = tuneAdapter
        }

    }


}
