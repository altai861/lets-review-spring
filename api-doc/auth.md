#Authenticated endpoints

1. POST /api/auth/register

Request
'''
{
    "email": "altai.g@grapecity.mn",
    "username": "altai.g",
    "firstName": "altai",
    "lastName": "gantumur",
    "phoneNumber": "+97690292709",
    "password": "Aka123"
}
'''

Response
'''
{
    "message": "User registered successfully",
    "userId": "123"
}
'''

2. POST /api/auth/login

Request
'''
{
    "email": "altai.g@grapecity.mn",
    "password": "Aka123"
}
'''

Response
'''
{
    "message": "User logged in successfully",
    "accessToken": "eYajkshdkjahsdhas...."
}
'''

3. POST /api/auth/refresh

Request
'''
{}
'''

Response
'''
{
    "message": "Refresh successful",
    "accessToken": "eYasdkjhjakjsdkjah....."
}
'''

4. POST /api/auth/logout

Request
'''
{}
'''

Response 
'''
{
    "message": "Logged out successfully"
}
'''