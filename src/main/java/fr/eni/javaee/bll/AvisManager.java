package fr.eni.javaee.bll;

import java.sql.SQLException;

import fr.eni.javaee.bo.Avis;
import fr.eni.javaee.dal.AvisDAO;
import fr.eni.javaee.dal.AvisDAOFactory;

/**
 * Couche BLL / couche Services
 * C'est là qu'on va effectuer les traitements metiers et la validation des données
 * Cette couche a une réference vers la couche DAL
 */
public class AvisManager {
	
	/**
	 * AvisDAO : reférence vers notre couche DAL
	 */
	// Plutôt que de définir la relation entre AvisManager et AvisDAO directement : AvisDAO avisDAO = new AvisDAOJdbcImpl();
	// On va passer par une Factory pour avoir une meilleur indépendance entre les composants (bonne pratique)	
	private AvisDAO avisDAO = AvisDAOFactory.getAVisDAO();
	

	/**
	 * add() : est appelé par le servlet
	 * => va envoyer les données à la couche DAL après validation
	 * @throws BusinessException 
	 */
	public void add(Avis avis) throws BusinessException {
		// 1 - on valide les données
		validation(avis);
		
		// 2 - si données OK, on envoie à la couche DAL
		try {
			this.avisDAO.add(avis);
		} catch (SQLException e) {
			// si jamais j'ai une erreur dans le DAO, je lance mon exception Business qui sera recupérée par mon servlet
			throw new BusinessException("erreur technique lors de l'insertion en base de donnée");
		}
	}

	/**
	 * Si jamais la validation ne passe pas : je lance une exception qui sera recupérée par mon servlet
	 */
	private void validation(Avis avis) throws BusinessException {
		// on valide que la note est comprise entre 0 et 5
		if (avis.getNote() > 5 || avis.getNote() < 0) {
			throw new BusinessException("la note doit être comprise entre 0 et 5");
		}
		// TODO : autres validations
	}
	
}
