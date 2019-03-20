package classification;
import java.util.ArrayList;
import java.util.HashSet;

import Jama.Matrix;

public class Kmeans {

	int[] classes;
	int[] tailles;
	Vecteur[] centres;
	
	int nbVecteurs;
	int dimension;
	int nbClasses;
		
	Matrix data;
	
	/*public Kmeans(Matrix donnees, int nombreClasses){
		
		this.nbClasses = nombreClasses;
		this.data = donnees;
		this.nbVecteurs = this.data.getRowDimension();
		this.dimension = this.data.getColumnDimension();
		this.classes = new int[this.nbVecteurs];
		this.centres = new Vecteur[this.nbClasses];
		this.tailles = new int[this.nbClasses];
		
		initialisationCentres();
		initialisationClasses();	
		calculCentresInitiaux();
		
		boolean changement = false;
		do {
			
			changement = false;
			for (int i = 0; i < this.nbVecteurs; i++) {
				System.out.println(getPartition());
				System.out.print("Vecteur " + i + " : classe " + this.classes[i] + " => ");
				if (this.tailles[this.classes[i]] > 1) {
					System.out.println("pas seul dans la classe");
					Vecteur vecteur = new Vecteur(this.data.getArray()[i]);
					int indiceMeilleureClasse = this.classes[i];
					double meilleureDeltaVariance = 0;
					for (int j = 0; j < this.nbClasses; j++) {
						if (j != this.classes[i]) {
							double delta = deltaVariance(vecteur, this.classes[i], j);
							System.out.println("\tDelta variance entre classes " + this.classes[i] + " et " + j + " = " + delta);
							if (delta < meilleureDeltaVariance) {
								indiceMeilleureClasse = j;
								meilleureDeltaVariance = delta;
							}
						}
					}
					System.out.print("Meilleure delta variance : classe " + indiceMeilleureClasse + " => ");
					if (indiceMeilleureClasse != this.classes[i]) {
						System.out.println("changement de classe");
						System.out.println();
						calculCentresApresChangement(i, this.classes[i], indiceMeilleureClasse);
						changement = true;
					} else {
						System.out.println("pas de changement de classe");
					}
				} else {
					System.out.println("seul dans la classe");
				}
				System.out.println();
			}
			
		} while (changement);
	}
	
	private void initialisationCentres() {
		
		for (int i = 0; i < this.nbClasses; i++) {
			int n;
			do {
				n = (int)(Math.random() * this.nbVecteurs);
			}
			while (estCentre(n));
			this.centres[i] = vecteur(n);
		}
		
		System.out.println("Points centres :");
		for (int i = 0; i < this.nbClasses; i++) {
			System.out.println("\tClasse " + i + " : " + this.centres[i]);
		}
		System.out.println();
	}
	
	private void initialisationClasses() {
		
		for (int i = 0; i < this.nbVecteurs; i++) {
			this.classes[i] = centreLePlusProche(new Vecteur(this.data.getArray()[i]));
		}
		
		System.out.println("Index classes :");
		for (int i = 0; i < this.nbVecteurs; i++) {
			if (i == 0) {
				System.out.print("\t" + this.classes[i] + ", ");
			} else if (i == this.nbVecteurs - 1) {
				System.out.println(this.classes[i]);
			} else {
				System.out.print(this.classes[i] + ", ");
			}
		}
		System.out.println();
	}
	
	private int centreLePlusProche(Vecteur vecteur){
		
		int nbCentre = this.centres.length;
		int classe = 0;
		double min = Vecteur.distance(vecteur, this.centres[0]);
		
		for (int i = 1; i < nbCentre; i++) {
			if (Vecteur.distance(vecteur, this.centres[i]) < min) {
				classe = i;
				min = Vecteur.distance(vecteur, this.centres[i]);
			}
		}
		
		return classe;
	}

	private void calculCentresInitiaux(){
		
		this.centres = new Vecteur[this.nbClasses];
		for (int i = 0; i < this.nbClasses; i++) {
			this.centres[i] = new Vecteur(this.dimension);
		}
		int[] nb = new int[this.nbClasses];
		for (int i = 0; i < this.nbVecteurs; i++) {
			this.centres[this.classes[i]].plus(vecteur(i));
			nb[this.classes[i]]++;
			this.tailles[this.classes[i]]++;
		}
		for (int i = 0; i < this.nbClasses; i++) {
			if (nb[this.classes[i]] == 0) {
				throw new Error("Cas dégénéré : classe " + i + " vide.");
			}
			this.centres[i].div(nb[i]);
		}
		
		System.out.println("Barycentres :");
		for (int i = 0; i < this.nbClasses; i++) {
			System.out.println("\tClasse " + i + " : " + this.centres[i]);
		}
		System.out.println();
	}
	
	private double deltaVariance(Vecteur v, int classeAvant, int classeApres){
		return (double)(this.tailles[classeApres])/(double)(this.tailles[classeApres]+1)*Vecteur.distanceCarre(this.centres[classeApres], v)
				- (double)this.tailles[classeAvant]/(double)(this.tailles[classeAvant]-1)*Vecteur.distanceCarre(this.centres[classeAvant], v);
	}
	
	private void calculCentresApresChangement(int indexVecteur, int indexClasseAvant, int indexClasseApres){
		
		this.centres[indexClasseAvant] = this.centres[indexClasseAvant].mult(this.tailles[indexClasseAvant]).moins(new Vecteur(this.data.getArray()[indexVecteur])).div(this.tailles[indexClasseAvant]-1);
		this.centres[indexClasseApres] = this.centres[indexClasseApres].mult(this.tailles[indexClasseApres]).plus(new Vecteur(this.data.getArray()[indexVecteur])).div(this.tailles[indexClasseApres]+1);
		
		this.classes[indexVecteur] = indexClasseApres;
		this.tailles[indexClasseAvant]--;
		this.tailles[indexClasseApres]++;
		
		System.out.println("Barycentres :");
		for (int i = 0; i < this.nbClasses; i++) {
			System.out.println("\tClasse " + i + " : " + this.centres[i]);
		}
	}*/

	public int[] getClasses(){
		return this.classes;
	}
	
	public int[] getTailles() {
		return this.tailles;
	}

	public ArrayList<HashSet<Integer>> getPartition(){ 
		ArrayList<HashSet<Integer>> r = new ArrayList<HashSet<Integer>>();
		for(int i=0;i<this.nbClasses;i++) r.add(new HashSet<Integer>());
		for(int i=0;i<this.classes.length;i++){
			r.get(this.classes[i]).add(i);
		}
		return r;
	}
	
	public boolean estCentre(int n){
		Vecteur vect = vecteur(n);
		for(int i=0;i<this.nbClasses;i++){
			if(vect.equals(this.centres[i])) return true;
		}
		return false;
	}
	
	public int[] getCouleurClasse(int k){
		int[] res = new int[this.dimension];
		for(int i=0;i<this.dimension;i++){
			res[i] = (int)this.centres[k].get(i);
		}
		return res;
	}
	
	public Vecteur vecteur(int n){
		double[] result = new double[this.dimension];
		for(int i=0;i<this.dimension;i++){
			result[i]=(double)this.data.get(n, i);
		}
		return new Vecteur(result);
	}
	
	public Kmeans(Matrix donnees, int nombreClasses){
		
		this.nbClasses = nombreClasses;
		this.data = donnees;
		this.nbVecteurs = this.data.getRowDimension();
		this.dimension = this.data.getColumnDimension();
		this.classes = new int[this.nbVecteurs];
		this.centres = new Vecteur[this.nbClasses];
		this.tailles = new int[this.nbClasses];
		
		initialisationCentres();
		initialisationClasses();	
		calculCentresInitiaux();
		
		boolean changement = false;
		do {
			
			changement = false;
			for (int i = 0; i < this.nbVecteurs; i++) {
				if (this.tailles[this.classes[i]] > 1) {
					Vecteur vecteur = new Vecteur(this.data.getArray()[i]);
					int indiceMeilleureClasse = this.classes[i];
					double meilleureDeltaVariance = 0;
					for (int j = 0; j < this.nbClasses; j++) {
						if (j != this.classes[i]) {
							double delta = deltaVariance(vecteur, this.classes[i], j);
							if (delta < meilleureDeltaVariance) {
								indiceMeilleureClasse = j;
								meilleureDeltaVariance = delta;
							}
						}
					}
					if (indiceMeilleureClasse != this.classes[i]) {
						calculCentresApresChangement(i, this.classes[i], indiceMeilleureClasse);
						changement = true;
					}
				}
			}
			
		} while (changement);
	}
	
	private void initialisationCentres() {
		
		for (int i = 0; i < this.nbClasses; i++) {
			int n;
			do {
				n = (int)(Math.random() * this.nbVecteurs);
			}
			while (estCentre(n));
			this.centres[i] = vecteur(n);
		}
	}
	
	private void initialisationClasses() {
		
		for (int i = 0; i < this.nbVecteurs; i++) {
			this.classes[i] = centreLePlusProche(new Vecteur(this.data.getArray()[i]));
		}
	}
	
	private int centreLePlusProche(Vecteur vecteur){
		
		int nbCentre = this.centres.length;
		int classe = 0;
		double min = Vecteur.distance(vecteur, this.centres[0]);
		
		for (int i = 1; i < nbCentre; i++) {
			if (Vecteur.distance(vecteur, this.centres[i]) < min) {
				classe = i;
				min = Vecteur.distance(vecteur, this.centres[i]);
			}
		}
		
		return classe;
	}

	private void calculCentresInitiaux(){
		
		this.centres = new Vecteur[this.nbClasses];
		for (int i = 0; i < this.nbClasses; i++) {
			this.centres[i] = new Vecteur(this.dimension);
		}
		int[] nb = new int[this.nbClasses];
		for (int i = 0; i < this.nbVecteurs; i++) {
			this.centres[this.classes[i]].plus(vecteur(i));
			nb[this.classes[i]]++;
			this.tailles[this.classes[i]]++;
		}
		for (int i = 0; i < this.nbClasses; i++) {
			if (nb[this.classes[i]] == 0) {
				throw new Error("Cas dégénéré : classe " + i + " vide.");
			}
			this.centres[i].div(nb[i]);
		}
	}
	
	private double deltaVariance(Vecteur v, int classeAvant, int classeApres){
		return (double)(this.tailles[classeApres])/(double)(this.tailles[classeApres]+1)*Vecteur.distanceCarre(this.centres[classeApres], v)
				- (double)this.tailles[classeAvant]/(double)(this.tailles[classeAvant]-1)*Vecteur.distanceCarre(this.centres[classeAvant], v);
	}
	
	private void calculCentresApresChangement(int indexVecteur, int indexClasseAvant, int indexClasseApres){
		
		this.centres[indexClasseAvant] = this.centres[indexClasseAvant].mult(this.tailles[indexClasseAvant]).moins(new Vecteur(this.data.getArray()[indexVecteur])).div(this.tailles[indexClasseAvant]-1);
		this.centres[indexClasseApres] = this.centres[indexClasseApres].mult(this.tailles[indexClasseApres]).plus(new Vecteur(this.data.getArray()[indexVecteur])).div(this.tailles[indexClasseApres]+1);
		
		this.classes[indexVecteur] = indexClasseApres;
		this.tailles[indexClasseAvant]--;
		this.tailles[indexClasseApres]++;
	}
}
