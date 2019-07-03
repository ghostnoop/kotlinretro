package com.example.kotlinretro.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinretro.R
import com.example.kotlinretro.api.RetrofitClient
import com.example.kotlinretro.models.DefaultResponse
import kotlinx.android.synthetic.main.activity_ads.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ads)


        button.setOnClickListener {

            val img = imgedit.text.toString()
            val name = namedit.text.toString()
            val days = daysedit.text.toString() + " days"
            val phont = phonedit.text.toString()



            if (img.isEmpty()) {
                imgedit.error = "img required"
                imgedit.requestFocus()
                return@setOnClickListener
            }


            if (name.isEmpty()) {
                namedit.error = "name required"
                namedit.requestFocus()
                return@setOnClickListener
            }

            if (days.isEmpty()) {
                daysedit.error = "days required"
                daysedit.requestFocus()
                return@setOnClickListener
            }

            if (phont.isEmpty()) {
                phonedit.error = "phone required"
                phonedit.requestFocus()
                return@setOnClickListener
            }



            RetrofitClient.instance.createAds(img,name,days,phont)
                .enqueue(object: Callback<DefaultResponse> {
                    override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                        Toast.makeText(applicationContext, "плохо", Toast.LENGTH_LONG).show()

                    }

                    override fun onResponse(call: Call<DefaultResponse>, response: Response<DefaultResponse>) {
                        Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()
                        Toast.makeText(applicationContext, "норм", Toast.LENGTH_LONG).show()

                    }

                })



        }





    }
}
