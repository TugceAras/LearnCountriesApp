package com.tugcearas.learncountriesapp.data.repo

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.tugcearas.learncountriesapp.data.model.CountryModel
import com.tugcearas.learncountriesapp.data.room.CountryDb
import com.tugcearas.learncountriesapp.service.retrofit.CountryApiService
import com.tugcearas.learncountriesapp.util.CustomSharedPreferences
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch

class HomeRepo: BaseRepo() {

    private val apiService = CountryApiService()
    private val disposable = CompositeDisposable()
    private var customPreferences: CustomSharedPreferences ?=null
    val countries = MutableLiveData<List<CountryModel>>()
    val errorMessage = MutableLiveData<Boolean>()
    val countryProgressBar = MutableLiveData<Boolean>()

    fun getData(context: Context){
        countryProgressBar.value = true
        disposable.add(
            apiService.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<CountryModel>>() {
                    override fun onSuccess(t: List<CountryModel>) {
                        saveDataInDb(context,t)
                        disposable.clear()
                    }
                    override fun onError(e: Throwable) {
                        countryProgressBar.value = false
                        errorMessage.value = true
                        e.printStackTrace()
                        disposable.clear()
                    }
                })
        )
    }

    private fun showCountries(list: List<CountryModel>){
        countries.value = list
        errorMessage.value = false
        countryProgressBar.value = false
    }

    fun saveDataInDb(context: Context, countryList: List<CountryModel>){
        launch {
            val getDao = CountryDb(context).countryDao()
            getDao.deleteCountries()
            val countryListLong = getDao.insertAllCountries(*countryList.toTypedArray())
            var i=0
            while (i<countryList.size){
                countryList[i].id = countryListLong[i].toInt()
                i+=1
            }
            showCountries(countryList)
        }
        customPreferences = CustomSharedPreferences(context)
        customPreferences?.saveTime(System.nanoTime())
    }

    fun getDataFromDb(context: Context){
        countryProgressBar.value = true
        launch {
            val getCountries = CountryDb(context).countryDao().getAllCountries()
            showCountries(getCountries)
        }
    }

    fun cancelJob(){
        clearJob()
    }

    fun getTime(): Long? {
        return customPreferences?.getTime()
    }
}