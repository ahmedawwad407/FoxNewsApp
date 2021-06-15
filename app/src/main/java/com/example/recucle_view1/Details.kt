package com.example.recucle_view1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_details.*

class Details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        if (intent.hasExtra("desc") && intent.hasExtra("link")){
            val desc = intent.getStringExtra("desc")
            descTV.setText(desc)

            val link = intent.getStringExtra("link")

            val inPhoto = intent.getIntExtra("inPhoto", 0)
            imageView2.setImageResource(inPhoto)

            linkbtn.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val i = Intent(Intent.ACTION_VIEW)
                    i.setData(Uri.parse(link))
                    startActivity(i)
                }
            })


        }

        GoToVideo.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val i = Intent(applicationContext, VideoOffLoading::class.java)
                startActivity(i)
            }
        })
    }
}
