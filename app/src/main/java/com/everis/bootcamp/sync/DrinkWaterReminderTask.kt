package com.everis.bootcamp.sync

import android.content.Context
import com.everis.bootcamp.utils.PreferencesUtils
import java.security.AccessControlContext


class DrinkWaterReminderTask {
    //  String constante estatica chamada ACTION_INCREMENT_WATER_COUNT para representar a ação de incrementar o contador
    companion object {
        const val ACTION_INCREMENT_WATER_COUNT = "action-increment-water-count"
        //função privada chamada incrementWaterCount para incrementar o contador de copo de água
        //Inclue um Context como parametro da função
        //Chama o metodo incrementWaterCount da classe PreferencesUtils
        private fun incrementWaterCount(context: Context) {
            PreferencesUtils.incrementWaterCount(context)
        }
       //método publico e estatico para executar a tarefa
       //Coloca um Context como parametro e uma string chamada action
       //Qdo a action for igual a constante ACTION_INCREMENT_WATER_COUNT chame o método incrementWaterCount desta classe
        fun executeTask(context: Context, action: String?) {
            if(ACTION_INCREMENT_WATER_COUNT == action) {
                incrementWaterCount(context)
            }
        }
    }


}


