import mechanic.CloseCombat;
import units.HochelfenSpeertr�ger;
import units.Unit;
import units.ZwergeKlankrieger;






public class Main {

	public static void main (String[] args) {
		
		System.out.println("Hallo, dies ist ein Test der Nahkampfphase.");

		
		Unit einheitA = new ZwergeKlankrieger(20,5,true,true,true,true,true);
		Unit einheitB = new HochelfenSpeertr�ger(20,5,true,true,true);
		CloseCombat nahkrampf = new CloseCombat();
		
		nahkrampf.closeCombat(einheitA, einheitB);
		
		//einheitA.ward(einheitA.armour(einheitA.wound(einheitA.hit(4),3),6),6);		
		//System.out.println("Die Punktkosten f�r diese Einheit betragen: " + einheitA.unitAttacks + " .");

		
	}
}
