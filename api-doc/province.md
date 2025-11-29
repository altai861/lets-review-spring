# Province APIs

---
1. Get Country Provinces GET [/api/countries/{countryId}/provinces](#get-country-provinces) -- DONE
2. Create Country Province POST [/api/countries/{countryId}/provinces](#create-country-cities) -- DONE
3. Get One Province GET [/api/provinces/{id}](#get-one-province) -- DONE
4. Update Province PUT [/api/provinces/{id}](#update-province) -- DONE
5. Delete Province DELETE [/api/provinces/{id}](#delete-province) -- DONE
--- 

## Get Country Provinces
## 1. GET /api/countries/{countryId}/provinces

### Request
```
{}
```

### Response
```
[
    {
        "provinceId": 2,
        "countryId": 2,
        "provinceName": "Ulaanbaatar",
        "coordinates": [
            {
                "lat": 47.918,
                "lng": 106.917
            },
            {
                "lat": 47.92,
                "lng": 106.92
            },
            {
                "lat": 47.92,
                "lng": 106.92
            }
        ],
        "createdDatetime": "2025-11-26T02:38:28.737Z",
        "createdBy": 0,
        "modifiedDatetime": "2025-11-26T02:38:28.737Z",
        "modifiedBy": 0
    },
    {
        ...
    }
]
```

---
## Create Country Province
## 2. POST /api/countries/{countryId}/provinces

### Request
```
{
    "provinceName": "Ulaanbaatar",
    "coordinates": [
        {
            "lat": 123.123,
            "lng": 123.123
        },
        {
            "lat": 123.123,
            "lng": 123.123
        },
        {
            "lat": 123.123,
            "lng": 123.123
        }
    ]
}
```

### Response
```
{
    "message": "Province successfully created",
    "provinceId": 123
}
```

---

## Get One Province
## 3. GET /api/provinces/{id}

### Request
```
{}
```

### Response
```
{
    "provinceId": 2,
    "countryId": 2,
    "provinceName": "Ulaanbaatar",
    "coordinates": [
        {
            "lat": 47.918,
            "lng": 106.917
        },
        {
            "lat": 47.92,
            "lng": 106.92
        },
        {
            "lat": 47.92,
            "lng": 106.92
        }
    ],
    "createdDatetime": "2025-11-26T02:38:28.737Z",
    "createdBy": 0,
    "modifiedDatetime": "2025-11-26T02:38:28.737Z",
    "modifiedBy": 0
}
```


---

## Update Province
## 4. PUT /api/provinces/{id}

### Request
```
{
    "provinceName": "Ulaanbaatar",
    "coordinates": [
        {
            "lat": 47.918,
            "lng": 106.917
        },
        {
            "lat": 47.92,
            "lng": 106.92
        },
        {
            "lat": 47.92,
            "lng": 106.92
        }
    ],
    "createdDatetime": "2025-11-26T02:38:28.737Z",
    "createdBy": 0,
    "modifiedDatetime": "2025-11-26T02:38:28.737Z",
    "modifiedBy": 0
}
```

### Response
```
{
    "provinceName": "Ulaanbaatar",
    "coordinates": [
        {
            "lat": 47.918,
            "lng": 106.917
        },
        {
            "lat": 47.92,
            "lng": 106.92
        },
        {
            "lat": 47.92,
            "lng": 106.92
        }
    ],
    "createdDatetime": "2025-11-26T02:38:28.737Z",
    "createdBy": 0,
    "modifiedDatetime": "2025-11-26T02:38:28.737Z",
    "modifiedBy": 0
}
```

---
## Delete Province
## 5. DELETE /api/provinces/{id}

### Request
```
{}
```

### Response
```
{
    "message": "Province deleted successfully"
}
```