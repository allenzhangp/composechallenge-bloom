package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.cardElevation

@Composable
fun Welcome(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.colors.primary)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = painterResource(R.drawable.ic_welcome_bg),
            contentDescription = "Welcome background"
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        ) {
            Image(
                modifier = Modifier
                    .padding(top = 72.dp)
                    .offset(x = 88.dp),
                painter = painterResource(R.drawable.ic_welcome_illos),
                contentDescription = "welcome illos",
                contentScale = ContentScale.Crop,
            )
            Image(
                modifier = Modifier
                    .padding(top = 48.dp)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(R.drawable.ic_logo),
                contentDescription = "welcome logo",
                contentScale = ContentScale.Crop
            )
            Text(
                style = MaterialTheme.typography.subtitle1,
                text = "Beautiful home garden solutions",
                modifier = Modifier
                    .paddingFromBaseline(top = 32.dp)
                    .align(Alignment.CenterHorizontally), color = MaterialTheme.colors.onPrimary
            )
            Button(
                onClick = { },
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 40.dp)
                    .requiredHeight(48.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
            ) {
                Text(
                    text = "Create account",
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.onSecondary
                )
            }
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .requiredHeight(48.dp),
                border = null, onClick = { navController.navigate("login") },
                shape = MaterialTheme.shapes.medium,
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp
                ),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
            ) {
                Text(
                    text = "Log in",
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.primaryVariant
                )
            }

        }
    }
}

@Preview
@Composable
fun WelcomePreview() {
    MyTheme {
        Welcome(navController = rememberNavController())
    }
}

@Preview
@Composable
fun WelcomeDarkPreview() {
    MyTheme(true) {
        Welcome(navController = rememberNavController())
    }
}
