package units;


public class HochelfenSpeerträger extends Unit{
	
	public HochelfenSpeerträger(int number, int width, boolean champione, boolean musican, boolean banner){

		points = 9; 			// Punktkosten pro Modell
		unit = 1; 				// Einheitenstärke pro Modell
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
		strikeFirst = true;
		this.number = number;
		this.width = width;
		this.champion = champione;
		this.musican = musican;
		this.banner = banner;	
		
		if (champion)
			unitAttacks = width*2*attacks+1;
		else
			unitAttacks = width*2*attacks;
		
		
		unitpoints = points*number;
				
	}
	
	@Override
	public String getName() {
		return "Speerträger";
	}
	
	@Override
	public String getRace() {
		return "Hochelfen";
	}	
}
