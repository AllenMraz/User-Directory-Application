package com.example.user_direcory_application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.user_direcory_application.ui.UserDirectoryApp
import com.example.user_direcory_application.ui.theme.UserDirecoryApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            UserDirecoryApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize()){
                    UserDirectoryApp()
                }
            }
        }
    }
}

