db = new Mongo().getDB('reservation');
db.createCollection('reservation');

db.reservation.insert(
    {
        "accommodationId": 1,
        "guestId": 1,
        "checkIn": new ISODate("2023-03-24T10:01:43.161Z"),
        "checkOut": new ISODate("2023-03-24T10:01:43.161Z"),
        "guestNumber": 5,
        "totalPrice": 260.0,
        "status": "RESERVED"
    }
);