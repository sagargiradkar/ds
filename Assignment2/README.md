To run your **CORBA-based Calculator Application** on **Ubuntu**, follow these step-by-step instructions:

---

### ✅ Prerequisites

1. **Install Java JDK**

   ```bash
   sudo apt update
   sudo apt install default-jdk
   ```

2. **Check Java version**

   ```bash
   java -version
   ```

3. **Ensure ORB tools (`idlj`, `tnameserv`) are available**

   * These are included in the **JDK** up to Java 8. If you're using Java 11+, you’ll need legacy Java support or a CORBA-compatible ORB like **JacORB**.
   * To use the built-in CORBA tools, **install JDK 8**:

     ```bash
     sudo apt install openjdk-8-jdk
     ```

---

### 🔧 Step-by-Step Execution

#### 1. **Write and Save the IDL**

Save this as `Calculator.idl`:

```idl
module CalculatorApp {
    interface Calculator {
        double add(in double x, in double y);
        double subtract(in double x, in double y);
        double multiply(in double x, in double y);
        double divide(in double x, in double y);
        oneway void shutdown();
    };
};
```

#### 2. **Compile the IDL**

Generate Java stubs:

```bash
idlj -fall Calculator.idl
```

> This generates the `CalculatorApp/` directory with required `.java` files.

#### 3. **Compile the Java Code**

Make sure all your `.java` files (server, client, impl) are in place, then compile:

```bash
javac CalculatorApp/*.java
javac Assignment2/*.java
```

#### 4. **Start CORBA Naming Service**

```bash
tnameserv -ORBInitialPort 1050
```

> Keep this terminal **open and running**.

#### 5. **Run the Server**

Open a new terminal window:

```bash
java Assignment2.Server -ORBInitialPort 1050 -ORBInitialHost localhost
```

#### 6. **Run the Client**

In a third terminal window:

```bash
java Assignment2.Client -ORBInitialPort 1050 -ORBInitialHost localhost
```

---

### ✅ Output Example

```text
Welcome to addition system:
1. Add
2. Subtract
3. Multiply
4. Divide
Enter your choice: 1
Enter first no: 12
Enter second no: 3
Ans = 12.0 + 3.0 = 15.0
```

---

### 🔁 Quick Summary

| Step         | Command (Ubuntu)                                                         |
| ------------ | ------------------------------------------------------------------------ |
| Compile IDL  | `idlj -fall Calculator.idl`                                              |
| Compile Code | `javac CalculatorApp/*.java Assignment2/*.java`                          |
| Start ORB    | `tnameserv -ORBInitialPort 1050`                                         |
| Run Server   | `java Assignment2.Server -ORBInitialPort 1050 -ORBInitialHost localhost` |
| Run Client   | `java Assignment2.Client -ORBInitialPort 1050 -ORBInitialHost localhost` |

---

Would you like a **shell script to automate this process** on Ubuntu?
