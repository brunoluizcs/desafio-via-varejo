package com.desafio.varejo.features.home.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.desafio.varejo.BuildConfig
import com.desafio.varejo.R
import com.desafio.varejo.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        setupView()
        return binding.root
    }

    private fun setupView(){
        binding.versionTextView.text = getString(R.string.app_version,BuildConfig.VERSION_NAME)
        binding.codeTextView.text = getString(R.string.app_code,BuildConfig.VERSION_CODE)
    }


}
