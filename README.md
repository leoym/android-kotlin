# android-kotlin
android-kotlin


Curso básico de android

1) IDE Androido studio
Versão 3.14 e 3.3

2) Linguagem
Kotlin (Java)

3) Abrindo e criando o primeiro Projeto
Empty Activity

4) Trabalhando com IDE
Configurações

5) Emulador
Execução do aplicativo

6) Mudando a versão do APl
Gradle

7) Atualizando o layout da activity
Adicionando componentes

8) Trabalhando com constraints
Layout
Disponibilidade dos componentes

9) Ordenando os componentes
Text
Edit
Button

10) Utilizando resources
Colors e strings

11) Criando a estrutura do App
Adicionando botões

12) Adicionando funcoes aos
botoes
// Clique no botao
        btEnviar.setOnClickListener {
            setTeste(etNome.text.toString(), etEmail.text.toString() )
        }

// Funcao
    private fun setTeste(texto: String, texto1: String) {
        tvNome.text = "$texto $texto1"
    }


13) Tipos

val 

var
14) Tratamento de dados
IsNotBlank

15) Case
If

16) New activity
Drawer - Intent


17) Permission
<uses-permission android:name="android.permission.INTERNET" /> 
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

18) Widgets

WebView

19) GetEstraString

Intent recebido

20) Envio de dados entre 
activities
            intent = Intent(this, SettingsActivity::class.java)
            intent.putExtra("", nome_email)
            startActivity(intent)

        val dado = intent.getStringExtra("NomeEmail")
        tvUsuario.setText(dado)

Toast.makeText(this, "Message", Toast.LENGTH_LONG).show();

Referencia

https://developer.android.com/kotlin?hl=pt-BR
https://developer.android.com/kotlin/get-started?hl=pt-br#kotlin
https://medium.com/androiddevelopers/tagged/kotlin
https://kotlinlang.org/docs/reference/basic-syntax.html
https://play.kotlinlang.org


