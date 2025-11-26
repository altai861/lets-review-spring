# Authentication endpoints

1. Register POST [/api/auth/register](#register)
2. Login POST [/api/auth/login](#login)
3. Refresh POST [/api/auth/refresh](#refresh)
4. Logout POST [/api/auth/logout](#logout)

## Register
## 1. POST /api/auth/register

### Request
```
{
    "email": "altai.g@grapecity.mn",
    "username": "altai.g",
    "firstName": "altai",
    "lastName": "gantumur",
    "phoneNumber": "+97690292709",
    "password": "Aka123"
}
```

### Response
```
{
    "message": "User registered successfully",
    "userId": "123"
}
```

## Login
## 2. POST /api/auth/login

### Request
```
{
    "email": "altai.g@grapecity.mn",
    "password": "Aka123"
}
```

### Response
```
{
    "message": "User logged in successfully",
    "accessToken": "eYajkshdkjahsdhas...."
}
```

## Refresh
## 3. POST /api/auth/refresh

### Request
```
{}
```

### Response
```
{
    "message": "Refresh successful",
    "accessToken": "eYasdkjhjakjsdkjah....."
}
```

## Logout
## 4. POST /api/auth/logout

### Request
```
{}
```

### Response 
```
{
    "message": "Logged out successfully"
}
```