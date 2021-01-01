package com.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.models.AbonneType1;
import com.models.AbonneType2;
import com.models.Magazine;
import com.models.Numero;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int faire;
		int type;
		String nom;
		
		// instanciation des objets ****************
		Magazine magazine = new Magazine();
		AbonneType1 abonne1 = new AbonneType1("amine");
		AbonneType2 abonne2 = new AbonneType2("yassine");
		Numero numero1 = new Numero("numero 1");
		Numero numero3 = new Numero("numero 3");
		Numero numero4 = new Numero("numero 4");
		Numero numero5 = new Numero("numero 5");
		Numero numero6 = new Numero("numero 6");
		// *****************************************
		
		// l'ajout des abonnées ********************
		
		magazine.ajtAbonne(abonne1);
		magazine.ajtAbonne(abonne2);
		
		// *****************************************
		
		// modification de la liste des abonnes
		System.out.println("Pour ajouter un abonne écrivez 1 :");
		faire = sc.nextInt();
		sc.nextLine();
		while(faire == 1) {
			magazine.ajtAbonne();
			System.out.println("Pour ajouter un autre abonne écrivez 1 :");
			faire = sc.nextInt();
			sc.nextLine();
		}
		
		
		System.out.println("Pour supprime un abonne écrivez 1 :");
		faire = sc.nextInt();
		sc.nextLine();
		
		while(faire == 1) {
			System.out.println("le nom d'abonne à suprimer : ");
			nom = sc.nextLine();
			magazine.sprAbonne(nom);
			System.out.println("Pour suprimer un autre abonne écrivez 1 :");
			faire = sc.nextInt();
			sc.nextLine();
		}
		// *****************************************
		
		// l'ajout des numéros *********************
		magazine.ajtNumero(numero1);
	
		// *****************************************
		
		// la supression des numéros ***************
		magazine.sprNumero(numero1);
		// *****************************************
		
		// Ajouter un ensemble de numeros d'un seul coup
		ArrayList<Numero> numeros = new ArrayList<>();
		numeros.add(numero3);
		numeros.add(numero4);
		numeros.add(numero5);
		numeros.add(numero6);
		magazine.setNumeros(numeros);
		
	}

}
