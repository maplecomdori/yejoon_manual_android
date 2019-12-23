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
            DataManager.juboTasks)

        juboTaskList.setOnItemClickListener { _, _, position, _ ->
            val task = DataManager.juboTasks.get(position)
            var intent = Intent()
            intent.putExtra(WHICH_SECTION, JUBO_SECTION)
            intent.putExtra(TITLE_POSITION, position)

            if (DataManager.keyValueTasks.contains(task)) {
                intent.setClass(this, KeyValueActivity::class.java)
            }
            else if (DataManager.imageTasks.contains(task)) {
                intent.setClass(this, ImageInstructionActivity::class.java)
            }

            startActivity(intent)
        }

        yebeTaskList.adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            DataManager.serviceTasks)

//        yebeTaskList.setOnItemClickListener { parent, view, position, id ->
        yebeTaskList.setOnItemClickListener { _, _, _, _ ->

        }
    }



}
