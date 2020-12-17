package com.sungbin.gitkakaobot.ui.activity

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.sungbin.androidutils.util.StorageUtil
import com.sungbin.gitkakaobot.R
import com.sungbin.gitkakaobot.databinding.ActivityDashboardBinding
import com.sungbin.gitkakaobot.util.manager.PathManager


/**
 * Created by SungBin on 2020-08-23.
 */

class DashboardActivity : AppCompatActivity() {

    companion object {
        lateinit var onBackPressedAction: () -> Unit
    }

    private lateinit var navController: NavController
    private val binding by lazy { ActivityDashboardBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcv_container) as NavHostFragment
        navController = navHostFragment.navController

        StorageUtil.createFolder(PathManager.JS)
        StorageUtil.createFolder(PathManager.SIMPLE)
        StorageUtil.createFolder(PathManager.DATABASE)
        StorageUtil.createFolder(PathManager.LOG)
        StorageUtil.createFolder(PathManager.SENDER)
        StorageUtil.createFolder(PathManager.ROOM)

        supportActionBar?.hide()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        binding.sbbNavigation.setupWithNavController(menu!!, navController)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp()
        return true
    }

    override fun onBackPressed() {
        onBackPressedAction()
    }

}