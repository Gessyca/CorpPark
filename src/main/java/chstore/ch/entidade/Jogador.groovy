package chstore.ch.entidade

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "colaborador")
class Jogador implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id
	Integer matricula
	String nome
	String email
	Integer ramal
	String celular
	@OneToMany(mappedBy = "jogador", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Veiculo> veiculos
}
