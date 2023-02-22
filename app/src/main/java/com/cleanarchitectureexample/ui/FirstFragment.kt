package com.cleanarchitectureexample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cleanarchitectureexample.R
import com.cleanarchitectureexample.data.repository.CountRepoImpl
import com.cleanarchitectureexample.data.source.local.LocalDataSourceImpl
import com.cleanarchitectureexample.databinding.FragmentFirstBinding
import com.cleanarchitectureexample.domain.Interactors.CountInteractor
import com.cleanarchitectureexample.ui.vm.SecondViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FirstViewModel by viewModels {
        FirstViewModel.FirstModelFactory(
            CountInteractor(
                CountRepoImpl(LocalDataSourceImpl())
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.count.observe(viewLifecycleOwner) {
           displayCount(it.count)
        }
        binding.buttonFirst.setOnClickListener {
            viewModel.updateCount((viewModel.count.value?.count ?: 0) + 1)
            viewModel.readCount()
        }
        binding.fab.setOnClickListener { view ->
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        viewModel.readCount()
    }

    private fun displayCount(count: Int){
        binding.textviewFirst.text = "${count}"
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}