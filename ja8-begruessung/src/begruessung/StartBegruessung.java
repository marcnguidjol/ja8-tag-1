package begruessung;

import java.util.LinkedHashMap;
import java.util.Map;

import begruessung.service.BegruessungService;
import teilnehmer.model.Anrede;
import teilnehmer.model.Name;
import teilnehmer.model.TeilnehmerIn;
import teilnehmer.model.Titel;
import teilnehmer.model.Vorname;
import teilnehmer.service.TeilnehmerService;

public class StartBegruessung {


	public static void main(String[] args) {

		BegruessungService begruessungService = new BegruessungService();
		final String begruessungsformel = begruessungService.findeRichtigeBegruessungAbhVonUhrzeit();

		TeilnehmerService teilnehmerService = new TeilnehmerService();

		Map<TeilnehmerIn, String> teilnehmerInMap = new LinkedHashMap<>();
		
		teilnehmerInMap.put(
				teilnehmerService.neuerTn(Anrede.HERR, Titel.DR, new Vorname("Max"), new Name("Mustermann")),
				begruessungsformel);
		teilnehmerInMap.put(
				teilnehmerService.neuerTn(Anrede.FRAU, null, new Vorname("Anne-Marie"), new Name("Musterfrau")),
				begruessungsformel);
		teilnehmerInMap.put(teilnehmerService.neuerTn(null, null, new Vorname("x"), new Name("Mustermann")),
				begruessungsformel);
		teilnehmerInMap.put(teilnehmerService.neuerTn(null, null, null, new Name("x")),
				begruessungsformel);
		
		begruessungService.begruesseAlleTN(teilnehmerInMap);

	}


}
