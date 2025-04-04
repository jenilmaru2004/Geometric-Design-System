## 🧮 Geometric Design System – Object-Oriented Shape Processing in Java

This project is a multi-phase object-oriented system developed in Java for detecting geometric shape intersections. Across three stages, it evolves from basic shape detection to a robust, design-pattern-driven framework. The system demonstrates efficient use of inheritance, interfaces, unit testing, exception handling, and software design patterns.

---

### 📦 Overview

**Part 1 – Core Shape Intersection Engine:**  
Implemented foundational classes (`Point`, `LineSeg`, `Circle`, `Rectangle`) and defined intersection logic using `CollisionDetector` interface. Ensured accurate shape behavior with clean class separation and minimal code redundancy.

**Part 2 – Testing & Exception Handling:**  
Introduced comprehensive **JUnit** testing for all intersection scenarios to ensure correctness and detect edge case errors. Built a custom exception (`ShapeArgumentException`) to handle invalid shape construction (e.g., zero-radius circles or overlapping line points) using Java's `try-catch` mechanism.

**Part 3 – Advanced Architecture with Design Patterns:**  
Enhanced the system with:
- **Composite Pattern:** Created `CompShape` to group shapes into hierarchical structures.  
- **Iterator Pattern:** Enabled structured access to components inside `CompShape`.  
- **Singleton Pattern:** Added a `Drawing` class ensuring a single source of truth for shape composition.

---

### 🔧 Technologies Used
- Java  
- JUnit  
- OOP Design Patterns (Composite, Iterator, Singleton)

---

### ✅ Features
- Accurate intersection logic for primitive and composite shapes  
- Robust input validation and exception handling  
- Modular, extensible class design  
- Fully tested with detailed JUnit coverage  
