package com.abrsoftware.mymovies.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abrsoftware.movieapp.domain.dbmovie.Account
import com.abrsoftware.movieapp.ui.screen.LoginScreen
import com.abrsoftware.movieapp.ui.screen.ProfileScreen
import com.abrsoftware.movieapp.ui.viewmodel.DBMovieViewModel

@ExperimentalFoundationApi
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavItem.LoginNavItem.route,
    ) {
        composable(NavItem.LoginNavItem) {
            LoginScreen(onNavigate = {
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "account",
                    value = it
                )
                navController.navigate(NavItem.ProfileNavItem.route)
            })
        }
        composable(NavItem.ProfileNavItem) {
            var account = navController.previousBackStackEntry?.savedStateHandle?.get<Account>("account")
            if (account != null) {
                ProfileScreen(account)
            }
        }
    }
}

private fun NavGraphBuilder.composable(
    navItem: NavItem,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = navItem.route,
        arguments = navItem.args
    ) {
        content(it)
    }
}

private inline fun <reified T> NavBackStackEntry.findArg(key: String): T {
    val value = arguments?.get(key)
    requireNotNull(value)
    return value as T
}