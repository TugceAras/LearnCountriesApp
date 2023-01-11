package com.tugcearas.learncountriesapp.data.repo

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.tugcearas.learncountriesapp.data.model.CountryModel
import com.tugcearas.learncountriesapp.data.room.CountryDao
import com.tugcearas.learncountriesapp.data.room.CountryDb
import kotlinx.coroutines.launch

class DetailRepo:BaseRepo() {
    val countryDetailData = MutableLiveData<CountryModel>()

    fun getDatafromRoom(context: Context, id:Int){
        launch {
            val dao = CountryDb(context).countryDao()
            val getCountry = dao.getCountry(id)
            countryDetailData.value = getCountry
        }
    }
}