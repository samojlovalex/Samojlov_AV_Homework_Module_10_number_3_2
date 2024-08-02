package com.example.samojlov_av_homework_module_10_number_3_2

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.samojlov_av_homework_module_10_number_3_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbarMain: androidx.appcompat.widget.Toolbar
    private lateinit var trafficLawsTV: TextView
    private lateinit var checkboxCB: CheckBox
    private lateinit var textVieWTV: TextView
    private lateinit var layoutLL: LinearLayout

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        unit()

        setSupportActionBar(toolbarMain)
        title = getString(R.string.toolbar_title)
        toolbarMain.setLogo(R.drawable.toolbar_icon)

        checkboxCB.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                trafficLawsTV.text = getString(R.string.trafficLawsTVAfter)
                trafficLawsTV.setTextColor(Color.WHITE)
                textVieWTV.text = getString(R.string.trafficLawsOut)
                layoutLL.setBackgroundColor(Color.BLUE)
            } else {
                trafficLawsTV.text = getString(R.string.trafficLawsTVBefore)
                trafficLawsTV.setTextColor(Color.BLUE)
                textVieWTV.text = ""
                layoutLL.setBackgroundColor(Color.WHITE)
            }
        }
    }

    fun unit() {
        toolbarMain = binding.toolbarMain
        trafficLawsTV = binding.trafficLawsTV
        checkboxCB = binding.checkboxCB
        textVieWTV = binding.textVieWTV
        layoutLL = binding.layoutLL
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    @SuppressLint("SetTextI18n", "ShowToast")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exitMenuMain -> {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.toast_exit),
                    Toast.LENGTH_LONG
                ).show()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}