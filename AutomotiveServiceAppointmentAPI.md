The Vehicle Management System is a comprehensive Spring Boot application designed to streamline the management of vehicle-related data and operations. The system encompasses functionalities for handling customer details, vehicle information, vehicle profiles, and service appointments, ensuring efficient organization and easy access to crucial information.






HTTP Method: POST
Endpoint: /appointments/create

Description: Allows users to schedule a new vehicle appointment with specified details.

Request Headers:

Content-Type: application/json
Request Body:

json

{
  "appointmentFrom": "2018-02-05T13:00:11.332",
  "appointmentTo": "2018-02-05T14:00:11.332",
  "garage": 2,
  "vehicle": {
    "model": "kia",
    "carYear": 2020
  },
  "serviceId": 2
}
Responses:

201 Created:
json

{
  "id": 1,
  "appointmentFrom": "2018-02-05T13:00:11.332",
  "appointmentTo": "2018-02-05T14:00:11.332",
  "garage": 2,
  "vehicle": {
    "model": "kia",
    "carYear": 2020
  },
  "serviceId": 2,
  "status": "Scheduled",
  "createdAt": "2024-05-25T12:00:00Z"
}
400 Bad Request: Invalid input

___________________________________________________________________________________________________________________________________________________________________

- View All Appointments
HTTP Method: GET
Endpoint: /appointments

Description: View the details of all scheduled appointments.

Request Headers:

Accept: application/json
Responses:

200 OK:
json
[
  {
    "id": 1,
    "appointmentFrom": "2018-02-05T13:00:11.332",
    "appointmentTo": "2018-02-05T14:00:11.332",
    "garage": 2,
    "vehicle": {
      "model": "kia",
      "carYear": 2020
    },
    "serviceId": 2,
    "status": "Scheduled",
    "createdAt": "2024-05-25T12:00:00Z"
  },
  {
    "id": 2,
    "appointmentFrom": "2018-02-06T10:00:11.332",
    "appointmentTo": "2018-02-06T11:00:11.332",
    "garage": 3,
    "vehicle": {
      "model": "skoda",
      "carYear": 2021
    },
    "serviceId": 3,
    "status": "Scheduled",
    "createdAt": "2024-05-25T13:00:00Z"
  }
  ]
  
204 No Content: No appointments found

___________________________________________________________________________________________________________________________________________________________________

- Retrieve a Single Appointment
HTTP Method: GET
Endpoint: /appointments/{id}

Description: Retrieve the details of a specific appointment by its ID.

Request Headers:

Accept: application/json
Path Parameters:

id (integer): ID of the appointment
Responses:

200 OK:
json

{
  "id": 1,
  "appointmentFrom": "2018-02-05T13:00:11.332",
  "appointmentTo": "2018-02-05T14:00:11.332",
  "garage": 2,
  "vehicle": {
    "model": "kia",
    "carYear": 2020
  },
  "serviceId": 2,
  "status": "Scheduled",
  "createdAt": "2024-05-25T12:00:00Z"
}
404 Not Found: Appointment not found

___________________________________________________________________________________________________________________________________________________________________

- Update Appointment Details
HTTP Method: PUT
Endpoint: /appointments/{id}

Description: Update the details of an existing appointment.

Request Headers:

Content-Type: application/json
Path Parameters:

id (integer): ID of the appointment
Request Body:

json

{
  "appointmentFrom": "2018-02-05T15:00:11.332",
  "appointmentTo": "2018-02-05T16:00:11.332",
  "status": "Rescheduled"
}
Responses:

200 OK:
json

{
  "id": 1,
  "appointmentFrom": "2018-02-05T15:00:11.332",
  "appointmentTo": "2018-02-05T16:00:11.332",
  "garage": 2,
  "vehicle": {
    "model": "kia",
    "carYear": 2020
  },
  "serviceId": 2,
  "status": "Rescheduled",
  "createdAt": "2024-05-25T12:00:00Z",
  "updatedAt": "2024-05-25T14:00:00Z"
}

400 Bad Request: Invalid input
404 Not Found: Appointment not found

___________________________________________________________________________________________________________________________________________________________________

- Delete an Appointment
HTTP Method: DELETE
Endpoint: /appointments/{id}

Description: Delete an appointment once it is completed or canceled.

Request Headers:

Accept: application/json
Path Parameters:

id (integer): ID of the appointment
Responses:

204 No Content: Successfully deleted
404 Not Found: Appointment not found
Additional Vehicle Profile Endpoints
Create Vehicle Profile

HTTP Method: POST
Endpoint: /vehicle-profile/create

Request Body:

json
{
  "customer": {
    "name": "marko",
    "surname": "simic"
  },
  "vehicles": [
    {
      "model": "golf",
      "carYear": 2011
    }
  ]
}
Delete Vehicle Profile

HTTP Method: DELETE
Endpoint: /vehicle-profile/delete/{customerId}/{vehicleId}

Path Parameters:

customerId (integer): ID of the customer
vehicleId (integer): ID of the vehicle
Responses:

204 No Content: Successfully deleted
404 Not Found: Vehicle or customer not found
Retrieve Vehicle Information

HTTP Method: GET
Endpoint: /vehicle-information/{vehicleId}

Path Parameters:

vehicleId (integer): ID of the vehicle
Responses:

200 OK:
json

{
  "id": 1,
  "model": "skoda",
  "carYear": 2021,
  "owner": {
    "name": "John",
    "surname": "Doe"
  }
}
404 Not Found: Vehicle not found
