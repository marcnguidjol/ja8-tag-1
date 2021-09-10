package teilnehmer.model;

import org.apache.commons.lang3.StringUtils;

/**
 * Builder Pattern
 * @author Training
 *
 */
public class TeilnehmerInBuilder {
	
	private TeilnehmerIn teilnehmerIn;
	
	public static TeilnehmerInBuilder neueInstanz() {
		return new TeilnehmerInBuilder();
	}
	
	//Wichtig fuer Builder-Klassen!
	private TeilnehmerInBuilder() {
		this.teilnehmerIn = new TeilnehmerIn();
	}
	
	public TeilnehmerInBuilder mitAnrede(final Anrede anrede) {
		if(null != anrede) {
			if(!anrede.equals(Anrede.KEINE) 
					&& !anrede.equals(Anrede.UNBEKANNT)) {
				this.teilnehmerIn.setAnrede(anrede);	
			}
		}
		return this;
	}
	
	public TeilnehmerInBuilder mitTitel(final Titel titel) {
		if(null != titel) {
			this.teilnehmerIn.setTitel(titel);
		}
		return this;
	}
	
	public TeilnehmerInBuilder mitVorname(final Vorname vorname) {
		if(null != vorname) {
			String vorName = vorname.getVorName();
			if(StringUtils.isNotEmpty(vorName)) {
				vorName = StringUtils.trim(vorName);
				if(StringUtils.length(vorName) > 2 
						&& StringUtils.length(vorName) < 256) {
					this.teilnehmerIn.setVorname(vorname);
				}
			}
		}
		return this;
	}
	
	public TeilnehmerInBuilder mitName(final Name name) {
		if(null != name) {
			String familienName = name.getFamilienName();
			if(StringUtils.isNotEmpty(familienName)) {
				familienName = StringUtils.trim(familienName);
				if(StringUtils.length(familienName) > 2 
						&& StringUtils.length(familienName) < 120) {
					this.teilnehmerIn.setName(name);
				}
			}
		}
		return this;
	}
	
	public TeilnehmerIn build() {
		return this.teilnehmerIn;
	}

}
