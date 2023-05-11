package com.devsuperior.dslist.projections;

public interface GameMinProjection { // colocar os metodos get correspondente a consulta
	
	Long getId();
	String getTitle();
	Integer getGameYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
	
}
