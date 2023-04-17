package com.p1rat.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.p1rat.android.screen.signUp.SignUpScreen
import com.p1rat.android.screen.restaurants.RestaurantScreen
import com.p1rat.android.screen.restaurants.RestaurantViewModel
import com.p1rat.android.screen.restaurants.detail.DetailScreen
import com.p1rat.android.screen.signUp.SignUpScreenViewModel
import com.p1rat.android.ui.theme.MiptandroidTheme
import dagger.hilt.android.AndroidEntryPoint
import java.net.URLDecoder

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            MiptandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    NavHost(navController = navController, startDestination = "sign_up") {
                        composable("sign_up") {
                            val signUpViewModel = hiltViewModel<SignUpScreenViewModel>()
                            SignUpScreen(
                                signUpScreenViewModel = signUpViewModel,
                                navController = navController
                            )
                        }
                        composable("restaurants") {
                            val restaurantViewModel = hiltViewModel<RestaurantViewModel>()
                            RestaurantScreen(
                                restaurantViewModel = restaurantViewModel,
                                navController = navController
                            )
                        }
                        composable(
                            "detail/{name}/{image}/{deliveryTime}",
                            arguments = listOf(navArgument("name") {type = NavType.StringType},
                                navArgument("image") {type = NavType.StringType},
                                navArgument("deliveryTime") {type = NavType.StringType}
                            )
                        ) { backStackEntry ->
                            val name = backStackEntry.arguments?.getString("name")
                            val image = URLDecoder.decode(backStackEntry.arguments?.getString("image"), "UTF-8")
                            val deliveryTime = backStackEntry.arguments?.getString("deliveryTime")
                            DetailScreen(name.orEmpty(), image.orEmpty(), deliveryTime.orEmpty())
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MiptandroidTheme {
    }
}