# District APIs

---

1. Get Province Districts GET [/api/provinces/{provinceId}/districts](#get-province-districts) -- DONE
2. Create Province District POST [/api/provinces/{provinceId}/districts](#create-province-district) -- DONE
3. Get One District GET [/api/districts/{id}](#get-one-district) -- DONE
4. Update District PUT [/api/districts/{id}](#update-district) -- DONE
5. Delete District DELETE [/api/districts/{id}](#delete-district) -- DONE



---

## Get Province Districts
## 1. GET /api/provinces/{provinceId}/districts

### Request
```
{}
```

### Response
```
[
    {
        "districtId": 2,
        "provinceId: 2,
        "districtName": "Baynzurkh",
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

## Create Province District
## 2. POST /api/provinces/{provinceId}/districts

### Request
```
{
    "districtName": "Baynzurkh",
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
    "message": "District successfully created",
    "districtId": 123
}
```

--- 

## Get One District
## 3. GET /api/districts/{id}

### Request
```
{}
```

### Response
```
{
    "districtId": 2,
    "provinceId": 2,
    "districtName": "Baynzurkh",
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

## Update District
## 4. PUT /api/districts/{id}

### Request
```
{
    "districtName": "Baynzurkh",
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
    "districtName": "Baynzurkh",
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
    "modifiedDatetime": "2025-11-26T02:38:28.737Z",
    "modifiedBy": 0
}
```
---

## Delete District
## 5. DELETE /api/districts/{id}

### Request
```
{}
```

### Response
```
{
    "message": "District deleted successfully"
}
```

