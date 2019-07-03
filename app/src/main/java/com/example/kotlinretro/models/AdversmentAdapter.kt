package com.example.kotlinretro.models

import android.annotation.SuppressLint
import android.content.Context
import android.preference.PreferenceManager
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinretro.R
import com.example.kotlinretro.activity.LoaderActivity
import com.example.kotlinretro.fragments.AdversFragment
import com.example.kotlinretro.storage.SharedPrefManager
import kotlinx.android.synthetic.main.layout_ads.view.*
import java.security.AccessController.getContext

class AdversmentAdapter(val adversments: List<Adversment>) :
    RecyclerView.Adapter<AdversmentAdapter.AdversmentViewHolder>() {
    private val SHARED_PREF_NAME = "my_shared_preff"



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            AdversmentViewHolder {


        return AdversmentViewHolder(

            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_ads, parent, false)

        )



    }

    override fun getItemCount() = adversments.size



    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AdversmentViewHolder, position: Int) {


        val adversment = adversments[position]

        holder.view.textViewTitle.text = adversment.name
        holder.view.textViewVotesCount.setText(adversment.days + " days")
        holder.view.textViewLanguage.text = adversment.phont

        Glide.with(holder.view.context)
            .load(adversment.img)
            .into(holder.view.imageView)





    holder.view.setOnClickListener {


        Toast.makeText(
                holder.view.context,
        adversments[position].id.toString() + '\n' + adversments[position].img + '\n' + adversments[position].name + '\n' + adversments[position].days + '\n' + adversments[position].phont,
        Toast.LENGTH_LONG
        ).show()



        SharedPrefManager.getInstance(holder.view.context).saveStatus(adversments[position])


        Navigation.findNavController(it).navigate(R.id.action_adversFragment_to_restAdver_Fragment2)




    }

    }

open class AdversmentViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}




