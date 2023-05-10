package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

@Service //Componente do sistema
public class GameService {

	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get(); //recebe um id e retorna um objeto Game
		 return new GameDTO(result);
		
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll(); //Devolve uma variavel
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();//tranformando Entity game para GameMinDTO
		return dto;
	
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId); //Devolve uma variavel
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();//tranformando Entity game para GameMinDTO
		return dto;
	
	}
}
