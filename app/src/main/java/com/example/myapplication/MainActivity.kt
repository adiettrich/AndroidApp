package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.rollButton)
        val resultTextView = findViewById<TextView>(R.id.resultView)
        val input = findViewById<EditText>(R.id.inputView)



        rollButton.setOnClickListener {
            if (Integer.parseInt(input.text.toString()) <= 1000000){
                val rand = 1 + Random().nextInt(Integer.parseInt(input.text.toString()))
                resultTextView.text = rand.toString()
            }
        }

        toggle = ActionBarDrawerToggle(this,drawerLayout_main, R.string.open, R.string.close)
        drawerLayout_main.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView_main.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miItem2 -> {
                    val intent = Intent(this,CurseActivity::class.java)
                    startActivity(intent)
                }
                R.id.miItem3 -> Toast.makeText(applicationContext,
                    "Coming Soon", Toast.LENGTH_SHORT).show()
            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}