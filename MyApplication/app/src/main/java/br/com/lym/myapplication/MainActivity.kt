package br.com.lym.myapplication

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Clique no text
        tvNome.setOnClickListener {
            setTeste("Texto alterado", " OK")
        }

        // Clique no botao
        btEnviar.setOnClickListener {
            val nome: String  = etNome.text.toString()
            val email: String  = etEmail.text.toString()
            var nome_email: String = "$nome $email"

            if (nome.isNotBlank() && email.isNotBlank()) {
                tvResultado.text = "$nome $email"
            } else {
                if (nome.isBlank())
                    etNome.error = "Digite seu nome"
                if (email.isBlank())
                    etEmail.error = "Digite seu email"
                tvResultado.text = "Digitar dados"
            }

            setTeste(nome_email, "")

        }

        btNomeEmail.setOnClickListener {
            val nome: String  = etNome.text.toString()
            val email: String  = etEmail.text.toString()
            var nome_email: String = "$nome $email"
            intent = Intent(this, SettingsActivity::class.java)
            intent.putExtra("NOMEMAIL", nome_email)
            //startActivity(intent)
            startActivityForResult(intent,REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            tvResultado.text = "IntentResult " + data?.getStringExtra("NOMEMAIL").toString();
            Toast.makeText(this, "Message", Toast.LENGTH_LONG).show();
        }
    }

    // Funcao
    private fun setTeste(texto: String, texto1: String) {
        tvNome.text = "$texto $texto1"
    }
}
