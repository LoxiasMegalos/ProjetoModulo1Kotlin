package cadastro

class CadastroMedico(
    nome: String,
    login: String,
    senha: String,
    telefone: String,
    val cpf: String,
    val crm: String
) : Cadastro(nome, login, senha, telefone) {

    init{
        if(cpf.length == 11 && crm.length == 8){
            println("Medico $nome cadastrado com sucesso")
        } else {
            throw IllegalArgumentException ("Cadastro Inválido!")
        }

    }

    companion object{
        val postagens = mutableListOf<String>()

        fun listarPostagens():String{
            var posts = ""
            var id = 0
            for(postagem in postagens){
                posts += "id: ${id} - "+ postagem + "\n"
                id++
            }
            return posts
        }
    }

    fun criarPostagem(post: String){
        var postagem = "Médico $nome postou:\n"
        postagem += post
        if(post.isNotBlank()){
            postagens.add(postagem)
            return
        }
        println("O post nao pode estar em branco")
    }

    fun deletarPostagem(postDeletado: Int){
        if(CadastroMedico.postagens.contains(CadastroMedico.postagens.get(postDeletado))){
            CadastroMedico.postagens.removeAt(postDeletado)
            return
        }
        println("O $postDeletado nao existe")
    }

    /*
    fun editarPostagem(id: Int){
        for (postagem in postagens){
            if(postagens.indexOf(postagem) == id){
                print("Digite o novo post: ")
                var novaPostagem = readln()
                novaPostagem += "(editado)"
                //postagens.add(novaPostagem)
                postagens.remove(postagem)
                this.criarPostagem(novaPostagem)
                break
            }
        }
    }
    */

    override fun toString(): String {
        var retorno = "Médico: $nome, Crm: $crm "

        return retorno
    }

}