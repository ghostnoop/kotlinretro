package com.example.kotlinretro.storage

import android.content.Context
import android.widget.Toast
import com.example.kotlinretro.models.Adversment
import com.example.kotlinretro.models.User


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class SharedPrefManager private constructor(private val mCtx: Context) {

    val isLoggedIn: Boolean
        get() {
            val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return sharedPreferences.getInt("id", -1) != -1
        }
    val isnot:Adversment
        get(){
            val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
//            val  sharedPreferences.getInt("idveb",-1)



            return adversment
        }






    val user: User
        get() {
            val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return User(
                sharedPreferences.getInt("id", -1),
                sharedPreferences.getString("email", ""),
                sharedPreferences.getString("name", "")
            )
        }

    val adversment: Adversment
        get() {
            val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return Adversment(
                sharedPreferences.getInt("idveb", -1),
                sharedPreferences.getString("imgveb", ""),
                sharedPreferences.getString("nameveb", ""),
                sharedPreferences.getString("daysveb", ""),
                sharedPreferences.getString("phonveb", "")



            )
        }


    fun saveUser(user: User) {

        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.putInt("id", user.id)
        editor.putString("email", user.email)
        editor.putString("name", user.name)

//        editor.putString("school", user.school)

        editor.apply()

    }

    fun saveStatus(adversment: Adversment){

        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editer = sharedPreferences.edit()

        editer.putInt("idveb", adversment.id)
        editer.putString("imgveb", adversment.img)
        editer.putString("nameveb", adversment.name)
        editer.putString("daysveb", adversment.days)
        editer.putString("phonveb", adversment.phont)

        editer.apply()
    }



    fun clear() {
        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    companion object {
        val SHARED_PREF_NAME = "my_shared_preff"
        private val SHARED_PREF_ADVER = "my_shared_adver"

        private var mInstance: SharedPrefManager? = null
        @Synchronized
        fun getInstance(mCtx: Context): SharedPrefManager {
            if (mInstance == null) {
                mInstance = SharedPrefManager(mCtx)
            }
            return mInstance as SharedPrefManager
        }
    }

}