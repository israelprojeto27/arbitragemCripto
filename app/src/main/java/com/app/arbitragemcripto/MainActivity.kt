package com.app.arbitragemcripto

import android.os.Bundle
import android.os.StrictMode
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import androidx.fragment.app.FragmentTransaction
import com.app.arbitragemcripto.fragments.allcriptos.AllCriptosFragment
import com.app.arbitragemcripto.fragments.bycripto.ByCriptoFragment
import com.app.arbitragemcripto.fragments.byexchanges.ByExchangeFragment
import com.app.arbitragemcripto.fragments.cotacaobycripto.CotacaoByCriptoFragment
import com.app.arbitragemcripto.fragments.cotacaobyexchanges.CotacaoByExchangesFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var allCriptosFragment: AllCriptosFragment
    lateinit var byCriptoFragment : ByCriptoFragment
    lateinit var byExchangeFragment: ByExchangeFragment
    lateinit var cotacaoByCriptoFragment: CotacaoByCriptoFragment
    lateinit var cotacaoByExchangesFragment : CotacaoByExchangesFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

        allCriptosFragment = AllCriptosFragment();
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, allCriptosFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_all_criptomoedas -> {
                allCriptosFragment = AllCriptosFragment();
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, allCriptosFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_by_cripto -> {
                byCriptoFragment = ByCriptoFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, byCriptoFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_by_exchanges -> {
                byExchangeFragment = ByExchangeFragment();
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, byExchangeFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_cotacao_by_cripto -> {
                cotacaoByCriptoFragment = CotacaoByCriptoFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, cotacaoByCriptoFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_cotacao_by_exchanges -> {
                cotacaoByExchangesFragment = CotacaoByExchangesFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, cotacaoByExchangesFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
