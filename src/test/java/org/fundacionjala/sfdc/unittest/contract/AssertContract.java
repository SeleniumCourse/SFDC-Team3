package org.fundacionjala.sfdc.unittest.contract;

import org.fundacionjala.sfdc.pages.opportunities.OpportunityDetail;

import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * This class is to assert of opportunities.
 */
public final class AssertContract {

    private AssertContract() {
    }

    /**
     * This method verify the values in opportunity detail.
     *
     * @param opportunityDetail is a object.
     * @param valuesMapJson     is a map with values of a json file.
     */
    public static void assertDetailValues(final OpportunityDetail opportunityDetail,
                                          final Map<String, String> valuesMapJson) {
        valuesMapJson.keySet()
                .forEach(value -> assertEquals(opportunityDetail.getStrategyAssertMap().get(value).getText(),
                        valuesMapJson.get(value)));
    }
}
