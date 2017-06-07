package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdditionalFinancials", propOrder = {
	"financialItems",
	"financialStatement"
})

public class AdditionalFinancials implements Serializable {

	@XmlElement(name = "FinancialItems")
	protected List<FinancialItems> financialItems;
	public List<FinancialItems> getFinancialItems() {
		if (financialItems == null) {
			financialItems = new ArrayList<FinancialItems>();
		}
		return financialItems;
	}
	@XmlElement(name = "FinancialStatement")
	protected List<FinancialStatement> financialStatement;
	public List<FinancialStatement> getFinancialStatement() {
		if (financialStatement == null) {
			financialStatement = new ArrayList<FinancialStatement>();
		}
		return financialStatement;
	}
}
