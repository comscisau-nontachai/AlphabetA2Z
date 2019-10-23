package com.becomedev.alphabeta2z.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.viewpager.widget.ViewPager
import com.becomedev.alphabeta2z.R
import com.becomedev.alphabeta2z.model.Alphabet
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var indicator: Array<TextView>
    private lateinit var list : ArrayList<Alphabet>
    private var currentPage = 0
    private val listener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            currentPage = position
            addIndicator(currentPage)

            when (position) {
                0 -> {
                    btn_next.isEnabled = true
                    btn_prev.isEnabled = false

                    btn_next.text = "next"
                    btn_prev.text = ""

                    btn_prev.visibility = View.INVISIBLE

                }
                indicator.size - 1 -> {
                    btn_next.isEnabled = true
                    btn_prev.isEnabled = true

                    btn_next.text = "finish"
                    btn_prev.text = "prev"

                    btn_prev.visibility = View.VISIBLE
                }
                else -> {
                    btn_next.isEnabled = true
                    btn_prev.isEnabled = true

                    btn_next.text = "next"
                    btn_prev.text = "prev"

                    btn_prev.visibility = View.VISIBLE
                }
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_main)



        val adapter = AlphabetAdapter(addListData())
        view_pager.adapter = adapter

        addIndicator(0)

        view_pager.addOnPageChangeListener(listener)

        btn_next.setOnClickListener {
            view_pager.currentItem = currentPage+1
        }
        btn_prev.setOnClickListener {
            view_pager.currentItem = currentPage-1
        }
    }

    private fun addListData() : ArrayList<Alphabet>{
        list = ArrayList()

        list.add(Alphabet("A - Apple","He looked longingly at an apple pie fresh from the oven.",R.drawable.ic_001_letter_a))
        list.add(Alphabet("B - Bee","Somewhere in the garden a bee buzzed and someone shuffled their feet.",R.drawable.ic_002_letter_b))
        list.add(Alphabet("C - Cat","Did the cat get your tongue at the table?",R.drawable.ic_003_letter_c))
        list.add(Alphabet("D - Drum","And then she heard the drum of hooves behind her.",R.drawable.ic_004_letter_d))
        list.add(Alphabet("E - Egg","The egg popped grease and she jumped back.",R.drawable.ic_005_letter_e))
        list.add(Alphabet("F - Fish","The fish flipped and dived back into the water.",R.drawable.ic_006_letter_f))
        list.add(Alphabet("G - Glove","He wiped the tear away with a thumb and then opened the glove compartment.",R.drawable.ic_007_letter_g))
        list.add(Alphabet("H - Home","His home was in the country not far from a great forest.",R.drawable.ic_008_letter_h))
        list.add(Alphabet("I - Igloo","I have a special little igloo high up in our new home.",R.drawable.ic_009_letter_i))
        list.add(Alphabet("J - Jar","She handed the jar to Rob and grinned.",R.drawable.ic_010_letter_j))
        list.add(Alphabet("K - Key","He has a key to the mine gate.",R.drawable.ic_011_letter_k))
        list.add(Alphabet("L - Lock","They're too busy trying to lock me up and toss the key.",R.drawable.ic_012_letter_l))
        list.add(Alphabet("M - Mug","He set the coffee mug on the counter.",R.drawable.ic_013_letter_m))
        list.add(Alphabet("N - Net","The net seemed heavy.",R.drawable.ic_014_letter_n))
        list.add(Alphabet("O - Orange","Four years later East Orange was chartered as a city.",R.drawable.ic_015_letter_o))
        list.add(Alphabet("P - Pumpkin","Not the case with Pumpkin Green.",R.drawable.ic_016_letter_p))
        list.add(Alphabet("Q - Queen","You are the Queen of my heart.",R.drawable.ic_017_letter_q))
        list.add(Alphabet("R - Robot","I would need the robot to be able to proactively offer suggestions.",R.drawable.ic_018_letter_r))
        list.add(Alphabet("S - Snake","There could be a snake in the daylight.",R.drawable.ic_019_letter_s))
        list.add(Alphabet("T - Teapot","The khiao were invested by a gold dish, betel-box, spittoon and teapot, which were sent from Bangkok and returned at their death or deposition.",R.drawable.ic_020_letter_t))
        list.add(Alphabet("U - Umbrella","She held an umbrella and was dressed in a grey suit.",R.drawable.ic_021_letter_u))
        list.add(Alphabet("V - Volcano","The active volcano of Ceboruco rises in the western part of the territory.",R.drawable.ic_022_letter_v))
        list.add(Alphabet("W - Watch","And he will find he is capable of adding far more value than as a set of eyes watching a screen.",R.drawable.ic_023_letter_w))
        list.add(Alphabet("X - Xylophone","thumb piano and xylophone as well as West and East African drumming and dancing.",R.drawable.ic_024_letter_x))
        list.add(Alphabet("Y - Yoyo","One of the most popular free design programs you can use is called Gamemaker, which is available from YoYo Games.",R.drawable.ic_025_letter_y))
        list.add(Alphabet("Z - Zipper","He tugged on her zipper, slowly pulling it down.",R.drawable.ic_026_letter_z))

        return list
    }

    private fun addIndicator(position: Int) {

        indicator = Array(list.size) { TextView(this) }
        linear_indicator.removeAllViews()

        for (i in 0..indicator.lastIndex) {
            indicator[i] = TextView(this)
            indicator[i].text = Html.fromHtml("&#8226;")
            indicator[i].textSize = 35.0f
            indicator[i].setTextColor(resources.getColor(R.color.colorWhiteTransparent))

            linear_indicator.addView(indicator[i])
        }

        //set select indicator
        if (indicator.isNotEmpty())
            indicator[position].setTextColor(resources.getColor(R.color.colorAccent))
    }
}
