package com.example.event_master

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.event_master.ui.components.Navigation
import com.example.event_master.ui.theme.Event_MasterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {//asdasd
            Event_MasterTheme {
                Navigation()
            }
        }
    }
}