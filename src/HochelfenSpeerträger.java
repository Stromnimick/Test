
public class HochelfenSpeertr�ger extends Unit{
	
	public HochelfenSpeertr�ger(boolean champion, boolean musican, boolean banner){
		name = "Speetr�ger"; 	// Name der Einheit
		race = "Hochelfen"; 	// Rasse der Einheit
		points = 9; 			// Punktkosten pro Modell
		number = 10;			// Anzahl der Modelle in einer Einheit
		unit = 1; 				// Einheitenst�rke pro Modell
		width = 5; 				// Breite der Einheit
		ranks = number/width; 	// Glieder des Regiments
		movement = 5; 			// Bewegungsreichweite der Einheit
		weaponSkill = 4; 		// Kampff�higkeiten im Nahkampf
		ballisticSkill = 4; 	// Kampff�higkeiten im Fernkampf
		strength = 3; 			// St�rke der Angriffe
		toughness = 3; 			// Widerstand gegen Verwundungen
		will = 1; 				// Lebenspunkte bis ein Modell entfernt wird
		initiative = 5; 		// Bestimmt die Reihenfolge der Attacken
		attacks = 1; 			// Anzahl der Attacken
		leadership = 8; 		// Moralwert f�r Psychologietests
		armourSave = 5; 		// Leichte R�stung und Schild
		wardSave = 7; 			// Rettungswurf nach erfolglosem R�stungswurf 
		magicAbility = 0; 		// Magiestufe zum Zaubern
		hasShield = true;
		firstStrike = true;
		
		unitpoints = points*number;
				
	}
}
