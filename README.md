Java-Based ATM Simulation System
A robust console-based ATM simulator developed in Java. This project demonstrates core foundational software engineering principles, modular programming, and efficient data handling within a command-line interface environment.

Key Features
1- Account Creation: Allows users to register unique account profiles with dynamic initial balance validation.
2- Balance Inquiry: Provides real-time retrieval and formatting of account ledger details.
3- Financial Transactions: Implements secure deposit and withdrawal operations with integrated overdraft protection.
4- Security and Validation: Prevents logical errors such as duplicate account registration, zero/negative transaction inputs, and insufficient fund errors.

Core Concepts and Technologies
Language: Java
Programming Paradigm: Procedural and Modular Programming (structured with dedicated specialized methods)
Data Management: Dynamic data grouping using parallel arrays for real-time tracking.
Input/Output Engineering: Handled through the java.util.Scanner class with formatted terminal outputs.

How It Works
Launch: Run the BasicATMSystem.java file in your terminal.
Menu Interaction: Navigate through a continuous system runtime menu using numeric choices (1-5).
Transaction Execution: Input target user credentials; the system securely maps the name to the data array, executes validation checks, and performs the requested operation.

Exit: Safely terminate the runtime session via option 5.
