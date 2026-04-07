package com.example.user_direcory_application.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.user_direcory_application.R
import com.example.user_direcory_application.model.User
import com.example.user_direcory_application.model.UserResponse

@Composable
fun HomeScreen(
    userUiState: UserUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    when (userUiState){
        is UserUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is UserUiState.Success -> ResultScreen(
            userUiState.Users, modifier = modifier.fillMaxSize()
        )
        is UserUiState.Error -> ErrorScreen( modifier = modifier.fillMaxSize())
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.ic_launcher_background),
        contentDescription = stringResource(R.string.loading)
    )
}


@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.outline_error_24), contentDescription = ""
        )
        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun ResultScreen(users: UserResponse, modifier: Modifier = Modifier)
{
    val userList: List<User> = users.users
    LazyColumn(
        modifier = modifier
    )
    {
        items(userList){

            user -> UserCard(user)
        }
    }
}

@Composable
fun UserCard(user: User, modifier: Modifier = Modifier){
    Card() {
        Row() {
            AsyncImage(
                ImageRequest.Builder(LocalContext.current).data(user.image)
                    .crossfade(true).build(),
                placeholder = painterResource(R.drawable.ic_launcher_background),
                contentDescription = user.id.toString(),
                contentScale = ContentScale.Crop
            )

            UserInfo(user.firstName, user.lastName, user.email)

        }


    }
}

@Composable
fun UserInfo(firstName: String, lastName: String, email: String){
    Column() {
        Text("$firstName $lastName")

        Text(email)
    }
}

@Preview
@Composable
fun LoadingScreenPreview(){
    LoadingScreen()
}

@Preview
@Composable
fun ErrorScreenPreview(){
    ErrorScreen()
}