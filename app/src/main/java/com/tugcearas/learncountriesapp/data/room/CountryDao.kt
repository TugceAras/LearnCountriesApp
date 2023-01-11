package com.tugcearas.learncountriesapp.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tugcearas.learncountriesapp.data.model.CountryModel

@Dao
interface CountryDao {

    @Insert
    suspend fun insertAllCountries(vararg countries: CountryModel) : List<Long>

    @Query("SELECT * FROM countryTable")
    suspend fun getAllCountries() : List<CountryModel>

    @Query("SELECT * FROM countryTable WHERE id = :countryId")
    suspend fun getCountry(countryId:Int) : CountryModel

    @Query("DELETE FROM countryTable")
    suspend fun deleteCountries()
}