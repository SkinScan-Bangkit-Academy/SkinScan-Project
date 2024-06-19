package com.bangkit.skinscan.view.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.bangkit.skinscan.R
import com.bangkit.skinscan.data.Disease
import com.bangkit.skinscan.data.Labels
import com.bangkit.skinscan.databinding.FragmentHomeBinding
import com.bangkit.skinscan.view.ViewModelFactory
import com.bangkit.skinscan.view.diseasehome.DiseaseHomeAdapter

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private var list: ArrayList<Disease> = arrayListOf()
    private val homeFragmentViewModel by viewModels<HomeFragmentViewModel> { ViewModelFactory.getInstance(requireContext()) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setView()
    }

    private fun setView(){
        list.addAll(Labels.listData)
        binding.rvHome.layoutManager = GridLayoutManager(requireContext(), 3)
        val adapter = DiseaseHomeAdapter(list)
        binding.rvHome.adapter = adapter
        binding.rvHome.setHasFixedSize(true)
        setName()
    }

    private fun setName(){
            homeFragmentViewModel.userSession.observe(viewLifecycleOwner){ user ->
                binding.displayName.text = getString(R.string.hi, user.name)
            }

    }

}