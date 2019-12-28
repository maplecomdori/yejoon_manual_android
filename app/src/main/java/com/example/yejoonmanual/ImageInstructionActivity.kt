package com.example.yejoonmanual

import android.app.PendingIntent.getActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginBottom
import androidx.core.widget.TextViewCompat
import com.example.yejoonmanual.DataManager.imageTaskDataMap

import kotlinx.android.synthetic.main.activity_image_inscturction.*
import kotlinx.android.synthetic.main.activity_shortcut.*
import java.io.IOException

class ImageInstructionActivity : AppCompatActivity() {

    private var instructions: Array<Instruction>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_inscturction)
        setSupportActionBar(toolbar)
        setTitle()
        prepareUI()
    }

    private fun prepareUI() {
        instructions = imageTaskDataMap[this.title]
        instructions?.forEachIndexed { index, inst ->
            val ll = LinearLayout(this)
            val ll_layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)
            ll_layoutParams.setMargins(0, 0, 0, 50)
            ll.layoutParams = ll_layoutParams
            ll.orientation = LinearLayout.VERTICAL

            val tvTitle = TextView(this)
            tvTitle.text = "#" + (index + 1) + " " + inst.title
            TextViewCompat.setTextAppearance(tvTitle, R.style.instructionTitle)

            ll.addView(tvTitle)

            if(inst.picturePath != null) {
                val iv = ImageView(this)
                val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT)
                params.bottomMargin = 30
                iv.layoutParams = params
                iv.adjustViewBounds = true

                val bm = getBitmapFromAssets(inst.picturePath)
                iv.setImageBitmap(bm)
                ll.addView(iv)
            }
            if(inst.description != null) {
                val tvDesc = TextView(this)
                tvDesc.setTextColor(Color.WHITE)
                val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT)
                tvDesc.layoutParams = params
                tvDesc.text = inst.description

                ll.addView(tvDesc)
            }
            ll_imageInst.addView(ll)
        }
    }

    private fun setTitle() {
        val taskIndex = intent.getIntExtra(TITLE_POSITION, POSITION_NOT_SET)
        val sectionTasks = getSectionTasks()
        val taskTitle = sectionTasks[taskIndex]
        this.title = taskTitle
    }

    private fun getSectionTasks(): Array<String> {
        val section = intent.getStringExtra(WHICH_SECTION)
        val sectionTasks = if (section.equals(JUBO_SECTION))
            DataManager.juboTasks
        else if (section.equals(YEBE_SECTION))
            DataManager.serviceTasks
        else
            arrayOf()
        return sectionTasks
    }

    private fun getBitmapFromAssets(fileName: String): Bitmap? {
        return try {
            BitmapFactory.decodeStream(assets.open(fileName))
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}
