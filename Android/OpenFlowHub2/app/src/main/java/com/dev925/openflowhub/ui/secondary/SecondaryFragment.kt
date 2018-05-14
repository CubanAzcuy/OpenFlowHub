package com.dev925.openflowhub.ui.secondary

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev925.openflowhub.R

class SecondaryFragment : Fragment() {

    companion object {
        fun newInstance() = SecondaryFragment()
    }

    private lateinit var viewModel: SecondaryViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SecondaryViewModel::class.java)
        // TODO: Use the ViewModel
    }
}