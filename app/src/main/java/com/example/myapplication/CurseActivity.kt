package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.model.Curse
import com.example.myapplication.model.CurseFactory
import kotlinx.android.synthetic.main.activity_curse.*
import java.util.*

class CurseActivity : AppCompatActivity(){

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curse)

        /*
        *Operating Code
        * Roll onClick(): gives an random funny @Curse
        * Confirm onClick(): tackes the Progress of the @seekBar and saved it as level of the Curse
         */
        val curseFactory = CurseFactory()
        curseFactory.initCurses()
        val curses = curseFactory.curses
        val rollButton = findViewById<Button>(R.id.curseRollButton);
        val output = findViewById<TextView>(R.id.curseOutputView);
        val confirm = findViewById<Button>(R.id.curseConfirmButton);
        val seekBar = findViewById<SeekBar>(R.id.curseSeekBar);

        rollButton.setOnClickListener{
            output.text = curses[Random().nextInt(10)].ger
        }

        confirm.setOnClickListener{

        }


        toggle = ActionBarDrawerToggle(this,drawerLayout_curse, R.string.open, R.string.close)
        drawerLayout_curse.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Eventhandling of the nav-drawer menu
        navView_curse.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miItem1 -> {
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.miItem3 -> {
                    val intent = Intent(this,ThirdActivity::class.java)
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