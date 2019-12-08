package com.example.yejoonmanual

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_shortcut.*

class KeyValueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shortcut)
        setSupportActionBar(toolbar)


        val title = DataManager.juboTasks.get(intent.getIntExtra(TITLE_POSITION, POSITION_NOT_SET))
        this.title = title

    }
}
