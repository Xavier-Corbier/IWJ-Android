package fr.xaviercorbier.iwj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        // redirection vers "MainActivity" après 3 secondes
        val handler = Handler()
        val runnable =  Runnable {
            // demarrer une page
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            // on termine l'activité courrante
            finish()
        }
        // envoyer une instruction après un délai
        handler.postDelayed(runnable, 3000)
    }

}