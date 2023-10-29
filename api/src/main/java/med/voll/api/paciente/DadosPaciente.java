package med.voll.api.paciente;

import med.voll.api.endereco.DadosEndereco;

public record DadosPaciente(String nome,String telefone,String email,String cpf,DadosEndereco endereco) {

}
