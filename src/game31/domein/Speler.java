/*
 * Created on 24-jun-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author JN Hardeman
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package game31.domein;

public abstract class Speler {
	String naam;
	int fices;
	Deelname deelname;
	Tafel tafel;
	Pot pot;

	public Speler(String naam, int fices, Tafel tafel, Pot pot)
	{
		this.naam = naam;
		this.fices = fices;
		this.tafel = tafel;
		this.pot = pot;
	}

	public String geefNaam()
	{
		return naam;
	}

	public void dumpFiche()
	{
		pot.donatieFiche();
		this.fices--;
	}

	public int geefFiches()
	{
		return fices;
	}

	public abstract void aanDeBeurt();
	public abstract void eersteKeerInRonde();


	public void setDeelname(Deelname dn) {
		this.deelname = dn;
	}
}
