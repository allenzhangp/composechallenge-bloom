package com.example.androiddevchallenge

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Home(navController: NavHostController) {
    var searchValue by remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(bottom = 56.dp)
                .fillMaxSize()
        ) {
            OutlinedTextField(
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        modifier = Modifier.requiredHeight(18.dp),
                        contentDescription = null
                    )
                },
                value = searchValue,
                onValueChange = { searchValue = it },
                placeholder = {
                    Text(
                        "Search",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onPrimary
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .requiredHeight(48.dp)
                    .offset(y = 40.dp)
            )
            Text(
                text = "Browse Theme",
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier.paddingFromBaseline(32.dp),
            )
            LazyRow(modifier = Modifier.padding(top = 16.dp)) {
                items(dataSource1) { itemData ->
                    BrowseItem(id = itemData.resourceId, title = itemData.title)
                }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    "Design your home garden",
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier.fillMaxWidth()
                )
                Icon(
                    imageVector = Icons.Filled.FilterList,
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .weight(1f)
                )
            }
            LazyRow() {

            }
        }
        BottomNavigation(modifier = Modifier.requiredHeight(56.dp)) {
            BottomNavigationItem(
                selected = true,
                onClick = { /*TODO*/ },
                icon = { Icons.Filled.Home },
                label = { Text(text = "Home") })
            BottomNavigationItem(
                selected = true,
                onClick = { /*TODO*/ },
                icon = { Icons.Filled.FavoriteBorder },
                label = { Text(text = "Favorite") })
            BottomNavigationItem(
                selected = true,
                onClick = { /*TODO*/ },
                icon = { Icons.Filled.AccountCircle },
                label = { Text(text = "Profile") })
            BottomNavigationItem(
                selected = true,
                onClick = { /*TODO*/ },
                icon = { Icons.Filled.ShoppingCart },
                label = { Text(text = "Cart") })
        }
    }
}

@Composable
fun BrowseItem(@DrawableRes id: Int, title: String) {
    Surface(shape = MaterialTheme.shapes.small) {
        Column(modifier = Modifier.size(136.dp)) {
            Image(painter = painterResource(id = id), contentDescription = title)
            Text(
                text = title,
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun GardenItem(itemData: ItemData, isDone: Boolean) {
    Row {
        Image(
            painter = painterResource(id = itemData.resourceId),
            contentDescription = itemData.title
        )
        Column {
            Row {
                Column() {

                    Text(
                        itemData.title,
                        style = MaterialTheme.typography.h2,
                        color = MaterialTheme.colors.onPrimary
                    )
                    itemData.subTitle?.run {
                        Text(
                            this,
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.onPrimary
                        )
                    }

                }
                if (isDone) {

                }
            }
            Divider()
        }
    }
}

val dataSource1 = listOf(
    ItemData(R.drawable.img1, "Desert chic"),
    ItemData(R.drawable.img2, "Tiny terrarium"),
    ItemData(R.drawable.img3, "Jungle"),
    ItemData(R.drawable.img4, "Desert chic"),
    ItemData(R.drawable.img5, "Desert chic"),
)
val dataSource2 = listOf(
    ItemData(R.drawable.img6, "Desert chic", subTitle = "This is description"),
    ItemData(R.drawable.img7, "Tiny terrarium", subTitle = "This is description"),
    ItemData(R.drawable.img8, "Jungle", subTitle = "This is description"),
    ItemData(R.drawable.img9, "Desert chic", subTitle = "This is description"),
    ItemData(R.drawable.img10, "Desert chic", subTitle = "This is description"),
    ItemData(R.drawable.img11, "Desert chic", subTitle = "This is description"),
)