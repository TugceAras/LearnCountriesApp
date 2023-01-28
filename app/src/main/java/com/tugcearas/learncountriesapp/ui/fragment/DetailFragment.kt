package com.tugcearas.learncountriesapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.tugcearas.learncountriesapp.R
import com.tugcearas.learncountriesapp.data.viewmodel.DetailVM
import com.tugcearas.learncountriesapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private val detailViewModel: DetailVM by lazy { ViewModelProvider(this)[DetailVM::class.java] }
    private lateinit var binding: FragmentDetailBinding
    private var getCountryUuid = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            getCountryUuid = DetailFragmentArgs.fromBundle(it).countryUuid
        }
        detailViewModel.getData(view.context,getCountryUuid)
        observeDetailData()
    }

    private fun observeDetailData(){
        detailViewModel.detailRepo.countryDetailData.observe(viewLifecycleOwner, Observer { country ->
            country?.let {
                binding.detailCountry = country
            }
        })
    }
}