package com.june.testlab1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.startActivity
import java.sql.Time
import java.util.*

class SlashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slash_screen)

        Timer().schedule( object : TimerTask(){
            override fun run() {
                val intent = Intent(this@SlashScreen, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

        }, 1200L)
    }
}
