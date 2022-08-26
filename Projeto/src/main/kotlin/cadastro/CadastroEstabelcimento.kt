package cadastro

class CadastroEstabelcimento(
    nome: String,
    login: String,
    senha: String,
    telefone: String,
    private val cnpj: String
) : Cadastro(nome, login, senha, telefone) {

    init{
        if(cnpj.length == 14){
            println("Estabelecimento $nome cadastrado com sucesso")
        } else {
            throw IllegalArgumentException ("CNPJ Inválido!")
        }

    }

    fun criarPostagem(post: String){
        var postagem = "Estabelecimento $nome postou:\n"
        postagem += post
        if(post.isNotBlank()){

            CadastroMedico.postagens.add(postagem)
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
        for (postagem in CadastroMedico.postagens){
            if(CadastroMedico.postagens.indexOf(postagem) == id){
                print("Digite o novo post: ")
                val novaPostagem = readln()
                CadastroMedico.postagens.add(novaPostagem)
                CadastroMedico.postagens.remove(postagem)
                break
            }
        }
    }
    */

    override fun toString(): String {
        var retorno = "Estabelecimento: $nome, CNPJ: $cnpj "
        return retorno
    }

}