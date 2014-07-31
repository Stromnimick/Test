package units;


public class ZwergeKlankrieger extends Unit{
	
	public ZwergeKlankrieger(int number, int width, boolean champione, boolean musican, boolean banner, boolean hasshield, boolean has2handweapon){

		points = 8; 			// Punktkosten pro Modell
		unit = 1; 				// Einheitenst�rke pro Modell
		movement = 3; 			// Bewegungsreichweite der Einheit
		weaponSkill = 4; 		// Kampff�higkeiten im Nahkampf
		ballisticSkill = 3; 	// Kampff�higkeiten im Fernkampf
		strength = 3; 			// St�rke der Angriffe
		toughness = 4; 			// Widerstand gegen Verwundungen
		will = 1; 				// Lebenspunkte bis ein Modell entfernt wird
		initiative = 2; 		// Bestimmt die Reihenfolge der Attacken
		attacks = 1; 			// Anzahl der Attacken
		leadership = 9; 		// Moralwert f�r Psychologietests
		armourSave = 5; 		// Schwere R�stung
		wardSave = 7; 			// Rettungswurf nach erfolglosem R�stungswurf 
		magicAbility = 0; 		// Magiestufe zum Zaubern
		strikeFirst = false;
		strikeLast = false;
		this.number = number;
		this.width = width;
		this.hasShield = hasshield;
		this.has2HandWeapon = has2handweapon;
		this.champion = champione;
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
			strikeLast = true;
		}

	}

	@Override
	public String getName() {
		return "Klankrieger";
	}
	
	@Override
	public String getRace() {
		return "Zwerge";
	}
	
}




