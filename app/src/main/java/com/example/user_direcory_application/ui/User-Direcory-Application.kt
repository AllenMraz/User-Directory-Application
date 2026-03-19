@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.user_direcory_application.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun UserDirectoryApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

    }

}