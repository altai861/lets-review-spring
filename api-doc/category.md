# Category APIs

1. Get Categories GET [/api/categories](#get-categories) -- DONE
2. Add Category POST [/api/categories](#add-category) -- DONE
3. Get One Category GET [/api/categories/{id}](#get-one-category) -- DONE
4. Update Category PUT [/api/categories/{id}](#update-category) -- DONE
5. Delete Category DELETE [/api/categories/{id}](#delete-country) -- DONE

---

## Get Categories
## 1. GET /api/categories

### Request
```
{}
```
### Response
```
[
    {
        "categoryId": 1,
        "categoryName": "Restaurant",
        "categoryDescription": "Someplace where foods are served",
        "iconFilePath": "/uploads/category/2025/wassup.png",
        "createdDatetime": "2025-11-26T02:38:28.737Z",
        "createdBy": 0,
        "modifiedDatetime": "2025-11-26T02:38:28.737Z",
        "modifiedBy": 0
    }
]
```
---

## Add Category
## 2. POST /api/categories

### Request
```
{
    "categoryName": "Restaurant",
    "categoryDescription": "Someplace where foods are served",
    "mediaId": 1
}
```

### Response
```
{
    "message": "Category successfully created",
    "categoryId": 123
}
```

---

## Get One Category
## 3. GET /api/categories/{id}

### Request
```
{}
```

### Response
```
{
    "categoryId": 1,
    "categoryName": "Restaurant",
    "categoryDescription": "Someplace where foods are served",
    "iconFilePath": "/uploads/category/2025/wassup.png",
    "createdDatetime": "2025-11-26T02:38:28.737Z",
    "createdBy": 0,
    "modifiedDatetime": "2025-11-26T02:38:28.737Z",
    "modifiedBy": 0
}
```

---

## Update Country
## 4. PUT /api/categories/{id}

### Request
```
{
    "categoryName": "Restaurant updated",
    "categoryDescription": "Some place where food is served hot",
    "mediaId": 2
}
```

### Response
```
{
    "categoryId": 1,
    "categoryName": "Restaurant updated",
    "categoryDescription": "Someplace where foods are served hot",
    "iconFilePath": "/uploads/category/2025/wassup_new.png",
    "createdDatetime": "2025-11-26T02:38:28.737Z",
    "createdBy": 0,
    "modifiedDatetime": "2025-11-26T02:38:28.737Z",
    "modifiedBy": 0
}
```

--- 
## Delete Country
## 5. DELETE /api/categories/{id}

### Request
```
{}
```
### Response
```
{
    "message": "Category deleted successfully"
}
```
