package br.com.lym.myapplication

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val dado = intent.getStringExtra("NOMEMAIL")
        tvUsuario.setText(dado)
        val intentResult = Intent()
        intentResult.putExtra("NOMEMAIL", "OK-LYM")
        setResult(Activity.RESULT_OK,intentResult)
        finish()
    }

}
