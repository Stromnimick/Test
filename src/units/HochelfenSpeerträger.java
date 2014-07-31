package units;


public class HochelfenSpeertr�ger extends Unit{
	
	public HochelfenSpeertr�ger(int number, int width, boolean champione, boolean musican, boolean banner){

		points = 9; 			// Punktkosten pro Modell
		unit = 1; 				// Einheitenst�rke pro Modell
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
		return "Speertr�ger";
	}
	
	@Override
	public String getRace() {
		return "Hochelfen";
	}	
}
