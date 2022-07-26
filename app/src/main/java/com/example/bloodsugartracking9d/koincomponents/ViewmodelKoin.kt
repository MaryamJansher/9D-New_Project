package com.example.bloodsugartracking9d.koincomponents

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bloodsugartracking9d.room.UserDetail

class ViewmodelKoin (val repositoryKoin: RepositoryKoin) : ViewModel() {


     fun getalldata() = repositoryKoin.getalldata()
    suspend fun insert(userDetail: UserDetail) = repositoryKoin.insert(userDetail)
    suspend fun delete(userDetail: UserDetail) = repositoryKoin.delete(userDetail)
    fun set_unit_selected(unit: String)  =  repositoryKoin.set_unit_selected(unit)
    var get_unit_selected = repositoryKoin.get_unit_selected


}