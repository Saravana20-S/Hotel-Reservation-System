# Hotel Reservation System

A Java-based **Hotel Reservation System** that helps customers find the most suitable hotel based on reservation dates, customer type, hotel rates, and hotel ratings. The application is developed incrementally using **Object-Oriented Programming**, **Java 8 Features**, **JUnit 5**, and **Maven**, following clean coding practices and Git workflow.

## Features

* Add hotels to the reservation system
* Store weekday and weekend rates for Regular customers
* Calculate the cheapest hotel for a given date range
* Handle weekday and weekend pricing
* Store hotel ratings
* Select the highest-rated hotel when multiple hotels have the same total cost
* Find the highest-rated hotel for a given date range
* Support Reward customer pricing as part of the loyalty program
* Calculate the cheapest best-rated hotel for Reward customers
* Calculate the cheapest best-rated hotel for Regular customers
* Validate customer type and reservation date inputs
* Custom exception handling for invalid inputs
* Java 8 Stream API implementation for hotel selection
* Java 8 Date and Time API (`LocalDate`, `DayOfWeek`)
* JUnit 5 test cases for all implemented use cases

## Technologies Used

* Java 8+
* Maven
* JUnit 5
* Java Stream API
* Java Time API
* Regular Expressions (Regex)
* Exception Handling
* IntelliJ IDEA

## Project Structure

```text
HotelReservationSystem
│── pom.xml
│── README.md
│
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── bridgelabz
    │               └── hrs
    │                   ├── HotelReservation.java
    │                   ├── model
    │                   ├── service
    │                   ├── exception
    │                   └── util
    │
    └── test
        └── java
            └── com
                └── bridgelabz
                    └── hrs
```

## Hotel Details

| Hotel      | Rating | Regular Weekday | Regular Weekend | Reward Weekday | Reward Weekend |
| ---------- | :----: | --------------: | --------------: | -------------: | -------------: |
| Lakewood   |    3   |            $110 |             $90 |            $80 |            $80 |
| Bridgewood |    4   |            $150 |             $50 |           $110 |            $50 |
| Ridgewood  |    5   |            $220 |            $150 |           $100 |            $40 |

## Implemented Use Cases

* **UC1** – Add Hotel to the Hotel Reservation System
* **UC2** – Find the cheapest hotel for a given date range
* **UC3** – Add weekday and weekend rates for each hotel
* **UC4** – Find the cheapest hotel considering weekday and weekend rates
* **UC5** – Add ratings for each hotel
* **UC6** – Find the cheapest best-rated hotel for a given date range
* **UC7** – Find the highest-rated hotel for a given date range
* **UC8** – Add special rates for Reward customers
* **UC10** – Find the cheapest best-rated hotel for Reward customers with input validation and exception handling
* **UC11** – Implement hotel selection using Java Streams, Regex validation, Java 8 Date API, and custom exceptions
* **UC12** – Find the cheapest best-rated hotel for Regular customers using Java Streams

## Sample Input

```text
Customer Type : REGULAR
Dates : 11Sep2020, 12Sep2020
```

## Sample Output

```text
Bridgewood, Rating: 4 and Total Rates: $200
```

## Testing

JUnit 5 test cases are included to verify:

* Hotel creation
* Hotel rate storage
* Hotel rating storage
* Cheapest hotel selection
* Best-rated hotel selection
* Reward customer pricing
* Regular customer pricing
* Java Stream-based hotel selection
* Customer type validation
* Date range validation
* Exception handling

## How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Import the project as a Maven project.
4. Build the project using Maven.
5. Run the `HotelReservation` class.
6. Execute the JUnit test cases from the `src/test/java` directory.

## Git Workflow

* `main` – Stable production branch
* `dev` – Development branch
* `feature/UC*-*` – Individual feature branches for each use case

Example:

```text
main
│
└── dev
    ├── feature/UC1-add-hotel
    ├── feature/UC2-find-cheapest-hotel
    ├── feature/UC3-add-weekday-weekend-rates
    ├── feature/UC4-find-cheapest-hotel-weekday-weekend
    ├── feature/UC5-add-hotel-ratings
    ├── feature/UC6-find-cheapest-best-rated-hotel
    ├── feature/UC7-find-best-rated-hotel
    ├── feature/UC8-add-reward-customer-rates
    ├── feature/UC10-reward-customer-hotel-selection
    ├── feature/UC11-java-streams-validation
    └── feature/UC12-regular-customer-java-streams
```
