package baz.bar.foo.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    init {
        Log.d("dtm463", "Created activity - ${this.hashCode() % 1000}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_host_layout, Fragment1())
            .commit()
    }

    @Throws(Throwable::class)
    protected fun finalize() {
        Log.d("dtm463", "finalize for activity ${this.hashCode() % 1000}")
    }
}
