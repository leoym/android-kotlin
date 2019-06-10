# android-kotlin
android-kotlin


Curso básico de android

Aulas A3 e A4


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
https://github.com/Kotlin/anko

A6 e A7


Aulas 
A6 - Aula - Programação Android com Kotlin

1 - Conceitos básicos 

WebServices - API

2 - Formato Json

{
  "nome" : "Leonardo",
  "idade": 40,
  "altura": 1,68, 
  "endereco" : {
      "Rua" : "Al. Santos",
      "Numero" : 1165	
  }
}

3 - Dados externos - Endpoints de acesso do Github

https://developer.github.com/
https://developer.github.com/v3/search/
https://developer.github.com/v4/

Query

https://api.github.com/search/repositories?q=tetris+language:assembly&sort=stars&order=desc
https://api.github.com/search/users?q=lymteclab



4 - Criando um novo projeto no Android studio

Empty activity

5 - Inserindo os elementos no layout

TextView


    <TextView
            android:id="@+id/tvRepositorios"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Repos do Git"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="parent"/>



6 - Rodando o aplicativo no Emulador

Run


7 - Inserindo o código

Documentação

	Kotlin com retrofit - http://square.github.io/retrofit/

Inserir as dependências no retrofit

 	implementation 'com.squareup.retrofit2:retrofit:2.6.0'
    	implementation 'com.squareup.retrofit2:converter-gson:2.6.0'

Criar a interface

	
	interface ApiService {

	    @GET("search/repositories")
	    fun buscarRepositorios(@Query("q") query: String): Call<GitHubResult>
	}

Criar as classe


	class GitHubResult (
	    val items: List<Repository>
	)

	class Repository (
	    val id: Long?,
	    val name: String?,
	    val full_name: String?,
	    val owner: Owner
	)	

	class Owner (
	    val id: Long?,
	    val login: String?,
	val avatar_url: String?
	)

Main

	var retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service:ApiService = retrofit.create(ApiService::class.java)

        val call : Call<GitHubResult> = service.buscarRepositorios("lymtec")

        call.enqueue(object: Callback<GitHubResult> {
            override fun onResponse(call: Call<GitHubResult>, response: Response<GitHubResult>) {
                tvRepositorios.text = "ok"
                val result = response.body()
                if(result != null) {
                    var nomes = "OK"
                    result.items.forEach{
                    //    //nomes =+ it.name + "\n"
                       nomes = "Nome: ${it.name}  Login:${it.owner.login} \n"
                    }
                    tvRepositorios.text = nomes;
                }
            }
            override fun onFailure(call: Call<GitHubResult>, t: Throwable) {
                tvRepositorios.text = "ERRO"
            }

        })


8 - Verificando e testando o código

QA

9 - Ajustes 

TextBox
Button

10 - Novo código

fun efeturarBusca(language: String) {
}

btQuery.setOnClickListener {
}

https://github.com/kassiano


A7 - Aula Banco de Dados

Setup do Banco de Dados

class DatabaseHelper (context: Context?):
    SQLiteOpenHelper(context, "ocean_db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        var sql = """
            CREATE TABLE contatos ( id integer PRIMARY KEY,
            nome TEXT,
            telefone TEXT
            );
        """.trimIndent()

        db?.execSQL(sql)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}

Criar uma função que salva dados

    
    fun salvarContato(nome: String, telefone: String) {
        TODO("BD")
        tvResult.text = "Gravar contato: $nome - $telefone"
    }



