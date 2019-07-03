package com.example.kotlinretro.fragments

import android.graphics.Color
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.kotlinretro.R
import com.example.kotlinretro.api.RetrofitClient
import com.example.kotlinretro.models.Adversment
import com.example.kotlinretro.models.AdversmentAdapter
import kotlinx.android.synthetic.main.advers_fragment.*
import kotlinx.android.synthetic.main.layout_ads.*
import retrofit2.Call
import retrofit2.Response




class AdversFragment : Fragment() {

    companion object {
        fun newInstance() = AdversFragment()
    }

    private lateinit var viewModel: AdversViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.advers_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AdversViewModel::class.java)
        // TODO: Use the ViewModel




        refreshLayout.setOnRefreshListener {
            fetchAdvers()
        }

        fetchAdvers()







    }




    private fun fetchAdvers(){
        refreshLayout.isRefreshing= true
        RetrofitClient.instance.getAds()
            .enqueue(object : retrofit2.Callback<List<Adversment>> {
                override fun onFailure(call: Call<List<Adversment>>, t: Throwable) {
                    Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                    refreshLayout.isRefreshing= false

                }

                override fun onResponse(call: Call<List<Adversment>>, response: Response<List<Adversment>>) {
                    refreshLayout.isRefreshing= false
                    val adversment = response.body()
                    adversment?.let {
                        showadversment(it)
                    }

                }


            })
    }

    private fun showadversment(adversment: List<Adversment>){
        recyclerViewAdversment.layoutManager = LinearLayoutManager(activity)
        recyclerViewAdversment.adapter = AdversmentAdapter(adversment)




//        Toast.makeText(context,adversment.toString(),Toast.LENGTH_LONG).show()
//        Log.e("THIS",adversment.toString())
    }



}


