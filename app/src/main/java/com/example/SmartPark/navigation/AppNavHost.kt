package com.example.SmartPark.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.SmartPark.ui.theme.screens.Dashboard.DashBoardScreen
import com.example.SmartPark.ui.theme.screens.Rsignup.RsignupScreen
import com.example.SmartPark.ui.theme.screens.Space.AddSpaceScreen
import com.example.SmartPark.ui.theme.screens.Space.ViewSpaceScreen
import com.example.SmartPark.ui.theme.screens.Upark.UparkScreen
import com.example.SmartPark.ui.theme.screens.about.AboutScreen
import com.example.SmartPark.ui.theme.screens.elgon.ElgonScreen
import com.example.SmartPark.ui.theme.screens.furaha.FurahaScreen
import com.example.SmartPark.ui.theme.screens.garden.GardenScreen
import com.example.SmartPark.ui.theme.screens.green.GreenScreen
import com.example.SmartPark.ui.theme.screens.login.LoginScreen
import com.example.SmartPark.ui.theme.screens.notification.notification

import com.example.SmartPark.ui.theme.screens.profile.ProfileScreen
import com.example.SmartPark.ui.theme.screens.quiver.QuiverScreen
import com.example.SmartPark.ui.theme.screens.rally.RallyScreen
import com.example.SmartPark.ui.theme.screens.renter.RenterScreen
import com.example.SmartPark.ui.theme.screens.salama.SalamaScreen
import com.example.SmartPark.ui.theme.screens.samara.samaraScreen
import com.example.SmartPark.ui.theme.screens.sarit.SaritScreen
import com.example.SmartPark.ui.theme.screens.signup.SignupScreen
import com.example.SmartPark.ui.theme.screens.splash.SplashScreen
import com.example.SmartPark.ui.theme.screens.starehe.StareheScreen
import com.example.SmartPark.ui.theme.screens.swari.SwariScreen
import com.example.SmartPark.ui.theme.screens.tsavo.TsavoScreen
import com.example.SmartPark.ui.theme.screens.uhuru.UhuruScreen
import com.example.SmartPark.ui.theme.screens.user.Userscreen
import com.example.SmartPark.ui.theme.screens.valley.valleyScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController:NavHostController = rememberNavController(),
    startDestination:String = SPLASH_URL
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier){
        composable(SPLASH_URL){
            SplashScreen(navController = navController)
        }
        composable(LOGIN_URL){
            LoginScreen(navController = navController)
        }
        composable(UHURU_URL){
            UhuruScreen(navController = navController)
        }
        composable(USER_URL){
            Userscreen(navController = navController)
        }
        composable(ROUT_ABOUT){
           AboutScreen(navController = navController)
        }
        composable(SIGNUP_URL){
            SignupScreen(navController = navController)
        }
        composable(RSIGNUP_URL){
            RsignupScreen(navController = navController)
        }
        composable(ROUT_NOTIFICATION){
            notification(navController = navController)
        }
        composable(RENTER_URL){
            RenterScreen(navController = navController)
        }

        composable(FURAHA_URL){
            FurahaScreen(navController = navController)
        }
        composable(STAREHE_URL){
            StareheScreen(navController = navController)
        }
        composable(SARIT_URL){
            SaritScreen( navController = navController)
        }
        composable(SAMARA_URL){
            samaraScreen(navController =  navController)
        }
        composable(SWARI_URL){
            SwariScreen(navController =  navController)
        }
        composable(SALAMA_URL){
            SalamaScreen( navController = navController)
        }
        composable(GREEN_URL){
            GreenScreen( navController = navController)
        }
        composable(GARDEN_URL){
            GardenScreen( navController = navController)
        }
        composable(TSAVO_URL){
            TsavoScreen( navController = navController)
        }
        composable(UPARK_URL){
            UparkScreen( navController = navController)
        }
        composable(QUIVER_URL){
            QuiverScreen( navController = navController)
        }
        composable(VALLEY_URL){
            valleyScreen( navController = navController)
        }
        composable(ELGON_URL){
           ElgonScreen( navController = navController)
        }
        composable(RALLY_URL){
            RallyScreen( navController = navController)
        }

        composable(PROFILE_URL){
            ProfileScreen(navController = navController)
        }
        composable(DASHBOARD_URL){
            DashBoardScreen(navController = navController)
        }
        composable(ADD_SPACES_URL){
            AddSpaceScreen(navController = navController)
        }
        composable(VIEW_SPACES_URL){
            ViewSpaceScreen(navController = navController)
        }
    }
}