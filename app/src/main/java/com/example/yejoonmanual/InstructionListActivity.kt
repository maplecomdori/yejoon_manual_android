package com.example.yejoonmanual

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity

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
            val activityIntent = Intent(this, ShortcutActivity::class.java)
//            activityIntent.putExtra(EXTRA_NOTE_POSITION, position)
            startActivity(activityIntent)

        }

        yebeTaskList.adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            DataManager.sectionTaskMap.getValue("예배"))

    }

}
