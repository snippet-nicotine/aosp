package utilisateur.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="aosp_specialite")
public class Specialite implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getIdSpecialite() {
		return idSpecialite;
	}

	public void setIdSpecialite(String idSpecialite) {
		this.idSpecialite = idSpecialite;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String idSpecialite;
	
	@Column(length = 30, nullable = true)
	private String libelle;

}
