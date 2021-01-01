package com.models;

import java.util.Iterator;
import java.util.Map.Entry;

import com.models.Magazine.Etat;

public class AbonneType2 implements IAbonne {
	
	String nom;
	
	public AbonneType2(String nom) {
		this.nom = nom;
	}
	
	

	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	@Override
	public void update(IMagazine magazine) {
		Iterator iterator = ((Magazine)magazine).getNouveautes().entrySet().iterator();
		System.out.println("Abonné type 2 "+nom+" update");
		while(iterator.hasNext()) {
			Entry<Numero, Etat> entry = (Entry<Numero, Etat>) iterator.next();
			System.out.println("le numéro: "+entry.getKey().description
            + " est : " + entry.getValue());
		}
		System.out.println("");
		System.out.println("*************************");
		System.out.println("");
		

	}

}
