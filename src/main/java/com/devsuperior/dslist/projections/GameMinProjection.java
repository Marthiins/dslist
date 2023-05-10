package com.devsuperior.dslist.projections;

public interface GameMinProjection { // colocar os metodos get correspondente a consulta
	
	Long getId();
	String getTitle();
	Integer getYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
	
}
