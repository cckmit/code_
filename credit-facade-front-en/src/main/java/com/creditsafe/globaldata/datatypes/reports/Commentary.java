package com.creditsafe.globaldata.datatypes.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Commentary", propOrder = {
	"commentaryText",
	"positiveOrNegative"
})

public class Commentary implements Serializable {

	@XmlElement(name = "CommentaryText")
	protected String commentaryText;
	public String getCommentaryText() {return commentaryText;}
	public void setCommentaryText(String value) {this.commentaryText =  value;}

	@XmlElement(name = "PositiveOrNegative")
	protected String positiveOrNegative;
	public String getPositiveOrNegative() {return positiveOrNegative;}
	public void setPositiveOrNegative(String value) {this.positiveOrNegative =  value;}

}
