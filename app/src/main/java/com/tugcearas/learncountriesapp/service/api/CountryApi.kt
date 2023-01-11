package com.tugcearas.learncountriesapp.service.api

import com.tugcearas.learncountriesapp.constants.Constants
import com.tugcearas.learncountriesapp.data.model.CountryModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface CountryApi {

    @GET(Constants.GET_COUNTRY_URL)
    fun getCountries() : Single<List<CountryModel>>
}