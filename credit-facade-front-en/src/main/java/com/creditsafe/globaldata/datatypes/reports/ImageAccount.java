package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImageAccount", propOrder = {
	"imageId",
	"startDate",
	"endDate",
	"publishedDate",
	"documentType",
	"financialsType"
})

public class ImageAccount implements Serializable {

	@XmlElement(name = "ImageId")
	protected String imageId;
	public String getImageId() {return imageId;}
	public void setImageId(String value) {this.imageId =  value;}

	@XmlElement(name = "StartDate")
	protected String startDate;
	public String getStartDate() {return startDate;}
	public void setStartDate(String value) {this.startDate =  value;}

	@XmlElement(name = "EndDate")
	protected String endDate;
	public String getEndDate() {return endDate;}
	public void setEndDate(String value) {this.endDate =  value;}

	@XmlElement(name = "PublishedDate")
	protected String publishedDate;
	public String getPublishedDate() {return publishedDate;}
	public void setPublishedDate(String value) {this.publishedDate =  value;}

	@XmlElement(name = "DocumentType")
	protected String documentType;
	public String getDocumentType() {return documentType;}
	public void setDocumentType(String value) {this.documentType =  value;}

	@XmlElement(name = "FinancialsType")
	protected String financialsType;
	public String getFinancialsType() {return financialsType;}
	public void setFinancialsType(String value) {this.financialsType =  value;}

}
