package com.tugcearas.learncountriesapp.data.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.tugcearas.learncountriesapp.data.repo.HomeRepo

class HomeVM: ViewModel(){

    val repo = HomeRepo()
    private var refreshTime = 10*60*1000*1000*1000L

    fun refreshData(context: Context){
        val updateTime: Long? = repo.getTime()
        if (updateTime != null && updateTime != 0L && (System.nanoTime() - updateTime) < refreshTime){
            repo.getDataFromDb(context)
        }else{
            repo.getData(context)
        }
    }
    override fun onCleared() {
        super.onCleared()
        repo.cancelJob()
    }
}