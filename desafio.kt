enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario ( val nomeUsuario: String, val idadeUsuario: Int, val stackUsuario: String )

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun imprimirUsuariosMatriculados(){
        for (usuarios in inscritos){
            println(usuarios.nomeUsuario)
            println(usuarios.stackUsuario)
        }
    }
}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    
    //Gerando usuários
    val usuarioUm = Usuario("Usuario1", 22, "Front end")
    val usuarioDois = Usuario("Usuario2", 28, "Back end")
    val usuarioTres = Usuario("Usuario3", 25, "Mobile")
    val usuarioQuatro = Usuario("Usuario4", 31, "Fullstack")
    
    //Gerando a lista que alimenta a dataclass de conteúdos
    val listaConteudos = mutableListOf<ConteudoEducacional>()
   	
    //Inserindo os conteúdos da lista de conteúdos
    val conteudoBasico = ConteudoEducacional("Conteúdo de nível Basico", 60, Nivel.BASICO)
    val conteudoIntermediario = ConteudoEducacional("Conteúdo de nível Intermediario", 80, Nivel.INTERMEDIARIO)
    val conteudoAvancado = ConteudoEducacional("Conteúdo de nível Avancado", 120, Nivel.AVANCADO)
       
    //Alimentando a lista de conteúdos
    listaConteudos.add(conteudoBasico)
    listaConteudos.add(conteudoIntermediario)
    listaConteudos.add(conteudoAvancado)
    
    //Desenvolvendo matrículas
    val formacaoDio = Formacao("Curso DIO", listaConteudos, Nivel.INTERMEDIARIO)
    
    formacaoDio.matricular(usuarioUm)
    formacaoDio.matricular(usuarioTres)
    
    //Impressão de resultados
    println("Formação da Dio:\n${formacaoDio.nome} de nível ${formacaoDio.nivel}\n")
    println("Lista de usuários matrículados no curso:")
    println(formacaoDio.imprimirUsuariosMatriculados())
    
    //Impressão da lista de conteúdos
    println("\nLista de conteúdos estudados no curso:\n")
    fun imprimirListaDeConteudos(){
        for (conteudos in listaConteudos){
            println(conteudos.nome)
        }
	}
    println(imprimirListaDeConteudos())
}