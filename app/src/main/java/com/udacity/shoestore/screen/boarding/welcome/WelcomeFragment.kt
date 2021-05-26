package com.udacity.shoestore.screen.boarding.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    private lateinit var welcomeViewModel: WelcomeViewModel

    private lateinit var binding: FragmentWelcomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)

        welcomeViewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)
        binding.welcomeViewModel = welcomeViewModel
        binding.lifecycleOwner = this

        subscribeObservable()

        return binding.root

    }

    private fun subscribeObservable() {
        welcomeViewModel.eventClicked.observe(viewLifecycleOwner, { eventClicked ->
            if (eventClicked) {
                welcomeViewModel.onEventCompleted()
                navigateToInstruction()
            }
        })

    }

    private fun navigateToInstruction() {
        this.findNavController()
            .navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment())
    }

}