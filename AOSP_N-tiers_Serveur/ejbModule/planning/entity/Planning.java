package planning.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * EJB Entity, classe Entity Serialisable. Actuellement et
 * pour des raisons pratiques, la propri�t� evenements de type
 * ArrayList<Evenement> reste en Transient. Aucune m�thode 
 * cod�e dans cette classe.
 * @author Didier
 *
 */
@Entity
public class Planning implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int idPlanning;
	private int idCarre;
	private LocalDate dateCr�ation;
	@Transient
	private ArrayList<Evenement> evenements;

	public Planning() {
		super();
	}

	public Planning(int idPlanning, int idCarre, LocalDate dateCr�ation, ArrayList<Evenement> evenements) {
		super();
		this.idPlanning   = idPlanning;
		this.idCarre      = idCarre;
		this.dateCr�ation = dateCr�ation;
		this.evenements   = evenements;
	}

	public int getIdPlanning() {
		return idPlanning;
	}

	public void setIdPlanning(int idPlanning) {
		this.idPlanning = idPlanning;
	}

	public int getIdCarre() {
		return idCarre;
	}

	public void setIdCarre(int idCarre) {
		this.idCarre = idCarre;
	}

	public LocalDate getDateCr�ation() {
		return dateCr�ation;
	}

	public void setDateCr�ation(LocalDate dateCr�ation) {
		this.dateCr�ation = dateCr�ation;
	}

	public ArrayList<Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(ArrayList<Evenement> evenements) {
		this.evenements = evenements;
	}

	@Override
	public String toString() {
		return "Planning [idPlanning=" + idPlanning + ", idCarre=" + idCarre + ", dateCr�ation=" + dateCr�ation
				+ ", evenements=" + evenements + "]";
	}




}
