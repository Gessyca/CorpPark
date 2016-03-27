package chstore.ch.controller

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.List

import javax.annotation.PostConstruct
import javax.faces.bean.ManagedBean
import javax.faces.bean.ViewScoped
import javax.inject.Inject

import chstore.ch.GenericoJPA
import chstore.ch.entidade.Jogador
import chstore.ch.entidade.Veiculo

@ManagedBean
@ViewScoped
public class VeiculoController {

	@Inject
	private GenericoJPA genericoJPA
	String dataString
	List<Veiculo> veiculos
	Veiculo veiculoSelecionado
	int idVeiculo
	List<Jogador> colaboradores
	def marcas
	def modelos

	Integer idTemp

	Veiculo veiculo

	@PostConstruct
	public void inicializar() {
		veiculo = new Veiculo()
		veiculos = genericoJPA.buscarTodosVeiculos()
		colaboradores = genericoJPA.buscarTodosJogadores()
	}

	void atualizalistaMarcas(){
		if(veiculo.tipo == 'CARRO'){
			marcas = [
				'CHEVROLET',
				'RENAULT',
				'JEEP',
				'FIAT'
			]
		}else if(veiculo.tipo == 'MOTO'){
			marcas = ['NAO SEI ']
		} else {
			marcas = ['ESCOLHA UM TIPO...']
		}
	}

	void atualizalistaModelos(){
		if(veiculo.marca == 'CHEVROLET') {
			modelos = ['CHEVROLET-1']
		} else if(veiculo.marca == 'RENAULT') {
			modelos = ['RENAULT-1']
		} else {
			modelos = ['ESCOLHA UMA MARCA']
		}
	}

	public void salvar() {

		veiculo.jogador = genericoJPA.buscarJogadorPorId(idTemp)
		if (veiculo.getId() > 0) {
			genericoJPA.atualizar(veiculo)
		} else {
			genericoJPA.salvar(veiculo)
		}
		inicializar()
		veiculo = new Veiculo()
		dataString = null
	}

	public void editar() {

		if (veiculoSelecionado.getId() > 0) {
			genericoJPA.atualizar(veiculoSelecionado)
		}
		inicializar()
	}

	public void remover() {
		genericoJPA.remover(veiculoSelecionado.getId(), Veiculo.class)
		inicializar()
	}
}
