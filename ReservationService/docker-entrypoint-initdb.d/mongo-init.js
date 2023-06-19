db = new Mongo().getDB('reservation');
db.createCollection('reservation');

db.reservation.insert(
    {
        "accommodationId": null,
        "guestId": null,
        "checkIn": new ISODate("2023-03-24T10:01:43.161Z"),
        "checkOut": new ISODate("2023-04-14T10:01:43.161Z"),
        "guestNumber": 5,
        "totalPrice": 260.0,
        "status": "RESERVED"
    }
);

db.reservation.insert(
    {
            "accommodationId": null,
            "guestId": null,
            "checkIn": new ISODate("2023-04-24T10:01:43.161Z"),
            "checkOut": new ISODate("2023-05-24T10:01:43.161Z"),
            "guestNumber": 8,
            "totalPrice": 280.0,
            "status": "RESERVED"
    }
);

db.reservation.insert(
    {
        "accommodationId": null,
        "guestId": null,
        "checkIn": new ISODate("2023-05-28T10:01:43.161Z"),
        "checkOut": new ISODate("2023-06-10T10:01:43.161Z"),
        "guestNumber": 8,
        "totalPrice": 280.0,
        "status": "RESERVED"
    }
);

db.reservation.insert(
    {
        "accommodationId": null,
        "guestId": null,
        "checkIn": new ISODate("2023-06-24T10:01:43.161Z"),
        "checkOut": new ISODate("2023-06-28T10:01:43.161Z"),
        "guestNumber": 8,
        "totalPrice": 280.0,
        "status": "RESERVED"
    }
);