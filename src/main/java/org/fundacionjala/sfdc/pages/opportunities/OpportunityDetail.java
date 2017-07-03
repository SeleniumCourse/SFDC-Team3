package org.fundacionjala.sfdc.pages.opportunities;

import java.util.HashMap;
import java.util.Map;

import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.fundacionjala.sfdc.pages.AssertsDetails;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.accounts.AccountDetail;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.ACCOUNT_NAME;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.AMOUNT;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.CURRENT_CLOSE_DATE;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.DELIVERY_INSTALL_STATUS;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.LEAD_SOURCE;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.NEXT_STEP;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.OPPORTUNITY_NAME;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.ORDER_NUMBER;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.STAGE;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.TYPE;

/**
 * This class represents the opportunity detail.
 */
public class OpportunityDetail extends DetailBase {

    @FindBy(xpath = "//span[text()='Opportunity Name']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement opportunityNameLabel;

    @FindBy(xpath = "//span[text()='Account Name']/parent::div/following-sibling::div/span/div/a")
    @CacheLookup
    private WebElement accountNameLabel;

    @FindBy(xpath = "//span[text()='Type']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement typeLabel;

    @FindBy(xpath = "//span[text()='Lead Source']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement leadSourceLabel;

    @FindBy(xpath = "//span[contains(text(), 'Amount')]/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement amountLabel;

    @FindBy(xpath = "//span[text()= 'Close Date']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement closeDateLabel;

    @FindBy(xpath = "//span[text()= 'Next Step']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement nextStepLabel;

    @FindBy(xpath = "//span[text()= 'Stage']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement stageLabel;

    @FindBy(xpath = "//span[text()= 'Order Number']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement orderNumberLabel;

    @FindBy(xpath = "//span[text()= 'Delivery/Installation Status']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement deliveryInstallLabel;

    @FindBy(xpath = "//span[text()= 'Private']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement privateFlagImg;

    @FindBy(xpath = "//span[text()= 'Description']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement descriptionLabel;


    @FindBy(xpath = "//span[text()='Details']")
    @CacheLookup
    private WebElement detailsButton;

    /**
     * {@inheritDoc}.
     */
    @Override
    public OpportunityForm clickEditButton() {
        CommonActions.clickElement(downArrow);
        CommonActions.clickElement(editBtn);
        return new OpportunityForm();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public MainApp clickDeleteButton() {
        CommonActions.clickElement(downArrow);
        CommonActions.clickElement(deleteBtn);
        CommonActions.clickElement(confirmDeleteButton);
        return new MainApp();
    }

    /**
     * This method compare the title.
     *
     * @return a boolean.
     */
    public boolean isPrivateFlag() {
        String attributeState = privateFlagImg.getAttribute("title");
        return attributeState.equals("Checked");
    }

    /**
     * This method gets the opportunity name.
     *
     * @return a string with opportunity name text.
     */
    public String getOpportunityName() {
        return opportunityNameLabel.getText();
    }

    /**
     * This method gets the account name.
     *
     * @return a string with account name text.
     */
    public String getAccountName() {
        return accountNameLabel.getText();
    }

    /**
     * This method gets the close date.
     *
     * @return a string with the close date text.
     */
    public String getCloseDate() {
        return closeDateLabel.getText();
    }

    /**
     * This method gets the stage.
     *
     * @return a string with stage text.
     */
    public String getStage() {
        return stageLabel.getText();
    }

    /**
     * This method gets the order number.
     *
     * @return a string with order number text.
     */
    public String getOrderNumber() {
        return orderNumberLabel.getText();
    }

    /**
     * This method gets the delivery install.
     *
     * @return a string with delivery install label
     */
    public String getDeliveryInstallation() {
        return deliveryInstallLabel.getText();
    }

    /**
     * This method gets the amount label.
     *
     * @return a string with amount label.
     */
    public String getAmount() {
        return amountLabel.getText();
    }

    /**
     * This method gets the type label.
     *
     * @return a string with type label.
     */
    public String getTypeText() {
        return typeLabel.getText();
    }

    /**
     * This method gets the lead source label.
     *
     * @return a string with lead source label.
     */
    public String getLeadSource() {
        return leadSourceLabel.getText();
    }

    /**
     * This method gets the delivery install.
     *
     * @return a string with delivery install text.
     */
    public String getNextStep() {
        return nextStepLabel.getText();
    }

    /**
     * This method finds the account name.
     *
     * @param accountName a string with account name.
     * @return {@link AccountDetail}.
     */
    public AccountDetail clickAccountName(final String accountName) {
        driver.findElement(By.xpath("//a[contains(.,'" + accountName + "')]")).click();
        return new AccountDetail();
    }

    /**
     * This method verify if opportunity is displayed.
     *
     * @param opportunityName string with name opportunity.
     * @return a boolean.
     */
    public boolean isOpportunityDisplayed(final String opportunityName) {
        try {
            driver.findElement(By.linkText(opportunityName)).getText();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

    /**
     * Method that to permit gets texts.
     *
     * @return a Map with the values of opportunity edit.
     */
    public Map<String, AssertsDetails> getStrategyAssertMap() {
        final Map<String, AssertsDetails> strategyMap = new HashMap<>();

        strategyMap.put(OPPORTUNITY_NAME.toString(), this::getOpportunityName);
        strategyMap.put(STAGE.toString(), this::getStage);
        strategyMap.put(ORDER_NUMBER.toString(), this::getOrderNumber);
        strategyMap.put(DELIVERY_INSTALL_STATUS.toString(), this::getDeliveryInstallation);
        strategyMap.put(ACCOUNT_NAME.toString(), this::getAccountName);
        strategyMap.put(CURRENT_CLOSE_DATE.toString(), this::getCloseDate);
        strategyMap.put(TYPE.toString(), this::getTypeText);
        strategyMap.put(LEAD_SOURCE.toString(), this::getLeadSource);
        strategyMap.put(NEXT_STEP.toString(), this::getNextStep);
        strategyMap.put(AMOUNT.toString(), this::getAmount);

        return strategyMap;
    }

    /**
     * Method that gets the Owner that was registered in the creation of LeadHome.
     */
    public void clickDetails() {
        CommonActions.clickElement(detailsButton);
    }
}
