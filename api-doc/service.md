# Service APIs

1. Get Business Services GET [/api/businesses/{id}/services](#get-business-services) -- DONE
2. Add Business Service POST [/api/businesses/{id}/services](#add-business-service) -- DONE
3. Get One Service GET [/api/services/{id}](#get-one-service) -- DONE
4. Update Service PUT [/api/services/{id}](#update-service) -- DONE
5. Delete Service DELETE [/api/services/{id}](#delete-service) -- DONE

---

## Get Business Services
## 1. GET /api/businesses/{id}/services

### Request
```
{}
```

### Response
```
[
    {
        "serviceId": 1,
        "serviceName": "Cheese Pizza",
        "price": 40000,
        "description": "Aimar ih cheese tei goy amttai pizza",
        "availability": 1,
        "businessId": 1,
        "media": [
            {
                "mediaId": 1,
                "subject": "service",
                "filePath": "/uploads/service/1.png",
                "originalFilename": "1.png",
                "createdAt": "2025-11-26T02:38:28.737Z"
            }
        ],
        "createdDatetime": "2025-11-26T02:38:28.737Z",
        "createdBy": 0,
        "modifiedDatetime": "2025-11-26T02:38:28.737Z",
        "modifiedBy": 0
    }.
    { ... }
]
```

---

## Add Business Service
## 2. POST /api/businesses/{id}/services


### Request
```
{
    "serviceName": "Cheese Pizza",
    "price": 40000,
    "description": "Aimr ih cheesetei pizza",
    "availability": 1,
    "media": [1,2,3]
}
```

### Response
```
{
    "serviceId": 1,
    "serviceName": "Cheese Pizza",
    "price": 40000,
    "description": "Aimar ih cheese tei goy amttai pizza",
    "availability": 1,
    "businessId": 1,
    "media": [
        {
            "mediaId": 1,
            "subject": "service",
            "filePath": "/uploads/service/1.png",
            "originalFilename": "1.png",
            "createdAt": "2025-11-26T02:38:28.737Z"
        }
    ],
    "createdDatetime": "2025-11-26T02:38:28.737Z",
    "createdBy": 0,
    "modifiedDatetime": "2025-11-26T02:38:28.737Z",
    "modifiedBy": 0
}
```


--- 

## Get One Service
## 3. GET /api/services/{id}


### Request
```
{ }
```

### Response
```
{
    "serviceId": 1,
    "serviceName": "Cheese Pizza",
    "price": 40000,
    "description": "Aimar ih cheese tei goy amttai pizza",
    "availability": 1,
    "businessId": 1,
    "media": [
        {
            "mediaId": 1,
            "subject": "service",
            "filePath": "/uploads/service/1.png",
            "originalFilename": "1.png",
            "createdAt": "2025-11-26T02:38:28.737Z"
        }
    ],
    "createdDatetime": "2025-11-26T02:38:28.737Z",
    "createdBy": 0,
    "modifiedDatetime": "2025-11-26T02:38:28.737Z",
    "modifiedBy": 0
}
```

---

## Update Service
## 4. PUT /api/services/{id}

### Request
```
{
    "serviceName": "Cheese Pizza -- updated",
    "price": 40000,
    "description": "Aimr ih cheesetei pizza",
    "availability": 1,
    "media": [1,2,3]
}
```

### Response
```
{
    "serviceId": 1,
    "serviceName": "Cheese Pizza -- updated",
    "price": 40000,
    "description": "Aimar ih cheese tei goy amttai pizza",
    "availability": 1,
    "businessId": 1,
    "media": [
        {
            "mediaId": 1,
            "subject": "service",
            "filePath": "/uploads/service/1.png",
            "originalFilename": "1.png",
            "createdAt": "2025-11-26T02:38:28.737Z"
        }
    ],
    "createdDatetime": "2025-11-26T02:38:28.737Z",
    "createdBy": 0,
    "modifiedDatetime": "2025-11-26T02:38:28.737Z",
    "modifiedBy": 0
}
```

--- 
## Delete Service
## 5. DELETE /api/services/{id}

### Request
```
{

}
```

### Response
```
{
    "message": "Service got deleted successfully"
}
```