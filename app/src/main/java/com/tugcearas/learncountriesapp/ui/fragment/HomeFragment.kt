package com.tugcearas.learncountriesapp.ui.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tugcearas.learncountriesapp.R
import com.tugcearas.learncountriesapp.data.viewmodel.HomeVM
import com.tugcearas.learncountriesapp.databinding.FragmentHomeBinding
import com.tugcearas.learncountriesapp.ui.adapter.CountryAdapter

class HomeFragment : Fragment() {

    private val homeViewModel : HomeVM by lazy { ViewModelProvider(this)[HomeVM::class.java] }
    private lateinit var binding: FragmentHomeBinding
    private val countryAdapter = CountryAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.refreshData(view.context)
        binding.countryList.adapter = countryAdapter
        swipeRefreshLayout(view.context)
        observeData()
    }

    private fun swipeRefreshLayout(context: Context){
        binding.refreshLayout.setOnRefreshListener {
            binding.countryList.visibility = View.GONE
            binding.countryErrorText.visibility = View.GONE
            binding.homeProgressBar.visibility = View.VISIBLE
            homeViewModel.repo.getData(context)
            binding.refreshLayout.isRefreshing = false
        }
    }

    private fun observeData(){
        homeViewModel.repo.countries.observe(viewLifecycleOwner, Observer {countries ->
            countries?.let {
                binding.countryList.visibility = View.VISIBLE
                countryAdapter.refreshCountryList(countries)
            }
        })

        homeViewModel.repo.errorMessage.observe(viewLifecycleOwner, Observer {error ->
            error?.let {
                if (it){
                    binding.countryErrorText.visibility = View.VISIBLE
                }
                else{
                    binding.countryErrorText.visibility = View.GONE
                }
            }
        })

        homeViewModel.repo.countryProgressBar.observe(viewLifecycleOwner, Observer { progressBar ->
            progressBar?.let {
                if (it){
                    binding.homeProgressBar.visibility = View.VISIBLE
                    binding.countryList.visibility = View.GONE
                    binding.countryErrorText.visibility = View.GONE
                }
                else{
                    binding.homeProgressBar.visibility = View.GONE
                }
            }
        })
    }
}



