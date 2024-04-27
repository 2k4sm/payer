# Payer

## payment service made using springboot and razorpay.

### Setup Guide.

- Clone the repository and move into it.

  ```bash
  git clone git@github.com:2k4sm/payer.git
  cd payer
  ```

- SET ENV Variables by creating a .env file.

  ```bash
  touch .env

  # export the variables.
  export DB_URL=<url>/payer
  export DB_NAME=<db-name>
  export DB_PWD=<user-password>
  export UNAME=<user-name>

  # Store it in .env(needed for compose to run.)
  echo DB_URL=$DB_URL >> .env
  echo DB_NAME=$DB_NAME >> .env
  echo DB_PWD=$DB_PWD >> .env
  echo UNAME=$UNAME >> .env
  ```

- Start postgres instance.

  ```bash
  docker compose up -d
  ```

- Run the server.

  ```java
  export $(cat .env | xargs)
  ./mvnw clean package
  java -jar ./target/payer-0.0.1-SNAPSHOT.jar
  ```

- Stop postgres instance.

  ```bash
  docker compose down
  ```

## Thanks for using Payer.
