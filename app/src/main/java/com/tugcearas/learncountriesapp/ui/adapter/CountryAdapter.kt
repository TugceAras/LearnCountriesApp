package com.tugcearas.learncountriesapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.tugcearas.learncountriesapp.R
import com.tugcearas.learncountriesapp.data.model.CountryModel
import com.tugcearas.learncountriesapp.databinding.CountryItemBinding
import com.tugcearas.learncountriesapp.ui.fragment.HomeFragmentDirections

class CountryAdapter(
    private val countryList : ArrayList<CountryModel>): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(),
    CountryClickListener{

    class CountryViewHolder(var view:CountryItemBinding):RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = DataBindingUtil.inflate<CountryItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.country_item,
            parent,
            false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.view.country = countryList[position]
        holder.view.clickListener = this
    }

    override fun getItemCount(): Int = countryList.size

    @SuppressLint("NotifyDataSetChanged")
    fun refreshCountryList(newCountryList:List<CountryModel>){
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }

    override fun countryClick(getView: View) {
        val getId = getView.findViewById<TextView>(R.id.countryId_tv)
        val id = getId.text.toString().toInt()
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(id)
        getView.findNavController().navigate(action)
    }
}