package fr.eni.javaee.dal;

import java.sql.SQLException;

import fr.eni.javaee.bo.Avis;

/**
 * Interface : définit les fonctionnalités qu'on cherche à avoir
 */
public interface AvisDAO {
	/*
	 * Je veux pouvoir ajouter un avis
	 */
	public void add(Avis avis) throws SQLException;
}
