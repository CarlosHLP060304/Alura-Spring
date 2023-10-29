package med.voll.api.paciente;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Entity
@Table(name = "pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String telefone;
	@Email
	private String email;
	@CPF
	private String cpf;
	@Embedded
	private Endereco endereco;
	
	public Paciente(DadosPaciente dPaciente) {
		this.cpf = dPaciente.cpf();
		this.email = dPaciente.email();
		this.endereco = new Endereco(dPaciente.endereco());
		this.nome = dPaciente.nome();
		this.telefone = dPaciente.telefone();
	}

}
