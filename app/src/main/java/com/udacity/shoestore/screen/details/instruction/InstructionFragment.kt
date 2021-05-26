package com.udacity.shoestore.screen.details.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding


class InstructionFragment : Fragment() {


    private lateinit var binding: FragmentInstructionBinding

    private lateinit var instructionViewModel: InstructionViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instruction, container, false)

        instructionViewModel = ViewModelProvider(this).get(InstructionViewModel::class.java)

        binding.instructionViewModel = instructionViewModel

        binding.lifecycleOwner = this

        subscribeObservable()


        return binding.root
    }

    private fun subscribeObservable() {
        instructionViewModel.eventClicked.observe(viewLifecycleOwner, { eventClicked ->
            if (eventClicked) {
                instructionViewModel.onEventCompleted()
                navigateToShoeList()
            }
        })
    }

    private fun navigateToShoeList() {
        this.findNavController()
            .navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment())
    }


}