package com.udacity.shoestore.screen.boarding.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding


/**
 *
 * User will login through email and password in this screen
 *
 */
class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.loginViewModel = loginViewModel
        binding.lifecycleOwner = this

        subscribeObservable()

        return binding.root
    }

    private fun subscribeObservable() {
        loginViewModel.eventClicked.observe(viewLifecycleOwner, { eventClicked ->
            if (eventClicked) {
                loginViewModel.onEventCompleted()
                navigateToWelcomeScreen()
            }
        })
    }


    //used for navigating login screen to welcome screen
    private fun navigateToWelcomeScreen() {
        this.findNavController()
            .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())

    }

}