package fr.eni.javaee.dal;

/**
 * Classe qui va juste servir à faire le lien entre ma couche BLL et ma couche DAL
 */
public abstract class AvisDAOFactory {
	
	/**
	 * Cette méthode sert à éviter le : AvisDAO avisDAO = new AvisDAOJdbcImpl() dans la couche BLL
	 */
	public static AvisDAO getAVisDAO() {
		return new AvisDAOJdbcImpl();
	}
}
