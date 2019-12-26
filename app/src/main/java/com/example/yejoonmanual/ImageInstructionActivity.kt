package com.example.yejoonmanual

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.LinearLayout
import android.widget.TextView
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
            val tvTitle = TextView(this)

            tvTitle.text = "#" + (index + 1) + " " + inst.title
            ll_imageInst.addView(tvTitle)

            if(inst.picturePath != null) {
                val iv = ImageView(this)
                iv.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT)
                iv.adjustViewBounds = true
                val bm = getBitmapFromAssets(inst.picturePath)
                iv.setImageBitmap(bm)
                ll_imageInst.addView(iv)
            }
            if(inst.description != null) {
                val tvDesc = TextView(this)
                tvDesc.text = inst.description
                ll_imageInst.addView(tvDesc)
            }
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
