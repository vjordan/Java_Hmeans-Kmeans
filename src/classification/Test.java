package classification;
import java.io.IOException;

import Jama.Matrix;

public class Test {
	
	public static void main(String[] args) throws IOException {
		
		int nbClasses = 15;
		String cheminImage = "images/monzoo.jpg";
		
		/*Image imageHmeans = new Image("test Hmeans",cheminImage);
		
		long startTimeHmeans = System.currentTimeMillis();
		imageHmeans.hmeans(nbClasses);
		long endTimeHmeans = System.currentTimeMillis();
		
		imageHmeans.display();
		imageHmeans.display3D();
		
		System.out.println("Temps d'exécution Hmeans : " + (endTimeHmeans - startTimeHmeans) + " ms");*/
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Image imageKmeans = new Image("test Kmeans",cheminImage);
		
		long startTimeKmeans = System.currentTimeMillis();
		imageKmeans.kmeans(nbClasses);
		long endTimeKmeans = System.currentTimeMillis();
		
		imageKmeans.display();
		imageKmeans.display3D();
		
		System.out.println("Temps d'exécution Kmeans : " + (endTimeKmeans - startTimeKmeans) + " ms");
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/*Vecteur[] nuage = new Vecteur[20];
		nuage[0]=new Vecteur(19,4);
		nuage[1]=new Vecteur(12,15);
		nuage[2]=new Vecteur(15,11);
		nuage[3]=new Vecteur(2,17);
		nuage[4]=new Vecteur(9,18);
		nuage[5]=new Vecteur(18,3);
		nuage[6]=new Vecteur(5,9);
		nuage[7]=new Vecteur(16,10);
		nuage[8]=new Vecteur(6,18);
		nuage[9]=new Vecteur(17,19);
		nuage[10]=new Vecteur(11,2);
		nuage[11]=new Vecteur(18,15);
		nuage[12]=new Vecteur(8,3);
		nuage[13]=new Vecteur(12,8);
		nuage[14]=new Vecteur(8,13);
		nuage[15]=new Vecteur(2,2);
		nuage[16]=new Vecteur(19,11);
		nuage[17]=new Vecteur(5,15);
		nuage[18]=new Vecteur(2,6);
		nuage[19]=new Vecteur(9,8);
		
		int nbClasses = 7;
		int nbTours = 1000;
		
		double meilleurResultatH = -1;
		Hmeans meilleurH = null;
		double pireResultatH = -1;
		Hmeans pireH = null;
		long tempsExecH;
		
		int compteurTours = 0;
		
		long startTime = System.currentTimeMillis();
		
		do {
			
			if (compteurTours != 0) {
				System.out.println();
			}
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println("                      TOUR " + (compteurTours+1) + "                     ");
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println();
			
			Hmeans h = new Hmeans(matrice(nuage), nbClasses);
			
			System.out.println("Résultat du tour :");
			System.out.println(h.getPartition());
			
			int[][] classes = constitutionClassesHmeans(h, nbClasses);
			double inertie = inertie(nuage, classes);
			
			System.out.println("Inertie = " + inertie);
			
			if (meilleurResultatH == -1) {
				meilleurResultatH = inertie;
				pireResultatH = inertie;
				meilleurH = h;
				pireH = h;
			} else if (inertie < meilleurResultatH) {
				meilleurResultatH = inertie;
				meilleurH = h;
			} else if (inertie > pireResultatH){
				pireResultatH = inertie;
				pireH = h;
			}
			
			compteurTours++;
			
		} while (compteurTours < nbTours);
		
		long endTime = System.currentTimeMillis();
		tempsExecH = endTime - startTime;
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		double meilleurResultatK = -1;
		Kmeans meilleurK = null;
		double pireResultatK = -1;
		Kmeans pireK = null;
		long tempsExecK = 0;
		
		compteurTours = 0;
		
		startTime = System.currentTimeMillis();
		
		do {
			
			System.out.println();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println("                      TOUR " + (compteurTours+1) + "                     ");
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println();
			
			Kmeans k = new Kmeans(matrice(nuage), nbClasses);
			
			System.out.println("Résultat du tour :");
			System.out.println(k.getPartition());
			
			int[][] classes = constitutionClassesKmeans(k, nbClasses);
			double inertie = inertie(nuage, classes);
			
			System.out.println("Inertie = " + inertie);
			
			if (meilleurResultatK == -1) {
				meilleurResultatK = inertie;
				pireResultatK = inertie;
				meilleurK = k;
				pireK = k;
			} else if (inertie < meilleurResultatK) {
				meilleurResultatK = inertie;
				meilleurK = k;
			} else if (inertie > pireResultatK){
				pireResultatK = inertie;
				pireK = k;
			}
			
			compteurTours++;
			
		} while (compteurTours < nbTours);
		
		endTime = System.currentTimeMillis();
		tempsExecK = endTime - startTime;
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println();
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("                     RESULTAT                     ");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println();
		
		System.out.println("Meilleure inertie avec Hmeans = " + meilleurResultatH);
		System.out.println(meilleurH.getPartition());
		System.out.println();
		
		System.out.println("Pire inertie avec Hmeans = " + pireResultatH);
		System.out.println(pireH.getPartition());
		System.out.println();
		
		System.out.println("\tTemps d'exécution avec Hmeans : " + tempsExecH + " ms");
		System.out.println();
		
		System.out.println("Meilleure inertie avec Kmeans = " + meilleurResultatK);
		System.out.println(meilleurK.getPartition());
		System.out.println();
		
		System.out.println("Pire inertie avec Kmeans = " + pireResultatK);
		System.out.println(pireK.getPartition());
		System.out.println();
		
		System.out.println("\tTemps d'exécution avec Kmeans : " + tempsExecK + " ms");*/
	}

	public static double inertie(Vecteur[] vs) {
		
		double inertie = 0;
		int tailleVecteurs = vs[0].length;
		double[] barycentre = new double[tailleVecteurs];
		
		for (Vecteur vecteur : vs) {
			for (int i = 0; i < tailleVecteurs; i++) {
				barycentre[i] += vecteur.get(i);
			}
		}
		for (int i = 0; i < tailleVecteurs; i++) {
			barycentre[i] /= vs.length;
		}
		
		for (Vecteur vecteur : vs) {
			double distanceCarre = Vecteur.distanceCarre(vecteur, new Vecteur(barycentre));
			inertie += distanceCarre;
		}
		
		return inertie;
	}
	
	public static double inertie(Vecteur[] vs, int[][] classes) {
		
		double inertie = 0;
		
		for (int [] classe : classes) {
			Vecteur[] vecteurs = new Vecteur[classe.length];
			for (int i = 0; i < classe.length; i++) {
				int pos = classe[i];
				vecteurs[i] = vs[pos];
			}
			inertie += inertie(vecteurs);
		}
		
		return inertie;
	}
	
	public static int[][] constitutionClassesHmeans(Hmeans h, int nbClasses) {
		
		int[][] constitutionClasses = new int[nbClasses][];
		
		int[] indexClasses = h.getClasses();
		for (int i = 0; i < nbClasses; i++) {
			int[] indexClasse = new int[h.getTailleClasses()[i]];
			int compteur = 0;
			for (int j = 0; j < h.getClasses().length; j++) {
				if (i == indexClasses[j]) {
					indexClasse[compteur] = j;
					compteur++;
				}
			}
			constitutionClasses[i] = indexClasse;
		}
		
		return constitutionClasses;
	}
	
	public static int[][] constitutionClassesKmeans(Kmeans k, int nbClasses) {
		
		int[][] constitutionClasses = new int[nbClasses][];
		
		int[] indexClasses = k.getClasses();
		for (int i = 0; i < nbClasses; i++) {
			int[] indexClasse = new int[k.getTailles()[i]];
			int compteur = 0;
			for (int j = 0; j < k.getClasses().length; j++) {
				if (i == indexClasses[j]) {
					indexClasse[compteur] = j;
					compteur++;
				}
			}
			constitutionClasses[i] = indexClasse;
		}
		
		return constitutionClasses;
	}
	
	public static Matrix matrice(Vecteur[] vs){
		double[][] c = new double[vs.length][vs[0].length];
		int i=0;
		for(Vecteur v:vs)
			c[i++]=v.toDouble();
		return new Matrix(c);		
	}
}
