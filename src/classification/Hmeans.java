package classification;
import java.util.*;
import Jama.Matrix;

public class Hmeans {

	Matrix donnees;
	int[] classes;
	public Vecteur[] barycentres;

	int nombreVecteurs;
	int nombreClasses;
	int dimension;
	
	int[] tailleClasses;
	
	/*public Hmeans(Matrix donnees, int nombreClasses){
		
		this.nombreClasses = nombreClasses;
		this.donnees = donnees;
		this.nombreVecteurs = this.donnees.getRowDimension();
		this.dimension = this.donnees.getColumnDimension();
		this.classes = new int[this.nombreVecteurs];
		this.barycentres = new Vecteur[this.nombreClasses];
		
		initialisationClasses();
		
		boolean changement = false;
		do {
			
			calculBarycentres();
			
			changement = false;
			for (int i = 0; i < this.nombreVecteurs; i++) {
				System.out.println(getPartition());
				System.out.print("Vecteur " + i + " : classe " + this.classes[i] + " => ");
				if (this.tailleClasses[this.classes[i]] > 1) {
					System.out.println("pas seul dans la classe");
					Vecteur vecteur = new Vecteur(this.donnees.getArray()[i]);
					int indiceMeilleureClasse = calculCentreLePlusProche(vecteur);
					if (indiceMeilleureClasse != this.classes[i]) {
						this.tailleClasses[this.classes[i]]--;
						this.tailleClasses[indiceMeilleureClasse]++;
						this.classes[i] = indiceMeilleureClasse;
						changement = true;
						System.out.println("changement de classe");
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
	
	private void initialisationClasses() {
		
		Random r = new Random();
		
		ArrayList<Integer> listeIndexVecteurs = new ArrayList<Integer>();
		for (int i = 0; i < this.nombreVecteurs; i++) {
			listeIndexVecteurs.add(i);
		}
		
		for (int i = 0; i < this.nombreClasses; i++) {
			int indexChoisi = r.nextInt(listeIndexVecteurs.size());
			if (i == 0) {
				this.classes[listeIndexVecteurs.get(indexChoisi)] = -1;
			} else {
				this.classes[listeIndexVecteurs.get(indexChoisi)] = i;
			}
			listeIndexVecteurs.remove(indexChoisi);
		}
		
		System.out.println("Index classes :");
		for (int i = 0; i < this.nombreVecteurs; i++) {
			if (this.classes[i] == 0) {
				this.classes[i] = r.nextInt(this.nombreClasses);
			} else if (this.classes[i] == -1) {
				this.classes[i] = 0;
			}
			if (i == 0) {
				System.out.print("\t" + this.classes[i] + ", ");
			} else if (i == this.nombreVecteurs - 1) {
				System.out.println(this.classes[i]);
			} else {
				System.out.print(this.classes[i] + ", ");
			}
		}
		System.out.println();
	}

	private void calculBarycentres(){
		
		this.tailleClasses = new int[this.nombreClasses];
		
		for (int i = 0; i < this.nombreClasses; i++) {
			double[] barycentre = new double[this.dimension];
			for (int j = 0; j < this.nombreVecteurs; j++) {
				if (i == this.classes[j]) {
					this.tailleClasses[this.classes[j]]++;
					for (int k = 0; k < this.dimension; k++) {
						barycentre[k] += this.donnees.get(j, k);
					}
				}
			}
			for (int j = 0; j < this.dimension; j++) {
				barycentre[j] /= this.tailleClasses[i];
			}
			this.barycentres[i] = new Vecteur(barycentre);
		}
		
		System.out.println("Barycentres :");
		for (int i = 0; i < this.nombreClasses; i++) {
			System.out.println("\tClasse " + i + " : " + this.barycentres[i]);
		}
		System.out.println();
	}
	
	private int calculCentreLePlusProche(Vecteur vecteur){
		
		int posCentreLePlusProche = -1;
		double meilleureDistance = -1;
		
		for (int i = 0; i < this.nombreClasses; i++) {
			double distance = Vecteur.distance(vecteur, this.barycentres[i]);
			System.out.println("\tDistance avec barycentre " + i + " = " + distance);
			if (meilleureDistance == -1 || distance < meilleureDistance) {
				meilleureDistance = distance;
				posCentreLePlusProche = i;
			}
		}
		
		System.out.print("Meilleure distance : classe " + posCentreLePlusProche + " => ");
		
		return posCentreLePlusProche;
	}*/
	
	public int[] getClasses(){
		return this.classes;
	}

	public int[] getTailleClasses() {
		return this.tailleClasses;
	}

	public ArrayList<HashSet<Integer>> getPartition(){ 
		ArrayList<HashSet<Integer>> r = new ArrayList<HashSet<Integer>>();
		for(int i=0;i<this.nombreClasses;i++) r.add(new HashSet<Integer>());
		for(int i=0;i<this.classes.length;i++){
			r.get(this.classes[i]).add(i);
		}
		return r;
	}
	
	public boolean estCentre(int n){
		Vecteur vect = vecteur(n);
		for(int i=0;i<this.nombreClasses;i++){
			if(vect.equals(this.barycentres[i])) return true;
		}
		return false;
	}
	
	public int[] getCouleurClasse(int k){
		int[] res = new int[this.dimension];
		for(int i=0;i<this.dimension;i++){
			res[i] = (int)this.barycentres[k].get(i);
		}
		return res;
	}
	
	public Vecteur vecteur(int n){
		double[] result = new double[this.dimension];
		for(int i=0;i<this.dimension;i++){
			result[i]=(double)this.donnees.get(n, i);
		}
		return new Vecteur(result);
	}
	
	public Hmeans(Matrix donnees, int nombreClasses){
		
		this.nombreClasses = nombreClasses;
		this.donnees = donnees;
		this.nombreVecteurs = this.donnees.getRowDimension();
		this.dimension = this.donnees.getColumnDimension();
		this.classes = new int[this.nombreVecteurs];
		this.barycentres = new Vecteur[this.nombreClasses];
		
		initialisationClasses();
		
		boolean changement = false;
		do {
			
			calculBarycentres();
			
			changement = false;
			for (int i = 0; i < this.nombreVecteurs; i++) {
				if (this.tailleClasses[this.classes[i]] > 1) {
					Vecteur vecteur = new Vecteur(this.donnees.getArray()[i]);
					int indiceMeilleureClasse = calculCentreLePlusProche(vecteur);
					if (indiceMeilleureClasse != this.classes[i]) {
						this.tailleClasses[this.classes[i]]--;
						this.tailleClasses[indiceMeilleureClasse]++;
						this.classes[i] = indiceMeilleureClasse;
						changement = true;
					}
				}
			}
			
		} while (changement);
	}
	
	private void initialisationClasses() {
		
		Random r = new Random();
		
		ArrayList<Integer> listeIndexVecteurs = new ArrayList<Integer>();
		for (int i = 0; i < this.nombreVecteurs; i++) {
			listeIndexVecteurs.add(i);
		}
		
		for (int i = 0; i < this.nombreClasses; i++) {
			int indexChoisi = r.nextInt(listeIndexVecteurs.size());
			if (i == 0) {
				this.classes[listeIndexVecteurs.get(indexChoisi)] = -1;
			} else {
				this.classes[listeIndexVecteurs.get(indexChoisi)] = i;
			}
			listeIndexVecteurs.remove(indexChoisi);
		}
		
		for (int i = 0; i < this.nombreVecteurs; i++) {
			if (this.classes[i] == 0) {
				this.classes[i] = r.nextInt(this.nombreClasses);
			} else if (this.classes[i] == -1) {
				this.classes[i] = 0;
			}
		}
	}

	private void calculBarycentres(){
		
		this.tailleClasses = new int[this.nombreClasses];
		
		for (int i = 0; i < this.nombreClasses; i++) {
			double[] barycentre = new double[this.dimension];
			for (int j = 0; j < this.nombreVecteurs; j++) {
				if (i == this.classes[j]) {
					this.tailleClasses[this.classes[j]]++;
					for (int k = 0; k < this.dimension; k++) {
						barycentre[k] += this.donnees.get(j, k);
					}
				}
			}
			for (int j = 0; j < this.dimension; j++) {
				barycentre[j] /= this.tailleClasses[i];
			}
			this.barycentres[i] = new Vecteur(barycentre);
		}
	}
	
	private int calculCentreLePlusProche(Vecteur vecteur){
		
		int posCentreLePlusProche = -1;
		double meilleureDistance = -1;
		
		for (int i = 0; i < this.nombreClasses; i++) {
			double distance = Vecteur.distance(vecteur, this.barycentres[i]);
			if (meilleureDistance == -1 || distance < meilleureDistance) {
				meilleureDistance = distance;
				posCentreLePlusProche = i;
			}
		}
		
		return posCentreLePlusProche;
	}
}
