package com.example.bloodsugartracking9d.activities

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.bloodsugartracking9d.R
import com.example.bloodsugartracking9d.databinding.ActivitySplashBinding

import kotlinx.coroutines.*


class SplashActivity : AppCompatActivity() {

    lateinit var activitySplashBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activitySplashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        GlobalScope.launch(Dispatchers.Main) {
            delay(5000)
            activitySplashBinding.btnStart.visibility = View.VISIBLE
        }


        /*   job = CoroutineScope(Dispatchers.Main).launch {

               withContext(Dispatchers.IO) {

                   CoroutineScope(Dispatchers.IO).launch {

                       job = GlobalScope.launch(Dispatchers.Default) {
                           delay(5000)
                       }

                       job!!.join()

                       withContext(Dispatchers.Main) {
                           activitySplashBinding.btnStart.visibility = View.VISIBLE
                       }
                   }

               }


           }
   */


        /*  if (isNetworkConnected()){
               /// show add
          }else{

              MainActivity.start(this )
          }
  */

        activitySplashBinding.btnStart.setOnClickListener {

            MainActivity.start(context = this)

        }


    }

    private fun isNetworkConnected(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
    }


}