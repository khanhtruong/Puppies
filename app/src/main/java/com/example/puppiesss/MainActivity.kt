package com.example.puppiesss

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.puppiesss.composable.BuildPuppies
import com.example.puppiesss.composable.DetailPuppy
import com.example.puppiesss.composable.PuppiesTopBar
import com.example.puppiesss.model.Puppy
import com.example.puppiesss.util.Factory
import com.example.puppiesss.viewmodel.PuppyViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PuppyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, Factory(PuppyViewModel()))
            .get(PuppyViewModel::class.java)

        setContent {
            MainScreen(viewModel)
        }

        viewModel.fetchPuppies()
    }
}

@Composable
fun MainScreen(viewModel: PuppyViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            ListScreen(viewModel, navController)
        }
        composable("detail", arguments = listOf(navArgument("puppy") {
            type = NavType.ParcelableType(Puppy::class.java)
        })) {
            DetailScreen(navController)
        }
    }
}

@Composable
fun ListScreen(viewModel: PuppyViewModel, navController: NavController) {
    Scaffold(
        topBar = { PuppiesTopBar("Choose one") }
    ) {
        BuildPuppies(viewModel) {
            navController.currentBackStackEntry?.arguments?.putParcelable(
                "puppy",
                viewModel.getPuppy(it)
            )
            navController.navigate("detail")
        }
    }
}

@Composable
fun DetailScreen(navController: NavController) {
    val puppy = navController.previousBackStackEntry?.arguments?.getParcelable<Puppy>("puppy")

    Scaffold(
        topBar = { PuppiesTopBar("Your puppy") }
    ) {
        puppy?.let {
            DetailPuppy(it)
        }
    }
}
