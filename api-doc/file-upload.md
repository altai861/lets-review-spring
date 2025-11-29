# File Upload APIs

1. Upload a file POST [/api/files/upload](#upload-file) -- DONE

---

## Upload file
## 1. POST /api/files/upload

### Request formData
```
file: MultiPartFile 
subject: String
```

### Response
```
{
    "filePath": "/uploads/test/2025-11-29/43d52d3d-cb83-4693-87ae-9dfeacf5bb1b_giphy.gif",
    "mediaId": 1
}
```
