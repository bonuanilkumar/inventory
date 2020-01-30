# IEM
InventoryMgnt

This application handles all the Order and inventory management requirements for a small scale business.

*************************************************************
                    Add Supplier
*************************************************************
EndPoint - http://localhost:8080/iem/addsupplier

{
    "supplierName": "XXXXXX Gas Agency",
    "phoneNumber": "XXXXXXXXX",
    "address": "XXXXXXXXXXXXXXX",
    "contactName": "XXXXX XXXX",
    "mobile": "XXXXXXXXXX",
    "createdBy": "XXXX",
    "lastUpdatedBy": "XXXX"
}


*************************************************************
                    suppliers - Get
*************************************************************
EndPoint - http://localhost:8080/iem/suppliers

Response:

[
    {
        "supplierId": 1,
        "supplierName": "XXXXXXXXX",
        "phoneNumber": "XXXXXXXX",
        "address": "XXXXXXXXXXX",
        "contactName": "XXXXXXXXXXX",
        "mobile": "XXXXXXXXXX",
        "createdDate": "2020-01-28T03:54:11.000+0000",
        "createdBy": "XXXXX",
        "lastUpdatedDate": "2020-01-28T03:54:11.000+0000",
        "lastUpdatedBy": "XXXXX"
    }
]


*************************************************************
                    Modify Supplier
*************************************************************

TODO


*************************************************************
                    Add Customer
*************************************************************

TODO

*************************************************************
                    Modify Customer
*************************************************************

TODO

*************************************************************
                    GetCustomers
*************************************************************

TODO


*************************************************************
                    Add/Modify/Get Roles
*************************************************************

TODO


*************************************************************
                    Add/Modify/Get Users
*************************************************************

TODO

*************************************************************
                Create Purchase Order -  Sample
*************************************************************
EndPoint - http://localhost:8080/iem/purchaseorder

{
    "totalAmount": 100,
    "taxAmount": 3,
    "orderBy": "XXXXXX",
    "status": "Pending",
    "supplierId": 1,
    "orderDetails": [
        {
            "status": "Pending",
            "unitAmount": 10,
            "itemId": 1,
            "totalAmount": 100,
            "quantity": 10
        }
    ]
}

*************************************************************
                Get Purchase Order -  Sample
*************************************************************

TODO

*************************************************************
                Update Purchase Order -  Sample
*************************************************************

TODO

*************************************************************
                Create Sales Order -  Sample
*************************************************************

TODO

*************************************************************
                Update Sales Order -  Sample
*************************************************************

TODO

*************************************************************
                Get Sales Order -  Sample
*************************************************************

TODO

*************************************************************
                Delete Sales/Purchase Order -  Sample
*************************************************************

TODO

*************************************************************
                Reports
*************************************************************
