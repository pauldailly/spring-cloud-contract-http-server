package com.pauldailly.springcloudcontract

import com.pauldailly.springcloudcontract.model.FraudCheck
import com.pauldailly.springcloudcontract.model.FraudCheckResult
import com.pauldailly.springcloudcontract.model.FraudCheckStatus
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.POST

@RestController
class FraudDetectionController {
    private static final MAX_AMOUNT = new BigDecimal(99999)

    @RequestMapping(
            value = "/fraudchecks",
            method = POST,
            consumes = 'application/json',
            produces = 'application/json')
    FraudCheckResult fraudCheck(@RequestBody FraudCheck fraudCheck) {
        if (MAX_AMOUNT <= fraudCheck.loanAmount) {
           return new FraudCheckResult(status: FraudCheckStatus.FRAUDULENT, reason: 'Amount too high')
        }

        new FraudCheckResult(status: FraudCheckStatus.NON_FRAUDULENT, reason: '')
    }
}
