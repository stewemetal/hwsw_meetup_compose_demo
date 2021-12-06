package hu.stewemetal.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import hu.stewemetal.composedemo.ui.compose.ComposeFragment
import hu.stewemetal.composedemo.ui.theme.ComposeDemoTheme
import hu.stewemetal.composedemo.ui.view.ViewFragment

class MainActivity : AppCompatActivity() {

    // Don't do this in production! Use e.g. a ViewModel instead!
    // This is just a shortcut for a simple demo implementation.
    private var isComposeImplementationShown = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.contentFrame, ViewFragment())
            .commit()

        findViewById<FloatingActionButton>(R.id.implementationSwitcherFab)
            .apply {
                setOnClickListener {
                    isComposeImplementationShown = !isComposeImplementationShown
                    if(isComposeImplementationShown) {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.contentFrame, ComposeFragment())
                            .commit()
                    } else {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.contentFrame, ViewFragment())
                            .commit()
                    }
                }
            }
    }
}
