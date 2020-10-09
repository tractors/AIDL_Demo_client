package com.will.aidl_demo_client

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button
import com.will.aidl_demo.person.ILeoAidl
private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {


    private lateinit var btn:Button
    private  var leoAidl : ILeoAidl? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.btn);

        btn.setOnClickListener {
            bindService()
        }
    }

    private fun bindService(){
        val intent : Intent = Intent()

        intent.component = ComponentName("com.will.aidl_demo","com.will.aidl_demo.LeoAidlService")
        bindService(intent,connection,Context.BIND_AUTO_CREATE)
    }

    private val connection : ServiceConnection = object : ServiceConnection{
        override fun onServiceDisconnected(name: ComponentName?) {
            Log.e(TAG, "onServiceDisconnected: Success" )
            leoAidl = null
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.e(TAG, "onServiceConnected: Success" )
            leoAidl = ILeoAidl.Stub.asInterface(service)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(connection)
    }
}