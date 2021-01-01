package com.models;

public interface IMagazine {
	void ajtAbonne(IAbonne abonne);
	void sprAbonne(IAbonne abonne);
	void sprAbonne(String nom);
	void ajtAbonne();
	
	
	void notifyAbonnes();

}
