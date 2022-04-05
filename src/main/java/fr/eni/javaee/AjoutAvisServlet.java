package fr.eni.javaee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.bll.AvisManager;
import fr.eni.javaee.bll.BusinessException;
import fr.eni.javaee.bo.Avis;


/**
 * Servlet utilisé pour la fonctionnalité d'ajout d'avis 
 * on utilse "" comme url donc ce servlet sera "mappé" à l'url de base
 */
@WebServlet("")
public class AjoutAvisServlet extends HttpServlet {
	
	/**
	 * AvisManager : reférence vers notre couche BLL
	 */
	private AvisManager avisManager = new AvisManager();
	
	/**
	 * doGet : va être appelé quand on rentre l'url de l'application dans un nouvel onglet du navigateur
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/ajoutAvis.jsp").forward(request, response);
	}

	/**
	 * doPost : va être appelé quand on VALIDE LE FORMULAIRE
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {			
			// 1 - on récupère la note / desctipion et on crée l'onjet Avis associé
			int note = Integer.parseInt(request.getParameter("note"));
			String description = request.getParameter("description");
			Avis avis = new Avis(note, description);		
			// 2 - j'appelle ma couche BLL pour s'occuper du traitement métier		
			this.avisManager.add(avis);
			/** SI j'arrive ici sans plantage, c'est que l'insertion en base de donnée s'est bien passée **/
			// 3 - j'ajoute un attribut de requête "messageConfirmation" pour permettre à la JSP d'afficher un message.
			request.setAttribute("messageConfirmation", "Avis ajouté : " + avis);
		
		/*** Si jamais il y a des exceptions, j'affiche un message d'erreur dans la JSP ***/
		} catch (BusinessException e) { // si jamais j'ai une exception de validation
			// alors j'ajoute un  attribut de requête "messageErreur" pour permettre à la JSP d'afficher un message.
			request.setAttribute("messageErreur", e.getMessage());
		}
		catch (NumberFormatException e){ // si jamais j'ai une exception lors du parsage de la note
			// alors j'ajoute un  attribut de requête "messageErreur" pour permettre à la JSP d'afficher un message.
			request.setAttribute("messageErreur", "Veuillez renseigner une note au format correct");
		}
		
		// 4 - je délègue l'affichage de la réponse à la JSP
		request.getRequestDispatcher("/WEB-INF/ajoutAvis.jsp").forward(request, response);
	}

}
