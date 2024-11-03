package com.rakeshp.newsapp


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rakeshp.newsapp.domain.usecases.app_entry.AppEntryUseCases
import com.rakeshp.newsapp.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn

@HiltViewModel
class MainViewModel @Inject constructor(private val appEntryUseCases: AppEntryUseCases):ViewModel() {


   var splashCondition by mutableStateOf(true)
       private set

  var startDestination by mutableStateOf(Route.AppstartNavigation.route)
    private set

    init {
        appEntryUseCases.readAppEntry().onEach {shouldstartformhomescreen->
            if(shouldstartformhomescreen){
                startDestination=Route.NewsNavigation.route
            }else {
                startDestination = Route.AppstartNavigation.route
            }
            delay(300)
            splashCondition=false
        }.launchIn(viewModelScope)
    }
}