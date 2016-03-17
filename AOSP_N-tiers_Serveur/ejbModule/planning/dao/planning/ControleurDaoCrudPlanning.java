package planning.dao.planning;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import planning.entity.Planning;
import planning.exception.DaoException;
import planning.util.Utilitaire;

/**
 * EJB session bean de type Stateless, LocalBean : Controleur de
 * la couche dao qui g�re la partie crud d'un planning.
 * Utilise les acc�s � la couche persistance.
 * @author Didier
 *
 */
@Stateless
@LocalBean
public class ControleurDaoCrudPlanning {

	@PersistenceContext(unitName="AOSP_Hibernate")
	EntityManager em;
	
	public ControleurDaoCrudPlanning() {
	}
	
	public void creerPlanning(Planning planning) throws DaoException {
		if (planning == null) {
			throw new DaoException("ControleurDaoCrudPlanning creerPlanning : l'objet planning � cr�er est null");
		}
		else if (!Utilitaire.isEntierPositifNonNull(planning.getIdPlanning())) {
			throw new DaoException("L'id du planning est n�gatif ou nul");
		}else if (!Utilitaire.isEntierPositifNonNull(planning.getIdCarre())) {
			throw new DaoException("L'id du carr� est n�gatif ou nul");
		}
		try {
			em.persist(planning);
		} catch (Exception e) {
			throw new DaoException("ControleurDaoCrudPlanning creerPlanning : Erreur de cr�ation d'un planning");
		}
	}
	
	public void supprimerPlanning(int idPlanning) throws DaoException {
		if (!Utilitaire.isEntierPositifNonNull(idPlanning)) 
			throw new DaoException("L'id du planning est n�gatif ou nul");
		try {
			em.remove(getPlanning(idPlanning));
		} catch (Exception e) {
			throw new DaoException("ControleurDaoCrudPlanning supprimerPlanning : Erreur de suppression d'un planning");
		}
	}
	
	public Planning getPlanning(int idPlanning) throws DaoException {
		if (!Utilitaire.isEntierPositifNonNull(idPlanning)) 
			throw new DaoException("L'id du planning est n�gatif ou nul");
		try {
			return em.find(Planning.class, idPlanning);
		} catch (Exception e) {
			throw new DaoException("ControleurDaoCrudPlanning getPlanning : Erreur sur la recherche d'un planning");
		}
	}

	public void modifierPlanning(Planning planning) throws DaoException {
		if (planning == null) {
			throw new DaoException("ControleurDaoCrudPlanning modifierPlanning : l'objet planning � cr�er est null");
		}
		else if (!Utilitaire.isEntierPositifNonNull(planning.getIdPlanning())) {
			throw new DaoException("L'id du planning est n�gatif ou nul");
		}else if (!Utilitaire.isEntierPositifNonNull(planning.getIdCarre())) {
			throw new DaoException("L'id du carr� est n�gatif ou nul");
		}
		try {
			em.merge(planning);
		} catch (Exception e) {
			throw new DaoException("ControleurDaoCrudPlanning modifierPlanning : Erreur de modification d'un planning");
		}
	}
	
}
