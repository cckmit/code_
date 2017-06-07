
package com.creditsafe.globaldata.operations;

import com.creditsafe.globaldata.datatypes.*;
import com.creditsafe.globaldata.datatypes.reports.CompanyReportSet;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfunsignedInt;
import org.datacontract.schemas._2004._07.creditsafe.ArrayOfCountryCode;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.creditsafe.globaldata.operations package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetPortfoliosPortfolioIds_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "portfolioIds");
    private final static QName _GetPortfoliosChangedSince_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "changedSince");
    private final static QName _GetPortfoliosResponseGetPortfoliosResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "GetPortfoliosResult");
    private final static QName _ListMonitoredCompaniesResponseListMonitoredCompaniesResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "ListMonitoredCompaniesResult");
    private final static QName _CreatePortfolioSettings_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "settings");
    private final static QName _CreatePortfolioResponseCreatePortfolioResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "CreatePortfolioResult");
    private final static QName _RemovePortfoliosResponseRemovePortfoliosResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "RemovePortfoliosResult");
    private final static QName _GetPortfolioSettingsResponseGetPortfolioSettingsResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "GetPortfolioSettingsResult");
    private final static QName _SetPortfolioSettingsNewSettings_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "newSettings");
    private final static QName _SetPortfolioSettingsResponseSetPortfolioSettingsResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "SetPortfolioSettingsResult");
    private final static QName _AddCompaniesToPortfoliosCompanies_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "companies");
    private final static QName _AddCompaniesToPortfoliosResponseAddCompaniesToPortfoliosResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "AddCompaniesToPortfoliosResult");
    private final static QName _ImportCompaniesToPortfolioImportFile_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "importFile");
    private final static QName _ImportCompaniesToPortfolioResponseImportCompaniesToPortfolioResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "ImportCompaniesToPortfolioResult");
    private final static QName _RemoveCompaniesFromPortfoliosCompanyIds_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "companyIds");
    private final static QName _RemoveCompaniesFromPortfoliosResponseRemoveCompaniesFromPortfoliosResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "RemoveCompaniesFromPortfoliosResult");
    private final static QName _ChangeCompaniesReferenceStringsResponseChangeCompaniesReferenceStringsResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "ChangeCompaniesReferenceStringsResult");
    private final static QName _GetSupportedChangeEventsCountry_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "country");
    private final static QName _GetSupportedChangeEventsResponseGetSupportedChangeEventsResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "GetSupportedChangeEventsResult");
    private final static QName _GetMonitoringRulesResponseGetMonitoringRulesResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "GetMonitoringRulesResult");
    private final static QName _SetMonitoringRulesNewRules_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "newRules");
    private final static QName _SetMonitoringRulesResponseSetMonitoringRulesResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "SetMonitoringRulesResult");
    private final static QName _SetDefaultChangesCheckPeriodDays_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "days");
    private final static QName _SetDefaultChangesCheckPeriodResponseSetDefaultChangesCheckPeriodResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "SetDefaultChangesCheckPeriodResult");
    private final static QName _RetrieveCompanyOnlineReportCompanyId_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "companyId");
    private final static QName _RetrieveCompanyOnlineReportCustomData_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "customData");
    private final static QName _RetrieveCompanyOnlineReportChargeReference_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "chargeReference");
    private final static QName _RetrieveCompanyOnlineReportMonitoringReference_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "monitoringReference");
    private final static QName _RetrieveCompanyOnlineReportResponseRetrieveCompanyOnlineReportResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "RetrieveCompanyOnlineReportResult");
    private final static QName _TryRetrieveCompanyOnlineReportSearchCriteria_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "searchCriteria");
    private final static QName _TryRetrieveCompanyOnlineReportResponseTryRetrieveCompanyOnlineReportResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "TryRetrieveCompanyOnlineReportResult");
    private final static QName _OrderCompanyOfflineReportResponseOrderCompanyOfflineReportResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "OrderCompanyOfflineReportResult");
    private final static QName _GetReportboxContentsFilter_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "filter");
    private final static QName _GetReportboxContentsResponseGetReportboxContentsResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "GetReportboxContentsResult");
    private final static QName _GetReportboxReportsIds_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "ids");
    private final static QName _GetReportboxReportsResponseGetReportboxReportsResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "GetReportboxReportsResult");
    private final static QName _RemoveReportboxReportsResponseRemoveReportboxReportsResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "RemoveReportboxReportsResult");
    private final static QName _GetCountriesResponseGetCountriesResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "GetCountriesResult");
    private final static QName _GetPossibleSearchCriteriaCountries_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "countries");
    private final static QName _GetPossibleSearchCriteriaResponseGetPossibleSearchCriteriaResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "GetPossibleSearchCriteriaResult");
    private final static QName _FindCompaniesResponseFindCompaniesResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "FindCompaniesResult");
    private final static QName _GetReportCustomDataSchemaResponseGetReportCustomDataSchemaResult_QNAME = new QName("http://www.creditsafe.com/globaldata/operations", "GetReportCustomDataSchemaResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.creditsafe.globaldata.operations
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPortfolios }
     * 
     */
    public GetPortfolios createGetPortfolios() {
        return new GetPortfolios();
    }

    /**
     * Create an instance of {@link GetPortfoliosResponse }
     * 
     */
    public GetPortfoliosResponse createGetPortfoliosResponse() {
        return new GetPortfoliosResponse();
    }

    /**
     * Create an instance of {@link ListMonitoredCompanies }
     * 
     */
    public ListMonitoredCompanies createListMonitoredCompanies() {
        return new ListMonitoredCompanies();
    }

    /**
     * Create an instance of {@link ListMonitoredCompaniesResponse }
     * 
     */
    public ListMonitoredCompaniesResponse createListMonitoredCompaniesResponse() {
        return new ListMonitoredCompaniesResponse();
    }

    /**
     * Create an instance of {@link CreatePortfolio }
     * 
     */
    public CreatePortfolio createCreatePortfolio() {
        return new CreatePortfolio();
    }

    /**
     * Create an instance of {@link CreatePortfolioResponse }
     * 
     */
    public CreatePortfolioResponse createCreatePortfolioResponse() {
        return new CreatePortfolioResponse();
    }

    /**
     * Create an instance of {@link RemovePortfolios }
     * 
     */
    public RemovePortfolios createRemovePortfolios() {
        return new RemovePortfolios();
    }

    /**
     * Create an instance of {@link RemovePortfoliosResponse }
     * 
     */
    public RemovePortfoliosResponse createRemovePortfoliosResponse() {
        return new RemovePortfoliosResponse();
    }

    /**
     * Create an instance of {@link GetPortfolioSettings }
     * 
     */
    public GetPortfolioSettings createGetPortfolioSettings() {
        return new GetPortfolioSettings();
    }

    /**
     * Create an instance of {@link GetPortfolioSettingsResponse }
     * 
     */
    public GetPortfolioSettingsResponse createGetPortfolioSettingsResponse() {
        return new GetPortfolioSettingsResponse();
    }

    /**
     * Create an instance of {@link SetPortfolioSettings }
     * 
     */
    public SetPortfolioSettings createSetPortfolioSettings() {
        return new SetPortfolioSettings();
    }

    /**
     * Create an instance of {@link SetPortfolioSettingsResponse }
     * 
     */
    public SetPortfolioSettingsResponse createSetPortfolioSettingsResponse() {
        return new SetPortfolioSettingsResponse();
    }

    /**
     * Create an instance of {@link AddCompaniesToPortfolios }
     * 
     */
    public AddCompaniesToPortfolios createAddCompaniesToPortfolios() {
        return new AddCompaniesToPortfolios();
    }

    /**
     * Create an instance of {@link AddCompaniesToPortfoliosResponse }
     * 
     */
    public AddCompaniesToPortfoliosResponse createAddCompaniesToPortfoliosResponse() {
        return new AddCompaniesToPortfoliosResponse();
    }

    /**
     * Create an instance of {@link ImportCompaniesToPortfolio }
     * 
     */
    public ImportCompaniesToPortfolio createImportCompaniesToPortfolio() {
        return new ImportCompaniesToPortfolio();
    }

    /**
     * Create an instance of {@link ImportCompaniesToPortfolioResponse }
     * 
     */
    public ImportCompaniesToPortfolioResponse createImportCompaniesToPortfolioResponse() {
        return new ImportCompaniesToPortfolioResponse();
    }

    /**
     * Create an instance of {@link RemoveCompaniesFromPortfolios }
     * 
     */
    public RemoveCompaniesFromPortfolios createRemoveCompaniesFromPortfolios() {
        return new RemoveCompaniesFromPortfolios();
    }

    /**
     * Create an instance of {@link RemoveCompaniesFromPortfoliosResponse }
     * 
     */
    public RemoveCompaniesFromPortfoliosResponse createRemoveCompaniesFromPortfoliosResponse() {
        return new RemoveCompaniesFromPortfoliosResponse();
    }

    /**
     * Create an instance of {@link ChangeCompaniesReferenceStrings }
     * 
     */
    public ChangeCompaniesReferenceStrings createChangeCompaniesReferenceStrings() {
        return new ChangeCompaniesReferenceStrings();
    }

    /**
     * Create an instance of {@link ChangeCompaniesReferenceStringsResponse }
     * 
     */
    public ChangeCompaniesReferenceStringsResponse createChangeCompaniesReferenceStringsResponse() {
        return new ChangeCompaniesReferenceStringsResponse();
    }

    /**
     * Create an instance of {@link GetSupportedChangeEvents }
     * 
     */
    public GetSupportedChangeEvents createGetSupportedChangeEvents() {
        return new GetSupportedChangeEvents();
    }

    /**
     * Create an instance of {@link GetSupportedChangeEventsResponse }
     * 
     */
    public GetSupportedChangeEventsResponse createGetSupportedChangeEventsResponse() {
        return new GetSupportedChangeEventsResponse();
    }

    /**
     * Create an instance of {@link GetMonitoringRules }
     * 
     */
    public GetMonitoringRules createGetMonitoringRules() {
        return new GetMonitoringRules();
    }

    /**
     * Create an instance of {@link GetMonitoringRulesResponse }
     * 
     */
    public GetMonitoringRulesResponse createGetMonitoringRulesResponse() {
        return new GetMonitoringRulesResponse();
    }

    /**
     * Create an instance of {@link SetMonitoringRules }
     * 
     */
    public SetMonitoringRules createSetMonitoringRules() {
        return new SetMonitoringRules();
    }

    /**
     * Create an instance of {@link SetMonitoringRulesResponse }
     * 
     */
    public SetMonitoringRulesResponse createSetMonitoringRulesResponse() {
        return new SetMonitoringRulesResponse();
    }

    /**
     * Create an instance of {@link SetDefaultChangesCheckPeriod }
     * 
     */
    public SetDefaultChangesCheckPeriod createSetDefaultChangesCheckPeriod() {
        return new SetDefaultChangesCheckPeriod();
    }

    /**
     * Create an instance of {@link SetDefaultChangesCheckPeriodResponse }
     * 
     */
    public SetDefaultChangesCheckPeriodResponse createSetDefaultChangesCheckPeriodResponse() {
        return new SetDefaultChangesCheckPeriodResponse();
    }

    /**
     * Create an instance of {@link RetrieveCompanyOnlineReport }
     * 
     */
    public RetrieveCompanyOnlineReport createRetrieveCompanyOnlineReport() {
        return new RetrieveCompanyOnlineReport();
    }

    /**
     * Create an instance of {@link RetrieveCompanyOnlineReportResponse }
     * 
     */
    public RetrieveCompanyOnlineReportResponse createRetrieveCompanyOnlineReportResponse() {
        return new RetrieveCompanyOnlineReportResponse();
    }

    /**
     * Create an instance of {@link TryRetrieveCompanyOnlineReport }
     * 
     */
    public TryRetrieveCompanyOnlineReport createTryRetrieveCompanyOnlineReport() {
        return new TryRetrieveCompanyOnlineReport();
    }

    /**
     * Create an instance of {@link TryRetrieveCompanyOnlineReportResponse }
     * 
     */
    public TryRetrieveCompanyOnlineReportResponse createTryRetrieveCompanyOnlineReportResponse() {
        return new TryRetrieveCompanyOnlineReportResponse();
    }

    /**
     * Create an instance of {@link OrderCompanyOfflineReport }
     * 
     */
    public OrderCompanyOfflineReport createOrderCompanyOfflineReport() {
        return new OrderCompanyOfflineReport();
    }

    /**
     * Create an instance of {@link OrderCompanyOfflineReportResponse }
     * 
     */
    public OrderCompanyOfflineReportResponse createOrderCompanyOfflineReportResponse() {
        return new OrderCompanyOfflineReportResponse();
    }

    /**
     * Create an instance of {@link GetReportboxContents }
     * 
     */
    public GetReportboxContents createGetReportboxContents() {
        return new GetReportboxContents();
    }

    /**
     * Create an instance of {@link GetReportboxContentsResponse }
     * 
     */
    public GetReportboxContentsResponse createGetReportboxContentsResponse() {
        return new GetReportboxContentsResponse();
    }

    /**
     * Create an instance of {@link GetReportboxReports }
     * 
     */
    public GetReportboxReports createGetReportboxReports() {
        return new GetReportboxReports();
    }

    /**
     * Create an instance of {@link GetReportboxReportsResponse }
     * 
     */
    public GetReportboxReportsResponse createGetReportboxReportsResponse() {
        return new GetReportboxReportsResponse();
    }

    /**
     * Create an instance of {@link RemoveReportboxReports }
     * 
     */
    public RemoveReportboxReports createRemoveReportboxReports() {
        return new RemoveReportboxReports();
    }

    /**
     * Create an instance of {@link RemoveReportboxReportsResponse }
     * 
     */
    public RemoveReportboxReportsResponse createRemoveReportboxReportsResponse() {
        return new RemoveReportboxReportsResponse();
    }

    /**
     * Create an instance of {@link GetCountries }
     * 
     */
    public GetCountries createGetCountries() {
        return new GetCountries();
    }

    /**
     * Create an instance of {@link GetCountriesResponse }
     * 
     */
    public GetCountriesResponse createGetCountriesResponse() {
        return new GetCountriesResponse();
    }

    /**
     * Create an instance of {@link GetPossibleSearchCriteria }
     * 
     */
    public GetPossibleSearchCriteria createGetPossibleSearchCriteria() {
        return new GetPossibleSearchCriteria();
    }

    /**
     * Create an instance of {@link GetPossibleSearchCriteriaResponse }
     * 
     */
    public GetPossibleSearchCriteriaResponse createGetPossibleSearchCriteriaResponse() {
        return new GetPossibleSearchCriteriaResponse();
    }

    /**
     * Create an instance of {@link FindCompanies }
     * 
     */
    public FindCompanies createFindCompanies() {
        return new FindCompanies();
    }

    /**
     * Create an instance of {@link FindCompaniesResponse }
     * 
     */
    public FindCompaniesResponse createFindCompaniesResponse() {
        return new FindCompaniesResponse();
    }

    /**
     * Create an instance of {@link GetReportCustomDataSchema }
     * 
     */
    public GetReportCustomDataSchema createGetReportCustomDataSchema() {
        return new GetReportCustomDataSchema();
    }

    /**
     * Create an instance of {@link GetReportCustomDataSchemaResponse }
     * 
     */
    public GetReportCustomDataSchemaResponse createGetReportCustomDataSchemaResponse() {
        return new GetReportCustomDataSchemaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfunsignedInt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "portfolioIds", scope = GetPortfolios.class)
    public JAXBElement<ArrayOfunsignedInt> createGetPortfoliosPortfolioIds(ArrayOfunsignedInt value) {
        return new JAXBElement<ArrayOfunsignedInt>(_GetPortfoliosPortfolioIds_QNAME, ArrayOfunsignedInt.class, GetPortfolios.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "changedSince", scope = GetPortfolios.class)
    public JAXBElement<XMLGregorianCalendar> createGetPortfoliosChangedSince(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetPortfoliosChangedSince_QNAME, XMLGregorianCalendar.class, GetPortfolios.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PortfoliosList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "GetPortfoliosResult", scope = GetPortfoliosResponse.class)
    public JAXBElement<PortfoliosList> createGetPortfoliosResponseGetPortfoliosResult(PortfoliosList value) {
        return new JAXBElement<PortfoliosList>(_GetPortfoliosResponseGetPortfoliosResult_QNAME, PortfoliosList.class, GetPortfoliosResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfunsignedInt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "portfolioIds", scope = ListMonitoredCompanies.class)
    public JAXBElement<ArrayOfunsignedInt> createListMonitoredCompaniesPortfolioIds(ArrayOfunsignedInt value) {
        return new JAXBElement<ArrayOfunsignedInt>(_GetPortfoliosPortfolioIds_QNAME, ArrayOfunsignedInt.class, ListMonitoredCompanies.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "changedSince", scope = ListMonitoredCompanies.class)
    public JAXBElement<XMLGregorianCalendar> createListMonitoredCompaniesChangedSince(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetPortfoliosChangedSince_QNAME, XMLGregorianCalendar.class, ListMonitoredCompanies.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MonitoredCompaniesList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "ListMonitoredCompaniesResult", scope = ListMonitoredCompaniesResponse.class)
    public JAXBElement<MonitoredCompaniesList> createListMonitoredCompaniesResponseListMonitoredCompaniesResult(MonitoredCompaniesList value) {
        return new JAXBElement<MonitoredCompaniesList>(_ListMonitoredCompaniesResponseListMonitoredCompaniesResult_QNAME, MonitoredCompaniesList.class, ListMonitoredCompaniesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PortfolioSettings }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "settings", scope = CreatePortfolio.class)
    public JAXBElement<PortfolioSettings> createCreatePortfolioSettings(PortfolioSettings value) {
        return new JAXBElement<PortfolioSettings>(_CreatePortfolioSettings_QNAME, PortfolioSettings.class, CreatePortfolio.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PortfoliosList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "CreatePortfolioResult", scope = CreatePortfolioResponse.class)
    public JAXBElement<PortfoliosList> createCreatePortfolioResponseCreatePortfolioResult(PortfoliosList value) {
        return new JAXBElement<PortfoliosList>(_CreatePortfolioResponseCreatePortfolioResult_QNAME, PortfoliosList.class, CreatePortfolioResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfunsignedInt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "portfolioIds", scope = RemovePortfolios.class)
    public JAXBElement<ArrayOfunsignedInt> createRemovePortfoliosPortfolioIds(ArrayOfunsignedInt value) {
        return new JAXBElement<ArrayOfunsignedInt>(_GetPortfoliosPortfolioIds_QNAME, ArrayOfunsignedInt.class, RemovePortfolios.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "RemovePortfoliosResult", scope = RemovePortfoliosResponse.class)
    public JAXBElement<SimpleResult> createRemovePortfoliosResponseRemovePortfoliosResult(SimpleResult value) {
        return new JAXBElement<SimpleResult>(_RemovePortfoliosResponseRemovePortfoliosResult_QNAME, SimpleResult.class, RemovePortfoliosResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrentPortfolioSettings }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "GetPortfolioSettingsResult", scope = GetPortfolioSettingsResponse.class)
    public JAXBElement<CurrentPortfolioSettings> createGetPortfolioSettingsResponseGetPortfolioSettingsResult(CurrentPortfolioSettings value) {
        return new JAXBElement<CurrentPortfolioSettings>(_GetPortfolioSettingsResponseGetPortfolioSettingsResult_QNAME, CurrentPortfolioSettings.class, GetPortfolioSettingsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PortfolioSettings }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "newSettings", scope = SetPortfolioSettings.class)
    public JAXBElement<PortfolioSettings> createSetPortfolioSettingsNewSettings(PortfolioSettings value) {
        return new JAXBElement<PortfolioSettings>(_SetPortfolioSettingsNewSettings_QNAME, PortfolioSettings.class, SetPortfolioSettings.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "SetPortfolioSettingsResult", scope = SetPortfolioSettingsResponse.class)
    public JAXBElement<SimpleResult> createSetPortfolioSettingsResponseSetPortfolioSettingsResult(SimpleResult value) {
        return new JAXBElement<SimpleResult>(_SetPortfolioSettingsResponseSetPortfolioSettingsResult_QNAME, SimpleResult.class, SetPortfolioSettingsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfunsignedInt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "portfolioIds", scope = AddCompaniesToPortfolios.class)
    public JAXBElement<ArrayOfunsignedInt> createAddCompaniesToPortfoliosPortfolioIds(ArrayOfunsignedInt value) {
        return new JAXBElement<ArrayOfunsignedInt>(_GetPortfoliosPortfolioIds_QNAME, ArrayOfunsignedInt.class, AddCompaniesToPortfolios.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompanyReferences }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "companies", scope = AddCompaniesToPortfolios.class)
    public JAXBElement<CompanyReferences> createAddCompaniesToPortfoliosCompanies(CompanyReferences value) {
        return new JAXBElement<CompanyReferences>(_AddCompaniesToPortfoliosCompanies_QNAME, CompanyReferences.class, AddCompaniesToPortfolios.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PortfolioCompanyAdditionResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "AddCompaniesToPortfoliosResult", scope = AddCompaniesToPortfoliosResponse.class)
    public JAXBElement<PortfolioCompanyAdditionResult> createAddCompaniesToPortfoliosResponseAddCompaniesToPortfoliosResult(PortfolioCompanyAdditionResult value) {
        return new JAXBElement<PortfolioCompanyAdditionResult>(_AddCompaniesToPortfoliosResponseAddCompaniesToPortfoliosResult_QNAME, PortfolioCompanyAdditionResult.class, AddCompaniesToPortfoliosResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "importFile", scope = ImportCompaniesToPortfolio.class)
    public JAXBElement<byte[]> createImportCompaniesToPortfolioImportFile(byte[] value) {
        return new JAXBElement<byte[]>(_ImportCompaniesToPortfolioImportFile_QNAME, byte[].class, ImportCompaniesToPortfolio.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PortfolioCompanyAdditionResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "ImportCompaniesToPortfolioResult", scope = ImportCompaniesToPortfolioResponse.class)
    public JAXBElement<PortfolioCompanyAdditionResult> createImportCompaniesToPortfolioResponseImportCompaniesToPortfolioResult(PortfolioCompanyAdditionResult value) {
        return new JAXBElement<PortfolioCompanyAdditionResult>(_ImportCompaniesToPortfolioResponseImportCompaniesToPortfolioResult_QNAME, PortfolioCompanyAdditionResult.class, ImportCompaniesToPortfolioResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfunsignedInt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "portfolioIds", scope = RemoveCompaniesFromPortfolios.class)
    public JAXBElement<ArrayOfunsignedInt> createRemoveCompaniesFromPortfoliosPortfolioIds(ArrayOfunsignedInt value) {
        return new JAXBElement<ArrayOfunsignedInt>(_GetPortfoliosPortfolioIds_QNAME, ArrayOfunsignedInt.class, RemoveCompaniesFromPortfolios.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "companyIds", scope = RemoveCompaniesFromPortfolios.class)
    public JAXBElement<ArrayOfstring> createRemoveCompaniesFromPortfoliosCompanyIds(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_RemoveCompaniesFromPortfoliosCompanyIds_QNAME, ArrayOfstring.class, RemoveCompaniesFromPortfolios.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PortfolioCompanyRemovalResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "RemoveCompaniesFromPortfoliosResult", scope = RemoveCompaniesFromPortfoliosResponse.class)
    public JAXBElement<PortfolioCompanyRemovalResult> createRemoveCompaniesFromPortfoliosResponseRemoveCompaniesFromPortfoliosResult(PortfolioCompanyRemovalResult value) {
        return new JAXBElement<PortfolioCompanyRemovalResult>(_RemoveCompaniesFromPortfoliosResponseRemoveCompaniesFromPortfoliosResult_QNAME, PortfolioCompanyRemovalResult.class, RemoveCompaniesFromPortfoliosResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfunsignedInt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "portfolioIds", scope = ChangeCompaniesReferenceStrings.class)
    public JAXBElement<ArrayOfunsignedInt> createChangeCompaniesReferenceStringsPortfolioIds(ArrayOfunsignedInt value) {
        return new JAXBElement<ArrayOfunsignedInt>(_GetPortfoliosPortfolioIds_QNAME, ArrayOfunsignedInt.class, ChangeCompaniesReferenceStrings.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompanyReferences }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "companies", scope = ChangeCompaniesReferenceStrings.class)
    public JAXBElement<CompanyReferences> createChangeCompaniesReferenceStringsCompanies(CompanyReferences value) {
        return new JAXBElement<CompanyReferences>(_AddCompaniesToPortfoliosCompanies_QNAME, CompanyReferences.class, ChangeCompaniesReferenceStrings.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "ChangeCompaniesReferenceStringsResult", scope = ChangeCompaniesReferenceStringsResponse.class)
    public JAXBElement<SimpleResult> createChangeCompaniesReferenceStringsResponseChangeCompaniesReferenceStringsResult(SimpleResult value) {
        return new JAXBElement<SimpleResult>(_ChangeCompaniesReferenceStringsResponseChangeCompaniesReferenceStringsResult_QNAME, SimpleResult.class, ChangeCompaniesReferenceStringsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountryCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "country", scope = GetSupportedChangeEvents.class)
    public JAXBElement<CountryCode> createGetSupportedChangeEventsCountry(CountryCode value) {
        return new JAXBElement<CountryCode>(_GetSupportedChangeEventsCountry_QNAME, CountryCode.class, GetSupportedChangeEvents.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SupportedChangeEventsList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "GetSupportedChangeEventsResult", scope = GetSupportedChangeEventsResponse.class)
    public JAXBElement<SupportedChangeEventsList> createGetSupportedChangeEventsResponseGetSupportedChangeEventsResult(SupportedChangeEventsList value) {
        return new JAXBElement<SupportedChangeEventsList>(_GetSupportedChangeEventsResponseGetSupportedChangeEventsResult_QNAME, SupportedChangeEventsList.class, GetSupportedChangeEventsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrentPortfolioMonitoringRules }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "GetMonitoringRulesResult", scope = GetMonitoringRulesResponse.class)
    public JAXBElement<CurrentPortfolioMonitoringRules> createGetMonitoringRulesResponseGetMonitoringRulesResult(CurrentPortfolioMonitoringRules value) {
        return new JAXBElement<CurrentPortfolioMonitoringRules>(_GetMonitoringRulesResponseGetMonitoringRulesResult_QNAME, CurrentPortfolioMonitoringRules.class, GetMonitoringRulesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MonitoringRules }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "newRules", scope = SetMonitoringRules.class)
    public JAXBElement<MonitoringRules> createSetMonitoringRulesNewRules(MonitoringRules value) {
        return new JAXBElement<MonitoringRules>(_SetMonitoringRulesNewRules_QNAME, MonitoringRules.class, SetMonitoringRules.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "SetMonitoringRulesResult", scope = SetMonitoringRulesResponse.class)
    public JAXBElement<SimpleResult> createSetMonitoringRulesResponseSetMonitoringRulesResult(SimpleResult value) {
        return new JAXBElement<SimpleResult>(_SetMonitoringRulesResponseSetMonitoringRulesResult_QNAME, SimpleResult.class, SetMonitoringRulesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "days", scope = SetDefaultChangesCheckPeriod.class)
    public JAXBElement<Long> createSetDefaultChangesCheckPeriodDays(Long value) {
        return new JAXBElement<Long>(_SetDefaultChangesCheckPeriodDays_QNAME, Long.class, SetDefaultChangesCheckPeriod.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "SetDefaultChangesCheckPeriodResult", scope = SetDefaultChangesCheckPeriodResponse.class)
    public JAXBElement<SimpleResult> createSetDefaultChangesCheckPeriodResponseSetDefaultChangesCheckPeriodResult(SimpleResult value) {
        return new JAXBElement<SimpleResult>(_SetDefaultChangesCheckPeriodResponseSetDefaultChangesCheckPeriodResult_QNAME, SimpleResult.class, SetDefaultChangesCheckPeriodResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "companyId", scope = RetrieveCompanyOnlineReport.class)
    public JAXBElement<String> createRetrieveCompanyOnlineReportCompanyId(String value) {
        return new JAXBElement<String>(_RetrieveCompanyOnlineReportCompanyId_QNAME, String.class, RetrieveCompanyOnlineReport.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "customData", scope = RetrieveCompanyOnlineReport.class)
    public JAXBElement<CustomData> createRetrieveCompanyOnlineReportCustomData(CustomData value) {
        return new JAXBElement<CustomData>(_RetrieveCompanyOnlineReportCustomData_QNAME, CustomData.class, RetrieveCompanyOnlineReport.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "chargeReference", scope = RetrieveCompanyOnlineReport.class)
    public JAXBElement<String> createRetrieveCompanyOnlineReportChargeReference(String value) {
        return new JAXBElement<String>(_RetrieveCompanyOnlineReportChargeReference_QNAME, String.class, RetrieveCompanyOnlineReport.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfunsignedInt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "portfolioIds", scope = RetrieveCompanyOnlineReport.class)
    public JAXBElement<ArrayOfunsignedInt> createRetrieveCompanyOnlineReportPortfolioIds(ArrayOfunsignedInt value) {
        return new JAXBElement<ArrayOfunsignedInt>(_GetPortfoliosPortfolioIds_QNAME, ArrayOfunsignedInt.class, RetrieveCompanyOnlineReport.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "monitoringReference", scope = RetrieveCompanyOnlineReport.class)
    public JAXBElement<String> createRetrieveCompanyOnlineReportMonitoringReference(String value) {
        return new JAXBElement<String>(_RetrieveCompanyOnlineReportMonitoringReference_QNAME, String.class, RetrieveCompanyOnlineReport.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompanyReportSet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "RetrieveCompanyOnlineReportResult", scope = RetrieveCompanyOnlineReportResponse.class)
    public JAXBElement<CompanyReportSet> createRetrieveCompanyOnlineReportResponseRetrieveCompanyOnlineReportResult(CompanyReportSet value) {
        return new JAXBElement<CompanyReportSet>(_RetrieveCompanyOnlineReportResponseRetrieveCompanyOnlineReportResult_QNAME, CompanyReportSet.class, RetrieveCompanyOnlineReportResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCriteria }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "searchCriteria", scope = TryRetrieveCompanyOnlineReport.class)
    public JAXBElement<SearchCriteria> createTryRetrieveCompanyOnlineReportSearchCriteria(SearchCriteria value) {
        return new JAXBElement<SearchCriteria>(_TryRetrieveCompanyOnlineReportSearchCriteria_QNAME, SearchCriteria.class, TryRetrieveCompanyOnlineReport.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "customData", scope = TryRetrieveCompanyOnlineReport.class)
    public JAXBElement<CustomData> createTryRetrieveCompanyOnlineReportCustomData(CustomData value) {
        return new JAXBElement<CustomData>(_RetrieveCompanyOnlineReportCustomData_QNAME, CustomData.class, TryRetrieveCompanyOnlineReport.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "chargeReference", scope = TryRetrieveCompanyOnlineReport.class)
    public JAXBElement<String> createTryRetrieveCompanyOnlineReportChargeReference(String value) {
        return new JAXBElement<String>(_RetrieveCompanyOnlineReportChargeReference_QNAME, String.class, TryRetrieveCompanyOnlineReport.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfunsignedInt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "portfolioIds", scope = TryRetrieveCompanyOnlineReport.class)
    public JAXBElement<ArrayOfunsignedInt> createTryRetrieveCompanyOnlineReportPortfolioIds(ArrayOfunsignedInt value) {
        return new JAXBElement<ArrayOfunsignedInt>(_GetPortfoliosPortfolioIds_QNAME, ArrayOfunsignedInt.class, TryRetrieveCompanyOnlineReport.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompanyReportSet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "TryRetrieveCompanyOnlineReportResult", scope = TryRetrieveCompanyOnlineReportResponse.class)
    public JAXBElement<CompanyReportSet> createTryRetrieveCompanyOnlineReportResponseTryRetrieveCompanyOnlineReportResult(CompanyReportSet value) {
        return new JAXBElement<CompanyReportSet>(_TryRetrieveCompanyOnlineReportResponseTryRetrieveCompanyOnlineReportResult_QNAME, CompanyReportSet.class, TryRetrieveCompanyOnlineReportResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCriteria }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "searchCriteria", scope = OrderCompanyOfflineReport.class)
    public JAXBElement<SearchCriteria> createOrderCompanyOfflineReportSearchCriteria(SearchCriteria value) {
        return new JAXBElement<SearchCriteria>(_TryRetrieveCompanyOnlineReportSearchCriteria_QNAME, SearchCriteria.class, OrderCompanyOfflineReport.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "customData", scope = OrderCompanyOfflineReport.class)
    public JAXBElement<CustomData> createOrderCompanyOfflineReportCustomData(CustomData value) {
        return new JAXBElement<CustomData>(_RetrieveCompanyOnlineReportCustomData_QNAME, CustomData.class, OrderCompanyOfflineReport.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "chargeReference", scope = OrderCompanyOfflineReport.class)
    public JAXBElement<String> createOrderCompanyOfflineReportChargeReference(String value) {
        return new JAXBElement<String>(_RetrieveCompanyOnlineReportChargeReference_QNAME, String.class, OrderCompanyOfflineReport.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "OrderCompanyOfflineReportResult", scope = OrderCompanyOfflineReportResponse.class)
    public JAXBElement<ReportOrder> createOrderCompanyOfflineReportResponseOrderCompanyOfflineReportResult(ReportOrder value) {
        return new JAXBElement<ReportOrder>(_OrderCompanyOfflineReportResponseOrderCompanyOfflineReportResult_QNAME, ReportOrder.class, OrderCompanyOfflineReportResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportboxListingFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "filter", scope = GetReportboxContents.class)
    public JAXBElement<ReportboxListingFilter> createGetReportboxContentsFilter(ReportboxListingFilter value) {
        return new JAXBElement<ReportboxListingFilter>(_GetReportboxContentsFilter_QNAME, ReportboxListingFilter.class, GetReportboxContents.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportboxContents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "GetReportboxContentsResult", scope = GetReportboxContentsResponse.class)
    public JAXBElement<ReportboxContents> createGetReportboxContentsResponseGetReportboxContentsResult(ReportboxContents value) {
        return new JAXBElement<ReportboxContents>(_GetReportboxContentsResponseGetReportboxContentsResult_QNAME, ReportboxContents.class, GetReportboxContentsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfunsignedInt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "ids", scope = GetReportboxReports.class)
    public JAXBElement<ArrayOfunsignedInt> createGetReportboxReportsIds(ArrayOfunsignedInt value) {
        return new JAXBElement<ArrayOfunsignedInt>(_GetReportboxReportsIds_QNAME, ArrayOfunsignedInt.class, GetReportboxReports.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompanyReportSet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "GetReportboxReportsResult", scope = GetReportboxReportsResponse.class)
    public JAXBElement<CompanyReportSet> createGetReportboxReportsResponseGetReportboxReportsResult(CompanyReportSet value) {
        return new JAXBElement<CompanyReportSet>(_GetReportboxReportsResponseGetReportboxReportsResult_QNAME, CompanyReportSet.class, GetReportboxReportsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfunsignedInt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "ids", scope = RemoveReportboxReports.class)
    public JAXBElement<ArrayOfunsignedInt> createRemoveReportboxReportsIds(ArrayOfunsignedInt value) {
        return new JAXBElement<ArrayOfunsignedInt>(_GetReportboxReportsIds_QNAME, ArrayOfunsignedInt.class, RemoveReportboxReports.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "RemoveReportboxReportsResult", scope = RemoveReportboxReportsResponse.class)
    public JAXBElement<SimpleResult> createRemoveReportboxReportsResponseRemoveReportboxReportsResult(SimpleResult value) {
        return new JAXBElement<SimpleResult>(_RemoveReportboxReportsResponseRemoveReportboxReportsResult_QNAME, SimpleResult.class, RemoveReportboxReportsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountriesListingFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "filter", scope = GetCountries.class)
    public JAXBElement<CountriesListingFilter> createGetCountriesFilter(CountriesListingFilter value) {
        return new JAXBElement<CountriesListingFilter>(_GetReportboxContentsFilter_QNAME, CountriesListingFilter.class, GetCountries.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountriesList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "GetCountriesResult", scope = GetCountriesResponse.class)
    public JAXBElement<CountriesList> createGetCountriesResponseGetCountriesResult(CountriesList value) {
        return new JAXBElement<CountriesList>(_GetCountriesResponseGetCountriesResult_QNAME, CountriesList.class, GetCountriesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCountryCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "countries", scope = GetPossibleSearchCriteria.class)
    public JAXBElement<ArrayOfCountryCode> createGetPossibleSearchCriteriaCountries(ArrayOfCountryCode value) {
        return new JAXBElement<ArrayOfCountryCode>(_GetPossibleSearchCriteriaCountries_QNAME, ArrayOfCountryCode.class, GetPossibleSearchCriteria.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCriteriaSchemaSet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "GetPossibleSearchCriteriaResult", scope = GetPossibleSearchCriteriaResponse.class)
    public JAXBElement<SearchCriteriaSchemaSet> createGetPossibleSearchCriteriaResponseGetPossibleSearchCriteriaResult(SearchCriteriaSchemaSet value) {
        return new JAXBElement<SearchCriteriaSchemaSet>(_GetPossibleSearchCriteriaResponseGetPossibleSearchCriteriaResult_QNAME, SearchCriteriaSchemaSet.class, GetPossibleSearchCriteriaResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCountryCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "countries", scope = FindCompanies.class)
    public JAXBElement<ArrayOfCountryCode> createFindCompaniesCountries(ArrayOfCountryCode value) {
        return new JAXBElement<ArrayOfCountryCode>(_GetPossibleSearchCriteriaCountries_QNAME, ArrayOfCountryCode.class, FindCompanies.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCriteria }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "searchCriteria", scope = FindCompanies.class)
    public JAXBElement<SearchCriteria> createFindCompaniesSearchCriteria(SearchCriteria value) {
        return new JAXBElement<SearchCriteria>(_TryRetrieveCompanyOnlineReportSearchCriteria_QNAME, SearchCriteria.class, FindCompanies.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "customData", scope = FindCompanies.class)
    public JAXBElement<CustomData> createFindCompaniesCustomData(CustomData value) {
        return new JAXBElement<CustomData>(_RetrieveCompanyOnlineReportCustomData_QNAME, CustomData.class, FindCompanies.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "chargeReference", scope = FindCompanies.class)
    public JAXBElement<String> createFindCompaniesChargeReference(String value) {
        return new JAXBElement<String>(_RetrieveCompanyOnlineReportChargeReference_QNAME, String.class, FindCompanies.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompaniesList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "FindCompaniesResult", scope = FindCompaniesResponse.class)
    public JAXBElement<CompaniesList> createFindCompaniesResponseFindCompaniesResult(CompaniesList value) {
        return new JAXBElement<CompaniesList>(_FindCompaniesResponseFindCompaniesResult_QNAME, CompaniesList.class, FindCompaniesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomDataSchema }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/operations", name = "GetReportCustomDataSchemaResult", scope = GetReportCustomDataSchemaResponse.class)
    public JAXBElement<CustomDataSchema> createGetReportCustomDataSchemaResponseGetReportCustomDataSchemaResult(CustomDataSchema value) {
        return new JAXBElement<CustomDataSchema>(_GetReportCustomDataSchemaResponseGetReportCustomDataSchemaResult_QNAME, CustomDataSchema.class, GetReportCustomDataSchemaResponse.class, value);
    }

}
