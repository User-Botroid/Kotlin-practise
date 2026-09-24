package com.example.loginmodule

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.loginmodule.detail.DetailScreen
import com.example.loginmodule.items.CatalogScreen
import com.example.loginmodule.login.LoginScreen
import com.example.loginmodule.signUp.SignUpScreen


sealed class Screen(val route:String){
    object Login: Screen("login")
    object SignUp: Screen("signup")
    object Catalog: Screen("catalog")
    object Detail : Screen("detail/{itemId}") {
        fun createRoute(itemId: Int) = "detail/$itemId"
    }
}

@Composable
fun AppNavigate(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Login.route){

        composable(Screen.Login.route){
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.Catalog.route){
                        popUpTo(Screen.Login.route){inclusive = true}
                    }
                },
                onNavigateToSignUp = {
                    navController.navigate(Screen.SignUp.route)
                }
            )


        }

        composable(Screen.SignUp.route){
            SignUpScreen(
                onSignUpSuccess = {
                    navController.navigate(Screen.Catalog.route){
                        popUpTo(Screen.SignUp.route){inclusive = true}
                    }

                },
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.Catalog.route) {
            CatalogScreen (
                onItemClick = {item ->
                    navController.navigate(Screen.Detail.createRoute(item.id))

                }
            )
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("itemId"){type = NavType.IntType})
            ){backStackEntry ->
                val itemId = backStackEntry.arguments?.getInt("itemId") ?:0
                DetailScreen(
                    itemId = itemId,
                    onBackClick = {navController.popBackStack()}
                )

            }



    }

}