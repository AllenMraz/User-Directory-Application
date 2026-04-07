@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.user_direcory_application.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.user_direcory_application.R
import com.example.user_direcory_application.ui.screen.HomeScreen
import com.example.user_direcory_application.ui.screen.UserViewModel

// the composable that combines the main content and the top bar
@Composable
fun UserDirectoryApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {DirectoryTopAppBar(scrollBehavior = scrollBehavior)}
    ) {
        Surface(
            modifier = Modifier.fillMaxSize().padding(8.dp)
        ) {
            val userViewModel: UserViewModel = viewModel()
            HomeScreen(
                userUiState = userViewModel.userUiState,
                contentPadding = it
            )
        }
    }

}
// adds a top bar
@Composable
fun DirectoryTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineSmall,
            )
        },
        modifier = modifier.padding(4.dp)
    )
}