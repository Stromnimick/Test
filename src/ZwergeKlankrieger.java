
public class ZwergeKlankrieger extends Units{
	
	public ZwergeKlankrieger(boolean hasshield, boolean has2handweapon){
		name = "Klankrieger"; // Name der Einheit
		this.hasshield = hasshield;
		this.has2handweapon = has2handweapon;
	}
		
	String name = "Klankrieger"; // Name der Einheit
	String race = "Zwerge"; // Rasse der Einheit
	int points = 8; // Punktkosten pro Modell
	int number = 10;	// Anzahl der Modelle in einer Einheit
	int unit = 1; // Einheitenstärke pro Modell
	static int width = 5; // Breite der Einheit
	int ranks = number/width; // Glieder des Regiments
	int movement = 3; // Bewegungsreichweite der Einheit
	static int weaponskill = 9; // Kampffähigkeiten im Nahkampf
	int ballisticskill = 3; // Kampffähigkeiten im Fernkampf
	int strength = 3; // Stärke der Angriffe
	int toughness = 4; // Widerstand gegen Verwundungen
	int will = 1; // Lebenspunkte bis ein Modell entfernt wird
	int initiative = 2; // Bestimmt die Reihenfolge der Attacken
	int attacks = 1; // Anzahl der Attacken
	int leadership = 9; // Moralwert für Psychologietests
	int armoursave = 5; // Schwere Rüstung
	int wardsave = 7; // Rettungswurf nach erfolglosem Rüstungswurf 
	int magicability = 0; // Magiestufe zum Zaubern
	boolean hasshield;
	boolean has2handweapon;
	int unitpoints = points*number;

	
public void equip()
{
if(hasshield)
	{
	points = points+1;
	armoursave = armoursave-1;
	wardsave = wardsave -1;
	}
else ;

if(has2handweapon)
	{
	points = points+2;
	strength = strength+2;
	}
else ;
}

}




