package kovano.github.a00zadacha01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private var counter: Int = 0
    private var start: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text_view)


        Thread {
            start = true
            while (start) {
                Thread.sleep(1000)
                if (counter < 60){
                    runOnUiThread{textView?.setText(counter.toString())}


                }


                counter++
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        start = false
    }
}