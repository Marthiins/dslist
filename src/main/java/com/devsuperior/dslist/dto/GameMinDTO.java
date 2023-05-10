package com.devsuperior.dslist.dto;

import java.io.Serializable;

import com.devsuperior.dslist.entities.Game;

public class GameMinDTO implements Serializable{ //DTO é uma classe independente do banco de dados
	private static final long serialVersionUID = 1L;

	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;

	public GameMinDTO() {

	}

	public GameMinDTO(Game entity) {//Construtor gereando os dados da entidade
		id = entity.getId();
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	
	
}
