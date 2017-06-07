package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImageAccounts", propOrder = {
	"imageAccount"
})

public class ImageAccounts implements Serializable {

	@XmlElement(name = "ImageAccount")
	protected List<ImageAccount> imageAccount;
	public List<ImageAccount> getImageAccount() {
		if (imageAccount == null) {
			imageAccount = new ArrayList<ImageAccount>();
		}
		return imageAccount;
	}
}
