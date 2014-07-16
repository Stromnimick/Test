
public class HochelfenSpeerträger extends Unit{
	
	public HochelfenSpeerträger(boolean champion, boolean musican, boolean banner){
		name = "Speeträger"; 	// Name der Einheit
		race = "Hochelfen"; 	// Rasse der Einheit
		points = 9; 			// Punktkosten pro Modell
		number = 10;			// Anzahl der Modelle in einer Einheit
		unit = 1; 				// Einheitenstärke pro Modell
		width = 5; 				// Breite der Einheit
		ranks = number/width; 	// Glieder des Regiments
		movement = 5; 			// Bewegungsreichweite der Einheit
		weaponSkill = 4; 		// Kampffähigkeiten im Nahkampf
		ballisticSkill = 4; 	// Kampffähigkeiten im Fernkampf
		strength = 3; 			// Stärke der Angriffe
		toughness = 3; 			// Widerstand gegen Verwundungen
		will = 1; 				// Lebenspunkte bis ein Modell entfernt wird
		initiative = 5; 		// Bestimmt die Reihenfolge der Attacken
		attacks = 1; 			// Anzahl der Attacken
		leadership = 8; 		// Moralwert für Psychologietests
		armourSave = 5; 		// Leichte Rüstung und Schild
		wardSave = 7; 			// Rettungswurf nach erfolglosem Rüstungswurf 
		magicAbility = 0; 		// Magiestufe zum Zaubern
		hasShield = true;
		firstStrike = true;
		
		unitpoints = points*number;
				
	}
}
