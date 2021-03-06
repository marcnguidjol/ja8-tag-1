package teilnehmer.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Model Namen von TN besteht aus min. 2 Buchstaben
 * 
 * @author Training
 *
 */
public class Name {

	@NotNull
	@Size(min = 2, max = 120, message = "Ungueltige Eingabe - 2 bis 120 Zeichen erlaubt.")
	private String familienName;

	public Name(String familienName) {
		this.familienName = familienName;
	}

	public String getFamilienName() {
		return familienName;
	}

	public void setFamilienName(String familienName) {
		this.familienName = familienName;
	}

	@Override
	public String toString() {
		return "Name [familienName=" + familienName + "]";
	}

}
