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

        val rollButton = findViewById<Button>(R.id.mainRollButton)
        val resultTextView = findViewById<TextView>(R.id.mainOutputView)
        val inputLow = findViewById<EditText>(R.id.inputLowView)
        val inputHigh = findViewById<EditText>(R.id.inputUpperView)



        rollButton.setOnClickListener {
            if(inputLow.text.toString() != "" && inputHigh.text.toString() != "") {
                 if (Integer.parseInt(inputHigh.text.toString()) <= 99999 && Integer.parseInt(inputHigh.text.toString()) > Integer.parseInt(inputLow.text.toString())) {
                    val rand = Integer.parseInt(inputLow.text.toString()) +  1 + Random().nextInt(Integer.parseInt(inputHigh.text.toString()) - Integer.parseInt(inputLow.text.toString()))
                    resultTextView.text = rand.toString()
                }
                 else{
                     Toast.makeText(applicationContext,"Invalid Input",Toast.LENGTH_SHORT).show()
                 }
            }
        }

        toggle = ActionBarDrawerToggle(this,drawerLayout_main, R.string.open, R.string.close)
        drawerLayout_main.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView_main.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miItem1 -> {
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.miItem2 -> {
                    val intent = Intent(this,CurseActivity::class.java)
                    startActivity(intent)
                }
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