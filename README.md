# Retail Store Discounts

## Overview
• Low Level Design
• Software Development Practices
• Hands-on Programming

This project calculates the net payable amount for a bill based on various discount criteria.

1. If the user is an employee of the store, he gets a 30% discount
2. If the user is an affiliate of the store, he gets a 10% discount
3. If the user has been a customer for over 2 years, he gets a 5% discount.
4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45
   as a discount).
5. The percentage based discounts do not apply on groceries.
6. A user can get only one of the percentage based discounts on a bill.

## Setup
1. Clone the repository.
2. Set up the SQL Server database.
3. Configure the `application.properties` with your DB credentials.
4. Run the application using `mvn spring-boot:run`.

## Running Tests
Run the tests using `mvn test`.

## Code Coverage
Generate code coverage reports using `mvn jacoco:report`.
