package com.example.jetpackseries.recyclerViewAndCard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackseries.R
import com.example.jetpackseries.User
import com.example.jetpackseries.dummyData
import com.example.jetpackseries.loginScreen.ui.theme.JetpackSeriesTheme
import androidx.navigation.compose.rememberNavController

class RecyclerView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackSeriesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    HomeNavGraph(navController)
                }
            }
        }
    }
}

@Composable
fun EachRow(user: User, navController: NavController) {

    val selected by remember { mutableStateOf(false) }

    Card(
        shape = CardDefaults.elevatedShape,
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(HomeGraph.Another.route)
            },
        colors = CardDefaults.cardColors(
            containerColor =
            if (selected) MaterialTheme.colorScheme.primaryContainer
            else MaterialTheme.colorScheme.surfaceVariant
        )
    ) {

        Row(
            modifier = Modifier
                .padding(5.dp)
//                .background(MaterialTheme.colorScheme.primaryContainer)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "image",
                modifier = Modifier
                    .padding(8.dp)
                    .size(80.dp)
                    .align(Alignment.CenterVertically)
                    .clip(
                        RoundedCornerShape(CornerSize(10.dp))
                    )
            )
            Text(
                text = user.data,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
            )
        }
    }
}


@Composable
fun MyRecycleView(users: List<User>, navController: NavHostController) {

    LazyColumn(
        modifier = Modifier.background(MaterialTheme.colorScheme.primary)
    ) {
        items(users) { user ->
            EachRow(user, navController)
        }
    }
}

@Composable
fun AnotherComposable(navController: NavController) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "another composable function",
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.titleLarge
        )
    }

}

@Composable
fun HomeNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = HomeGraph.Main.route) {

        composable(HomeGraph.Main.route) {
            MyRecycleView(users = dummyData(), navController)
        }
        composable(HomeGraph.Another.route) {
            AnotherComposable(navController)
        }
    }
}

sealed class HomeGraph(val route: String) {

    object Main : HomeGraph("main_screen")
    object Another : HomeGraph("another_screen")
}