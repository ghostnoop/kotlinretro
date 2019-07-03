package com.example.kotlinretro.activity

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinretro.R
import com.example.kotlinretro.models.Adversment
import com.example.kotlinretro.models.AdversmentAdapter
import kotlinx.android.synthetic.main.activity_loader.*
import retrofit2.Call
import retrofit2.Response
import com.example.kotlinretro.api.RetrofitClient as RetrofitClient
import android.view.View
import android.widget.RelativeLayout
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.layout_ads.*


class LoaderActivity : AppCompatActivity() {

    lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loader)

//        val host = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment ?: return
//        val navControler = host.navController
//
//        drawer = findViewById(R.id.frag)
//        NavigationUI.setupActionBarWithNavController(this,navControler, drawer)

    }

//    override fun onSupportNavigateUp(): Boolean {
//        return NavigationUI.navigateUp(drawer,Navigation.findNavController
//            (this, R.id.nav_host))
//    }
}
