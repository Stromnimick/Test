package units;


public abstract class Unit {

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
	int strike;
	int unitpoints = points*number;
	boolean hasShield;
	boolean has2HandWeapon;
	boolean strikeFirst;
	boolean strikeLast;
	boolean champion;
	boolean musican;
	boolean banner;
	

	public abstract String getName();
	public abstract String getRace();
	public boolean getStrikeFirst() {
		return strikeFirst;
	}
	public boolean getStrikeLast() {
		return strikeLast;
	}	
	public int getInitiative() {
		return initiative;
	}
	public int getStrike(){
		if (strikeFirst && !strikeLast)
			strike = 2;
		else if (!strikeFirst && strikeLast)
			strike = 0;
		else strike = 1;		
		return strike;
	}
	public int getunitAttacks(int number, int kills) {
		if(getNewRanks(number)>=2){
			if (champion)
				unitAttacks = (width*2)*attacks+1;
			else
				unitAttacks = (width*2)*attacks;
				unitAttacks = unitAttacks-kills;
		}
		else 
			unitAttacks = number-kills;
		
		return unitAttacks;
	}
	public int getWeaponSkill() {
		return weaponSkill;
	}
	public int getStrength(){
		return strength;
	}
	public int getToughness(){
		return toughness;
	}
	public int getArmourSave(){
		return armourSave;
	}
	public int getWardSave(){
		return wardSave;
	}	
	public int getNewNumber(int kills){
		number = number-kills;
		return number;
	}
	public int getNewRanks(int number){
		ranks = number/width;
		return ranks;
	}
	public int getNumber(){
		return number;
	}
	public int getRanks(){
		return ranks;
	}	
	public boolean getBanner(){
		return banner;
	}
	public boolean getMusican(){
		return musican;
	}
	public int getLeadership(){
		return leadership;
	}
	
}
