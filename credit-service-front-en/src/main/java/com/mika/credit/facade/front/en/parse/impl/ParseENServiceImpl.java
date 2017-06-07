package com.mika.credit.facade.front.en.parse.impl;

import com.creditsafe.globaldata.datatypes.reports.*;
import com.mika.credit.common.entity.report.en.*;
import com.mika.credit.common.entity.report.en.FinancialStatement;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.front.en.parse.ParseENService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mike on 2017/3/8.
 */
@Service("parseENService")
public class ParseENServiceImpl implements ParseENService {

    public FullReport parseDate(LtdCompanyFullReport report, Integer fullReportId) {
        if (report == null) {
            return null;
        }
        FullReport fullReport = new FullReport();
        fullReport.setId(fullReportId);
        fullReport.setBankInfosList(parseBankInfos(report, fullReportId));
        fullReport.setBasicInfo(parseBasicInfos(report, fullReportId));
        fullReport.setChangeInfosList(parseChangeInfos(report, fullReportId));
        fullReport.setFinancialFiguresList(parseFinancialFigures(report, fullReportId));
        fullReport.setFinancialStatementList(parseFinancialStatement(report, fullReportId));
        fullReport.setHistoryInfosList(parseHistoryInfos(report, fullReportId));
        fullReport.setIdentificationList(parseIdentification(report, fullReportId));
        fullReport.setLegalInfos(parseLegalInfos(report, fullReportId));
        fullReport.setManagementsList(parseManagements(report, fullReportId));
        fullReport.setMediaRecordsList(parseMediaRecords(report, fullReportId));
        fullReport.setOperatingsList(parseOperatings(report, fullReportId));
        fullReport.setOtherInfosList(parseOtherInfos(report, fullReportId));
        fullReport.setPaymentHistoriesList(parsePaymentHistories(report, fullReportId));
        fullReport.setPublicRecordsList(parsePublicRecords(report, fullReportId));
        fullReport.setRegistrationInfosList(parseRegistrationInfos(report, fullReportId));
        fullReport.setRelatedCompaniesList(parseRelatedCompanies(report, fullReportId));
        fullReport.setShareholderInfosList(parseShareholderInfos(report, fullReportId));
        fullReport.setTradeReferencesList(parseTradeReferences(report, fullReportId));
        fullReport.setuCCsList(parseUCCs(report, fullReportId));

        return fullReport;
    }

    public List<BankInfos> parseBankInfos(LtdCompanyFullReport report, Integer fullReportId) {
        List<BankInfos> bankInfoss = new ArrayList<>();
        if (report.getOtherInformation() != null) {
            if (report.getOtherInformation().getBankers() != null) {
                if (report.getOtherInformation().getBankers().getBanker() != null) {
                    for (Banker banker : report.getOtherInformation().getBankers().getBanker()) {
                        BankInfos bankInfos = new BankInfos();
                        //设置fullReportId
                        bankInfos.setFullReportId(fullReportId);
                        bankInfos.setBankCode(banker.getBankCode());
                        bankInfos.setName(banker.getName());
                        if (banker.getAddress() != null) {
                            bankInfos.setAddress(banker.getAddress().getSimpleValue());
                            bankInfos.setCity(banker.getAddress().getCity());
                            bankInfos.setHouseNumber(banker.getAddress().getHouseNumber());
                            bankInfos.setPostalCode(banker.getAddress().getPostalCode());
                            bankInfos.setStreet(banker.getAddress().getStreet());
                            bankInfos.setProvince(banker.getAddress().getProvince());
                        }
                        bankInfoss.add(bankInfos);
                    }
                }
            }
        }
        return bankInfoss;
    }

    public List<BasicInfos> parseBasicInfos(LtdCompanyFullReport report, Integer fullReportId) {
        List<BasicInfos> basicInfosList = new ArrayList<>();
        BasicInfos basicInfos = new BasicInfos();
        //设置fullReportId
        basicInfos.setFullReportId(fullReportId);
        if (report.getCompanySummary() != null) {
            basicInfos.setBusinessComName(report.getCompanySummary().getBusinessName());
            basicInfos.setRegComName(report.getCompanySummary().getCompanyRegistrationNumber());
            basicInfos.setRegCode(report.getCompanySummary().getNumber());
            if (report.getCompanySummary().getMainActivity() != null) {
                basicInfos.setLocationStatus(report.getCompanySummary().getMainActivity().getActivityCode());
                basicInfos.setLocationDec(report.getCompanySummary().getMainActivity().getActivityDescription());
            }
            if (report.getCompanySummary().getCompanyStatus() != null) {
                basicInfos.setCompanyStatusCode(report.getCompanySummary().getCompanyStatus().getCode());
                basicInfos.setCompanyStatusText(report.getCompanySummary().getCompanyStatus().getValue());
            }
            if (report.getCompanySummary().getCountry() != null) {
                basicInfos.setCountryCode(report.getCompanySummary().getCountry().value());
            }

        }

        if (report.getCompanyIdentification() != null) {
            if (report.getCompanyIdentification().getBasicInformation() != null) {
                if (report.getCompanyIdentification().getBasicInformation().getContactAddress() != null) {
                    basicInfos.setRegHouseNumber(report.getCompanyIdentification().getBasicInformation().getContactAddress().getHouseNumber());
                    basicInfos.setRegStreet(report.getCompanyIdentification().getBasicInformation().getContactAddress().getStreet());
                    basicInfos.setRegCity(report.getCompanyIdentification().getBasicInformation().getContactAddress().getCity());
                    basicInfos.setRegProvince(report.getCompanyIdentification().getBasicInformation().getContactAddress().getProvince());
                    basicInfos.setRegPostalCode(report.getCompanyIdentification().getBasicInformation().getContactAddress().getPostalCode());
                }
                if (report.getCompanyIdentification().getBasicInformation().getCountry() != null) {
                    basicInfos.setRegCountry(report.getCompanyIdentification().getBasicInformation().getCountry().value());
                }
                if (report.getCompanyIdentification().getBasicInformation().getLegalForm() != null) {
                    basicInfos.setRegForm(report.getCompanyIdentification().getBasicInformation().getLegalForm().getValue());
                    basicInfos.setRegGlobalForm(report.getCompanyIdentification().getBasicInformation().getLegalForm().getValue());
                    basicInfos.setRegLocalForm(report.getCompanyIdentification().getBasicInformation().getLegalForm().getValue());
                }
                basicInfos.setRegType(report.getCompanyIdentification().getBasicInformation().getTypeofOwnership());
                if (report.getCompanyIdentification().getBasicInformation().getDateofCompanyRegistration() != null) {
                    basicInfos.setRegDate(report.getCompanyIdentification().getBasicInformation().getDateofCompanyRegistration().toString());
                }
                basicInfos.setVatCode(report.getCompanyIdentification().getBasicInformation().getVatRegistrationNumber());
                if (report.getCompanyIdentification().getBasicInformation().getVatRegistrationDate() != null) {

                    basicInfos.setVatDate(report.getCompanyIdentification().getBasicInformation().getVatRegistrationDate().toString());
                }
            }
        }


        if (report.getContactInformation() != null) {
            if (report.getContactInformation().getMainAddress() != null) {
                if (report.getContactInformation().getMainAddress().getAddress() != null) {
                    basicInfos.setContactTel(report.getContactInformation().getMainAddress().getTelephone());
                    basicInfos.setContactAddress(report.getContactInformation().getMainAddress().getAddress().getSimpleValue());
                    basicInfos.setContactHouseNumber(report.getContactInformation().getMainAddress().getAddress().getHouseNumber());
                    basicInfos.setContactStreet(report.getContactInformation().getMainAddress().getAddress().getStreet());
                    basicInfos.setContactCity(report.getContactInformation().getMainAddress().getAddress().getCity());
                    basicInfos.setContatctProvince(report.getContactInformation().getMainAddress().getAddress().getProvince());
                    basicInfos.setContatctPostalCode(report.getContactInformation().getMainAddress().getAddress().getPostalCode());
                    basicInfos.setRegTel(report.getContactInformation().getMainAddress().getTelephone());
                }
            }
            if (report.getContactInformation().getEmailAddresses() != null) {
                if (report.getContactInformation().getEmailAddresses().getEmailAddress().size() > 0) {
                    basicInfos.setEmail(report.getContactInformation().getEmailAddresses().getEmailAddress().get(0));
                }
            }
            if (report.getContactInformation().getWebsites() != null) {
                if (report.getContactInformation().getWebsites().getWebsite().size() > 0) {
                    basicInfos.setWebsite(report.getContactInformation().getWebsites().getWebsite().get(0));
                }
            }
            if (report.getContactInformation().getOtherAddresses() != null) {
                if (report.getContactInformation().getOtherAddresses().getOtherAddress().size() > 0) {
                    basicInfos.setOtherTel(report.getContactInformation().getOtherAddresses().getOtherAddress().get(0).getTelephone());
                    basicInfos.setOtherAddress(report.getContactInformation().getOtherAddresses().getOtherAddress().get(0).getAddress().getSimpleValue());
                    basicInfos.setOtherHouseNumber(report.getContactInformation().getOtherAddresses().getOtherAddress().get(0).getAddress().getHouseNumber());
                    basicInfos.setOtherStreet(report.getContactInformation().getOtherAddresses().getOtherAddress().get(0).getAddress().getStreet());
                    basicInfos.setOtherCity(report.getContactInformation().getOtherAddresses().getOtherAddress().get(0).getAddress().getCity());
                    basicInfos.setOtherProvice(report.getContactInformation().getOtherAddresses().getOtherAddress().get(0).getAddress().getProvince());
                    basicInfos.setOtherPostalCode(report.getContactInformation().getOtherAddresses().getOtherAddress().get(0).getAddress().getPostalCode());
                }
            }
        }
        basicInfosList.add(basicInfos);
        return basicInfosList;
    }

    public List<ChangeInfos> parseChangeInfos(LtdCompanyFullReport report, Integer fullReportId) {
        List<ChangeInfos> changeInfos = new ArrayList<>();
        if (report.getCompanyIdentification() != null) {
            if (report.getCompanyIdentification().getPreviousLegalForms() != null) {
                if (report.getCompanyIdentification().getPreviousLegalForms().getPreviousLegalForm() != null) {
                    for (int i = 0; i < report.getCompanyIdentification().getPreviousLegalForms().getPreviousLegalForm().size(); i++) {
                        ChangeInfos changeInfoss = new ChangeInfos();
                        //设置fullReportId
                        changeInfoss.setFullReportId(fullReportId);
                        changeInfoss.setPreviousForm(report.getCompanyIdentification().getPreviousLegalForms().getPreviousLegalForm().get(i).getLegalForm().getValue());
                        changeInfoss.setPreviousCommonCode(report.getCompanyIdentification().getPreviousLegalForms().getPreviousLegalForm().get(i).getLegalForm().getCommonCode());
                        changeInfoss.setPreviousProviderCode(report.getCompanyIdentification().getPreviousLegalForms().getPreviousLegalForm().get(i).getLegalForm().getProviderCode());
                        changeInfoss.setFormChangeDate(report.getCompanyIdentification().getPreviousLegalForms().getPreviousLegalForm().get(i).getDateChanged().toString());

                        if (report.getCompanyIdentification().getPreviousNames() != null) {
                            if (report.getCompanyIdentification().getPreviousNames().getPreviousName().size() > 0) {
                                changeInfoss.setPreviousName(report.getCompanyIdentification().getPreviousNames().getPreviousName().get(0).getName());
                                changeInfoss.setNameChangeDate(report.getCompanyIdentification().getPreviousNames().getPreviousName().get(0).getDateChanged().toString());
                            }
                        }
                        if (report.getContactInformation() != null) {
                            if (report.getContactInformation().getPreviousAddresses() != null) {
                                if (report.getContactInformation().getPreviousAddresses().getPreviousAddress().size() > 0) {
                                    changeInfoss.setPreviousAddress(report.getContactInformation().getPreviousAddresses().getPreviousAddress().get(0).getAddress().getSimpleValue());
                                }
                            }
                        }
                        changeInfos.add(changeInfoss);
                    }
                }
            }
        }
        return changeInfos;
    }

    public List<FinancialFigures> parseFinancialFigures(LtdCompanyFullReport report, Integer fullReportId) {
        List<FinancialFigures> financialFigures = new ArrayList<>();
        if (report.getOtherInformation() != null) {
            if (report.getOtherInformation().getAdvisors() != null) {
                if (report.getOtherInformation().getAdvisors().getAdvisor() != null) {
                    for (int i = 0; i < report.getOtherInformation().getAdvisors().getAdvisor().size(); i++) {
                        FinancialFigures financialFiguress = new FinancialFigures();
                        //设置fullReportId
                        financialFiguress.setFullReportId(fullReportId);
                        financialFiguress.setAuditorNameCN(report.getOtherInformation().getAdvisors().getAdvisor().get(i).getAuditorName());
                        financialFigures.add(financialFiguress);
                    }
                }
            }
        }
        return financialFigures;
    }

    public List<FinancialStatement> parseFinancialStatement(LtdCompanyFullReport report, Integer fullReportId) {
        List<FinancialStatement> financialStatements = new ArrayList<>();
        if (report.getFinancialStatements() != null) {
            if (report.getFinancialStatements().getFinancialStatement() != null) {
                for (int i = 0; i < report.getFinancialStatements().getFinancialStatement().size(); i++) {
                    FinancialStatement financialStatement = new FinancialStatement();
                    //设置fullReportId
                    financialStatement.setFullReportId(fullReportId);
                    if (report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss() != null) {
                        if (report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getAmortisation() != null) {
                            financialStatement.setAmortisation(report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getAmortisation().toString());
                        }
                    }
                    if (report.getFinancialStatements().getFinancialStatement().get(i).getCurrency() != null) {
                        financialStatement.setCurrency(report.getFinancialStatements().getFinancialStatement().get(i).getCurrency().value());
                    }
                    if (report.getFinancialStatements().getFinancialStatement().get(i).getNumberOfWeeks() != null) {
                        financialStatement.setWeeks(report.getFinancialStatements().getFinancialStatement().get(i).getNumberOfWeeks().toString());
                    }
                    if (report.getFinancialStatements().getFinancialStatement().get(i).getYearEndDate() != null) {
                        financialStatement.setYear(report.getFinancialStatements().getFinancialStatement().get(i).getYearEndDate().toString());
                    }

                    if (report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss() != null) {
                        if (report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getRevenue() != null) {
                            financialStatement.setRevenue(report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getRevenue().toString());
                        }
                        if (report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getOperatingCosts() != null) {
                            financialStatement.setOperatingCosts(report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getOperatingCosts().toString());
                        }
                        if (report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getOperatingProfit() != null) {
                            financialStatement.setOperatingProfit(report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getOperatingProfit().toString());
                        }
                        if (report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getWagesAndSalaries() != null) {
                            financialStatement.setWagesAndSalaries(report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getWagesAndSalaries().toString());
                        }
                        if (report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getPensionCosts() != null) {
                            financialStatement.setPensionCosts(report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getPensionCosts().toString());
                        }
                        if (report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getDepreciation() != null) {
                            financialStatement.setDepreciation(report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getDepreciation().toString());
                        }
                        if (report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getAmortisation() != null) {
                            financialStatement.setAmortisation(report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getAmortisation().toString());
                        }
                        if (report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getFinancialIncome() != null) {
                            financialStatement.setFinancialIncome(report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getFinancialIncome().toString());
                        }
                        if (report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getFinancialExpenses() != null) {
                            financialStatement.setFinancialExpenses(report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getFinancialExpenses().toString());
                        }
                        if (report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getExtraordinaryIncome() != null) {
                            financialStatement.setExtraordinaryIncome(report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getExtraordinaryIncome().toString());
                        }
                        if (report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getExtraordinaryCosts() != null) {
                            financialStatement.setExtraordinaryCosts(report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getExtraordinaryCosts().toString());
                        }
                        if (report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getProfitBeforeTax() != null) {
                            financialStatement.setProfitBeforeTax(report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getProfitBeforeTax().toString());
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getTax() != null) {
                                financialStatement.setTax(report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getTax().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getProfitAfterTax() != null) {
                                financialStatement.setProfitAfterTax(report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getProfitAfterTax().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getDividends() != null) {
                                financialStatement.setDividends(report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getDividends().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getMinorityInterests() != null) {
                                financialStatement.setMinorityInterests(report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getMinorityInterests().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getOtherAppropriations() != null) {
                                financialStatement.setOtherAppropriations(report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getOtherAppropriations().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getRetainedProfit() != null) {
                                financialStatement.setRetainedProfit(report.getFinancialStatements().getFinancialStatement().get(i).getProfitAndLoss().getRetainedProfit().toString());
                            }
                        }

                        if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet() != null) {
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getLandAndBuildings() != null) {
                                financialStatement.setLandAndBuildings(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getLandAndBuildings().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getPlantAndMachinery() != null) {
                                financialStatement.setPlantAndMachinery(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getPlantAndMachinery().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getOtherTangibleAssets() != null) {
                                financialStatement.setOtherTangibleAssets(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getOtherTangibleAssets().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalTangibleAssets() != null) {
                                financialStatement.setTotalTangibleAssets(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalTangibleAssets().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getGoodwill() != null) {
                                financialStatement.setGoodwill(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getGoodwill().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getOtherIntangibleAssets() != null) {
                                financialStatement.setOtherIntangibleAssets(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getOtherIntangibleAssets().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalIntangibleAssets() != null) {
                                financialStatement.setTotalIntangibleAssets(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalIntangibleAssets().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getInvestments() != null) {
                                financialStatement.setInvestments(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getInvestments().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getLoansToGroup() != null) {
                                financialStatement.setLoansToGroup(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getLoansToGroup().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getOtherLoans() != null) {
                                financialStatement.setOtherLoans(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getOtherLoans().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getMiscellaneousFixedAssets() != null) {
                                financialStatement.setMiscellaneousFixedAssets(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getMiscellaneousFixedAssets().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalOtherFixedAssets() != null) {
                                financialStatement.setTotalOtherFixedAssets(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalOtherFixedAssets().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalFixedAssets() != null) {
                                financialStatement.setTotalFixedAssets(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalFixedAssets().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getRawMaterials() != null) {
                                financialStatement.setRawMaterials(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getRawMaterials().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getWorkInProgress() != null) {
                                financialStatement.setWorkInProgress(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getWorkInProgress().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getFinishedGoods() != null) {
                                financialStatement.setFinishedGoods(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getFinishedGoods().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getOtherInventories() != null) {
                                financialStatement.setOtherInventories(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getOtherInventories().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalInventories() != null) {
                                financialStatement.setTotalInventories(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalInventories().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTradeReceivables() != null) {
                                financialStatement.setTradeReceivables(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTradeReceivables().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getGroupReceivables() != null) {
                                financialStatement.setGroupReceivables(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getGroupReceivables().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getReceivablesDueAfter1Year() != null) {
                                financialStatement.setReceivablesDueAfter1Year(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getReceivablesDueAfter1Year().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getMiscellaneousReceivables() != null) {
                                financialStatement.setMiscellaneousReceivables(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getMiscellaneousReceivables().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalReceivables() != null) {
                                financialStatement.setTotalReceivables(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalReceivables().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getCash() != null) {
                                financialStatement.setCash(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getCash().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getOtherCurrentAssets() != null) {
                                financialStatement.setOtherCurrentAssets(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getOtherCurrentAssets().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalCurrentAssets() != null) {
                                financialStatement.setTotalCurrentAssets(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalCurrentAssets().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalAssets() != null) {
                                financialStatement.setTotalAssets(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalAssets().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTradePayables() != null) {
                                financialStatement.setTradePayables(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTradePayables().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getBankLiabilities() != null) {
                                financialStatement.setBankLiabilities(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getBankLiabilities().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getOtherLoansOrFinance() != null) {
                                financialStatement.setOtherLoansOrFinance(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getOtherLoansOrFinance().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getGroupPayables() != null) {
                                financialStatement.setGroupPayables(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getGroupPayables().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getMiscellaneousLiabilities() != null) {
                                financialStatement.setMiscellaneousLiabilities(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getMiscellaneousLiabilities().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalCurrentLiabilities() != null) {
                                financialStatement.setTotalCurrentLiabilities(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalCurrentLiabilities().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTradePayablesDueAfter1Year() != null) {
                                financialStatement.setTradePayablesDueAfter1Year(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTradePayablesDueAfter1Year().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getBankLiabilitiesDueAfter1Year() != null) {
                                financialStatement.setBankLiabilitiesDueAfter1Year(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getBankLiabilitiesDueAfter1Year().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getOtherLoansOrFinanceDueAfter1Year() != null) {
                                financialStatement.setOtherLoansOrFinanceDueAfter1Year(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getOtherLoansOrFinanceDueAfter1Year().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getGroupPayablesDueAfter1Year() != null) {
                                financialStatement.setGroupPayablesDueAfter1Year(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getGroupPayablesDueAfter1Year().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getMiscellaneousLiabilitiesDueAfter1Year() != null) {
                                financialStatement.setMiscellaneousLiabilitiesDueAfter1Year(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getMiscellaneousLiabilitiesDueAfter1Year().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalLongTermLiabilities() != null) {
                                financialStatement.setTotalLongTermLiabilities(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalLongTermLiabilities().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalLiabilities() != null) {
                                financialStatement.setTotalLiabilities(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalLiabilities().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getCalledUpShareCapital() != null) {
                                financialStatement.setCalledUpShareCapital(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getCalledUpShareCapital().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getSharePremium() != null) {
                                financialStatement.setRevenueReserves(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getRevenueReserves().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getRevenueReserves()!=null){
                                financialStatement.setRevenueReserves(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getRevenueReserves().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getOtherReserves()!=null){
                                financialStatement.setOtherReserves(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getOtherReserves().toString());
                            }
                            if (report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalShareholdersEquity()!=null){
                                financialStatement.setTotalShareholdersEquity(report.getFinancialStatements().getFinancialStatement().get(i).getBalanceSheet().getTotalShareholdersEquity().toString());
                            }
                        }
                    }

                    if (report.getFinancialStatements().getFinancialStatement().get(i).getOtherFinancials()!=null){
                        financialStatement.setContingentLiabilities(report.getFinancialStatements().getFinancialStatement().get(i).getOtherFinancials().getContingentLiabilities());
                        if (report.getFinancialStatements().getFinancialStatement().get(i).getOtherFinancials().getWorkingCapital()!=null){
                            financialStatement.setWorkingCapital(report.getFinancialStatements().getFinancialStatement().get(i).getOtherFinancials().getWorkingCapital().toString());
                        }
                    }
                    if (report.getFinancialStatements().getFinancialStatement().get(i).getOtherFinancials().getNetWorth()!=null){
                        financialStatement.setNetWorth(report.getFinancialStatements().getFinancialStatement().get(i).getOtherFinancials().getNetWorth().toString());
                    }


                    if (report.getCreditScore() != null) {
                        if (report.getCreditScore().getCurrentCreditRating() != null) {
                            if (report.getCreditScore().getCurrentCreditRating().getCommonValue()!=null){
                                financialStatement.setCurrCommonValue(report.getCreditScore().getCurrentCreditRating().getCommonValue().value());
                            }
                            financialStatement.setCurrCommonDescription(report.getCreditScore().getCurrentCreditRating().getCommonDescription());
                            if (report.getCreditScore().getCurrentCreditRating().getCreditLimit()!=null){
                                financialStatement.setCurrCreditLimit(report.getCreditScore().getCurrentCreditRating().getCreditLimit().getValue());
                            }
                            if (report.getCreditScore().getCurrentCreditRating().getProviderValue()!=null){
                                financialStatement.setCurrProviderValue(report.getCreditScore().getCurrentCreditRating().getProviderValue().getValue());
                            }
                        }
                        if (report.getCreditScore().getPreviousCreditRating() != null) {
                            if (report.getCreditScore().getPreviousCreditRating().getCommonValue()!=null){
                                financialStatement.setPreCommonValue(report.getCreditScore().getPreviousCreditRating().getCommonValue().value());
                            }
                            financialStatement.setPreCommonDescription(report.getCreditScore().getPreviousCreditRating().getCommonDescription());
                            if (report.getCreditScore().getPreviousCreditRating().getCreditLimit()!=null){
                                financialStatement.setPreCreditLimit(report.getCreditScore().getPreviousCreditRating().getCreditLimit().toString());
                            }
                            if (report.getCreditScore().getPreviousCreditRating().getProviderValue()!=null){
                                financialStatement.setPreProviderValue(report.getCreditScore().getPreviousCreditRating().getProviderValue().getValue());
                            }
                        }
                        if (report.getCreditScore().getCurrentContractLimit()!=null){
                            financialStatement.setCurrContractLimit(report.getCreditScore().getCurrentContractLimit().toString());
                        }
                        if (report.getCreditScore().getDateOfLatestRatingChange()!=null){
                            financialStatement.setDateOfLatestRatingChange(report.getCreditScore().getDateOfLatestRatingChange().toString());
                        }
                    }
                    if (report.getCompanySummary() != null) {
                        if (report.getCompanySummary().getCreditRating()!=null){
                            financialStatement.setLocalCreditRating(report.getCompanySummary().getCreditRating().toString());
                        }
                    }
                    if (report.getOtherInformation() != null) {
                        if (report.getOtherInformation().getAdvisors() != null) {
                            if (report.getOtherInformation().getAdvisors().getAdvisor().size() > 0) {
                                financialStatement.setSolicitorName(report.getOtherInformation().getAdvisors().getAdvisor().get(0).getSolicitorName());
                                financialStatement.setAdvisors(report.getOtherInformation().getAdvisors().getAdvisor().get(0).getAuditorName());
                                financialStatement.setAuditorName(report.getOtherInformation().getAdvisors().getAdvisor().get(0).getAuditorName());
                            }
                        }
                    }
                    financialStatements.add(financialStatement);
                }
            }
        }

        return financialStatements;
    }

    public List<HistoryInfos> parseHistoryInfos(LtdCompanyFullReport report, Integer fullReportId) {
        List<HistoryInfos> historyInfoss = new ArrayList<>();
        HistoryInfos historyInfos = new HistoryInfos();
        //设置fullReportId
        historyInfos.setFullReportId(fullReportId);
        historyInfoss.add(historyInfos);
        return historyInfoss;
    }

    public List<Identification> parseIdentification(LtdCompanyFullReport report, Integer fullReportId) {
        List<Identification> identifications = new ArrayList<>();
        Identification identification = new Identification();
        //设置fullReportId
        identification.setFullReportId(fullReportId);
        identifications.add(identification);
        return identifications;
    }

    public List<LegalInfos> parseLegalInfos(LtdCompanyFullReport report, Integer fullReportId) {
        List<LegalInfos> legalInfosList = new ArrayList<>();
        LegalInfos legalInfos = new LegalInfos();
        //设置fullReportId
        legalInfos.setFullReportId(fullReportId);
        if (report.getAdditionalInformation() != null) {
            if (report.getAdditionalInformation().getNegativeInformation() != null) {
                if (report.getAdditionalInformation().getNegativeInformation().getBankruptcyData() != null) {
                    if (report.getAdditionalInformation().getNegativeInformation().getBankruptcyData().getBankruptcy() != null) {
                        legalInfos.setBankruptcy(report.getAdditionalInformation().getNegativeInformation().getBankruptcyData().getBankruptcy().getHasBankruptcy());
                    }
                }
                if (report.getAdditionalInformation().getNegativeInformation().getLegalFilingSummary() != null) {
                    legalInfos.setJudgmentFilings(report.getAdditionalInformation().getNegativeInformation().getLegalFilingSummary().getJudgmentFilings());
                    legalInfos.setTaxLienFilings(report.getAdditionalInformation().getNegativeInformation().getLegalFilingSummary().getTaxLienFilings());
                    legalInfos.setSum(report.getAdditionalInformation().getNegativeInformation().getLegalFilingSummary().getSum());
                    legalInfos.setuCCFilings(report.getAdditionalInformation().getNegativeInformation().getLegalFilingSummary().getUccFilings());
                    legalInfos.setCautionaryUCCFilings(report.getAdditionalInformation().getNegativeInformation().getLegalFilingSummary().getCautionaryUCCFilings());
                }
            }
        }
        legalInfosList.add(legalInfos);
        return legalInfosList;

    }

    public List<Managements> parseManagements(LtdCompanyFullReport report, Integer fullReportId) {
        List<Managements> managementss = new ArrayList<>();
        Managements managements = new Managements();
        if (report.getDirectors() != null) {
            if (report.getDirectors().getCurrentDirectors() != null) {
                if (report.getDirectors().getCurrentDirectors().getDirector() != null) {
                    for (Director director : report.getDirectors().getCurrentDirectors().getDirector()) {
                        managements.setName(director.getName());
                        //设置fullReportId
                        managements.setFullReportId(fullReportId);
                        if(StringUtil.isNotNull(director.getAddress())){
                            managements.setAddress(director.getAddress().getSimpleValue());
                        }
                        String gender = String.valueOf(director.getGender());
                        managements.setGender(gender);
                        if (director.getPosition().size()>0) {
                            managements.setPosition(director.getPosition().get(0).getValue());
                                managements.setCommonCode(director.getPosition().get(0).getCommonCode());
                                if(director.getPosition().get(0).getAppointmentDate()!=null){
                                    managements.setAppointmentDate(director.getPosition().get(0).getAppointmentDate().toString());
                                }
                                managements.setProviderCode(director.getPosition().get(0).getProviderCode());
                                managementss.add(managements);
                            }
                        managementss.add(managements);
                    }
                }
            }
        }

        return managementss;
    }

    public List<MediaRecords> parseMediaRecords(LtdCompanyFullReport report, Integer fullReportId) {
        List<MediaRecords> mediaRecordss = new ArrayList<>();
        MediaRecords mediaRecords = new MediaRecords();
        //设置fullReportId
        mediaRecords.setFullReportId(fullReportId);
        mediaRecordss.add(mediaRecords);
        return mediaRecordss;
    }

    public List<Operatings> parseOperatings(LtdCompanyFullReport report, Integer fullReportId) {
        List<Operatings> operatingss = new ArrayList<>();
        if (report.getOtherInformation() != null) {
            if (report.getOtherInformation().getEmployeesInformation() != null) {
                if (report.getOtherInformation().getEmployeesInformation().getEmployeeInformation() != null) {
                    for (EmployeeInformation employeeInformation : report.getOtherInformation().getEmployeesInformation().getEmployeeInformation()) {
                        Operatings operatings = new Operatings();
                        if (report.getCompanySummary() != null) {
                            if (report.getCompanySummary().getMainActivity() != null) {
                                operatings.setActivityCode(report.getCompanySummary().getMainActivity().getActivityCode());
                                operatings.setActivityDescription(report.getCompanySummary().getMainActivity().getActivityDescription());
                            }
                        }
                        //设置fullReportId
                        operatings.setFullReportId(fullReportId);
                        if (employeeInformation.getYear()!=null){
                            operatings.setYear(employeeInformation.getYear().toString());
                        }
                        operatingss.add(operatings);
                    }
                }
            }
        }
        return operatingss;
    }

    public List<OtherInfos> parseOtherInfos(LtdCompanyFullReport report, Integer fullReportId) {
        List<OtherInfos> otherInfoss = new ArrayList<>();
        OtherInfos otherInfos = new OtherInfos();
        //设置fullReportId
        otherInfos.setFullReportId(fullReportId);
        otherInfoss.add(otherInfos);
        return otherInfoss;
    }

    public List<PaymentHistories> parsePaymentHistories(LtdCompanyFullReport report, Integer fullReportId) {
        List<PaymentHistories> paymentHistoriess = new ArrayList<>();
        PaymentHistories paymentHistories = new PaymentHistories();
        //设置fullReportId
        paymentHistories.setFullReportId(fullReportId);
        paymentHistoriess.add(paymentHistories);
        return paymentHistoriess;
    }

    public List<PublicRecords> parsePublicRecords(LtdCompanyFullReport report, Integer fullReportId) {
        List<PublicRecords> publicRecordss = new ArrayList<>();
        PublicRecords publicRecords = new PublicRecords();
        //设置fullReportId
        publicRecords.setFullReportId(fullReportId);
        publicRecordss.add(publicRecords);
        return publicRecordss;
    }

    public List<RegistrationInfos> parseRegistrationInfos(LtdCompanyFullReport report, Integer fullReportId) {
        List<RegistrationInfos> registrationInfoss = new ArrayList<>();
        RegistrationInfos registrationInfos = new RegistrationInfos();
        //设置fullReportId
        registrationInfos.setFullReportId(fullReportId);
        registrationInfoss.add(registrationInfos);
        return registrationInfoss;
    }

    public List<RelatedCompanies> parseRelatedCompanies(LtdCompanyFullReport report, Integer fullReportId) {
        List<RelatedCompanies> relatedCompaniess = new ArrayList<>();
        if (report.getAdditionalInformation() != null) {
            if (report.getAdditionalInformation().getExtendedGroupStructure() != null) {
                if (report.getAdditionalInformation().getExtendedGroupStructure().getGroupStructure() != null) {
                    if (report.getAdditionalInformation().getExtendedGroupStructure().getGroupStructure().getCompanyInGroup() != null) {
                        for (CompanyInGroup companyInGroup:report.getAdditionalInformation().getExtendedGroupStructure().getGroupStructure().getCompanyInGroup()) {
                            RelatedCompanies relatedCompanies = new RelatedCompanies();
                            //设置fullReportId
                            relatedCompanies.setFullReportId(fullReportId);
                            relatedCompanies.setSafeNumber(companyInGroup.getSafeNumber());
                            relatedCompanies.setCountry(companyInGroup.getCountry());
                            relatedCompanies.setName(companyInGroup.getCompanyName());
                            relatedCompanies.setStatus(companyInGroup.getStatus());
                            if (report.getContactInformation() != null) {
                                if (report.getContactInformation().getMainAddress() != null) {
                                    if (report.getContactInformation().getMainAddress().getAddress() != null) {
                                        relatedCompanies.setHouseNumber(report.getContactInformation().getMainAddress().getAddress().getHouseNumber());
                                        relatedCompanies.setStreet(report.getContactInformation().getMainAddress().getAddress().getStreet());
                                        relatedCompanies.setCity(report.getContactInformation().getMainAddress().getAddress().getCity());
                                        relatedCompanies.setProvince(report.getContactInformation().getMainAddress().getAddress().getProvince());
                                        relatedCompanies.setPostalCode(report.getContactInformation().getMainAddress().getAddress().getPostalCode());
                                    }
                                }
                            }
                            relatedCompaniess.add(relatedCompanies);
                        }
                    }
                }
            }
        }
        return relatedCompaniess;
    }

    public List<ShareholderInfos> parseShareholderInfos(LtdCompanyFullReport report, Integer fullReportId) {
        List<ShareholderInfos> shareholderInfoss = new ArrayList<>();
        ShareholderInfos shareholderInfos = new ShareholderInfos();
        //设置fullReportId
        shareholderInfos.setFullReportId(fullReportId);
        if (report.getShareCapitalStructure() != null) {
            if (report.getShareCapitalStructure().getShareHolders() != null) {
                if (report.getShareCapitalStructure().getShareHolders().getShareHolder().size()>0) {
                    for (ShareHolder shareHolder : report.getShareCapitalStructure().getShareHolders().getShareHolder()) {
                        if (report.getShareCapitalStructure().getNominalShareCapital()!=null){
                            shareholderInfos.setShareNominalCapital(report.getShareCapitalStructure().getNominalShareCapital().toString());
                        }
                        if (report.getShareCapitalStructure().getIssuedShareCapital()!=null){
                            shareholderInfos.setShareIssuedCapital(report.getShareCapitalStructure().getIssuedShareCapital().toString());
                        }

                        shareholderInfos.setShareName(shareHolder.getName());
                        if(StringUtil.isNotNull(shareHolder.getSharePercent())){
                            shareholderInfos.setSharePercent(shareHolder.getSharePercent().toString());
                        }
                        if(StringUtil.isNotNull(shareHolder.getAddress())){
                            shareholderInfos.setShareAddress(shareHolder.getAddress().getSimpleValue());
                        }
                        shareholderInfoss.add(shareholderInfos);
                    }

                }
            }
        }
        return shareholderInfoss;
    }

    public List<TradeReferences> parseTradeReferences(LtdCompanyFullReport report, Integer fullReportId) {
        List<TradeReferences> tradeReferencess = new ArrayList<>();
        TradeReferences tradeReferences = new TradeReferences();
        //设置fullReportId
        tradeReferences.setFullReportId(fullReportId);
        tradeReferencess.add(tradeReferences);
        return tradeReferencess;
    }

    public List<UCCs> parseUCCs(LtdCompanyFullReport report, Integer fullReportId) {
        List<UCCs> ucCss = new ArrayList<>();
        if (report.getAdditionalInformation() != null) {
            if (report.getAdditionalInformation().getNegativeInformation() != null) {
                if (report.getAdditionalInformation().getNegativeInformation().getUccDetails() != null) {
                    if (report.getAdditionalInformation().getNegativeInformation().getUccDetails().getUccDetail() != null) {
                        for (UCCDetail uccDetail : report.getAdditionalInformation().getNegativeInformation().getUccDetails().getUccDetail()) {
                            UCCs ucCs = new UCCs();
                            //设置fullReportId
                            ucCs.setFullReportId(fullReportId);
                            ucCs.setFiledDate(uccDetail.getFiledDate());
                            ucCs.setFlingNumber(uccDetail.getFilingNumber());
                            ucCs.setSecuredParty(uccDetail.getSecuredPartyName());
                            ucCss.add(ucCs);
                        }
                    }
                }
            }
        }
        return ucCss;
    }

}
