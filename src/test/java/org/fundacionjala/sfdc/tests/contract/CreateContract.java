package org.fundacionjala.sfdc.tests.contract;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.selenium.Navigator;
import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.contracts.ContractDetail;
import org.fundacionjala.sfdc.pages.contracts.ContractForm;
import org.fundacionjala.sfdc.pages.contracts.ContractHome;
import org.fundacionjala.sfdc.tests.Asserts;

/**
 * This class handle create a new contract.
 */
public class CreateContract {

    static final String CONTRACT_DATA_PATH = "contract/CreateContractData.json";

    private static final String STATUS = "Draft";

    private static final String CONTRACT_START_DATE = "11/1/2016";

    private static final String CONTRACT_TERM_MONTHS = "1";

    private ContractHome contractHome;

    private Map<String, String> valuesMapJson;

    private ContractDetail contractDetail;

    /**
     * This method is Before setup.
     */
    @BeforeMethod
    public void setup() {
        valuesMapJson = JsonMapper.getMapJson(CONTRACT_DATA_PATH);

        LoginPage.loginAsPrimaryUser();
        contractHome = Navigator.goToContract();
    }

    /**
     * This method that is created a new contract with json.
     */
    @Test
    public void createContractWithJson() {
        ContractForm contractForm = contractHome.clickNewButton();
        contractForm.fillTheForm(valuesMapJson);
        contractDetail = contractForm.clickSaveButton();
        contractDetail.goToLinkDetail();
        Asserts.assertDetailValues(contractDetail, valuesMapJson);
    }

    /**
     * This method that is created a new contract.
     */
//    @Test
//    public void createContract() {
//        contractHome.clickNewButton();
//
//        contractForm = new ContractForm.ContractBuilder(
//                valuesMapJson.get(ACCOUNT_NAME.toString()), STATUS, CONTRACT_START_DATE, CONTRACT_TERM_MONTHS)
//                .build();
//        contractDetail = contractForm.saveContract();
//        Navigator.goToContract();
//        Asserts.assertDetailValues(contractDetail, contractForm.getValuesMap());
//    }

    /**
     * This method is executed after the scenario.
     */
    @AfterMethod
    public void tearDown() {
        contractDetail.clickDeleteButton();
    }
}
