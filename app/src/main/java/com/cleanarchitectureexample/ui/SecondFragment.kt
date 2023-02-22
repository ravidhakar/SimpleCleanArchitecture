package com.cleanarchitectureexample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.cleanarchitectureexample.data.repository.UserRepositoryImpl
import com.cleanarchitectureexample.data.source.remote.RemoteDataSourceImpl
import com.cleanarchitectureexample.databinding.FragmentSecondBinding
import com.cleanarchitectureexample.domain.Interactors.UserInteractor
import com.cleanarchitectureexample.domain.model.User
import com.cleanarchitectureexample.ui.vm.SecondViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel: SecondViewModel by viewModels {
        SecondViewModel.SecondModelFactory(
            UserInteractor(
                UserRepositoryImpl(RemoteDataSourceImpl())
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
           viewModel.getUser()
        }
        viewModel.user.observe(viewLifecycleOwner, Observer {
            showInfo(it)
        })
    }

    private fun showInfo(user: User) {
        _binding?.textviewSecond?.text="Name:${user.name}\nMobile:${user.mobile}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}