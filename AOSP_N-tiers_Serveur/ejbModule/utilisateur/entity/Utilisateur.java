package utilisateur.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "aosp_utilisateur")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utilisateur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ref_droit")
	private String idUtilisateur;
	
	@OneToOne ( cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "idEtatcivil", unique = true, nullable = true)
	private EtatCivil etatCivil;
	
	@Column(name="mail", length = 30, nullable = true)
	private String mail;
	
	@Column(name = "motPasse", length = 30, nullable = true)	
	private String motPasse;
	
	public String getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public EtatCivil getEtatCivil() {
		return etatCivil;
	}

	public void setEtatCivil(EtatCivil etatCivil) {
		this.etatCivil = etatCivil;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotPasse() {
		return motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}

	public Collection<DroitsUtilisateur> getListeDroits() {
		return listeDroits;
	}

	public void setListeDroits(Collection<DroitsUtilisateur> listeDroits) {
		this.listeDroits = listeDroits;
	}

	@ManyToMany(cascade= { CascadeType.DETACH}, fetch = FetchType.EAGER)
	@JoinTable(name="aosp_droits_utilisateur",
	 joinColumns = @JoinColumn(name="idUtilisateur") ,
	 inverseJoinColumns = @JoinColumn(name="idDroit") )
	Collection<DroitsUtilisateur> listeDroits;

}
