package com.music.itune.View.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.music.itune.Model.room.Tune
import com.music.itune.R
import kotlinx.android.synthetic.main.item_layout.view.*


class TuneAdapter(
    val TuneList : MutableList<Tune>) : RecyclerView.Adapter<TuneViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TuneViewHolder {
        val view :View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return TuneViewHolder(view)
    }

    override fun onBindViewHolder(holder: TuneViewHolder, position: Int) {
        holder.setData(TuneList[position])
    }

    override fun getItemCount(): Int {
        return TuneList.size
    }
}

class TuneViewHolder(val view: View) : RecyclerView.ViewHolder(view) {


    fun setData(tune: Tune){
        Glide.with(view.imageView).load(tune.Image)
            .into(view.imageView)
        view.artistName.setText(tune.artistName)
        view.SongName.setText(tune.SubTitle)
    }

    // https://is4-ssl.mzstatic.com/image/thumb/Music113/v4/e9/a9/5e/e9a95eb5-93ee-baf4-d564-c9c272aaa136/9781094248165_cover.jpg/100x100bb.jpg"
   // https://is3-ssl.mzstatic.com/image/thumb/Music114/v4/52/ea/03/52ea0399-bfa9-4b0a-5b9f-a3b8a2ce07a8/9780062562982.jpg/60x60bb.jpg


}