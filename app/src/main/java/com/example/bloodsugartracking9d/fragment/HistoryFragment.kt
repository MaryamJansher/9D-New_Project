package com.example.bloodsugartracking9d.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bloodsugartracking9d.R
import com.example.bloodsugartracking9d.adapters.History_Adapter
import com.example.bloodsugartracking9d.adapters.Measurements_recycler_Adapter
import com.example.bloodsugartracking9d.databinding.FragmentHistoryBinding

import com.example.bloodsugartracking9d.koincomponents.ViewmodelKoin
import com.example.bloodsugartracking9d.room.UserDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryFragment : Fragment() {


    private val mViewModel: ViewmodelKoin by viewModel()
    lateinit var historyBinding: FragmentHistoryBinding
    lateinit var history_adapter: History_Adapter
    lateinit var get_all_data_list: ArrayList<UserDetail>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        historyBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_history, container, false)


        mViewModel.getalldata().observe(viewLifecycleOwner, {

            get_all_data_list = it as ArrayList<UserDetail>
            history_adapter = History_Adapter(get_all_data_list)
            historyBinding.historyRecyclerView.setLayoutManager(LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false))
            historyBinding.historyRecyclerView.adapter = history_adapter


        })



        return historyBinding.root


    }

    fun get_all_data() {



    }


}

