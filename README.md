# NYCTrivia

Welcome to the NYCTrivia repository! This project is built with Java and managed using Maven.

## Prerequisites

Before you start working with this project, please ensure you have the following prerequisites installed on your system:

- Java Development Kit (JDK) version 17.0 or higher

## Getting Started

To get started with this project, follow these steps:

1. Clone this repository to your local machine:

    ```sh
    git clone https://github.com/madmoon00/Project-1.git
    ```

2. Navigate to the project directory:

    ```sh
    cd Project-1
    ```

3. Set up the `JAVA_HOME` environment variable to point to your JDK installation directory. For example:

    ```sh
    export JAVA_HOME=/path/to/your/java/sdk/17.0
    ```
    
    Ensure that `JAVA_HOME` is set before running the Maven wrapper script.


4. Execute the Maven wrapper script to build the project:

    ```sh
    ./mvnw clean package
    ```

   This will compile the source code, run tests, and package the application into a JAR file. Note that Maven Wrapper (`mvnw`) is included in the project, so you don't need to have Maven installed globally.

5. Once the build is successful, you can find the generated JAR file in the `target` directory.

## Running the Application

To run the application, navigate to the `target` directory and execute the JAR file:

```sh
cd target
java -jar NYCTrivia-1.0-SNAPSHOT.jar
