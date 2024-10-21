package com.twakeapps.multimedia_audioplayer

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.twakeapps.multimedia_audioplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding : ActivityMainBinding
    private lateinit var mp: MediaPlayer

    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//offline
        //mp = MediaPlayer.create(this,R.raw.my_audio)

        //online
        mp = MediaPlayer.create(this,Uri.parse("https://touhidapps.com/api/demo/akash.mp3"))

        mp.isLooping = true



        listeners()

    }//onCreate

    private fun listeners(){

        binding.btnPlay.setOnClickListener {
            mp.start()

        }
        binding.btnPause.setOnClickListener {
            mp.pause()

        }
        binding.btnStop.setOnClickListener {
            mp.seekTo(0)
            mp.pause()

        }

    }//listeners

    override fun onStop()
    {
        super.onStop()

        mp.release()
        mp.stop()

    }

}