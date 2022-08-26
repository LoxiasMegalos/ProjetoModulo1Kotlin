package cadastro

class CadastroUsuario(
    nome: String,
    login: String,
    senha: String,
    telefone: String,
    val cpf: String
) : Cadastro(nome, login, senha, telefone) {

    init{
        if(cpf.length == 11){
            println("Usuario $nome cadastrado com sucesso")
        } else {
            throw IllegalArgumentException ("CPF Inválido!")
        }

    }

    override fun toString(): String {
        return "Usuário: $nome, Cpf $cpf"
    }


    fun adicionarComentario (id:Int, comentario:String){
        try{
        for(post in 0..CadastroMedico.postagens.size){
            if(post == id){

                var postmodificado = CadastroMedico.postagens.get(post)
                CadastroMedico.postagens.removeAt(post)

                postmodificado += "\ncomentario: $comentario - autor: $nome"
                CadastroMedico.postagens.add(postmodificado)
                return
            }
        }}catch (e: Exception){
            throw Exception ("Id do post não encontrado nas postagens")
        }
    }

}