package com.example.myapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.compose.ItemContent
import com.example.myapplication.databinding.FragmentMainBinding
import com.google.accompanist.appcompattheme.AppCompatTheme

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        activity?.title = "This is RecyclerView layout"
        _binding = DataBindingUtil.bind(view)

        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                AppCompatTheme {
                    ItemContent()
                }
            }
        }
        return view
    }
}