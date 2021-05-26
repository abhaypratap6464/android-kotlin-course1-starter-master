package com.udacity.shoestore.screen.details.shoelist

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe


class ShoeListFragment : Fragment() {
    companion object {
        private var shoeList = ArrayList<Shoe>()
    }

    lateinit var shoeListViewModel: ShoeListViewModel

    lateinit var binding: FragmentShoeListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        shoeListViewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        binding.shoeListViewModel = shoeListViewModel
        binding.lifecycleOwner = this

        subscribeObservable()
        getIntentData()
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun getIntentData() {
        val args: ShoeListFragmentArgs by navArgs()
        if (args.shoeData != null) {
            shoeList.add(args.shoeData!!)
        }
        createShoes(shoeList)
    }

    private fun subscribeObservable() {
        shoeListViewModel.eventClicked.observe(viewLifecycleOwner, { eventClicked ->
            if (eventClicked) {
                this.findNavController()
                    .navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
                shoeListViewModel.onEventCompleted()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun createShoes(shoes: ArrayList<Shoe>) {
        context?.let { context ->
            val shoeContainer = binding.layoutShoeList
            shoes.forEach { shoe ->
                val shoeLayout = ShoeLayout(context)
                shoeLayout.loadShoe(shoe)
                shoeContainer.addView(shoeLayout)
            }
        }
    }

}