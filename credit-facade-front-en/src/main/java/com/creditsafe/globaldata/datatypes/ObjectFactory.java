
package com.creditsafe.globaldata.datatypes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import java.io.Serializable;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.creditsafe.globaldata.datatypes package. 
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
public class ObjectFactory implements Serializable {

    private final static QName _ReportboxListingFilter_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "ReportboxListingFilter");
    private final static QName _ServiceResponse_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "ServiceResponse");
    private final static QName _CountriesList_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "CountriesList");
    private final static QName _ChangeEventsBasicParamsList_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "ChangeEventsBasicParamsList");
    private final static QName _ReportOrder_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "ReportOrder");
    private final static QName _CompanyReferences_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "CompanyReferences");
    private final static QName _CompaniesList_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "CompaniesList");
    private final static QName _PortfolioSettings_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "PortfolioSettings");
    private final static QName _SimpleResult_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "SimpleResult");
    private final static QName _PortfolioCompanyAdditionResult_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "PortfolioCompanyAdditionResult");
    private final static QName _PortfolioRemovalResult_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "PortfolioRemovalResult");
    private final static QName _PortfoliosList_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "PortfoliosList");
    private final static QName _CurrentPortfolioSettings_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "CurrentPortfolioSettings");
    private final static QName _CompanyChangesList_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "CompanyChangesList");
    private final static QName _ReportboxContents_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "ReportboxContents");
    private final static QName _CountriesListingFilter_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "CountriesListingFilter");
    private final static QName _CurrentPortfolioMonitoringRules_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "CurrentPortfolioMonitoringRules");
    private final static QName _MonitoringRules_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "MonitoringRules");
    private final static QName _SearchCriteria_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "SearchCriteria");
    private final static QName _SearchCriteriaSchemaSet_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "SearchCriteriaSchemaSet");
    private final static QName _MonitoredCompaniesList_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "MonitoredCompaniesList");
    private final static QName _CustomData_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "CustomData");
    private final static QName _CustomDataSchema_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "CustomDataSchema");
    private final static QName _PortfolioCompanyRemovalResult_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "PortfolioCompanyRemovalResult");
    private final static QName _SupportedChangeEventsList_QNAME = new QName("http://www.creditsafe.com/globaldata/datatypes", "SupportedChangeEventsList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.creditsafe.globaldata.datatypes
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SearchCriteriaSchemaValueSchemaCompanyStatus }
     * 
     */
    public SearchCriteriaSchemaValueSchemaCompanyStatus createSearchCriteriaSchemaValueSchemaCompanyStatus() {
        return new SearchCriteriaSchemaValueSchemaCompanyStatus();
    }

    /**
     * Create an instance of {@link SearchCriteriaSchemaValueSchemaOfficeType }
     * 
     */
    public SearchCriteriaSchemaValueSchemaOfficeType createSearchCriteriaSchemaValueSchemaOfficeType() {
        return new SearchCriteriaSchemaValueSchemaOfficeType();
    }

    /**
     * Create an instance of {@link SearchCriteriaSchemaValueSchemaCompanyType }
     * 
     */
    public SearchCriteriaSchemaValueSchemaCompanyType createSearchCriteriaSchemaValueSchemaCompanyType() {
        return new SearchCriteriaSchemaValueSchemaCompanyType();
    }

    /**
     * Create an instance of {@link SearchCriteriaSchemaValueSchemaString }
     * 
     */
    public SearchCriteriaSchemaValueSchemaString createSearchCriteriaSchemaValueSchemaString() {
        return new SearchCriteriaSchemaValueSchemaString();
    }

    /**
     * Create an instance of {@link SearchCriteriaSchemaQueryStringSchema }
     * 
     */
    public SearchCriteriaSchemaQueryStringSchema createSearchCriteriaSchemaQueryStringSchema() {
        return new SearchCriteriaSchemaQueryStringSchema();
    }

    /**
     * Create an instance of {@link EmailNotificationSettings }
     * 
     */
    public EmailNotificationSettings createEmailNotificationSettings() {
        return new EmailNotificationSettings();
    }

    /**
     * Create an instance of {@link ChangeEventBasicParams }
     * 
     */
    public ChangeEventBasicParams createChangeEventBasicParams() {
        return new ChangeEventBasicParams();
    }

    /**
     * Create an instance of {@link PortfolioCompanyIds }
     * 
     */
    public PortfolioCompanyIds createPortfolioCompanyIds() {
        return new PortfolioCompanyIds();
    }

    /**
     * Create an instance of {@link PortfolioCompanies }
     * 
     */
    public PortfolioCompanies createPortfolioCompanies() {
        return new PortfolioCompanies();
    }

    /**
     * Create an instance of {@link CustomDataEntrySchema }
     * 
     */
    public CustomDataEntrySchema createCustomDataEntrySchema() {
        return new CustomDataEntrySchema();
    }

    /**
     * Create an instance of {@link MonitoringRule }
     * 
     */
    public MonitoringRule createMonitoringRule() {
        return new MonitoringRule();
    }

    /**
     * Create an instance of {@link MonitoredCompany }
     * 
     */
    public MonitoredCompany createMonitoredCompany() {
        return new MonitoredCompany();
    }

    /**
     * Create an instance of {@link Company }
     * 
     */
    public Company createCompany() {
        return new Company();
    }

    /**
     * Create an instance of {@link Company.AdditionalData }
     * 
     */
    public Company.AdditionalData createCompanyAdditionalData() {
        return new Company.AdditionalData();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link CompanyChangesList }
     * 
     */
    public CompanyChangesList createCompanyChangesList() {
        return new CompanyChangesList();
    }

    /**
     * Create an instance of {@link PortfolioRemovalResult }
     * 
     */
    public PortfolioRemovalResult createPortfolioRemovalResult() {
        return new PortfolioRemovalResult();
    }

    /**
     * Create an instance of {@link ChangeEventsBasicParamsList }
     * 
     */
    public ChangeEventsBasicParamsList createChangeEventsBasicParamsList() {
        return new ChangeEventsBasicParamsList();
    }

    /**
     * Create an instance of {@link CustomDataSchema }
     * 
     */
    public CustomDataSchema createCustomDataSchema() {
        return new CustomDataSchema();
    }

    /**
     * Create an instance of {@link CompaniesList }
     * 
     */
    public CompaniesList createCompaniesList() {
        return new CompaniesList();
    }

    /**
     * Create an instance of {@link SearchCriteriaSchemaSet }
     * 
     */
    public SearchCriteriaSchemaSet createSearchCriteriaSchemaSet() {
        return new SearchCriteriaSchemaSet();
    }

    /**
     * Create an instance of {@link CountriesList }
     * 
     */
    public CountriesList createCountriesList() {
        return new CountriesList();
    }

    /**
     * Create an instance of {@link CountriesListingFilter }
     * 
     */
    public CountriesListingFilter createCountriesListingFilter() {
        return new CountriesListingFilter();
    }

    /**
     * Create an instance of {@link ReportboxContents }
     * 
     */
    public ReportboxContents createReportboxContents() {
        return new ReportboxContents();
    }

    /**
     * Create an instance of {@link CustomData }
     * 
     */
    public CustomData createCustomData() {
        return new CustomData();
    }

    /**
     * Create an instance of {@link CustomData.Entries }
     * 
     */
    public CustomData.Entries createCustomDataEntries() {
        return new CustomData.Entries();
    }

    /**
     * Create an instance of {@link CurrentPortfolioMonitoringRules }
     * 
     */
    public CurrentPortfolioMonitoringRules createCurrentPortfolioMonitoringRules() {
        return new CurrentPortfolioMonitoringRules();
    }

    /**
     * Create an instance of {@link SupportedChangeEventsList }
     * 
     */
    public SupportedChangeEventsList createSupportedChangeEventsList() {
        return new SupportedChangeEventsList();
    }

    /**
     * Create an instance of {@link PortfolioCompanyRemovalResult }
     * 
     */
    public PortfolioCompanyRemovalResult createPortfolioCompanyRemovalResult() {
        return new PortfolioCompanyRemovalResult();
    }

    /**
     * Create an instance of {@link CompanyReferences }
     * 
     */
    public CompanyReferences createCompanyReferences() {
        return new CompanyReferences();
    }

    /**
     * Create an instance of {@link CompanyReferences.Companies }
     * 
     */
    public CompanyReferences.Companies createCompanyReferencesCompanies() {
        return new CompanyReferences.Companies();
    }

    /**
     * Create an instance of {@link PortfolioSettings }
     * 
     */
    public PortfolioSettings createPortfolioSettings() {
        return new PortfolioSettings();
    }

    /**
     * Create an instance of {@link MonitoredCompaniesList }
     * 
     */
    public MonitoredCompaniesList createMonitoredCompaniesList() {
        return new MonitoredCompaniesList();
    }

    /**
     * Create an instance of {@link PortfoliosList }
     * 
     */
    public PortfoliosList createPortfoliosList() {
        return new PortfoliosList();
    }

    /**
     * Create an instance of {@link SimpleResult }
     * 
     */
    public SimpleResult createSimpleResult() {
        return new SimpleResult();
    }

    /**
     * Create an instance of {@link CurrentPortfolioSettings }
     * 
     */
    public CurrentPortfolioSettings createCurrentPortfolioSettings() {
        return new CurrentPortfolioSettings();
    }

    /**
     * Create an instance of {@link PortfolioCompanyAdditionResult }
     * 
     */
    public PortfolioCompanyAdditionResult createPortfolioCompanyAdditionResult() {
        return new PortfolioCompanyAdditionResult();
    }

    /**
     * Create an instance of {@link MonitoringRules }
     * 
     */
    public MonitoringRules createMonitoringRules() {
        return new MonitoringRules();
    }

    /**
     * Create an instance of {@link SearchCriteria }
     * 
     */
    public SearchCriteria createSearchCriteria() {
        return new SearchCriteria();
    }

    /**
     * Create an instance of {@link ReportOrder }
     * 
     */
    public ReportOrder createReportOrder() {
        return new ReportOrder();
    }

    /**
     * Create an instance of {@link ReportboxListingFilter }
     * 
     */
    public ReportboxListingFilter createReportboxListingFilter() {
        return new ReportboxListingFilter();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link PortfolioActionResult }
     * 
     */
    public PortfolioActionResult createPortfolioActionResult() {
        return new PortfolioActionResult();
    }

    /**
     * Create an instance of {@link Portfolio }
     * 
     */
    public Portfolio createPortfolio() {
        return new Portfolio();
    }

    /**
     * Create an instance of {@link ReportboxEntry }
     * 
     */
    public ReportboxEntry createReportboxEntry() {
        return new ReportboxEntry();
    }

    /**
     * Create an instance of {@link QueryString }
     * 
     */
    public QueryString createQueryString() {
        return new QueryString();
    }

    /**
     * Create an instance of {@link AddressCriteria }
     * 
     */
    public AddressCriteria createAddressCriteria() {
        return new AddressCriteria();
    }

    /**
     * Create an instance of {@link SearchCriteriaSchema }
     * 
     */
    public SearchCriteriaSchema createSearchCriteriaSchema() {
        return new SearchCriteriaSchema();
    }

    /**
     * Create an instance of {@link ChangeEventDescription }
     * 
     */
    public ChangeEventDescription createChangeEventDescription() {
        return new ChangeEventDescription();
    }

    /**
     * Create an instance of {@link CompanyData }
     * 
     */
    public CompanyData createCompanyData() {
        return new CompanyData();
    }

    /**
     * Create an instance of {@link HttpNotificationSettings }
     * 
     */
    public HttpNotificationSettings createHttpNotificationSettings() {
        return new HttpNotificationSettings();
    }

    /**
     * Create an instance of {@link FtpNotificationSettings }
     * 
     */
    public FtpNotificationSettings createFtpNotificationSettings() {
        return new FtpNotificationSettings();
    }

    /**
     * Create an instance of {@link ChangeEvent }
     * 
     */
    public ChangeEvent createChangeEvent() {
        return new ChangeEvent();
    }

    /**
     * Create an instance of {@link AddressCriteriaSchema }
     * 
     */
    public AddressCriteriaSchema createAddressCriteriaSchema() {
        return new AddressCriteriaSchema();
    }

    /**
     * Create an instance of {@link AddressData }
     * 
     */
    public AddressData createAddressData() {
        return new AddressData();
    }

    /**
     * Create an instance of {@link TextValueChangeEvent }
     * 
     */
    public TextValueChangeEvent createTextValueChangeEvent() {
        return new TextValueChangeEvent();
    }

    /**
     * Create an instance of {@link NumericValueChangeEvent }
     * 
     */
    public NumericValueChangeEvent createNumericValueChangeEvent() {
        return new NumericValueChangeEvent();
    }

    /**
     * Create an instance of {@link TextValueRangeCondition }
     * 
     */
    public TextValueRangeCondition createTextValueRangeCondition() {
        return new TextValueRangeCondition();
    }

    /**
     * Create an instance of {@link NumericValueRangeCondition }
     * 
     */
    public NumericValueRangeCondition createNumericValueRangeCondition() {
        return new NumericValueRangeCondition();
    }

    /**
     * Create an instance of {@link ChangeRangeCondition }
     * 
     */
    public ChangeRangeCondition createChangeRangeCondition() {
        return new ChangeRangeCondition();
    }

    /**
     * Create an instance of {@link ServiceResponse.Messages }
     * 
     */
    public ServiceResponse.Messages createServiceResponseMessages() {
        return new ServiceResponse.Messages();
    }

    /**
     * Create an instance of {@link SearchCriteriaSchemaValueSchemaCompanyStatus.AllowedValues }
     * 
     */
    public SearchCriteriaSchemaValueSchemaCompanyStatus.AllowedValues createSearchCriteriaSchemaValueSchemaCompanyStatusAllowedValues() {
        return new SearchCriteriaSchemaValueSchemaCompanyStatus.AllowedValues();
    }

    /**
     * Create an instance of {@link SearchCriteriaSchemaValueSchemaOfficeType.AllowedValues }
     * 
     */
    public SearchCriteriaSchemaValueSchemaOfficeType.AllowedValues createSearchCriteriaSchemaValueSchemaOfficeTypeAllowedValues() {
        return new SearchCriteriaSchemaValueSchemaOfficeType.AllowedValues();
    }

    /**
     * Create an instance of {@link SearchCriteriaSchemaValueSchemaCompanyType.AllowedValues }
     * 
     */
    public SearchCriteriaSchemaValueSchemaCompanyType.AllowedValues createSearchCriteriaSchemaValueSchemaCompanyTypeAllowedValues() {
        return new SearchCriteriaSchemaValueSchemaCompanyType.AllowedValues();
    }

    /**
     * Create an instance of {@link SearchCriteriaSchemaValueSchemaString.AllowedValues }
     * 
     */
    public SearchCriteriaSchemaValueSchemaString.AllowedValues createSearchCriteriaSchemaValueSchemaStringAllowedValues() {
        return new SearchCriteriaSchemaValueSchemaString.AllowedValues();
    }

    /**
     * Create an instance of {@link SearchCriteriaSchemaQueryStringSchema.AllowedMatchTypes }
     * 
     */
    public SearchCriteriaSchemaQueryStringSchema.AllowedMatchTypes createSearchCriteriaSchemaQueryStringSchemaAllowedMatchTypes() {
        return new SearchCriteriaSchemaQueryStringSchema.AllowedMatchTypes();
    }

    /**
     * Create an instance of {@link EmailNotificationSettings.AddressesMain }
     * 
     */
    public EmailNotificationSettings.AddressesMain createEmailNotificationSettingsAddressesMain() {
        return new EmailNotificationSettings.AddressesMain();
    }

    /**
     * Create an instance of {@link EmailNotificationSettings.AddressesCopy }
     * 
     */
    public EmailNotificationSettings.AddressesCopy createEmailNotificationSettingsAddressesCopy() {
        return new EmailNotificationSettings.AddressesCopy();
    }

    /**
     * Create an instance of {@link ChangeEventBasicParams.PossibleValues }
     * 
     */
    public ChangeEventBasicParams.PossibleValues createChangeEventBasicParamsPossibleValues() {
        return new ChangeEventBasicParams.PossibleValues();
    }

    /**
     * Create an instance of {@link PortfolioCompanyIds.CompanyIds }
     * 
     */
    public PortfolioCompanyIds.CompanyIds createPortfolioCompanyIdsCompanyIds() {
        return new PortfolioCompanyIds.CompanyIds();
    }

    /**
     * Create an instance of {@link PortfolioCompanies.Companies }
     * 
     */
    public PortfolioCompanies.Companies createPortfolioCompaniesCompanies() {
        return new PortfolioCompanies.Companies();
    }

    /**
     * Create an instance of {@link CustomDataEntrySchema.AllowedValues }
     * 
     */
    public CustomDataEntrySchema.AllowedValues createCustomDataEntrySchemaAllowedValues() {
        return new CustomDataEntrySchema.AllowedValues();
    }

    /**
     * Create an instance of {@link MonitoringRule.Conditions }
     * 
     */
    public MonitoringRule.Conditions createMonitoringRuleConditions() {
        return new MonitoringRule.Conditions();
    }

    /**
     * Create an instance of {@link MonitoredCompany.Changes }
     * 
     */
    public MonitoredCompany.Changes createMonitoredCompanyChanges() {
        return new MonitoredCompany.Changes();
    }

    /**
     * Create an instance of {@link Company.AvailableReportTypes }
     * 
     */
    public Company.AvailableReportTypes createCompanyAvailableReportTypes() {
        return new Company.AvailableReportTypes();
    }

    /**
     * Create an instance of {@link Company.AvailableLanguages }
     * 
     */
    public Company.AvailableLanguages createCompanyAvailableLanguages() {
        return new Company.AvailableLanguages();
    }

    /**
     * Create an instance of {@link Company.AdditionalData.AdditionalDataItem }
     * 
     */
    public Company.AdditionalData.AdditionalDataItem createCompanyAdditionalDataAdditionalDataItem() {
        return new Company.AdditionalData.AdditionalDataItem();
    }

    /**
     * Create an instance of {@link Country.AvailableReportTypes }
     * 
     */
    public Country.AvailableReportTypes createCountryAvailableReportTypes() {
        return new Country.AvailableReportTypes();
    }

    /**
     * Create an instance of {@link Country.AvailableLanguages }
     * 
     */
    public Country.AvailableLanguages createCountryAvailableLanguages() {
        return new Country.AvailableLanguages();
    }

    /**
     * Create an instance of {@link CompanyChangesList.Companies }
     * 
     */
    public CompanyChangesList.Companies createCompanyChangesListCompanies() {
        return new CompanyChangesList.Companies();
    }

    /**
     * Create an instance of {@link PortfolioRemovalResult.Portfolios }
     * 
     */
    public PortfolioRemovalResult.Portfolios createPortfolioRemovalResultPortfolios() {
        return new PortfolioRemovalResult.Portfolios();
    }

    /**
     * Create an instance of {@link ChangeEventsBasicParamsList.Events }
     * 
     */
    public ChangeEventsBasicParamsList.Events createChangeEventsBasicParamsListEvents() {
        return new ChangeEventsBasicParamsList.Events();
    }

    /**
     * Create an instance of {@link CustomDataSchema.CustomData }
     * 
     */
    public CustomDataSchema.CustomData createCustomDataSchemaCustomData() {
        return new CustomDataSchema.CustomData();
    }

    /**
     * Create an instance of {@link CompaniesList.Companies }
     * 
     */
    public CompaniesList.Companies createCompaniesListCompanies() {
        return new CompaniesList.Companies();
    }

    /**
     * Create an instance of {@link SearchCriteriaSchemaSet.Schemas }
     * 
     */
    public SearchCriteriaSchemaSet.Schemas createSearchCriteriaSchemaSetSchemas() {
        return new SearchCriteriaSchemaSet.Schemas();
    }

    /**
     * Create an instance of {@link SearchCriteriaSchemaSet.CustomData }
     * 
     */
    public SearchCriteriaSchemaSet.CustomData createSearchCriteriaSchemaSetCustomData() {
        return new SearchCriteriaSchemaSet.CustomData();
    }

    /**
     * Create an instance of {@link SearchCriteriaSchemaSet.Countries }
     * 
     */
    public SearchCriteriaSchemaSet.Countries createSearchCriteriaSchemaSetCountries() {
        return new SearchCriteriaSchemaSet.Countries();
    }

    /**
     * Create an instance of {@link CountriesList.Countries }
     * 
     */
    public CountriesList.Countries createCountriesListCountries() {
        return new CountriesList.Countries();
    }

    /**
     * Create an instance of {@link CountriesListingFilter.Codes }
     * 
     */
    public CountriesListingFilter.Codes createCountriesListingFilterCodes() {
        return new CountriesListingFilter.Codes();
    }

    /**
     * Create an instance of {@link ReportboxContents.Entries }
     * 
     */
    public ReportboxContents.Entries createReportboxContentsEntries() {
        return new ReportboxContents.Entries();
    }

    /**
     * Create an instance of {@link CustomData.Entries.Entry }
     * 
     */
    public CustomData.Entries.Entry createCustomDataEntriesEntry() {
        return new CustomData.Entries.Entry();
    }

    /**
     * Create an instance of {@link CurrentPortfolioMonitoringRules.Rules }
     * 
     */
    public CurrentPortfolioMonitoringRules.Rules createCurrentPortfolioMonitoringRulesRules() {
        return new CurrentPortfolioMonitoringRules.Rules();
    }

    /**
     * Create an instance of {@link SupportedChangeEventsList.Events }
     * 
     */
    public SupportedChangeEventsList.Events createSupportedChangeEventsListEvents() {
        return new SupportedChangeEventsList.Events();
    }

    /**
     * Create an instance of {@link PortfolioCompanyRemovalResult.Portfolios }
     * 
     */
    public PortfolioCompanyRemovalResult.Portfolios createPortfolioCompanyRemovalResultPortfolios() {
        return new PortfolioCompanyRemovalResult.Portfolios();
    }

    /**
     * Create an instance of {@link CompanyReferences.Companies.Company }
     * 
     */
    public CompanyReferences.Companies.Company createCompanyReferencesCompaniesCompany() {
        return new CompanyReferences.Companies.Company();
    }

    /**
     * Create an instance of {@link PortfolioSettings.NotificationSettings }
     * 
     */
    public PortfolioSettings.NotificationSettings createPortfolioSettingsNotificationSettings() {
        return new PortfolioSettings.NotificationSettings();
    }

    /**
     * Create an instance of {@link MonitoredCompaniesList.Portfolios }
     * 
     */
    public MonitoredCompaniesList.Portfolios createMonitoredCompaniesListPortfolios() {
        return new MonitoredCompaniesList.Portfolios();
    }

    /**
     * Create an instance of {@link PortfoliosList.Portfolios }
     * 
     */
    public PortfoliosList.Portfolios createPortfoliosListPortfolios() {
        return new PortfoliosList.Portfolios();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportboxListingFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "ReportboxListingFilter")
    public JAXBElement<ReportboxListingFilter> createReportboxListingFilter(ReportboxListingFilter value) {
        return new JAXBElement<ReportboxListingFilter>(_ReportboxListingFilter_QNAME, ReportboxListingFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "ServiceResponse")
    public JAXBElement<ServiceResponse> createServiceResponse(ServiceResponse value) {
        return new JAXBElement<ServiceResponse>(_ServiceResponse_QNAME, ServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountriesList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "CountriesList")
    public JAXBElement<CountriesList> createCountriesList(CountriesList value) {
        return new JAXBElement<CountriesList>(_CountriesList_QNAME, CountriesList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeEventsBasicParamsList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "ChangeEventsBasicParamsList")
    public JAXBElement<ChangeEventsBasicParamsList> createChangeEventsBasicParamsList(ChangeEventsBasicParamsList value) {
        return new JAXBElement<ChangeEventsBasicParamsList>(_ChangeEventsBasicParamsList_QNAME, ChangeEventsBasicParamsList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "ReportOrder")
    public JAXBElement<ReportOrder> createReportOrder(ReportOrder value) {
        return new JAXBElement<ReportOrder>(_ReportOrder_QNAME, ReportOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompanyReferences }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "CompanyReferences")
    public JAXBElement<CompanyReferences> createCompanyReferences(CompanyReferences value) {
        return new JAXBElement<CompanyReferences>(_CompanyReferences_QNAME, CompanyReferences.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompaniesList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "CompaniesList")
    public JAXBElement<CompaniesList> createCompaniesList(CompaniesList value) {
        return new JAXBElement<CompaniesList>(_CompaniesList_QNAME, CompaniesList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PortfolioSettings }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "PortfolioSettings")
    public JAXBElement<PortfolioSettings> createPortfolioSettings(PortfolioSettings value) {
        return new JAXBElement<PortfolioSettings>(_PortfolioSettings_QNAME, PortfolioSettings.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "SimpleResult")
    public JAXBElement<SimpleResult> createSimpleResult(SimpleResult value) {
        return new JAXBElement<SimpleResult>(_SimpleResult_QNAME, SimpleResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PortfolioCompanyAdditionResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "PortfolioCompanyAdditionResult")
    public JAXBElement<PortfolioCompanyAdditionResult> createPortfolioCompanyAdditionResult(PortfolioCompanyAdditionResult value) {
        return new JAXBElement<PortfolioCompanyAdditionResult>(_PortfolioCompanyAdditionResult_QNAME, PortfolioCompanyAdditionResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PortfolioRemovalResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "PortfolioRemovalResult")
    public JAXBElement<PortfolioRemovalResult> createPortfolioRemovalResult(PortfolioRemovalResult value) {
        return new JAXBElement<PortfolioRemovalResult>(_PortfolioRemovalResult_QNAME, PortfolioRemovalResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PortfoliosList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "PortfoliosList")
    public JAXBElement<PortfoliosList> createPortfoliosList(PortfoliosList value) {
        return new JAXBElement<PortfoliosList>(_PortfoliosList_QNAME, PortfoliosList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrentPortfolioSettings }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "CurrentPortfolioSettings")
    public JAXBElement<CurrentPortfolioSettings> createCurrentPortfolioSettings(CurrentPortfolioSettings value) {
        return new JAXBElement<CurrentPortfolioSettings>(_CurrentPortfolioSettings_QNAME, CurrentPortfolioSettings.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompanyChangesList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "CompanyChangesList")
    public JAXBElement<CompanyChangesList> createCompanyChangesList(CompanyChangesList value) {
        return new JAXBElement<CompanyChangesList>(_CompanyChangesList_QNAME, CompanyChangesList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportboxContents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "ReportboxContents")
    public JAXBElement<ReportboxContents> createReportboxContents(ReportboxContents value) {
        return new JAXBElement<ReportboxContents>(_ReportboxContents_QNAME, ReportboxContents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountriesListingFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "CountriesListingFilter")
    public JAXBElement<CountriesListingFilter> createCountriesListingFilter(CountriesListingFilter value) {
        return new JAXBElement<CountriesListingFilter>(_CountriesListingFilter_QNAME, CountriesListingFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrentPortfolioMonitoringRules }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "CurrentPortfolioMonitoringRules")
    public JAXBElement<CurrentPortfolioMonitoringRules> createCurrentPortfolioMonitoringRules(CurrentPortfolioMonitoringRules value) {
        return new JAXBElement<CurrentPortfolioMonitoringRules>(_CurrentPortfolioMonitoringRules_QNAME, CurrentPortfolioMonitoringRules.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MonitoringRules }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "MonitoringRules")
    public JAXBElement<MonitoringRules> createMonitoringRules(MonitoringRules value) {
        return new JAXBElement<MonitoringRules>(_MonitoringRules_QNAME, MonitoringRules.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCriteria }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "SearchCriteria")
    public JAXBElement<SearchCriteria> createSearchCriteria(SearchCriteria value) {
        return new JAXBElement<SearchCriteria>(_SearchCriteria_QNAME, SearchCriteria.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCriteriaSchemaSet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "SearchCriteriaSchemaSet")
    public JAXBElement<SearchCriteriaSchemaSet> createSearchCriteriaSchemaSet(SearchCriteriaSchemaSet value) {
        return new JAXBElement<SearchCriteriaSchemaSet>(_SearchCriteriaSchemaSet_QNAME, SearchCriteriaSchemaSet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MonitoredCompaniesList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "MonitoredCompaniesList")
    public JAXBElement<MonitoredCompaniesList> createMonitoredCompaniesList(MonitoredCompaniesList value) {
        return new JAXBElement<MonitoredCompaniesList>(_MonitoredCompaniesList_QNAME, MonitoredCompaniesList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "CustomData")
    public JAXBElement<CustomData> createCustomData(CustomData value) {
        return new JAXBElement<CustomData>(_CustomData_QNAME, CustomData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomDataSchema }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "CustomDataSchema")
    public JAXBElement<CustomDataSchema> createCustomDataSchema(CustomDataSchema value) {
        return new JAXBElement<CustomDataSchema>(_CustomDataSchema_QNAME, CustomDataSchema.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PortfolioCompanyRemovalResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "PortfolioCompanyRemovalResult")
    public JAXBElement<PortfolioCompanyRemovalResult> createPortfolioCompanyRemovalResult(PortfolioCompanyRemovalResult value) {
        return new JAXBElement<PortfolioCompanyRemovalResult>(_PortfolioCompanyRemovalResult_QNAME, PortfolioCompanyRemovalResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SupportedChangeEventsList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.creditsafe.com/globaldata/datatypes", name = "SupportedChangeEventsList")
    public JAXBElement<SupportedChangeEventsList> createSupportedChangeEventsList(SupportedChangeEventsList value) {
        return new JAXBElement<SupportedChangeEventsList>(_SupportedChangeEventsList_QNAME, SupportedChangeEventsList.class, null, value);
    }

}
