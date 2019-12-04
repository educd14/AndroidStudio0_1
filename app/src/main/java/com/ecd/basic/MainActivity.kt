package com.ecd.basic

import android.graphics.Color
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.longToast
import org.jetbrains.anko.selector
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

      fab.setOnClickListener{
           botonSaludo.setBackgroundColor(Color.BLUE)
          textoSaludo.setText("A\nZ\nU\nL")
          textoSaludo.setTextColor(Color.BLACK)
          image.visibility = View.INVISIBLE
          Snackbar.make(it, "Ya no", Snackbar.LENGTH_LONG)
              .setAction("Action", null).show()

       }
        fab.setOnLongClickListener{
            botonSaludo.setBackgroundColor(Color.GREEN)
            textoSaludo.setText("V\nE\nR\nD\nE")
            textoSaludo.setTextColor(Color.WHITE)
            image.visibility = View.VISIBLE
            it.snackbar("¡Un fondo!")

            false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    fun prueba(v: View){
        botonSaludo.setBackgroundColor(Color.RED)
        textoSaludo.setText("R\nO\nJ\nO")
        longToast("Hi there!")
        val countries = listOf("Russia", "USA", "Japan", "Australia")
        selector("Where are you from?", countries, { dialogInterface, i ->
            toast("So you're living in ${countries[i]}, right?")
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
