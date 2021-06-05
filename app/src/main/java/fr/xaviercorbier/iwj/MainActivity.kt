package fr.xaviercorbier.iwj

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import fr.xaviercorbier.iwj.api.RetrofitInstance
import fr.xaviercorbier.iwj.models.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.apply {
            setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
            setCustomView(R.layout.action_bar_layout)
        }
        val button: Button = findViewById(R.id.button) as Button
        button.setOnClickListener {
            val textView: TextView = findViewById(R.id.textView2) as TextView
            textView.text = "Research ..."
            jsonParse()
        }
    }

    private fun jsonParse() {
        val url = "https://icanhazdadjoke.com/"
        val textView: TextView = findViewById(R.id.textView2) as TextView
        val call: Call<Joke> = RetrofitInstance.createCallApi().getJoke()
        call.enqueue(object : Callback<Joke?> {
            override  fun onResponse(call: Call<Joke?>?, response: Response<Joke?>) {
                //val statusCode: Int = response.code()
                val joke: Joke? = response.body()
                if (joke?.status==200) {
                    textView.text = joke?.joke
                } else {
                    textView.text = "Sorry, I don't have more joke"
                }
            }
            override fun onFailure(call: Call<Joke?>?, t: Throwable?) {
                textView.text = "Error : check your internet connection"
            }
        })
    }
}

