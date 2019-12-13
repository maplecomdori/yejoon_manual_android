package com.example.yejoonmanual

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_shortcut.*
import java.lang.reflect.Array

class KeyValueActivity : AppCompatActivity() {

    var d = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shortcut)
        setSupportActionBar(toolbar)

        var tasks = chooseData()
        val title = tasks.get(intent.getIntExtra(TITLE_POSITION, POSITION_NOT_SET))
        this.title = title

    }

    private fun chooseData(): kotlin.Array<String> {
        val section = intent.getStringExtra(WHICH_SECTION)
        val d = if (section.equals(JUBO_SECTION))
            DataManager.juboTasks
        else if (section.equals(YEBE_SECTION))
            DataManager.serviceTasks
        else
            arrayOf()
        return d
    }
}
