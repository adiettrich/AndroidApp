package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_camera.*
import java.io.File

private const val REQUEST_CODE = 42
private const val FILE_NAME = "photo.jpg"
private lateinit var photoFile: File

class CameraActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        button_capture.setOnClickListener{
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            photoFile = getPhotoFile(FILE_NAME)

            val fileProvider = FileProvider.getUriForFile(this, "com.example.myapplication.fileprovider", photoFile)
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider)
            //startActivityForResult(takePictureIntent, REQUEST_CODE)
            //If-Statement does not work for AVD with Android 11.0
            if (takePictureIntent.resolveActivity(this.packageManager) != null) {
                startActivityForResult(takePictureIntent, REQUEST_CODE)
            } else {
                Toast.makeText(this,"Unable to open Camera", Toast.LENGTH_SHORT).show()
            }
        }

        toggle = ActionBarDrawerToggle(this,drawerLayout_third, R.string.open, R.string.close)
        drawerLayout_third.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView_third.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.miItem1 -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.miItem2 -> {
                    val intent = Intent(this, CurseActivity::class.java)
                    startActivity(intent)
                }
            }
            true
        }
    }

    private fun getPhotoFile(fileName: String): File{
        //Uses @getExternalFilesDir() on Context to access package-specific directories
        val storageDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(fileName,".jpg",storageDirectory)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            val takenImage = BitmapFactory.decodeFile(photoFile.absolutePath)
            findViewById<ImageView>(R.id.camera_preview).setImageBitmap(takenImage)
            if(takenImage.height < takenImage.width){
                findViewById<ImageView>(R.id.camera_preview).rotation = 90F
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}