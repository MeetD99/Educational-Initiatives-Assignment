# Design Patterns & Satellite State Management

This repository contains **two exercises** that demonstrate software engineering principles and practices:

1. **Exercise 1** – A Java project showcasing 6 Design Patterns (2 each from Creational, Behavioral, and Structural).
2. **Exercise 2** – A TypeScript console application that allows users to interactively manage the state of a satellite.

---

## 📂 Project Structure

```
.
├── Exercise1/     # Java Design Patterns demos
│   ├── CreationalPatterns/
│   ├── BehaviouralPatterns/
│   ├── StructuralPatterns/
│
└── Exercise2/     # TypeScript Satellite State Management App
```

---

## 🚀 Exercise 1 – Design Patterns in Java

This exercise demonstrates **6 classic design patterns**:

* **Creational Patterns** (2)
* **Behavioral Patterns** (2)
* **Structural Patterns** (2)

Each pattern has a demo class in the format:

```
<DesignPatternName>Demo.java
```

For example:

* `ObserverDemo.java`
* `AbstractFactoryDemo.java`

### ▶️ Running the Demos

1. Navigate to the root folder (i.e, `.`).
2. Compile all the files:

```bash
javac Exercise1/<DesignPatterns>/<DesignPatternName>/*.java
```

3. Run the demo:

```bash
java Exercise1.<DesignPatterns>.<DesignPatternNameDemo>
```

#### Example: Running the Observer Pattern demo

```bash
javac Exercise1/CreationalPatterns/Builder/*.java
java Exercise1.CreationalPatterns.Builder.BuilderDemo
```

---

## 🛰️ Exercise 2 – Satellite State Management in TypeScript

This exercise is a **console-based TypeScript application** that allows the user to enter commands to control and manage the state of a satellite.

* Users can input commands via the console.
* The app ensures proper state management of the satellite.

### ▶️ Running the App

1. Navigate to the `Exercise2` folder:

```bash
cd Exercise2
```

2. Install dependencies:

```bash
npm i
```

3. Start the application:

```bash
npm start
```

---

## ⚡ Tech Stack

* **Exercise 1:** Java (OOP, Design Patterns)
* **Exercise 2:** TypeScript, Node.js

---

## 📖 Learning Outcomes

* Understanding and applying **Creational, Behavioral, and Structural design patterns** in Java.
* Building a **stateful console-based application** in TypeScript.
* Following **SOLID principles, design patterns, and best practices** for code quality and maintainability.
