package teilnehmer.service;

import teilnehmer.model.Anrede;
import teilnehmer.model.Name;
import teilnehmer.model.TeilnehmerIn;
import teilnehmer.model.TeilnehmerInBuilder;
import teilnehmer.model.Titel;
import teilnehmer.model.Vorname;

/**
 * Klasse zur Verwaltung von TNs.
 * @author Training
 *
 */
public class TeilnehmerService {
	
	public TeilnehmerIn neuerTn(final Anrede anrede, final Titel titel, final Vorname vornamen, final Name name) {
		return TeilnehmerInBuilder.neueInstanz()
				.mitAnrede(anrede)
				.mitTitel(titel)
				.mitVorname(vornamen)
				.mitName(name)
				.build();
	}

}
