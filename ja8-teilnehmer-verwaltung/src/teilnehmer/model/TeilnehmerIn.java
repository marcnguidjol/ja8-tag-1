package teilnehmer.model;

/**
 * Model TeilnehmerIn
 * 
 * @author Training
 *
 */
public class TeilnehmerIn {

	private Anrede anrede;
	private Titel titel;
	private Vorname vorname;
	private Name name;

	
	public TeilnehmerIn() {
	}

	public TeilnehmerIn(Anrede anrede, Titel titel, Vorname vorname, Name name) {
		this.anrede = anrede;
		this.titel = titel;
		this.vorname = vorname;
		this.name = name;
	}

	public Anrede getAnrede() {
		return anrede;
	}

	public void setAnrede(Anrede anrede) {
		this.anrede = anrede;
	}

	public Titel getTitel() {
		return titel;
	}

	public void setTitel(Titel titel) {
		this.titel = titel;
	}

	public Vorname getVorname() {
		return vorname;
	}

	public void setVorname(Vorname vorname) {
		this.vorname = vorname;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TeilnehmerIn [anrede=" + anrede + ", titel=" + titel + ", vorname=" + vorname + ", name=" + name + "]";
	}

}
