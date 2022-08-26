package cadastro

class CadastroUsuario(
    nome: String,
    login: String,
    senha: String,
    telefone: String,
    val cpf: String
) : Cadastro(nome, login, senha, telefone) {

    companion object{
         val cpfsCadastrados = mutableSetOf<String>()
    }

    init{
        if(cpf.length == 11){
            if(cpf !in cpfsCadastrados){
                println("Usuario $nome cadastrado com sucesso")
                cpfsCadastrados.add(cpf)
            }
            else{
                throw IllegalArgumentException ("CPF Já cadastrado")
            }
        } else {
            throw IllegalArgumentException ("CPF Inválido!")
        }

    }

    override fun toString(): String {
        return "Usuário: $nome, Cpf $cpf"
    }


    fun adicionarComentario (id:Int, comentario:String):String{
        try{
        for(post in 0..CadastroMedico.postagens.size){
            if(post == id-1){

                var postmodificado = CadastroMedico.postagens.get(post)
                CadastroMedico.postagens.removeAt(post)

                postmodificado += "\ncomentario: $comentario - autor: $nome"
                CadastroMedico.postagens.add(postmodificado)
                return "Comentario de $nome adicionado com sucesso!"
            }
        }
            return ""
        }catch (e: Exception){
            throw Exception ("Id do post não encontrado nas postagens")
        }
    }

}