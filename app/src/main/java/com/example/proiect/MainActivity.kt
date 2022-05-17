package com.example.proiect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.menu.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle( this, drawerlayout, toolbar, R.string.open, R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawerlayout.addDrawerListener(toggle)
        toggle.syncState()

        nav_menu.setNavigationItemSelectedListener(this)

        setToolbarTitle("Home")
        changeFragment(HomePage())
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerlayout.closeDrawer(GravityCompat.START)

        when(item.itemId){
            R.id.home -> {
                setToolbarTitle("Home")
                changeFragment(HomePage())
            }

            R.id.about -> {
                setToolbarTitle("About")
                changeFragment(AboutPage())
            }

            R.id.contact -> {
                setToolbarTitle("Contact")
                changeFragment(ContactPage())
            }

            R.id.recyclerViewButton -> {
                setToolbarTitle("RecyclerView")
                changeFragment(RecyclerViewPage())
            }

        }

        return true
    }

    fun setToolbarTitle(title: String){
        supportActionBar?.title = title
    }

    fun changeFragment(func_fragment: Fragment){
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.fragment_container, func_fragment).commit()
    }
}