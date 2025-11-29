# Country APIs

1. Get Countries GET [/api/countries](#get-countries) -- DONE
2. Add Country POST [/api/countries](#add-country) -- DONE
3. Get One Country GET [/api/countries/{id}](#get-one-country) -- DONE
4. Update Country PUT [/api/countries/{id}](#update-country) -- DONE
5. Delete Country DELETE [/api/countries/{id}](#delete-country) -- DONE

---

## Get Countries
## 1. GET /api/countries

### Request
```
{}
```

### Response
```
[
    {
        "countryId": 2,
        "countryName": "Mongolia",
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

## Add Country
## 2. POST /api/countries

### Request
```
{
    "countryName": "Mongolia",
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
    "message": "Country successfully created",
    "countryId": 123
}
```

--- 

## Get One Country
## 3. GET /api/countries/{id}

### Request
```
{}
```

### Response
```
{
    "countryId": 2,
    "countryName": "Mongolia",
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

## Update Country
## 4. PUT /api/countries/{id}

### Request
```
{
    "countryName": "Mongolia",
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
            "lat": 47.93,
            "lng": 106.93
        }
    ]
}
```

### Response
```
{
    "countryId": 2,
    "countryName": "Mongolia",
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
            "lat": 47.93,
            "lng": 106.93
        }
    ],
    "createdDatetime": "2025-11-26T02:38:28.737Z",
    "createdBy": 0,
    "modifiedDatetime": "2025-11-26T09:10:00.123Z",
    "modifiedBy": 1
}
```

--- 
## Delete Country
## 5. DELETE /api/countries/{id}

### Request
```
{}
```

### Response
```
{
    "message": "Country deleted successfully"
}
```

