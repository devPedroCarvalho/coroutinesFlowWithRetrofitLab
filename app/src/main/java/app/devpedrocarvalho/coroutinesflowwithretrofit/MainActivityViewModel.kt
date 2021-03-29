package app.devpedrocarvalho.coroutinesflowwithretrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import app.devpedrocarvalho.coroutinesflowwithretrofit.network.InsultRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {

    val insultLiveData = InsultRepository().getInsultRepository().asLiveData()


    private val _insultStateFlow = MutableStateFlow(UiState.Success(""))
    val insultStateFlow: StateFlow<UiState> = _insultStateFlow



    fun getInsult(){
        viewModelScope.launch {
            InsultRepository().getInsultRepository().collect { insultResponse ->
                _insultStateFlow.value = UiState.Success(insultResponse!!.insult)
            }
        }
    }
    
    sealed class UiState {
        data class Success(val insult: String): UiState()
        data class Error(val exception: Throwable): UiState()
    }

}