package com.raproject.eventclicker.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.raproject.eventclicker.R
import com.raproject.eventclicker.tools.launch
import com.raproject.eventclicker.view_model.EventViewModel
import kotlinx.coroutines.flow.collect
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val vm: EventViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launch {
            vm.eventsList.collect {

            }
        }
    }
}
