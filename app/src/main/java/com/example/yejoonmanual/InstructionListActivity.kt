package com.example.yejoonmanual

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.yejoonmanual.DataManager.shortcutMap

import kotlinx.android.synthetic.main.activity_instruction_list.*
import kotlinx.android.synthetic.main.content_instruction_list.*

class InstructionListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instruction_list)
        setSupportActionBar(toolbar)

        juboTaskList.adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            DataManager.sectionTaskMap.getValue("주보"))


        juboTaskList.setOnItemClickListener { parent, view, position, id ->

            val task = DataManager.juboTasks.get(position)
            if (DataManager.keyValueTasks.contains(task)) {
                val activityIntent = Intent(this, KeyValueActivity::class.java)
                activityIntent.putExtra(WHICH_SECTION, JUBO_SECTION)
                activityIntent.putExtra(TITLE_POSITION, position)
                startActivity(activityIntent)
            }

        }

        yebeTaskList.adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            DataManager.sectionTaskMap.getValue("예배"))

        yebeTaskList.setOnItemClickListener { parent, view, position, id ->

        }
    }

}
