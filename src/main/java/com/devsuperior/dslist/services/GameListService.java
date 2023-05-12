package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

@Service //Componente do sistema
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll(); //Devolve uma variavel
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();//tranformando Entity game para GameMinDTO
		return dto;
	
	}
	
	//Mover posição da lista, dado uma lista a posição de destino eu atualizo a lista no banco de dados
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) { //Origem e destino
		List<GameMinProjection> list = gameRepository.searchByList(listId);//Buscar na memoria game na lista
		
		GameMinProjection obj = list.remove(sourceIndex);//Movimentar jogos da lista primeiro eu removo o objeto na posição de origem
		
		list.add(destinationIndex, obj);//Inserir objeto na posição da lista
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;//criar variavel para pegar o minimo
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;//criar variavel para pegar o minimo
	
		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
			
		}
	}
}
