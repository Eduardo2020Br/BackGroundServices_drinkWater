package com.everis.bootcamp.drinkwater

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import com.everis.bootcamp.sync.DrinkWaterReminderIntentService
import com.everis.bootcamp.sync.DrinkWaterReminderTask
import com.everis.bootcamp.utils.PreferencesUtils
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),
    SharedPreferences.OnSharedPreferenceChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Realizar a chamada da função updateWaterCount
        updateWaterCount()

        imageview_cup_icon.setOnClickListener {
            //Chamar a função incrementWaterHandler
            incrementWaterHandler()
        }

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        prefs.registerOnSharedPreferenceChangeListener(this)
    }

    // função updateWaterCount - Atualiza o textview_quantity com o valor da PreferencesUtils.getWaterCount
    fun updateWaterCount() {
        val count = PreferencesUtils.getWaterCount(this)
        textview_quantity.text = "$count"
    }
    // criar uma função chamada incrementWaterHandler
    // criar uma intent explicita para acionar o DrinkWaterReminderIntentService
    // Definir a action da Intent com a constant ACTION_INCREMENT_WATER_COUNT
    // Chamar startService e passe a intent como parametro
    fun incrementWaterHandler() {
        val intent = Intent(this, DrinkWaterReminderIntentService::class.java)
        intent.action = DrinkWaterReminderTask.ACTION_INCREMENT_WATER_COUNT
        startService(intent)

    }


    override fun onDestroy() {
        super.onDestroy()
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        prefs.unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        //Chamar o método updateWaterCount se o parametro key for igual a constante PrefencesUtils.KEY_WATER_COUNT
        if (PreferencesUtils.KEY_WATER_COUNT == key) {
            updateWaterCount()
        }
    }
}
