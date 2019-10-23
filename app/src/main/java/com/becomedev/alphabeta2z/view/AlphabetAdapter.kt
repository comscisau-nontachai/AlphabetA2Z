package com.becomedev.alphabeta2z.view

import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.becomedev.alphabeta2z.R
import com.becomedev.alphabeta2z.model.Alphabet
import java.util.zip.Inflater

class AlphabetAdapter constructor(val list:ArrayList<Alphabet>) : PagerAdapter(){


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int = list.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any{
        val view = LayoutInflater.from(container.context).inflate(R.layout.item_slide,container,false)

        val tvHeader = view.findViewById<TextView>(R.id.txt_head)
        val tvDesc = view.findViewById<TextView>(R.id.txt_desc)
        val imgTitle = view.findViewById<ImageView>(R.id.img_slide)

        tvHeader.text = list[position].title
        tvDesc.text = list[position].detail
        imgTitle.setBackgroundResource(list[position].img)

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }
}