package org.sopt.sample.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import org.sopt.sample.R
import org.sopt.sample.databinding.ActivityHomeBinding
import org.sopt.sample.presentation.gallery.GalleryFragment
import org.sopt.sample.presentation.search.SearchFragment

class HomeActivity : AppCompatActivity() {
    private val homeFragment by lazy { HomeFragment() }
    private val galleryFragment by lazy { GalleryFragment() }
    private val searchFragment by lazy { SearchFragment() }
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    /*    if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.home_container, HomeFragment())
            }
        }*/
        initTransactionEvent()
    }


    private fun initTransactionEvent() {
        binding.bnvHome.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    changeFragment(homeFragment)
                }
                R.id.menu_gallery -> {
                    changeFragment(galleryFragment)
                }
                R.id.menu_search -> {
                    changeFragment(searchFragment)
                }
            }
            true
        }
        binding.bnvHome.selectedItemId = R.id.menu_home
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.home_container, fragment)
            .commit()
    }
}