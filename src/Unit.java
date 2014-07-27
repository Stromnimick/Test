import java.util.Random;




public class Unit {

	String name; // Name der Einheit
	String race; // Rasse der Einheit
	int number;	// Anzahl der Modelle in einer Einheit
	int unit; // Einheitenstärke pro Modell
	int points;  
	int width; // Breite der Einheit
	int ranks; // Glieder des Regiments
	int movement; // Bewegungsreichweite der Einheit
	int weaponSkill; // Kampffähigkeiten im Nahkampf
	int ballisticSkill; // Kampffähigkeiten im Fernkampf
	int strength; // Stärke der Angriffe
	int toughness; // Widerstand gegen Verwundungen
	int will; // Lebenspunkte bis ein Modell entfernt wird
	int initiative; // Bestimmt die Reihenfolge der Attacken
	int attacks; // Anzahl der Attacken
	int leadership; // Moralwert für Psychologietests
	int armourSave; // Rüstungswurf gegen erfolgreiche Verwundungen
	int wardSave; // Rettungswurf nach erfolglosem Rüstungswurf 
	int magicAbility; // Magiestufe zum Zaubern
	int unitAttacks;
	int unitpoints = points*number;
	boolean hasShield;
	boolean has2HandWeapon;
	protected boolean strikeFirst;
	protected boolean strikeLast;
	boolean champion;
	boolean musican;
	boolean banner;
	

	
	
	public int hit(int ews){ 		// ews = Kampfgeschick des Gegners
		int dicetohit; 				// was muss gewürfelt werden um einen Treffer zu erzielen?
		int hits=0;					// Anzahl der zugefügten Verwundungen
		int attacks;
		if (champion)
			attacks = width*2+1;
		else
			attacks = width*2;
		
		if(2*weaponSkill<ews) 		// ist das Kampfgeschick des Gegners mehr als doppelt so hoch, dann auf 5
			dicetohit = 5;
		else if (weaponSkill>ews)	// ist das Kampfgeschick des Gegners kleiner, dann auf 3
			dicetohit = 3;
		else						// sonst auf 4
			dicetohit = 4;
		
		System.out.println("Es werden " + attacks + " Attacken ausgeführt."); // die erste und zweite Reihe können kämpfen
		System.out.println("Kampfgeschick " + weaponSkill + " gegen Kampfgeschick " + ews + " bedeutet, dass mindestens eine " + dicetohit + " zum Treffen benötigt wird.");
		
		Random dice = new Random();
		for (int i = 0; i < attacks; i++){ 	// so oft Würfel wie Modelle im ersten und zweiten Glied
			int roll = dice.nextInt(6) + 1; // einen W6 werfen (gibt 0-5 zurück, deshalb die +1)
//			System.out.println(roll);		// Würfelergebnisse anzeigen
			if (roll>dicetohit)				// kein Treffer
				hits = hits+1;			// Treffer
		}
		if (hits==0)						// Ausgabe wenn kein Treffer
			System.out.println("Den " + name +"n gelangen bei " + attacks + " Attacken kein Treffer.");
		else if (hits==width*2)			// Ausgabe wenn alles Treffer
			System.out.println("Den " + name +"n trafen ihren Gegner mit jeder ihrer Attacken.");
		else System.out.println("Den " + name +"n gelangen bei " + attacks + " Attacken " + hits + " Treffer."); // sonstige Ausgabe
			
		return hits;				// wounds zurückgeben um sie bei wound() zu nutzen
	}

	
	public int hit2(int eweaponSkill, int willlost){ // Methode für den Gegenschlag
		int dicetohit; 				// was muss gewürfelt werden um einen Treffer zu erzielen?
		int hits=0;					// Anzahl der zugefügten Verwundungen
		int attacks;
		if (champion)
			attacks = width*2+1;
		else
			attacks = width*2;
		attacks = attacks-willlost;
		
		if(2*weaponSkill<eweaponSkill) 		// ist das Kampfgeschick des Gegners mehr als doppelt so hoch, dann auf 5
			dicetohit = 5;
		else if (weaponSkill>eweaponSkill)	// ist das Kampfgeschick des Gegners kleiner, dann auf 3
			dicetohit = 3;
		else						// sonst auf 4
			dicetohit = 4;
		
		System.out.println("Es werden " + attacks + " Attacken ausgeführt."); // die erste und zweite Reihe können kämpfen
		System.out.println("Kampfgeschick " + weaponSkill + " gegen Kampfgeschick " + eweaponSkill + " bedeutet, dass mindestens eine " + dicetohit + " zum Treffen benötigt wird.");
		
		Random dice = new Random();
		for (int i = 0; i < attacks; i++){ 	// so oft Würfel wie Modelle im ersten und zweiten Glied
			int roll = dice.nextInt(6) + 1; // einen W6 werfen (gibt 0-5 zurück, deshalb die +1)
//			System.out.println(roll);		// Würfelergebnisse anzeigen
			if (roll>dicetohit)				// kein Treffer
				hits = hits+1;			// Treffer
		}
		if (hits==0)						// Ausgabe wenn kein Treffer
			System.out.println("Den " + name +"n gelangen bei " + attacks + " Attacken kein Treffer.");
		else if (hits==width*2)			// Ausgabe wenn alles Treffer
			System.out.println("Den " + name +"n trafen ihren Gegner mit jeder ihrer Attacken.");
		else System.out.println("Den " + name +"n gelangen bei " + attacks + " Attacken " + hits + " Treffer."); // sonstige Ausgabe
			
		return hits;				// wounds zurückgeben um sie bei wound() zu nutzen
	}
	
	
	public int wound(int hits, int etoughness){ // hits = Anzahl der Treffer, et = Widerstand des Ziels 
		if (hits==0)
			return 0;
		else{
			int dicetowound;			// was muss gewürfelt werden um eine Verwundung zu erzielen?
			int wounds = 0;				// Anzahl der Rüstungswürfe, die abgelegt werden müssen
		
			if(etoughness>strength+1)			// ist der Widerstand um mindestens 2 größer als die Stärke, dann auf 6
				dicetowound = 6;
			else if(etoughness>strength)		// ist der Widerstand nicht mindestens um 2 größer, aber größer, dann auf 5
				dicetowound = 5;
			else if (strength==etoughness)		// ist der Widerstand gleich der Stärke, dann auf 4
				dicetowound = 4;
			else if (strength==etoughness+1)	// ist die Stärke genau um 1 größer als der Widerstand, dann auf 3
				dicetowound = 3;
			else						// sonst auf 2
				dicetowound = 2;
		
			System.out.println("Stärke " + strength + " gegen Widerstand " + etoughness + " bedeutet, dass mindestens eine " + dicetowound + " zum Verwunden benötigt wird.");
		
			Random dice = new Random();
			for (int i = 0; i < hits; i++){	
				int roll = dice.nextInt(6) + 1;
//				System.out.println(roll);
				if (roll>dicetowound)
					wounds = wounds+1;
			}
			if (wounds==0)
				System.out.println("Den " + name + "n gelang bei " + hits + " Treffern keine Verwundung bei ihrem Gegner.");
			else if (wounds==hits)
				System.out.println("Die " + name + " verwundeten ihren Gegner mit jedem ihrer Treffer.");
			else System.out.println("Die " + name + " verwundeten bei " + hits + " Treffern ihren Gegner " + wounds + " Mal.");
		
			return wounds;
		}
	}
	
	public int armour(int wounds, int earmoursave){ //wounds = Anzahl der Verwundungen, ea = Rüstungswurf des Gegners
	
		if (wounds==0)
			return 0;
		else{
			int armourmodifier = strength-3;
			int armourlast = earmoursave;
			int armourmiss = 0;
			if (armourmodifier<1){
				System.out.println("Durch Stärke " + strength + " wird die Rüstung des Gegners nicht modifiziert. Der Gegner hat einen Rüstungswurf von " + armourlast + " .");
				armourmodifier=0;
			}
			else{
				armourlast = earmoursave+armourmodifier;
				System.out.println("Stärke " + strength + " bedeutet, dass der Rüstungswurf des Gegners von " + earmoursave + " auf " + armourlast + " modifiziert wird.");
			}

			if(armourlast>6){
				System.out.println("Der Gegner besitzt keinen Rüstungswurf (mehr).");
				armourmiss = wounds;
			}
			else{
				Random dice = new Random();
				for (int i = 0; i < wounds; i++){
					int roll = dice.nextInt(6) + 1;
//					System.out.println(roll);
					if (roll<armourlast)
						armourmiss = armourmiss+1;
				}	
			if(armourmiss==0)
				System.out.println("Der Gegner verliert keine Lebenspunkte, da es ihm gelang alle Rüstungswürfe erfolgreich abzulegen.");
			else if (armourmiss==wounds)
				System.out.println("Der Gegner legte keinen Rüstungswurf erfolgreich ab.");
			else System.out.println("Der Gegner legte " + (wounds-armourmiss) + " Rüstungswürfe erfolgreich ab.");
			}
			return armourmiss;
		}
	}
	
	public int ward(int armourmiss, int ewardsave){ // armourmiss = Anzahl der abzulegenden Rettungswürfe, ew = Rettungswurf des Gegners 
		if (armourmiss==0)
			return 0;
		else{
		int willlost = 0;

		if(ewardsave>6){
			System.out.println("Der Gegner besitzt keinen Rettungswurf. Dementsprechend fügen die " + name + " " + armourmiss + " Lebenspunkteverluste zu.");
			willlost = armourmiss;
		}
		else{
			Random dice = new Random();
			for (int i = 0; i < armourmiss; i++){
				int roll = dice.nextInt(6) + 1;
//				System.out.println(roll);
				if (roll<ewardsave)
					willlost = willlost+1;
//				else System.out.println("Kein Lebenspunktverlust, da der Rettungswurf von " + ew + " mit " + roll + " geschafft wurde.");
				}
			if(willlost==0)
				System.out.println("Der Gegner verliert keine Lebenspunkte, da es ihm gelang alle Rettungswürfe erfolgreich abzulegen.");
			else if (armourmiss==willlost)
				System.out.println("Der Gegner verliert " + willlost + " Lebenspunkt(e), da sie keinen Rettungswurf erfolgreich ablegten.");
			else System.out.println("Der Gegner verliert " + willlost + " Lebenspunkt(e), da es ihm gelang " + (armourmiss-willlost) + " Rettungswürfe erfolgreich abzulegen.");
			}

			return willlost;
		}
	}
	
}
