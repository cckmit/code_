package com.mika.credit.common.enums;

import java.util.Objects;

/**
 *
 * @author Nancy
 */
public enum EnumNegativeFact {
    NFC001("001","001","Judgements (total number)",""),//
    NFC002("002","002","Judgements (total amount)",""),//
    NFC003("003","003","Claims (total number)",""),//
    NFC004("004","004","Claims (total amount)",""),
    NFC005("005","005","Injunctions (total number)", ""),//
    NFC006("006","006","Injunctions (total amount)", ""),//
    NFC007("007","007","Total number of judgements, injunctions, claims, etc. (”weak negative facts”)", ""),//
    NFC008("008","008","The date of last judgements, injunctions, claims, etc. (”weak negative facts”)", ""),//
    NFC009("009","009","Acceptance of the settlement of debts plan", ""),//
    NFC011("011","011","Administrative receivership", ""),//
    NFC014("014","014","Amicable settlement ended", ""),//
    NFC015("015","015","Announcement of the residual debt release", ""),//
    NFC016("016","016","Annulment of judgement", ""),//
    NFC017("017","017","Appeal against sundry judgments", ""),//
    NFC018("018","018","Appeal rejected", ""),//
    NFC019("019","019","Application for composition respite", ""),//
    NFC020("020","020","Application for residual debt release", ""),//
    NFC021("021","021","Appointment of a provisionary receiver", ""),//
    NFC022("022","022","Appointment of administrator", ""),//
    NFC023("023","023","Approval of a composition with creditors", ""),//
    NFC024("024","024","Bad payment experience", ""),//
    NFC025("025","025","Balance of debt with the Enforcement Service, Private claims", ""),//
    NFC026("026","026","Balance of debt with the Enforcement Service, Public claims", ""),//
    NFC027("027","027","Ban on doing business", ""),//
    NFC028("028","028","Bankruptcy by application", ""),//
    NFC029("029","029","Bankruptcy by confession", ""),//
    NFC030("030","030","Bankruptcy by presentation of a petition or summons", ""),//
    NFC031("031","031","Bankruptcy ended, business activities (may) continue", ""),//
    NFC032("032","032","Bankruptcy for lack of assets rejected", ""),//
    NFC033("033","033","Bankruptcy proceedings", ""),//
    NFC034("034","034","Bankruptcy proceedings terminated by compulsory settlement", ""),//
    NFC035("035","035","Bankruptcy threat", ""),//
    NFC036("036","036","Bankruptcy was changed into the Law of Reorganization of Debts for Private Persons", ""),//
    NFC038("038","038","Blocking of bank account", ""),//
    NFC040("040","040","Cancellation of registration with the Trade Register", ""),//
    NFC041("041","041","Termination of composition with creditors (conclusion)", ""),//
    NFC042("042","042","Cessation of activity", ""),//
    NFC043("043","043","Cessation of receiver/administrator", ""),//
    NFC044("044","044","Claim call due to capital decrease", ""),//
    NFC045("045","045","Claim call due to liquidation", ""),//
    NFC046("046","046","Claim call due to merger", ""),//
    NFC047("047","047","Claims have been settled.", ""),//
    NFC048("048","048","Closing of bankruptcy proceedings / insolvency proceedings", ""),//
    NFC049("049","049","Closure judgement after suspension", ""),//
    NFC050("050","050","Collective proceedings", ""),//
    NFC052("052","052","Completion of voluntary arrangement", ""),//
    NFC053("053","053","Composition offer", ""),//
    NFC054("054","054","Composition proceedings", ""),//
    NFC055("055","055","Composition respite", ""),//
    NFC057("057","057","Compulsory auction", ""),//
    NFC058("058","058","Compulsory auction cancelled", ""),//
    NFC059("059","059","Compulsory auction ended", ""),//
    NFC060("060","060","Concession or prolongation of a final reprieve", ""),//
    NFC061("061","061","Concession or prolongation of a provisional reprieve", ""),//
    NFC062("062","062","Concession or prolongation of an extension of time for payment", ""),//
    NFC063("063","063","Conclusion of bankruptcy by liquidation", ""),//
    NFC064("064","064","Conclusion of bankruptcy due to absence or lack of assets", ""),//
    NFC065("065","065","Conclusion of bankruptcy or liquidation", ""),//
    NFC066("066","066","Confirmation of a judgment issued previously", ""),//
    NFC067("067","067","Confirmation of restructuring payment programme", ""),//
    NFC068("068","068","Consolidation of shares in one person's possession", ""),//
    NFC069("069","069","Consumer insolvency proceedings", ""),//
    NFC070("070","070","Continuation of activity despite the loss of half of the capital", ""),//
    NFC071("071","071","Continuation of activity despite the loss of three quarters of the capital", ""),//
    NFC072("072","072","Continuation plan", ""),//
    NFC073("073","073","Conviction for (negligent) bankruptcy", ""),//
    NFC074("074","074","Conviction for fraudulent bankruptcy", ""),//
    NFC075("075","075","County court judgement cancelled/set aside", ""),//
    NFC076("076","076","County court judgement convicted", ""),//
    NFC077("077","077","County court judgement/decree recalled", ""),//
    NFC078("078","078","County court judgement has been settled", ""),//
    NFC080("080","080","County court judgement is being disputed", ""),//
    NFC081("081","081","County court judgement registered", ""),//
    NFC083("083","083","Court order (arrest warrant)", ""),//
    NFC084("084","084","Court settlement", ""),//
    NFC085("085","085","Creditor's meeting (bankruptcy proceedings)", ""),//
    NFC086("086","086","Current seizure-loss certificate", ""),//
    NFC088("088","088","Deadline for debt filing (in case of bankruptcy)", ""),//
    NFC089("089","089","Deadline for debt filing (in case of composition)", ""),//
    NFC090("090","090","Debt collection proceedings", ""),//
    NFC091("091","091","Debt reorganising", ""),//
    NFC092("092","092","Debtor can continue to pay", ""),//
    NFC093("093","093","Debtor can resume his payments.", ""),//
    NFC094("094","094","Debtor causes exceeding debts.", ""),//
    NFC095("095","095","Debtor doesn't fulfil one or more of its obligations.", ""),//
    NFC096("096","096","Debtor tries to disadvantage his creditors.", ""),//
    NFC097("097","097","Decision to liquidate a company", ""),//
    NFC098("098","098","Decision to reinstate", ""),//
    NFC099("099","099","Declaration of a separation of property", ""),//
    NFC100("100","100","Declaration of absence of a merchant", ""),//
    NFC101("101","101","Declaration of nullity of a company", ""),//
    NFC102("102","102","Declaration of rehabilitation of the bankrupt party", ""),//
    NFC105("105","105","Declaration of the sale of a business", ""),//
    NFC107("107","107","Decree of a garnishment order (movables)", ""),//
    NFC108("108","108","Denial of residual debt release", ""),//
    NFC109("109","109","Department of Public Prosecutions appeal", ""),//
    NFC110("110","110","Deposit of final liquidation balance", ""),//
    NFC111("111","111","Deregistration", ""),//
    NFC112("112","112","Designation of a seizure of property", ""),//
    NFC113("113","113","Designation of a temporary administrator", ""),//
    NFC115("115","115","Dismissal of Petition for winding up", ""),//
    NFC117("117","117","Distraint (chattels)", ""),//
    NFC118("118","118","End of suspension", ""),//
    NFC119("119","119","End of the reprieve", ""),//
    NFC121("121","121","Entrepreneurial insolvency proceedings", ""),//
    NFC122("122","122","Execution", ""),//
    NFC124("124","124","Extrajudicial attempt to settle the debts", ""),//
    NFC126("126","126","Failure to keep account books", ""),//
    NFC127("127","127","Failure to submit the annual accounts to the general assembly within six months", ""),//
    NFC128("128","128","Filing of debt statement", ""),//
    NFC129("129","129","Final suspension", ""),//
    NFC130("130","130","Garnishment of wages and salaries", ""),//
    NFC131("131","131","Granting of residual debt release", ""),//
    NFC132("132","132","Indication of insufficiency of assets", ""),//
    NFC133("133","133","Injunction to pay", ""),//
    NFC135("135","135","Insolvency proceedings", ""),//
    NFC136("136","136","Insolvency proceedings on estate", ""),//
    NFC137("137","137","Issuing of uncovered bank cheques", ""),//
    NFC138("138","138","Judicial attempt to settle the debts", ""),//
    NFC139("139","139","Judicial winding up", ""),//
    NFC140("140","140","Judiciary liquidation", ""),//
    NFC141("141","141","Judiciary recovery", ""),//
    NFC142("142","142","Law of Reorganization of Debts for Private Persons is definitively applicable on the director(s).", ""),//
    NFC143("143","143","Legal dissolution by expiry", ""),//
    NFC144("144","144","Liquidation", ""),//
    NFC145("145","145","Loan authorization or agreement to defer payment", ""),//
    NFC146("146","146","Loss certificate", ""),//
    NFC147("147","147","Loss certificate from bankruptcy", ""),//
    NFC148("148","148","Loss certificate from seizure", ""),//
    NFC149("149","149","Modification of receiver's powers", ""),//
    NFC150("150","150","no longer subject to VAT", ""),//
    NFC151("151","151","Non-dissolution of the company - continuation of activity", ""),//
    NFC152("152","152","Oath of disclosure/oath of manifestation", ""),//
    NFC153("153","153","Occasional seizure-loss certificate", ""),//
    NFC154("154","154","Decision to open restructuring proceedings", ""),//
    NFC155("155","155","Opening of bankruptcy proceedings", ""),//
    NFC156("156","156","Opening of composition proceedings", ""),//
    NFC157("157","157","Opening of follow-up bankruptcy proceedings", ""),//
    NFC158("158","158","Opening of insolvency proceedings", ""),//
    NFC159("159","159","Order for arrest", ""),//
    NFC160("160","160","Order for compulsory auction (immovables)", ""),//
    NFC161("161","161","Order for self-administration", ""),//
    NFC162("162","162","Order for sequestration", ""),//
    NFC163("163","163","Order of a judicially enforced receivership (immovables)", ""),//
    NFC165("165","165","Overdue debts towards social security", ""),//
    NFC167("167","167","Partial cessation plan", ""),//
    NFC168("168","168","Payment extension", ""),//
    NFC169("169","169","Personal bankruptcy", ""),//
    NFC170("170","170","Petition for compulsory auction", ""),//
    NFC171("171","171","Petition for garnishment order", ""),//
    NFC172("172","172","Petition for injunction to pay", ""),//
    NFC173("173","173","Petition for insolvency / bankruptcy / winding-up", ""),//
    NFC174("174","174","Petition for judicial enforced receivership (immovables)", ""),//
    NFC175("175","175","Petition for liquidation", ""),//
    NFC176("176","176","Petition to dissolve, due to the lack of documentation /on application of the company itself", ""),//
    NFC177("177","177","Plan of total cessation", ""),//
    NFC178("178","178","Prohibition of trade", ""),//
    NFC179("179","179","Protest (draft or bill of exchange)", ""),//
    NFC180("180","180","Removed by the VAT administration", ""),//
    NFC181("181","181","Renewal of observation period", ""),//
    NFC182("182","182","Reorganisation completed", ""),//
    NFC183("183","183","Reorganization of debts has been rejected.", ""),//
    NFC184("184","184","Reorganization of debts has been withdrawn.", ""),//
    NFC185("185","185","Restructuring payment programme dropped", ""),//
    NFC187("187","187","Restructuring petition", ""),//
    NFC188("188","188","Restructuring petition or proceedings dropped or dismissed", ""),//
    NFC189("189","189","Restructuring petition or proceedings rejected", ""),//
    NFC190("190","190","Resumption of activity after bankruptcy", ""),//
    NFC191("191","191","Revocation of voluntary arrangement", ""),//
    NFC192("192","192","Serious action taken to wind-up the Business", ""),//
    NFC194("194","194","Statement of insolvency", ""),//
    NFC195("195","195","Subject company had to face strike-activities.", ""),//
    NFC196("196","196","Subject company was confronted with problems related to environmental legislation.", ""),//
    NFC197("197","197","Subject company was confronted with serious selling problems in the foreign countries.", ""),//
    NFC198("198","198","Subject company was confronted with the consequences of financial malversations comitted by a third party.", ""),//
    NFC199("199","199","Subject company was hit by natural disaster", ""),//
    NFC202("202","202","Suspension of payment", ""),//
    NFC203("203","203","Suspension of payment canceled by ratification of the offered agreement.", ""),//
    NFC205("205","205","Suspension of payment was changed into the Law of Reorganization of Debts for Private Persons", ""),//
    NFC206("206","206","Tax arrears", ""),//
    NFC208("208","208","unofficial information: Announcement : change of legal form", ""),//
    NFC209("209","209","unofficial information: Announcement : change of name", ""),//
    NFC210("210","210","unofficial information: Announcement : change of purpose", ""),//
    NFC211("211","211","unofficial information: Announcement : closing", ""),//
    NFC212("212","212","unofficial information: Announcement : constitution due to division", ""),//
    NFC213("213","213","unofficial information: Announcement : decrease in the nominal capital", ""),//
    NFC214("214","214","unofficial information: Announcement : dissolution because of merger", ""),//
    NFC215("215","215","unofficial information: Announcement : dissolution in view of a scission", ""),//
    NFC216("216","216","unofficial information: Announcement : division", ""),//
    NFC217("217","217","unofficial information: Announcement : earlier decomposition", ""),//
    NFC218("218","218","unofficial information: Announcement : increase in the nominal capital", ""),//
    NFC219("219","219","unofficial information: Announcement : increase in the nominal capital", ""),//
    NFC220("220","220","unofficial information: Announcement : merger", ""),//
    NFC221("221","221","unofficial information: Announcement : merger by absorption of third party", ""),//
    NFC222("222","222","unofficial information: Announcement : merger with third party", ""),//
    NFC224("224","224","unofficial information: Announcement : transfer of the seat", ""),//
    NFC225("225","225","unofficial information: Apply for composition", ""),//
    NFC227("227","227","unofficial information: Business manager involved in legal proceedings", ""),//
    NFC228("228","228","unofficial information: Business premises burned down", ""),//
    NFC229("229","229","unofficial information: Business premises partially burned down", ""),//
    NFC230("230","230","unofficial information: Changes in the board of directors", ""),//
    NFC231("231","231","unofficial information: Closing of department", ""),//
    NFC232("232","232","unofficial information: Company in total liquidation", ""),//
    NFC233("233","233","unofficial information: Company is for sale", ""),//
    NFC234("234","234","unofficial information: Contribution of assets/liabilities or part of it by third party", ""),//
    NFC235("235","235","unofficial information: Contribution of assets/liabilities or part of it to third party", ""),//
    NFC236("236","236","unofficial information: Does not live any more at the address", ""),//
    NFC237("237","237","unofficial information: Filing for bankruptcy", ""),//
    NFC238("238","238","unofficial information: Incidents", ""),//
    NFC239("239","239","unofficial information: Incidents that could have jeopardised the continuity of the business have been resolved", ""),//
    NFC240("240","240","unofficial information: Left without address", ""),//
    NFC241("241","241","unofficial information: most recent balance-sheet data", ""),//
    NFC242("242","242","unofficial information: Negotiation concerning merger", ""),//
    NFC243("243","243","unofficial information: Negotiations take-over department by third party", ""),//
    NFC244("244","244","unofficial information: Negotiations take-over department of third party", ""),//
    NFC245("245","245","unofficial information: Negotiations take-over of shares by third party", ""),//
    NFC246("246","246","unofficial information: Negotiations take-over of shares from third party", ""),//
    NFC247("247","247","unofficial information: Negotiations take-over of third party", ""),//
    NFC248("248","248","unofficial information: New investments", ""),//
    NFC249("249","249","unofficial information: No activity at the address", ""),//
    NFC250("250","250","unofficial information: Participation", ""),//
    NFC251("251","251","unofficial information: Principal shareholder bankrupt", ""),//
    NFC252("252","252","unofficial information: Protested bill(s) in the name of a manager", ""),//
    NFC253("253","253","unofficial information: Public sale", ""),//
    NFC254("254","254","unofficial information: Restructuring within the company", ""),//
    NFC255("255","255","unofficial information: Resumption of activity", ""),//
    NFC256("256","256","unofficial information: Serious incidents that could jeopardise the continuity of the business", ""),//
    NFC257("257","257","unofficial information: Serious incidents with financial consequences", ""),//
    NFC258("258","258","unofficial information: Serious incidents with legal consequences", ""),//
    NFC259("259","259","unofficial information: Social turmoils", ""),//
    NFC260("260","260","unofficial information: Social turmoils resolved", ""),//
    NFC261("261","261","unofficial information: Subsidiary bankrupt", ""),//
    NFC262("262","262","unofficial information: Summoned in bankruptcy", ""),//
    NFC263("263","263","unofficial information: Take over of shares from other company", ""),//
    NFC264("264","264","unofficial information: Take over of the shares", ""),//
    NFC265("265","265","unofficial information: Take over of third party", ""),//
    NFC266("266","266","unofficial information: Taken over", ""),//
    NFC267("267","267","unofficial information: Take-over of activity by third party", ""),//
    NFC268("268","268","unofficial information: Take-over of activity of third party", ""),//
    NFC269("269","269","unofficial information: Takeover of business by third party", ""),//
    NFC270("270","270","unofficial information: Takeover of business from third party", ""),//
    NFC271("271","271","unofficial information: Taking over of division by third party", ""),//
    NFC272("272","272","unofficial information: Taking over of division of third party", ""),//
    NFC273("273","273","unofficial information: Unknown at the address", ""),//
    NFC274("274","274","No proof of satisfaction of the creditors after 1 month", ""),//
    NFC275("275","275","Non-filing of the asset declaration", ""),//
    NFC276("276","276","Satisfaction of creditors excluded", ""),//
    NFC277("277","277","Opening of juridical preliminary proceedings", ""),//
    NFC278("278","278","Petition for registration of compulsory mortgage", ""),//
    NFC279("279","279","Registration of a compulsory mortgage (immovables)", ""),//
    NFC280("280","280","Public administration deeds", ""),//
    NFC281("281","281","Mortis causa acts", ""),//
    NFC282("282","282","Inter vivos acts", ""),//
    NFC284("284","284","Registered changes: for changes in credit guarantee", ""),//
    NFC285("285","285","Preemption: for special privileges acts", ""),//
    NFC286("286","286","Creditor protection proceedings", "");//


    private String nameDB;
    private String nameBigNet;
    private String bigNetDec;
    private String dbDec;

    EnumNegativeFact(String nameDB, String nameBigNet, String bigNetDec, String dbDec) {
        this.nameDB = nameDB;
        this.nameBigNet = nameBigNet;
        this.bigNetDec =bigNetDec;
        this.dbDec = dbDec;
    }

    public String getNameDB(){
        return nameDB;
    }
    public String getNameBigNet(){
        return nameBigNet;
    }
    public String getBigNetDec() {
        return bigNetDec;
    }

    public String getDbDec() {
        return dbDec;
    }

    public static String getNameBigNetByDB(String nameDB) {
        EnumNegativeFact[] values = EnumNegativeFact.values();
        for (EnumNegativeFact value : values) {
            if (Objects.equals(value.nameDB, nameDB)){
                return value.nameBigNet;
            }
        }
        return nameDB;
    }

    public static String getNameDBByBigNet(String nameBigNet) {
        EnumNegativeFact[] values = EnumNegativeFact.values();
        for (EnumNegativeFact value : values) {
            if (Objects.equals(value.nameBigNet, nameBigNet)){
                return value.nameDB;
            }
        }
        return nameBigNet;
    }


}
