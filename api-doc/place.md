# Place APIs

1. Get Places GET [/api/places](#get-places) 
2. Add Place POST [/api/places](#add-place)
3. Get One Place GET [/api/places/{id}](#get-one-place)
4. Update Place PUT [/api/places/{id}](#update-place)
5. Delete Place DELETE [/api/places/{id}](#delete-place)

---

## Get Places
## 1. GET /api/places
Here can be filtered with countryId, provinceId, districtId
### Request
```
{}
```

### Response
```
[
    {
        "placeId": 1,
        "placeName": "Max Mall",
        "description": "Baruun 4 zam iin uulzvar deer bairlah goy delguur",
        "address": "Mongolia, UB, Songinohairkhan, some street.",
        "latitude": 49.123,
        "longitude": 123.123,
        "floorNumber": 10,
        "districtId": 1,
        "provinceId": 1,
        "countryId": 1,
        "createdDatetime": "2025-11-26T02:38:28.737Z",
        "createdBy": 0,
        "modifiedDatetime": "2025-11-26T02:38:28.737Z",
        "modifiedBy": 0
    },
    { ... }
]
```

---


## Add Place
## 2. POST /api/places
### Request
```
{
    "placeName": "Max Mall",
    "description": "Baruun 4 zam iin uulzvar deer bairlah goy delguur",
    "address": "Mongolia, UB, Songinohairkhan, some street.",
    "latitude": 49.123,
    "longitude": 123.123,
    "floorNumber": 10,
    "districtId": 1
}
```

### Response
```
{
    "message": "Place added successfully",
    "placeId": 123
}
```

---

## Get One Place
## 3. GET /api/places/{id}
### Request
```
{ }
```

### Response
```
{
    "placeId": 1,
    "placeName": "Max Mall",
    "description": "Baruun 4 zam iin uulzvar deer bairlah goy delguur",
    "address": "Mongolia, UB, Songinohairkhan, some street.",
    "latitude": 49.123,
    "longitude": 123.123,
    "floorNumber": 10,
    "districtId": 1,
    "provinceId": 1,
    "countryId": 1,
    "createdDatetime": "2025-11-26T02:38:28.737Z",
    "createdBy": 0,
    "modifiedDatetime": "2025-11-26T02:38:28.737Z",
    "modifiedBy": 0
}
```

---


## Update Place
## 4. UPDATE /api/places/{id}
### Request
```
{ 
    "placeName": "Max Mall - updated",
    "description": "Baruun 4 zam iin uulzvar deer bairlah goy delguur",
    "address": "Mongolia, UB, Songinohairkhan, some street.",
    "latitude": 49.123,
    "longitude": 123.123,
    "floorNumber": 10,
    "districtId": 1
}
```

### Response
```
{
    "placeId": 1,
    "placeName": "Max Mall - updated",
    "description": "Baruun 4 zam iin uulzvar deer bairlah goy delguur",
    "address": "Mongolia, UB, Songinohairkhan, some street.",
    "latitude": 49.123,
    "longitude": 123.123,
    "floorNumber": 10,
    "districtId": 1,
    "provinceId": 1,
    "countryId": 1,
    "createdDatetime": "2025-11-26T02:38:28.737Z",
    "createdBy": 0,
    "modifiedDatetime": "2025-11-26T02:38:28.737Z",
    "modifiedBy": 0
}
```
---
## Delete Place
## 5. DELETE /api/places/{id}
### Request
```
{ 

}
```

### Response
```
{
    "message": "Place deleted successfully
}
```