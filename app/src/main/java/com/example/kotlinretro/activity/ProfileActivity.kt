package com.example.kotlinretro.activity

import android.app.DownloadManager
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinretro.R
import com.example.kotlinretro.api.RetrofitClient
import com.example.kotlinretro.storage.SharedPrefManager
import com.google.gson.GsonBuilder
import com.google.gson.internal.GsonBuildConfig
import kotlinx.android.synthetic.main.activity_profile.*
import okhttp3.*
import java.io.IOException

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        btn.setOnClickListener {

            logout()

        }

        addbtn.setOnClickListener {
//            val relativeLayout = findViewById(R.id.rlid) as RelativeLayout
//            val button = Button(this)
//            button.layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
//                RelativeLayout.LayoutParams.WRAP_CONTENT)
//            button.text = "Click me"
//            button.setOnClickListener(View.OnClickListener {
//                button.text = "you just clicked"
//            })
//            button.setBackgroundColor(Color.GREEN)
//            button.setTextColor(Color.RED)
//            relativeLayout.addView(button)

            val url = "http://api.openweathermap.org/data/2.5/weather?q=Novinki,RU&APPID=692af1539a2faebd8369fbe3d00c4fb6"

            val request = Request.Builder().url(url).build()
            val client = OkHttpClient()
            client.newCall(request).enqueue(object: Callback{

            override fun onResponse(call: Call?, response: Response?) {
                    val body = response?.body()?.string()
                    println(body)

                    val gson = GsonBuilder().create()

                    val feed = gson.fromJson(body, details::class.java)

                runOnUiThread {
                    Toast.makeText(applicationContext,feed.main.temp.toString(),Toast.LENGTH_LONG).show()

                }

            }
                override fun onFailure(call: Call, e: IOException) {

                }
            })


        }

        adsbtn.setOnClickListener {
            val intent = Intent(applicationContext, AdsActivity::class.java)

            startActivity(intent);

//            finish();
        }
        lodbtn.setOnClickListener{
            val intent = Intent(applicationContext, LoaderActivity::class.java)
            startActivity(intent)

        }
    }


    fun logout() {


        SharedPrefManager.getInstance(this).clear()
        val intent = Intent(applicationContext, LoginActivity::class.java)

        startActivity(intent);

        finish();
    }


    override fun onStart() {
        super.onStart()

        if (!SharedPrefManager.getInstance(this).isLoggedIn) {
            val intent = Intent(applicationContext, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
    class details(val main: Main, val wind: Wind)
    class Main(val temp:Double)
    class Wind(val speed:Double, val deg:Double)

}
