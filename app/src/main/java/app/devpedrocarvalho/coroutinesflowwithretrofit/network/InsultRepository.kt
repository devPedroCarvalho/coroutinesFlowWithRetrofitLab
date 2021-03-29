package app.devpedrocarvalho.coroutinesflowwithretrofit.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class InsultRepository {

    fun getInsultRepository(): Flow<InsultResponse?> {
        return flow{
            val insultsApi = ApiService.service.getInsult()
            emit(insultsApi.body())
        }
    }

}