package mechanic;
import java.util.Random;
import units.Unit;


public class CloseCombat {

	public int closeCombat(Unit a, Unit b){
		int aDeath=0;
		int bDeath=0;
		int aScore=0;
		int bScore=0;

		
		if (strikeOrder(a, b)==1){
			bDeath = ward(a,b,armour(a,b,wound(a,b,hit(a, b, 0))));
			aDeath = ward(b,a,armour(b,a,wound(b,a,hit(b, a, bDeath))));
		}
		else if (strikeOrder(a, b)==2){
			aDeath = ward(b,a,armour(b,a,wound(b,a,hit(b, a, 0))));
			bDeath = ward(a,b,armour(a,b,wound(a,b,hit(a, b, aDeath))));
		}
		else if (strikeOrder(a, b)==0){
			bDeath = ward(a,b,armour(a,b,wound(a,b,hit(a, b, 0))));
			aDeath = ward(b,a,armour(b,a,wound(b,a,hit(b, a, 0))));
		}
		
		aScore = battleScore(a, aDeath, bDeath);
		bScore = battleScore(b, bDeath, aDeath);
		battleResult(a, b, aScore, bScore);
		
		System.out.println("Die " + a.getName() +" haben noch " + a.getNumber() + " Modelle und " + a.getRanks() +" vollständige Glieder.");
		System.out.println("Die " + b.getName() +" haben noch " + b.getNumber() + " Modelle und " + b.getRanks() +" vollständige Glieder.");
		
		
		
		return 0;
	}
	
	public int strikeOrder (Unit a, Unit b){
		
		int order = 3;
		
		if (a.getStrike()>b.getStrike()){
			System.out.println("Die " + a.getName() +" der " + a.getRace() +" schlagen zuerst zu!");
			order = 1;
		}
		else if (a.getStrike()<b.getStrike()){
			System.out.println("Die " + b.getName() +" der " + b.getRace() +" schlagen zuerst zu!");
			order = 2;
		}	
		else if (a.getStrike()==b.getStrike()){
				if(a.getInitiative()>b.getInitiative()){
					System.out.println("Die " + a.getName() +" der " + a.getRace() +" schlagen zuerst zu!");
					order = 1;
				}
				else if(a.getInitiative()<b.getInitiative()){
					System.out.println("Die " + b.getName() +" der " + b.getRace() +" schlagen zuerst zu!");
					order = 2;
				}
				else {
					System.out.println("Beide Einheiten schlagen gleichzeitig zu!");
					order = 0;
				}
		}
		
		return order;
	}
		
	public int hit(Unit a, Unit b, int kills){ 		// ews = Kampfgeschick des Gegners
		int dicetohit; 				// was muss gewürfelt werden um einen Treffer zu erzielen?
		int hits=0;					// Anzahl der zugefügten Verwundungen
		
		if(2*a.getWeaponSkill()<b.getWeaponSkill()) 		// ist das Kampfgeschick des Gegners mehr als doppelt so hoch, dann auf 5
			dicetohit = 5;
		else if (a.getWeaponSkill()>b.getWeaponSkill())	// ist das Kampfgeschick des Gegners kleiner, dann auf 3
			dicetohit = 3;
		else						// sonst auf 4
			dicetohit = 4;
		
		System.out.println("Die "+ a.getName() +" führen " + a.getunitAttacks(a.getNumber(), kills) + " Attacken aus."); // die erste und zweite Reihe können kämpfen
		System.out.println("Kampfgeschick " + a.getWeaponSkill() + " gegen Kampfgeschick " + b.getWeaponSkill() + " bedeutet, dass mindestens eine " + dicetohit + " zum Treffen benötigt wird.");
		
		Random dice = new Random();
		for (int i = 0; i < a.getunitAttacks(a.getNumber(), kills); i++){ 	// so oft Würfel wie Modelle im ersten und zweiten Glied
			int roll = dice.nextInt(6) + 1; // einen W6 werfen (gibt 0-5 zurück, deshalb die +1)
//			System.out.println(roll);		// Würfelergebnisse anzeigen
			if (roll>dicetohit)				// kein Treffer
				hits = hits+1;			// Treffer
		}
		if (hits==0)						// Ausgabe wenn kein Treffer
			System.out.println("Den " + a.getName() +"n gelangen bei " + a.getunitAttacks(a.getNumber(), kills) + " Attacken kein Treffer.");
		else if (hits==a.getunitAttacks(a.getNumber(), kills))			// Ausgabe wenn alles Treffer
			System.out.println("Den " + a.getName() +"n trafen ihren Gegner mit jeder ihrer Attacken.");
		else System.out.println("Den " + a.getName() +"n gelangen bei " + a.getunitAttacks(a.getNumber(), kills) + " Attacken " + hits + " Treffer."); // sonstige Ausgabe
			
		return hits;				// Treffer zurückgeben um sie bei wound() zu nutzen
	}
		
	public int wound(Unit a, Unit b, int hits){ // hits = Anzahl der Treffer
		if (hits==0)
			return 0;
		else{
			int dicetowound;			// was muss gewürfelt werden um eine Verwundung zu erzielen?
			int wounds = 0;				// Anzahl der Rüstungswürfe, die abgelegt werden müssen
		
			if(b.getToughness()>a.getStrength()+1)			// ist der Widerstand um mindestens 2 größer als die Stärke, dann auf 6
				dicetowound = 6;
			else if(b.getToughness()>a.getStrength())		// ist der Widerstand nicht mindestens um 2 größer, aber größer, dann auf 5
				dicetowound = 5;
			else if (a.getStrength()==b.getToughness())		// ist der Widerstand gleich der Stärke, dann auf 4
				dicetowound = 4;
			else if (a.getStrength()==b.getToughness()+1)	// ist die Stärke genau um 1 größer als der Widerstand, dann auf 3
				dicetowound = 3;
			else						// sonst auf 2
				dicetowound = 2;
		
			System.out.println("Stärke " + a.getStrength() + " gegen Widerstand " + b.getToughness() + " bedeutet, dass mindestens eine " + dicetowound + " zum Verwunden benötigt wird.");
		
			Random dice = new Random();
			for (int i = 0; i < hits; i++){	
				int roll = dice.nextInt(6) + 1;
//				System.out.println(roll);
				if (roll>dicetowound)
					wounds = wounds+1;
			}
			if (wounds==0)
				System.out.println("Den " + a.getName() + "n gelang bei " + hits + " Treffern keine Verwundung bei den " + b.getName() + ".");
			else if (wounds==hits)
				System.out.println("Die " + a.getName() + " verwundeten die " + b.getName() + " mit jedem ihrer Treffer.");
			else System.out.println("Die " + a.getName() + " verwundeten bei " + hits + " Treffern die " + b.getName() + " " + wounds + " Mal.");
		
			return wounds;
		}
	}
	
	public int armour(Unit a, Unit b, int wounds){ //wounds = Anzahl der Verwundungen, ea = Rüstungswurf des Gegners
	
		if (wounds==0)
			return 0;
		else{
			int armourmodifier = a.getStrength()-3;
			int armourlast = b.getArmourSave();
			int armourmiss = 0;
			if (armourmodifier<1){
				System.out.println("Durch Stärke " + a.getStrength() + " wird die Rüstung der " + b.getName() + " nicht modifiziert. Die " + b.getName() + " haben einen Rüstungswurf von " + armourlast + " .");
				armourmodifier=0;
			}
			else{
				armourlast = b.getArmourSave()+armourmodifier;
				System.out.println("Stärke " + a.getStrength() + " bedeutet, dass der Rüstungswurf der " + b.getName() + " von " + b.getArmourSave() + " auf " + armourlast + " modifiziert wird.");
			}

			if(armourlast>6){
				System.out.println("Die " + b.getName() + " besitzt keinen Rüstungswurf (mehr).");
				armourmiss = wounds;
			}
			else{
				Random dice = new Random();
				for (int i = 0; i < wounds; i++){
					int roll = dice.nextInt(6) + 1;
//					System.out.println(roll);
					if (roll<armourlast)
						armourmiss = armourmiss+1;
				}	
			if(armourmiss==0)
				System.out.println("Die " + b.getName() + " verlieren keine Lebenspunkte, da es ihnen gelang alle Rüstungswürfe erfolgreich abzulegen.");
			else if (armourmiss==wounds)
				System.out.println("Die " + b.getName() + " legten keinen Rüstungswurf erfolgreich ab.");
			else System.out.println("Die " + b.getName() + " verpatzten " + armourmiss + " Rüstungswürfe.");
			}
			return armourmiss;
		}
	}
	
	public int ward(Unit a, Unit b, int armourmiss){ // armourmiss = Anzahl der abzulegenden Rettungswürfe, ew = Rettungswurf des Gegners 
		if (armourmiss==0)
			return 0;
		else{
		int willlost = 0;

		if(b.getWardSave()>6){
			System.out.println("Die " + b.getName() + " besitzen keinen Rettungswurf. Dementsprechend fügen die " + a.getName() + " " + armourmiss + " Lebenspunkteverluste zu.");
			willlost = armourmiss;
		}
		else{
			Random dice = new Random();
			for (int i = 0; i < armourmiss; i++){
				int roll = dice.nextInt(6) + 1;
//				System.out.println(roll);
				if (roll<b.getWardSave())
					willlost = willlost+1;
//				else System.out.println("Kein Lebenspunktverlust, da der Rettungswurf von " + ew + " mit " + roll + " geschafft wurde.");
				}
			if(willlost==0)
				System.out.println("Die " + b.getName() + " verlieren keine Lebenspunkte, da es ihnen gelang alle Rettungswürfe erfolgreich abzulegen.");
			else if (armourmiss==willlost)
				System.out.println("Die " + b.getName() + " verlieren " + willlost + " Lebenspunkt(e), da sie keinen Rettungswurf erfolgreich ablegten.");
			else System.out.println("Die " + b.getName() + " verlieren " + willlost + " Lebenspunkt(e), da es ihm gelang " + (armourmiss-willlost) + " Rettungswürfe erfolgreich abzulegen.");
			}

			return willlost;
		}
	
	}
	
	public int battleScore(Unit a, int ownDeath, int bDeath){
		int aScore=0;

		if (a.getBanner()){
			aScore = 1 + bDeath + a.getNewRanks(a.getNewNumber(ownDeath));
			System.out.println("Die " + a.getName() +" verursachen " + bDeath +" Lebenspunktverluste, haben eine Standarte und " + a.getRanks() + " Glieder und erzielen damit " + aScore + " Punkte.");
		}
		else{
			aScore = bDeath + a.getNewRanks(a.getNewNumber(ownDeath));
			System.out.println("Die " + a.getName() +" verursachen " + bDeath +" Lebenspunktverluste, haben " + a.getRanks() + " Glieder und erzielen damit " + aScore + " Punkte.");
		}

		return aScore;
	}

	public int battleResult(Unit a, Unit b, int aScore, int bScore){
		
		int score=0;
		
		if(aScore>bScore){
			score = aScore - bScore;
			System.out.println("Die " + b.getName() + " haben das Kampfergebnis um " + score + " Punkte verloren.");
			panikTest(b, score);
		}
		if(aScore<bScore){
			score = bScore - aScore;
			System.out.println("Die " + a.getName() + " haben das Kampfergebnis um " + score + " Punkte verloren.");
			panikTest(a, score);
		}
		if(aScore==bScore){
			if(a.getMusican() && !b.getMusican()){
				score = 1;
				System.out.println("Die " + b.getName() + " haben das Kampfergebnis um einen Punkt verloren.");
				panikTest(b, score);
			}
			if(!a.getMusican() && b.getMusican()){
				score = 1;
				System.out.println("Die " + a.getName() + " haben das Kampfergebnis um einen Punkt verloren.");
				panikTest(a, score);
			}
			else{
				score = 0;
				System.out.println("Im Nahkampf zwischen den " + a.getName() +" und den " + b.getName() + " gab es ein Unentschieden");
			}
		}
		
		return score;
	}
	
	public int panikTest(Unit a, int score){
		
		int leadershipLast = a.getLeadership()-score;
		System.out.println("Die " + a.getName() + " haben einen Moralwert von " + a.getLeadership() + " der durch das Kampfergebnis um " + score + " auf " + leadershipLast + " reduziert wird.");
		int fail=0;
		
		Random dice = new Random();
		int roll = dice.nextInt(12) + 1;
//		System.out.println(roll);
		if(roll>leadershipLast){
			fail = roll-leadershipLast;
			System.out.println("Die " + a.getName() + " haben den Moralwerttest durch den Wurf einer " + roll + " um " + fail + " verpatzt.");
		}
		else
			System.out.println("Die " + a.getName() + " haben den Moralwerttest durch den Wurf einer " + roll + " bestanden.");
		
		return fail;
	}
}
