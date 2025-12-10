# Business APIs

1. Get Businesses GET [/api/businesses](#get-businesses) -- DONE
2. Add Business POST [/api/businesses](#add-business) -- DONE
3. Get One Business GET [/api/businesses/{id}](#get-one-business) -- DONE
4. Update Business PUT [/api/businesses/{id}](#update-business) -- DONE
5. Delete Business DELETE [/api/businesses/{id}](#delete-business) -- DONE

---

## Get Businesses
## 1. GET /api/businesses

### Request
```
possible queryParams: {
    countryId, 
    provinceId, 
    districtId,
    categoryId
}
```

### Response
```
[
    {
        "address": "UB, baynzurkh, 25th horoo, Naturiin zam",
        "businessId": 3,
        "businessName": "DODO Pizza",
        "categories": [],
        "countryId": 1,
        "countryName": "Mongolia",
        "createdBy": 0,
        "createdDatetime": "2025-12-06T18:48:15.331109",
        "districtId": 1,
        "districtName": "Baynzurk",
        "email": "dodopizza@ub.mn",
        "floorNumber": null,
        "latitude": 49.123,
        "longitude": 123.123,
        "media": [],
        "modifiedBy": 0,
        "modifiedDatetime": "2025-12-06T18:48:15.331122",
        "placeId": 0,
        "placeName": null,
        "provinceId": 1,
        "provinceName": "Ulaanbaatar",
        "status": "UNVERIFIED",
        "userId": 0,
        "workingHours": "08:00-20:00"
    }, 
    { ... }
]
```

---

## Add Business
## 2. POST /api/businesses

### Request
```
{
    "businessName": "DODO pizza",
    "workingHours": "08:00-20:00",
    "address": "UB, baynzurkh district, 25th horoo, Naturiin zam",
    "latitude": 49.123,
    "longitude": 123.123,
    "email": "dodopizza@ub.mn",
    "districtId": 1,
    "mediaIds": [1,2,3],
    "categoryIds": [1,2,3],
    "placeId": 1,
    "floorNumber": 4
}
```
### Response
```
{
        "address": "UB, baynzurkh, 25th horoo, Naturiin zam",
        "businessId": 4,
        "businessName": "DODO Pizza",
        "categories": [],
        "countryId": 1,
        "countryName": "Mongolia",
        "createdBy": 0,
        "createdDatetime": "2025-12-06T19:02:45.865856",
        "districtId": 1,
        "districtName": "Baynzurk",
        "email": "dodopizza@ub.mn",
        "floorNumber": null,
        "latitude": 49.123,
        "longitude": 123.123,
        "media": [],
        "modifiedBy": 0,
        "modifiedDatetime": "2025-12-06T19:02:45.865867",
        "placeId": 0,
        "placeName": null,
        "provinceId": 1,
        "provinceName": "Ulaanbaatar",
        "status": "UNVERIFIED",
        "userId": 0,
        "workingHours": "08:00-20:00"
    }
```

---

## Get One Business
## 3. GET /api/businesses/{id}


### Request
```
{}
```
### Response
```
{
        "address": "UB, baynzurkh, 25th horoo, Naturiin zam",
        "businessId": 4,
        "businessName": "DODO Pizza",
        "categories": [],
        "countryId": 1,
        "countryName": "Mongolia",
        "createdBy": 0,
        "createdDatetime": "2025-12-06T19:02:45.865856",
        "districtId": 1,
        "districtName": "Baynzurk",
        "email": "dodopizza@ub.mn",
        "floorNumber": null,
        "latitude": 49.123,
        "longitude": 123.123,
        "media": [],
        "modifiedBy": 0,
        "modifiedDatetime": "2025-12-06T19:02:45.865867",
        "placeId": 0,
        "placeName": null,
        "provinceId": 1,
        "provinceName": "Ulaanbaatar",
        "status": "UNVERIFIED",
        "userId": 0,
        "workingHours": "08:00-20:00"
    }
```

--- 


## Update Business
## 4. UPDATE /api/businesses/{id}


### Request
```
{
    "businessName": "DODO pizza - updated",
    "workingHours": "08:00-20:00",
    "address": "UB, baynzurkh district, 25th horoo, Naturiin zam",
    "latitude": 49.123,
    "longitude": 123.123,
    "email": "dodopizza@ub.mn",
    "districtId": 1,
    "mediaIds": [1,2,3],
    "categoryIds": [1,2,3],
    "placeId": 1,
    "floorNumber": 4
}
```
### Response
```
{
    "address": "UB, baynzurkh, 25th horoo, Naturiin zam",
    "businessId": 4,
    "businessName": "DODO Pizza - updated",
    "categories": [],
    "countryId": 1,
    "countryName": "Mongolia",
    "createdBy": 0,
    "createdDatetime": "2025-12-06T19:02:45.865856",
    "districtId": 1,
    "districtName": "Baynzurk",
    "email": "dodopizza@ub.mn",
    "floorNumber": null,
    "latitude": 49.123,
    "longitude": 123.123,
    "media": [],
    "modifiedBy": 0,
    "modifiedDatetime": "2025-12-06T19:02:45.865867",
    "placeId": 0,
    "placeName": null,
    "provinceId": 1,
    "provinceName": "Ulaanbaatar",
    "status": "UNVERIFIED",
    "userId": 0,
    "workingHours": "08:00-20:00"
}
```

---

## Delete Business
## 4. DELETE /api/businesses/{id}


### Request
```
{}
```
### Response
```
{
    "message": "Business removed successfully"
}
```
