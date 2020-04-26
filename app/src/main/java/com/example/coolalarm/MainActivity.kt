package com.example.coolalarm

import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var context : Context
    lateinit var alarmManager : AlarmManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this
        alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        submit_button.setOnClickListener {
            val second = editText.text.toString().toInt() * 1000
            val intent = Intent(context,Receiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            Log.d("MainActivity", "Create : " + Date().toString())
            alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+ second, pendingIntent)
        }
    }

    fun doText(view: View) {
        textView.setText(editText.getText())
    }

    class Receiver : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?){
            Log.d("MainActivity", "Receiver :" + Date().toString())
           // var notificationHelper : NotificationManager
        }
    }
}
