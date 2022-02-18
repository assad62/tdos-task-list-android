package com.mohammadassad.todostask.routes
import androidx.navigation.NavController
import com.mohammadassad.todostask.R

sealed class Screens(val route:String) {
      object LoginPageToSignInPage:Screens("LoginPageToSignInPage")
      object LoginPageToHomePage:Screens("LoginInPageToHomePage")
      object SignInPageToHomePage:Screens("SignInPageToHomePage")
      object HomePageToLoginPage:Screens("HomePageToLoginPage")
}

fun navRoutes(navController: NavController, route: String){

      when (route) {
           Screens.LoginPageToSignInPage.route-> navController.navigate(R.id.action_loginFragment_to_signupFragment)
           Screens.SignInPageToHomePage.route -> navController.navigate(R.id.action_signupFragment_to_homeFragment)
           Screens.LoginPageToHomePage.route ->navController.navigate(R.id.action_loginFragment_to_homeFragment)
           Screens.HomePageToLoginPage.route ->navController.navigate(R.id.action_homeFragment_to_loginFragment)
      }
}