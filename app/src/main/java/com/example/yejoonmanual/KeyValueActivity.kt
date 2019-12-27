package com.example.yejoonmanual

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_shortcut.*
import kotlinx.android.synthetic.main.content_shortcut.*


class KeyValueActivity : AppCompatActivity() {

    private var dataMap:Map<String, Map<String, String>> = mapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shortcut)
        setSupportActionBar(toolbar)

        setTitle()
        dataMap = getTaskDataMap() ?: mapOf()
        createUI()
    }


    private fun createUI() {

        for ((title, kvMap) in this.dataMap) {
            val ll = LinearLayout(this)
            val ll_layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)
            ll_layoutParams.setMargins(0, 0, 0, 50)
            ll.layoutParams = ll_layoutParams
            ll.orientation = LinearLayout.VERTICAL

            val tvTitle = TextView(this)
            tvTitle.textSize = 40f
            tvTitle.text = title
            val params =
                LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            params.setMargins(0, 0, 0, 20)
            tvTitle.setLayoutParams(params)
            ll.addView(tvTitle)

            for ((k, v) in kvMap) {
                val container = LinearLayout(this)
                val containerLayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT)
                containerLayoutParams.setMargins(0,0, 0, 10)
                container.layoutParams = containerLayoutParams
                container.orientation = LinearLayout.HORIZONTAL

                val tvKey = TextView(this)
                tvKey.textSize = 20f
                tvKey.text = k
                tvKey.textAlignment = TextView.TEXT_ALIGNMENT_VIEW_START
                tvKey.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 0.4f)

                val tvValue = TextView(this)
                tvValue.textSize = 20f
                tvValue.text = v
                tvValue.textAlignment = TextView.TEXT_ALIGNMENT_VIEW_END

                tvValue.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 0.6f)

                container.addView(tvKey)
                container.addView(tvValue)
                ll.addView((container))
            }

            ll_keyValue.addView(ll)
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

    private fun getTaskDataMap(): Map<String, Map<String, String>>? {
        return DataManager.keyValueTaskDataMap[this.title]
    }


}
