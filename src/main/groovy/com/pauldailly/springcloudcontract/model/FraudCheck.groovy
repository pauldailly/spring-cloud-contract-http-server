package com.pauldailly.springcloudcontract.model

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString
class FraudCheck {

    BigDecimal loanAmount
    String clientId
}
