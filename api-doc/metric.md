# Metric APIs

1. Get Metrics GET [/api/metrics](#get-metrics) -- DONE
2. Add Metric POST [/api/metrics](#add-metric) -- DONE
3. Get One Metric GET [/api/metrics/{id}](#get-one-metric) -- DONE
4. Update Metric PUT [/api/metrics/{id}](#update-metric) -- DONE
5. Delete Metric DELETE [/api/metrics/{id}](#delete-country) -- DONE

---

## Get Metrics
## 1. GET /api/metrics

### Request
```
{}
```

### Response
```
[
    {
        "metricId": 1,
        "metricName": "Cleanliness",
        "metricDescription": "How clean is the environment",
        "minValue": 0,
        "maxValue": 5,
        "createdDatetime": "2025-11-26T02:38:28.737Z",
        "createdBy": 0,
        "modifiedDatetime": "2025-11-26T02:38:28.737Z",
        "modifiedBy": 0
    }
]
```

---

## Add Metric
## 2. POST /api/metrics

### Request
```
{
    "metricName": "Cleanliness",
    "metricDescription": "How clean is the environment",
    "minValue": 0,
    "maxValue": 5
}
```

### Response
```
{
    "message": "Metric created successfully",
    "metricId": 123
}
```

---

## Get One Metric
## 3. GET /api/metrics/{id}

### Request
```
{}
```

### Response
```
{
    "metricId": 1,
    "metricName": "Cleanliness",
    "metricDescription": "How clean is the environment",
    "minValue": 0,
    "maxValue": 5,
    "createdDatetime": "2025-11-26T02:38:28.737Z",
    "createdBy": 0,
    "modifiedDatetime": "2025-11-26T02:38:28.737Z",
    "modifiedBy": 0
}
```

---

## Update metric
## 4. PUT /api/metrics/{id}

### Request
```
{
    "metricName": "Cleanliness-updated",
    "metricDescription": "How clean is the environment-updated",
    "minValue": 0,
    "maxValue": 5,
}
```

### Response
```
{
    "metricId": 1,
    "metricName": "Cleanliness-updated",
    "metricDescription": "How clean is the environment-updated",
    "minValue": 0,
    "maxValue": 5,
    "createdDatetime": "2025-11-26T02:38:28.737Z",
    "createdBy": 0,
    "modifiedDatetime": "2025-11-26T02:38:28.737Z",
    "modifiedBy": 0
}
```

---

## Delete Country
## 5. DELETE /api/metrics/{id}

### Request
```
{}
```

### Response
```
{
    "message": "Metric deleted successfully"
}
```