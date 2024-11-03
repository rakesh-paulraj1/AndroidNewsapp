import android.annotation.SuppressLint
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.rakeshp.newsapp.presentation.navgraph.Route
import com.rakeshp.newsapp.presentation.onboarding.OnBoardingScreen
import com.rakeshp.newsapp.presentation.onboarding.OnBoardingViewModel

@SuppressLint("SuspiciousIndentation")
@Composable
fun NavGraph(startDestination:String){
 val navController= rememberNavController()

   NavHost(navController = navController, startDestination = startDestination) {
       navigation(
           route=Route.AppstartNavigation.route,
           startDestination=Route.Onboardingscreen.route
       ){
        composable(
            route=Route.Onboardingscreen.route
        ){
            val viewModel: OnBoardingViewModel = hiltViewModel()
            OnBoardingScreen(event = viewModel::onEvent)
        }
       }
       navigation(
           route=Route.NewsNavigation.route,
           startDestination=Route.NewsNavigatorScreen.route
       ){
           composable(
               route=Route.NewsNavigatorScreen.route
           ){
               Text(text = "The main screen content ")
           }
       }
   }
}