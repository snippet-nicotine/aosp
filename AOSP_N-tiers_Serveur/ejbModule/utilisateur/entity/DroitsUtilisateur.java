package utilisateur.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "aosp_droits_utilisateur")
public class DroitsUtilisateur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String idDroit;
	
	@Column(length = 30, nullable = true)
	private String libelle;

	public String getIdDroit() {
		return idDroit;
	}

	public void setIdDroit(String idDroit) {
		this.idDroit = idDroit;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
