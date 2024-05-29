# tManager

## Table of Contents
- [Project Description](#project-description)
- [Functionalities](#functionalities)
- [Instructions for Use](#instructions-for-use)
  - [Prerequisites](#prerequisites)
  - [Running the Application](#running-the-application)

## Project Description
`tManager` is a JavaFX-based desktop application designed for managing tasks and team members. The application allows users to add, view, and manage tasks and members efficiently, providing a user-friendly interface for task assignment and status tracking.

## Functionalities
- **Member Management**: Add new members with their names and surnames.
- **Task Management**: Add new tasks.
- **Status Updates**: Update task status to "To Do", "In Progress", or "Done".
- **Executor Assignment**: Assign tasks to team members.
- **Elapsed Time Tracking**: Real-time display of elapsed time for tasks in progress.

## Instructions for Use

### Prerequisites
- **Java Development Kit (JDK)**: Ensure you have JDK 8 or higher installed.
- **JavaFX SDK**: Download and set up JavaFX SDK if it is not included in your JDK distribution.

### Running the Application
1. **Clone the Repository**:
    git clone <mrzemieniuk/tmanager>
    cd tmanager

2. **Download JavaFX SDK**:
    - Download the JavaFX SDK from the official [JavaFX website](https://openjfx.io/).
    - Extract the downloaded SDK to a directory on your system.

3. **Set Up Environment Variables**:
    - Set the `PATH_TO_FX` environment variable to point to the `lib` directory of the extracted JavaFX SDK.

4. **Compile and Run**:
    - Open a terminal and navigate to the project directory.
    - Compile the project using the following command:
      javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml -d bin src/**/*.java
    - Run the application using the following command:
      java --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml -cp bin Main

### Notes
- Make sure to refresh the environment variables or restart the terminal after setting the `PATH_TO_FX` variable.
- Ensure that your IDE (e.g., IntelliJ IDEA, Eclipse) is configured to use the JavaFX SDK if you are running the application from within an IDE.
- JavaFX SDK is available also in lib directory of this repository.
- This repository is ready to run in Visual Studio Code. If you use this application, then the only thing you need to do is installing JDK and later compile and run it in VSC.

By following these instructions, you should be able to successfully run the `tManager` application and start managing tasks and team members effectively.
