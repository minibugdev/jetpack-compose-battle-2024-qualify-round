package com.github.thailandandroiddeveloper.cbth2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.thailandandroiddeveloper.common.ui.screen.qualify1.Qualify1Screen
import com.github.thailandandroiddeveloper.common.ui.screen.qualify2.Qualify2Screen
import com.github.thailandandroiddeveloper.common.ui.screen.qualify3.Qualify3Screen
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Main()
                }
            }
        }
    }
}

@Composable
fun Main() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                NavigationButton("qualify1", navController)
                NavigationButton("qualify2", navController)
                NavigationButton("qualify3", navController)
            }
        }
        composable("qualify1") { Qualify1Screen() }
        composable("qualify2") { Qualify2Screen() }
        composable("qualify3") { Qualify3Screen() }
    }
}

@Composable
fun NavigationButton(route: String, navController: NavController) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = { navController.navigate(route) },
    ) { Text(text = route) }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() = AppTheme {
    Main()
}