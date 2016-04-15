package potager.actions;

import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import commun.actions.AospAction;
import commun.config.Parametres;
import potager.clientServeur.ServiceGestionPotager;
import potager.entity.Potager;
import potager.service.exception.CPPotagerException;
import potager.service.exception.DaoPotagerAjoutException;
import potager.service.exception.DaoPotagerGetException;
import potager.service.exception.DaoPotagerModificationException;
import potager.service.exception.DaoPotagerQueryException;
import potager.service.exception.DaoPotagerSuppressionException;
import potager.service.exception.DimensionPotagerException;
import potager.service.exception.NomPotagerException;
import potager.service.exception.ProprietairePotagerException;
import utilisateur.entity.Jardinier;

public class Gestion_potager extends PotagerAction implements ServletRequestAware{

	private static final long serialVersionUID = 1L;
	
	private final String TITRE = "Gestion des potagers";
	private int id;
	
	private ArrayList<Potager> potagers;
	private Potager potager;
	private ArrayList<Jardinier> utilisateurs;
	private HttpServletRequest httpRequest;
	
		
	@Override 
	public boolean init(){
		
		boolean isValid = super.init();
		titre = TITRE;
		
		if(isValid){
			potagers     = new ArrayList<Potager>();
			utilisateurs = new ArrayList<Jardinier>();			
		}
		
		return isValid;
	}
	
	@Override
	public String execute(){
		System.out.println("test");
		return lister();
	}
	
	public String index(){		
		
		System.out.println("Index");
		return lister();
		
	}
	
	public String lister(){
		
		String result = SUCCESS;
				
		if( !init() ){
			result = ERROR;	
		}
		
		else{
			
			try {
				potagers = (ArrayList<Potager>) serviceGestionPotager.listerPotager();
				System.out.println(potagers);
				
			} catch (DaoPotagerQueryException e) {				
				addActionError( e.getMessage() );
			}
		}
		
		return result;
	}
	
	public String view(){
		return SUCCESS;
	}
	
	public String ajouter(){
		
		
		String result = SUCCESS;
		
		if( !init() ){
			result = ERROR;
		} 
		else {
			
			try {
				Jardinier user = new Jardinier();
				user.setNom("nico");
				potager.setProprietaire( user );
				serviceGestionPotager.ajouterPotager(potager);
				
			} catch (NomPotagerException e) {		
				addFieldError("potager.nom", e.getMessage() );
			} catch (CPPotagerException e) {		
				addFieldError("potager.codePostal", e.getMessage() );
			} catch (ProprietairePotagerException e) {
				addFieldError("potager.proprietaire", e.getMessage() );
			} catch (DimensionPotagerException e) {
				addFieldError("potager.longueur", e.getMessage() );
				addFieldError("potager.largeur", e.getMessage() );
			} catch (DaoPotagerAjoutException e) {
				addActionError( e.getMessage() );
			}
			
		}
		
		return lister();
	}
	
	public String supprimer(){
		String result = SUCCESS;
		
		if( !init() ){
			result = ERROR;
		} 
		else{
			
			try {
				serviceGestionPotager.supprimerPotager( id );
				
			} catch (DaoPotagerSuppressionException | DaoPotagerGetException e) {
				
				addActionError(e.getMessage());
				result = ERROR;
				
			} catch(Exception e){
				addActionError("Probleme avec idPotager: " + id );
				addActionError(e.getMessage() );
				e.printStackTrace();
				result = ERROR;
			}
			
		}

		return lister();
	}
	
	public String annuler(){
		String result = SUCCESS;
		
		if( !init() ){
			result = ERROR;
		}
		else{
			
			try {
				
				serviceGestionPotager.annuler();
				
			} catch (DaoPotagerAjoutException | DaoPotagerModificationException e) {
				addActionError(e.getMessage());
				result = ERROR;
			}
			
		}
		
		
		return lister();
	}
	
	public ArrayList<Potager> getPotagers() {
		return potagers;
	}
	public void setPotagers(ArrayList<Potager> potagers) {
		this.potagers = potagers;
	}
	public Potager getPotager() {
		return potager;
	}
	public void setPotager(Potager potager) {
		this.potager = potager;
	}

	public int getNombreAnnulations() {
		return serviceGestionPotager.getNombreAnnulations();
	}

	public int getId() {
		return id;
	}

	public void setId(int idPotager) {
		this.id = idPotager;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.httpRequest = request;
	}	

}
