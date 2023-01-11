package com.tugcearas.learncountriesapp.data.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.tugcearas.learncountriesapp.data.repo.DetailRepo

class DetailVM: ViewModel() {

    val detailRepo = DetailRepo()

    fun getData(context: Context, id:Int){
        detailRepo.getDatafromRoom(context,id)
    }
}