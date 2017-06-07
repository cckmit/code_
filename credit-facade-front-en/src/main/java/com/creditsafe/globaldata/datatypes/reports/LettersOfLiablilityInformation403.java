package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LettersOfLiablilityInformation403", propOrder = {
	"letterOfLiablilityInformation403"
})

public class LettersOfLiablilityInformation403 implements Serializable {

	@XmlElement(name = "LetterOfLiablilityInformation403")
	protected List<LetterOfLiablilityInformation403> letterOfLiablilityInformation403;
	public List<LetterOfLiablilityInformation403> getLetterOfLiablilityInformation403() {
		if (letterOfLiablilityInformation403 == null) {
			letterOfLiablilityInformation403 = new ArrayList<LetterOfLiablilityInformation403>();
		}
		return letterOfLiablilityInformation403;
	}
}
