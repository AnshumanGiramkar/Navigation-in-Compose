package com.example.myapplication.ui.theme

sealed class NavigationItem(val route:String){
    object Home: NavigationItem("home")
    object Detail: NavigationItem("detail/{name}")
}
