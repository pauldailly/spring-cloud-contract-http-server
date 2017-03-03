package contracts.fraud

import org.springframework.cloud.contract.spec.Contract


Contract.make {
    request { 
        method 'POST'
        url '/fraudchecks'
        body([ 
               clientId: $(regex('[0-9]{10}')),
               loanAmount: 99999
        ])
        headers { 
            contentType('application/json')
        }
    }
    response { 
        status 200 
        body([ 
               status: "FRAUDULENT",
               reason: "Amount too high"
        ])
        headers { 
            contentType('application/json')
        }
    }
}


