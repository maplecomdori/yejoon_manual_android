package com.example.yejoonmanual

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ImageInstructionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_inscturction)
        setTitle()
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

//    private fun getTaskDataMap(): Map<String, Map<String, String>>? {
//        return DataManager.keyValueTaskDataMap[this.title]
//    }

}
