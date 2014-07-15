
public class ZwergeKlankrieger extends Units{
	
	public ZwergeKlankrieger(boolean hasshield, boolean has2handweapon){
		name = "Klankrieger"; // Name der Einheit
		race = "Zwerge"; // Rasse der Einheit
		points = 8; // Punktkosten pro Modell
		number = 10;	// Anzahl der Modelle in einer Einheit
		unit = 1; // Einheitenstärke pro Modell
		width = 5; // Breite der Einheit
		ranks = number/width; // Glieder des Regiments
		movement = 3; // Bewegungsreichweite der Einheit
		weaponskill = 5; // Kampffähigkeiten im Nahkampf
		ballisticskill = 3; // Kampffähigkeiten im Fernkampf
		strength = 3; // Stärke der Angriffe
		toughness = 4; // Widerstand gegen Verwundungen
		will = 1; // Lebenspunkte bis ein Modell entfernt wird
		initiative = 2; // Bestimmt die Reihenfolge der Attacken
		attacks = 1; // Anzahl der Attacken
		leadership = 9; // Moralwert für Psychologietests
		armoursave = 5; // Schwere Rüstung
		wardsave = 7; // Rettungswurf nach erfolglosem Rüstungswurf 
		magicability = 0; // Magiestufe zum Zaubern
		unitpoints = points*number;
		this.hasShield = hasshield;
		this.has2HandWeapon = has2handweapon;
	}

	
	boolean hasShield;
	boolean has2HandWeapon;
	
	
	public void equip(){
		if(hasShield){
			points = points+1;
			armoursave = armoursave-1;
			wardsave = wardsave -1;
		}
	
		if(has2HandWeapon){
			points = points+2;
			strength = strength+2;
		}
	}

}




