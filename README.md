# HNG Stage One Task

# Number Facts API

## Overview
The **Number Facts API** takes a number as input and returns:
- **Mathematical Properties** (e.g., Prime, Even/Odd, Perfect)
- **Fun Facts** (e.g., "42 is the answer to life, the universe, and everything!")

## Features
- Check if a number is **Prime, Even/Odd, Perfect**.
- Calculate the sum of the digits of a number.
- Get **fun facts** about the number.
- Supports only **integers**.
- Simple and easy-to-use **Restful API**.

## Installation
1. **Clone the Repository**
   ```sh
   git clone https://github.com/saucekode/hng-stage-one-task.git
   cd hng-stage-one

2. **Install Dependencies**
    ```sh
    mvn install

3. **Run the Application**
    ```sh
    mvn spring-boot:run

## API USAGE

**Endpoint**

    GET /api/classify-number?number=

**Request Example**
  ```sh
  curl --location 'http://localhost:8084/api/classify-number?number=300'
  ```
**Response Example**
  ```sh
    {
      "number":"300",
      "digit_sum":3,
      "fun_fact":"300 is the largest possible score in bowling.",
      "is_prime":false,
      "is_perfect":false,
      "properties":["even"]
    }
  ```

## Technologies Used

 - **JDK 23**
 - **Springboot**
 - **Maven**
 - **Apache Commons**


