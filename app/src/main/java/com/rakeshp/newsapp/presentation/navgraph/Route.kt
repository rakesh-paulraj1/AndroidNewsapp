package com.rakeshp.newsapp.presentation.navgraph

 sealed class Route(val route :String) {
 object Onboardingscreen:Route("onboardingscreen")
  object HomeScreen:Route("homescreen")
object SearchScreen:Route("searchscreen")
  object BookMarkScreen:Route("bookmarkscreen")
  object DetailsScreen:Route("detailsscreen")

  object AppstartNavigation:Route("appstartnavigation")
  object NewsNavigation:Route("newsnavigation")
  object NewsNavigatorScreen:Route("newsnavigator")
}