import java.util.Random;


public class Units {

	String name; // Name der Einheit
	String race; // Rasse der Einheit
	int number;	// Anzahl der Modelle in einer Einheit
	int unit; // Einheitenst�rke pro Modell
	int points;  
	int width; // Breite der Einheit
	int ranks; // Glieder des Regiments
	int movement; // Bewegungsreichweite der Einheit
	int weaponskill; // Kampff�higkeiten im Nahkampf
	int ballisticskill; // Kampff�higkeiten im Fernkampf
	int strength; // St�rke der Angriffe
	int toughness; // Widerstand gegen Verwundungen
	int will; // Lebenspunkte bis ein Modell entfernt wird
	int initiative; // Bestimmt die Reihenfolge der Attacken
	int attacks; // Anzahl der Attacken
	int leadership; // Moralwert f�r Psychologietests
	int armoursave; // R�stungswurf gegen erfolgreiche Verwundungen
	int wardsave; // Rettungswurf nach erfolglosem R�stungswurf 
	int magicability; // Magiestufe zum Zaubern
	int unitpoints = points*number;
	
	
	public int hit(int ews) 		// ews = Kampfgeschick des Gegners
	{ 
		int dicetohit; 				// was muss gew�rfelt werden um einen Treffer zu erzielen?
		int hits=0;				// Anzahl der zugef�gten Verwundungen
		
		if(2*weaponskill<ews) 		// ist das Kampfgeschick des Gegners mehr als doppelt so hoch, dann auf 5
			dicetohit = 5;
		else if (weaponskill>ews)	// ist das Kampfgeschick des Gegners kleiner, dann auf 3
			dicetohit = 3;
		else						// sonst auf 4
			dicetohit = 4;
		
		System.out.println("Es werden " + width*2 + " Attacken ausgef�hrt."); // die erste und zweite Reihe k�nnen k�mpfen
		System.out.println("Kampfgeschick " + weaponskill + " gegen Kampfgeschick " + ews + " bedeutet, dass mindestens eine " + dicetohit + " zum Treffen ben�tigt wird.");
		
		Random dice = new Random();
			for (int i = 0; i < width*2; i++) 	// so oft W�rfel wie Modelle im ersten und zweiten Glied
				{
				int roll = dice.nextInt(6) + 1; // einen W6 werfen (gibt 0-5 zur�ck, deshalb die +1)
//				System.out.println(roll);		// W�rfelergebnisse anzeigen
				if (roll<dicetohit)				// kein Treffer
					System.out.println("Kein Treffer, da " + roll + " kleiner ist als " + dicetohit +".");
				else hits = hits+1;			// Treffer
				}
			if (hits==0)						// Ausgabe wenn kein Treffer
				System.out.println("Den " + name +"n gelangen bei " + width*2 + " Attacken kein Treffer.");
			else if (hits==width*2)			// Ausgabe wenn alles Treffer
				System.out.println("Den " + name +"n trafen ihren Gegner mit jeder ihrer Attacken.");
			else System.out.println("Den " + name +"n gelangen bei " + width*2 + " Attacken " + hits + " Treffer."); // sonstige Ausgabe
			
		return hits;				// wounds zur�ckgeben um sie bei wound() zu nutzen
	}
	
	public int wound(int hits, int et) // hits = Anzahl der Treffer, ew = Widerstand des Ziels
	{ 
		if (hits==0)
			return 0;
		else
		{
		int dicetowound;			// was muss gew�rfelt werden um eine Verwundung zu erzielen?
		int wounds = 0;			// Anzahl der R�stungsw�rfe, die abgelegt werden m�ssen
		
		if(et>strength+1)			// ist der Widerstand um mindestens 2 gr��er als die St�rke, dann auf 6
			dicetowound = 6;
		else if(et>strength)		// ist der Widerstand nicht mindestens um 2 gr��er, aber gr��er, dann auf 5
			dicetowound = 5;
		else if (strength==et)		// ist der Widerstand gleich der St�rke, dann auf 4
			dicetowound = 4;
		else if (strength==et+1)	// ist die St�rke genau um 1 gr��er als der Widerstand, dann auf 3
			dicetowound = 3;
		else						// sonst auf 2
			dicetowound = 2;
		
		System.out.println("St�rke " + strength + " gegen Widerstand " + et + " bedeutet, dass mindestens eine " + dicetowound + " zum Verwunden ben�tigt wird.");
		
		Random dice = new Random();
		for (int i = 0; i < hits; i++)
			{
			int roll = dice.nextInt(6) + 1;
//			System.out.println(roll);
			if (roll<dicetowound)
				System.out.println("Keine Verwundung, da " + roll + " kleiner ist als " + dicetowound +".");
			else wounds = wounds+1;
			}
		if (wounds==0)
			System.out.println("Den " + name + "n gelang bei " + hits + " Treffern keine Verwundung bei ihrem Gegner.");
		else if (wounds==hits)
			System.out.println("Die " + name + " verwundeten ihren Gegner mit jedem ihrer Treffer.");
		else System.out.println("Die " + name + " verwundeten bei " + hits + " Treffern ihren Gegner " + wounds + " Mal.");
		
		return wounds;
		}
	}
	
	public int armour(int wounds, int ea) //wounds = Anzahl der Verwundungen, ea = R�stungswurf des Gegners
	{ 
		if (wounds==0)
			return 0;
		else
		{
		int armourmodifier = strength-3;
		int armourlast = ea;
		int armourmiss = 0;
		if (armourmodifier<1)
			{
			System.out.println("Durch St�rke " + strength + " wird die R�stung des Gegners nicht modifiziert. Der Gegner hat einen R�stungswurf von " + armourlast + " .");
			armourmodifier=0;
			}
		else {
			armourlast = ea+armourmodifier;
			System.out.println("St�rke " + strength + " bedeutet, dass der R�stungswurf des Gegners von " + ea + " auf " + armourlast + " modifiziert wird.");
			}

		if(armourlast>6)
		{
		System.out.println("Der Gegner besitzt keinen R�stungswurf (mehr).");
		armourmiss = wounds;
		}
		else{
			Random dice = new Random();
			for (int i = 0; i < wounds; i++)
				{
				int roll = dice.nextInt(6) + 1;
//				System.out.println(roll);
				if (roll<armourlast)
					armourmiss = armourmiss+1;
				else System.out.println("Kein Lebenspunktverlust, da der R�stungswurf von " + armourlast + " mit " + roll + " geschafft wurde.");
				}	
			if(armourmiss==0)
				System.out.println("Der Gegner verliert keine Lebenspunkte, da es ihm gelang alle R�stungsw�rfe erfolgreich abzulegen.");
			else if (armourmiss==wounds)
				System.out.println("Der Gegner legte keinen R�stungswurf erfolgreich ab.");
			else System.out.println("Der Gegner legte " + (wounds-armourmiss) + " R�stungsw�rfe erfolgreich ab.");
			}
		return armourmiss;
		}
	}
	
	public int ward(int armourmiss, int ew) // armourmiss = Anzahl der abzulegenden Rettungsw�rfe, ew = Rettungswurf des Gegners
	{ 
		if (armourmiss==0)
			return 0;
		else
		{
		int willlost = 0;

		if(ew>6)
			{
			System.out.println("Der Gegner besitzt keinen Rettungswurf. Dementsprechend f�gen die " + name + " " + armourmiss + " Lebenspunkteverluste zu.");
			willlost = armourmiss;
			}
		else{
			Random dice = new Random();
			for (int i = 0; i < armourmiss; i++)
				{
				int roll = dice.nextInt(6) + 1;
//				System.out.println(roll);
				if (roll<ew)
					willlost = willlost+1;
				else System.out.println("Kein Lebenspunktverlust, da der Rettungswurf von " + ew + " mit " + roll + " geschafft wurde.");
				}
			if(willlost==0)
				System.out.println("Der Gegner verliert keine Lebenspunkte, da es ihm gelang alle Rettungsw�rfe erfolgreich abzulegen.");
			else if (armourmiss==willlost)
				System.out.println("Der Gegner verliert " + willlost + " Lebenspunkt(e), da sie keinen Rettungswurf erfolgreich ablegten.");
			else System.out.println("Der Gegner verliert " + willlost + " Lebenspunkt(e), da es ihm gelang " + (armourmiss-willlost) + " Rettungsw�rfe erfolgreich abzulegen.");
			}

		return willlost;
		}
	}
	
	
}
