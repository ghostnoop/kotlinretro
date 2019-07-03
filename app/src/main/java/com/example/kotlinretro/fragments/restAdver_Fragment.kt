package com.example.kotlinretro.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide

import com.example.kotlinretro.R
import com.example.kotlinretro.api.RetrofitClient
import com.example.kotlinretro.models.Adversment
import com.example.kotlinretro.models.DefaultResponse
import com.example.kotlinretro.storage.SharedPrefManager
import kotlinx.android.synthetic.main.rest_adver__fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class restAdver_Fragment : Fragment() {


    companion object {
        fun newInstance() = restAdver_Fragment()
    }

    private lateinit var viewModel: RestAdverViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {


        return inflater.inflate(R.layout.rest_adver__fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RestAdverViewModel::class.java)

        var myNon = activity!!


        val bb: Adversment
        bb = SharedPrefManager.getInstance(myNon).isnot




        idtextv.text = bb.id.toString()



        img.setText(bb.img)
        name.setText(bb.name)
        days.setText(bb.days)
        phont.setText(bb.phont)
        Glide.with(myNon)
            .load(bb.img)
            .into(imageView2)








        commitbtn.setOnClickListener {
            val idt = idtextv.text.toString()
            val img = img.text.toString().trim()
            val name = name.text.toString().trim()
            val days = days.text.toString().trim()
            val phont = phont.text.toString().trim()


            RetrofitClient.instance.updateAdver(idt.toInt(), img, name, days, phont)
                .enqueue(object : Callback<DefaultResponse> {
                    override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                        Toast.makeText(myNon, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<DefaultResponse>, response: Response<DefaultResponse>) {
                        Toast.makeText(myNon, response.body()?.message, Toast.LENGTH_LONG).show()

                    }
                })


        }


    }

}




