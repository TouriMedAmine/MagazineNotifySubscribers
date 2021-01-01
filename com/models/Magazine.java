package com.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Magazine implements IMagazine {
	
	public enum Etat{
		ADDED, REMOVED
	}
	List<IAbonne> abonnes;
	List<Numero> numeros;
	HashMap<Numero, Etat> nouveautes;
	
	public Magazine() {
		this.abonnes = new ArrayList<>();
		this.numeros = new ArrayList<>();
		this.nouveautes =new HashMap<>();
	}
	
	 

	public Magazine(List<IAbonne> abonnes) {
		super();
		this.abonnes = abonnes;
		this.numeros = new ArrayList<>();
		this.nouveautes =new HashMap<>();
	}

	

	public List<IAbonne> getAbonnes() {
		return abonnes;
	}



	public void setAbonnes(List<IAbonne> abonnes) {
		this.abonnes = abonnes;
	}



	public List<Numero> getNumeros() {
		return numeros;
	}
	
	


	public HashMap<Numero, Etat> getNouveautes() {
		return nouveautes;
	}



	// notify ***************************************
	public void setNumeros(List<Numero> numeros) {
		this.numeros = numeros;
		for(Numero numero : numeros) {
			this.nouveautes.put(numero, Etat.ADDED);
		}
		this.notifyAbonnes();
		this.nouveautes = new HashMap<>();
		
	}

	
	public void ajtNumero(Numero numero) {
		this.numeros.add(numero);
		this.nouveautes.put(numero, Etat.ADDED);
		this.notifyAbonnes();
		this.nouveautes = new HashMap<>();
	}

	
	public void sprNumero(Numero numero) {
		this.numeros.remove(numero);
		this.nouveautes.put(numero, Etat.REMOVED);
		this.notifyAbonnes();
		this.nouveautes = new HashMap<>();

	}
	
	@Override
	public void notifyAbonnes() {
		for(IAbonne abonne:this.abonnes) {
			abonne.update(this);
		}
		

	}
// ****************************************************

	@Override
	public void ajtAbonne(IAbonne abonne) {
		this.abonnes.add(abonne);
		System.out.println("l'abonne est ajouté");

	}

	@Override
	public void sprAbonne(String nom) {
		String[] vraiNom = nom.split(" ", 2);
		nom = vraiNom[0];
		System.out.println("le nom de l'abonné souhaiter de supprimer est : "+ nom);
		IAbonne abonneSup = null;
		
		for(IAbonne abonne: this.abonnes) {
			try {
				
				if ( ((AbonneType1)abonne).getNom().equals(nom)) {
					abonneSup = ((AbonneType1)abonne);
					
				}
			}
			catch(Exception e) {
				
			}
			
			try {
				if ( ((AbonneType2)abonne).getNom().equals(nom) ) {
					abonneSup = ((AbonneType2)abonne);
					
				}
			}
			catch(Exception e) {
				
			}
			
		}
		if(abonneSup !=null) {
			this.abonnes.remove(abonneSup);
			System.out.println("l'abonne : "+nom+" est supprimé");
		}

	}



	@Override
	public void sprAbonne(IAbonne abonne) {
		this.abonnes.remove(abonne);
		
	}



	@Override
	public void ajtAbonne() {
		Scanner sc = new Scanner(System.in);
		int type;
		String nom;
		
		System.out.println("Pour type 1 ecrivez 1 et Pour type 2 ecrivez 2 : ");
		type = sc.nextInt();
		sc.nextLine();
		if (type == 1) {
			System.out.println("nom de l'abonné : ");
			nom = sc.nextLine();
			AbonneType1 abonne = new AbonneType1(nom);
			this.ajtAbonne(abonne);
			
		}
		else if (type == 2) {
			System.out.println("nom de l'abonné : ");
			nom = sc.nextLine();
			AbonneType2 abonne = new AbonneType2(nom);
			this.ajtAbonne(abonne);

		}
		else {
			System.out.println("il n'y a que 2 types type1 et type2");
			
		}
		
	}



	

	

}
