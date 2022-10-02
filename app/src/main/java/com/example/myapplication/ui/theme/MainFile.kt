package com.example.myapplication


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.NavigationItem
import org.w3c.dom.Text

@Composable
fun Navigation(){
    val navController= rememberNavController()
    NavHost(navController =navController , startDestination = NavigationItem.Home.route ){
        composable(NavigationItem.Home.route){
            HomeScreen(navController)
        }
        composable(NavigationItem.Detail.route){
            val name = it.arguments?.getString("name")
            DetailScreen(name= name)
        }
    }
}
@Composable
fun HomeScreen(navController: NavHostController) {
    val dummyValue = remember{ mutableStateOf("") }
   Box(
       modifier = Modifier.fillMaxWidth() ,
       contentAlignment = Alignment.Center
   ) {
       Column(
           modifier=Modifier.fillMaxWidth(),
           horizontalAlignment =Alignment.CenterHorizontally
       ) {
           Text(text = "Write Something: ")
           TextField(value = dummyValue.value, onValueChange = {
               dummyValue.value = it
           })

           Button(onClick = { navController.navigate("detail/${dummyValue.value}") }) {
               Text(text = "Aage ka Rasta☕")

           }
       }
   }
}
@Composable
fun DetailScreen(name:String?){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = "Hello $name! You reached your destination \uD83D\uDEA9")
    }
}