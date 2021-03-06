package teilnehmer.model;

import javax.validation.constraints.Size;

/**
 * Model Struktur fuer Vornamen. - Min. 2 und max. 256
 * 
 * @author Training
 *
 */
public class Vorname {

	@Size(min = 2, max = 256, message = "Ungueltige Eingabe - 2 bis 256 Zeichen erlaubt.")
	private String vorName;

	public Vorname(String vorName) {
		this.vorName = vorName;
	}

	public String getVorName() {
		return vorName;
	}

	public void setVorName(String vorName) {
		this.vorName = vorName;
	}

	@Override
	public String toString() {
		return "Vorname [vorName=" + vorName + "]";
	}

}
