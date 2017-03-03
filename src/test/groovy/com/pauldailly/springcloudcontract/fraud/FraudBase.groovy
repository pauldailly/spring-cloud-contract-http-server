package com.pauldailly.springcloudcontract.fraud

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc
import com.pauldailly.springcloudcontract.FraudDetectionController
import org.junit.Before


class FraudBase {

    @Before
    void setup() {
        RestAssuredMockMvc.standaloneSetup(new FraudDetectionController());
    }
}
