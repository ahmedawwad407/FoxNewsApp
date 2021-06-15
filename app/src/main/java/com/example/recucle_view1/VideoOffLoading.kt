package com.example.recucle_view1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

class VideoOffLoading : AppCompatActivity() {
    lateinit var playerView: PlayerView
    lateinit var player: SimpleExoPlayer
    var videoURl =
        "https://media.gettyimages.com/videos/palestinian-protesters-clash-with-israeli-security-forces-as-they-video-id1183082087"
    private var playWhenReady = true
    private var currentWindow = 0
    private var playPackPosition: Long = 0
    lateinit var goToActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_off_loading)

        playerView = findViewById(R.id.video_view)
        goToActivity = findViewById(R.id.goToActivity)
        goToActivity.setOnClickListener(View.OnClickListener {
            releaseVideo()
            val i = Intent(applicationContext, ImagesOfNews::class.java)
            startActivity(i)
        })

    }

    fun initVideo() {
        //create player
        player = ExoPlayerFactory.newSimpleInstance(this)
        //connect Player with playerView
        playerView!!.setPlayer(player)
        //media source
        val uri = Uri.parse(videoURl)
        val factory: DataSource.Factory = DefaultDataSourceFactory(this, "exoplayer-codelab")
        val mediaSource: MediaSource =
            ProgressiveMediaSource.Factory(factory).createMediaSource(uri)
        player.setPlayWhenReady(playWhenReady)
        player.seekTo(currentWindow, playPackPosition)
        player.prepare(mediaSource, false, false)
    }


    fun releaseVideo() {
        if (player != null) {
            playWhenReady = player?.playWhenReady
            playPackPosition = player?.currentPosition
            currentWindow = player?.currentWindowIndex
            player?.release()
            player == null
        }
    }

    override fun onStart() {
        super.onStart()
        initVideo()
    }


    override fun onStop() {
        super.onStop()
        releaseVideo()
    }

    override fun onPause() {
        super.onPause()
        releaseVideo()
    }
}