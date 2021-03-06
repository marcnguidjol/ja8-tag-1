package begruessung.service;

import java.time.LocalDateTime;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;

import begruessung.commons.UngueltigenNameException;
import teilnehmer.model.Anrede;
import teilnehmer.model.Name;
import teilnehmer.model.TeilnehmerIn;
import teilnehmer.model.Titel;
import teilnehmer.model.Vorname;

/**
 * Begruessung aller ankommenden TN im Seminar
 * 
 * @author Training
 *
 */
public class BegruessungService {

	private static final String KOMMA = ",";
	private static final String PUNKT = ".";
	private static final String LEERZEICHEN = " ";
	private static final String MORGIGE_BEGRUESSUNG = "Guten Morgen";
	private static final String TAGSUEBER_BEGRUESSUNG = "Guten Tag";
	private static final String ABENDS_BEGRUESSUNG = "Guten Abend";

	public void begruesseAlleTN(final Map<TeilnehmerIn, String> teilnehmerInMap) {

		if (null != teilnehmerInMap && CollectionUtils.isNotEmpty(teilnehmerInMap.values())) {
			teilnehmerInMap.forEach((k, v) -> {
				
				StringBuilder stringBuilder = new StringBuilder();
				
				aktualisiereMitTitel(k, stringBuilder);
				aktualisiereMitAnrede(k, stringBuilder);
				aktualisiereMitVorname(k, stringBuilder);
				
				try {
					aktualisiereMitName(k, stringBuilder);
				} catch (UngueltigenNameException e) {
					System.err.println("--- Fehlermeldeung: " + e.getMessage() + " ---");
					return;
				}

				System.out.println(v + LEERZEICHEN + stringBuilder.toString());
			});
		}

	}

	public String findeRichtigeBegruessungAbhVonUhrzeit() {
		int aktuelleTagesUhrzeit = LocalDateTime.now().getHour();
		if (aktuelleTagesUhrzeit >= 6 && aktuelleTagesUhrzeit < 12)
			return MORGIGE_BEGRUESSUNG;
		if (aktuelleTagesUhrzeit >= 12 && aktuelleTagesUhrzeit <= 18)
			return TAGSUEBER_BEGRUESSUNG;
		return ABENDS_BEGRUESSUNG;
	}

	private void aktualisiereMitName(final TeilnehmerIn teilnehmerIn, StringBuilder stringBuilder)
			throws UngueltigenNameException {
		Name name = teilnehmerIn.getName();
		if (null != name) {
			String familienName = name.getFamilienName();
			if (null != familienName && familienName.trim().length() > 2 && familienName.trim().length() <= 120) {
				stringBuilder.append(familienName);
			} 
		} else {
			throw new UngueltigenNameException("Ungueltiger Name - Size[Min=2, Max=120]");
		}
	}

	private void aktualisiereMitVorname(final TeilnehmerIn teilnehmerIn, StringBuilder stringBuilder) {
		Vorname vorname = teilnehmerIn.getVorname();
		if (null != vorname) {
			final String vorName = vorname.getVorName();
			if (null != vorName && vorName.trim().length() > 0) {
				stringBuilder.append(vorName);
				stringBuilder.append(KOMMA);
			}
		}
	}

	private void aktualisiereMitAnrede(final TeilnehmerIn teilnehmerIn, StringBuilder stringBuilder) {
		Anrede anrede = teilnehmerIn.getAnrede();
		if (null != anrede) {
			if (!anrede.equals(Anrede.KEINE) && !anrede.equals(Anrede.UNBEKANNT)) {
				stringBuilder.append(anrede.name());
				stringBuilder.append(LEERZEICHEN);
			}
		}
	}
	
	private void aktualisiereMitTitel(final TeilnehmerIn teilnehmerIn, StringBuilder stringBuilder) {
		Titel titel = teilnehmerIn.getTitel();
		if (null != titel) {
			stringBuilder.append(titel.name());
			stringBuilder.append(PUNKT);
			stringBuilder.append(LEERZEICHEN);
			
		}
	}

}
