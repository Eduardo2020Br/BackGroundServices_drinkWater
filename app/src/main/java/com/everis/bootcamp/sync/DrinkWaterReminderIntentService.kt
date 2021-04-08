package com.everis.bootcamp.sync

import android.app.IntentService
import android.content.BroadcastReceiver
import android.content.Intent


//Entenda a classe IntentService e no construtor passe o parâmetro com o mesmo nome desta classe
class DrinkWaterReminderIntentService : IntentService ("DrinkWaterReminderIntentService"){
    //Sobrescrever o metodo onHandleIntent
    override fun onHandleIntent(intent: Intent?) {
         //Pegue a ação da intent que startou este service
         val action = intent?.action
         //Chamar o método DrinkWaterReminderTask.executeTask e passe a action no parâmetro
        DrinkWaterReminderTask.executeTask(this, action)
    }
 }