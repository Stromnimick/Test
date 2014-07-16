
public class ZwergeKlankrieger extends Unit{
	
	public ZwergeKlankrieger(boolean champion, boolean musican, boolean banner, boolean hasshield, boolean has2handweapon){
		name = "Klankrieger"; 	// Name der Einheit
		race = "Zwerge"; 		// Rasse der Einheit
		points = 8; 			// Punktkosten pro Modell
		number = 10;			// Anzahl der Modelle in einer Einheit
		unit = 1; 				// Einheitenstärke pro Modell
		width = 5; 				// Breite der Einheit
		ranks = number/width; 	// Glieder des Regiments
		movement = 3; 			// Bewegungsreichweite der Einheit
		weaponSkill = 4; 		// Kampffähigkeiten im Nahkampf
		ballisticSkill = 3; 	// Kampffähigkeiten im Fernkampf
		strength = 3; 			// Stärke der Angriffe
		toughness = 4; 			// Widerstand gegen Verwundungen
		will = 1; 				// Lebenspunkte bis ein Modell entfernt wird
		initiative = 2; 		// Bestimmt die Reihenfolge der Attacken
		attacks = 1; 			// Anzahl der Attacken
		leadership = 9; 		// Moralwert für Psychologietests
		armourSave = 5; 		// Schwere Rüstung
		wardSave = 7; 			// Rettungswurf nach erfolglosem Rüstungswurf 
		magicAbility = 0; 		// Magiestufe zum Zaubern
		this.hasShield = hasshield;
		this.has2HandWeapon = has2handweapon;
		this.champion = champion;
		this.musican = musican;
		this.banner = banner;		
		
		if(hasShield){
			points = points+1;
			armourSave = armourSave-1;
			wardSave = wardSave -1;
		}
	
		if(has2HandWeapon){
			points = points+2;
			strength = strength+2;
		}
		
		unitpoints = points*number;
				
	}

}




