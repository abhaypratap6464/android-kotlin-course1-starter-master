package com.udacity.shoestore.screen.details.shoedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment : Fragment() {

    lateinit var binding: FragmentShoeDetailBinding
    lateinit var shoeDetailViewModel: ShoeDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        shoeDetailViewModel = ViewModelProvider(this).get(ShoeDetailViewModel::class.java)
        binding.showDetailViewModel = shoeDetailViewModel
        binding.lifecycleOwner = this

        subscribeObservable()

        return binding.root
    }

    private fun subscribeObservable() {
        shoeDetailViewModel.eventClicked.observe(viewLifecycleOwner, {
            when (it.first) {
                "Save" -> {
                    this.findNavController()
                        .navigate(
                            ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment(
                                it.second as Shoe
                            )
                        )
                }
                "Cancel" -> {
                    this.findNavController()
                        .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
                }
            }
        })
    }


}