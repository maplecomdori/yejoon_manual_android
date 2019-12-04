package com.example.yejoonmanual

import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_instruction_list.*
import kotlinx.android.synthetic.main.content_instruction_list.*

class InstructionListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instruction_list)
        setSupportActionBar(toolbar)

        taskList.adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            DataManager.sectionTaskMap.keys.toList())


    }

}
