package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavBar:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavBar = findViewById(R.id.bottomNavBar)
        val homeFragment = HomeFragment()
        val notificationFragment = NotificationFragment()
        val profileFragment = ProfileFragment()
        setCurrentFragment(homeFragment)

        bottomNavBar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.bottom_home -> setCurrentFragment(homeFragment)
                R.id.bottom_notification -> setCurrentFragment(notificationFragment)
                R.id.bottom_profile -> setCurrentFragment(profileFragment)
            }
            true
        }

        bottomNavBar.getOrCreateBadge(R.id.bottom_notification).apply{
            number= 10
            isVisible = true
        }

    }

    fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout,fragment)
            commit()
        }
    }

}