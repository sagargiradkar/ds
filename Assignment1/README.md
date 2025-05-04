To **run your RMI program on Ubuntu**, follow these steps precisely:

---

## **Step-by-Step Guide to Run Java RMI Program on Ubuntu**

### **1. Open Terminal and Create Your Java Files**

Save the following four files in a directory (e.g., `~/RMIProject`):

* `Circle.java`
* `CircleImpl.java`
* `Server.java`
* `Client.java`

Use a text editor like `gedit`, `nano`, or `VS Code`.

---

### **2. Compile All Files**

In the terminal, navigate to your folder:

```bash
cd ~/RMIProject
javac *.java
```

This compiles all Java files.

---

### **3. Start the RMI Registry**

Run this in **a new terminal window or tab**:

```bash
cd ~/RMIProject
rmiregistry 4000
```

> Important: Keep this terminal open. The RMI registry must be running for the server to bind the object.

---

### **4. Run the Server**

In the original terminal:

```bash
java Server
```

**Expected Output:**

```
Server started...
```

---

### **5. Run the Client**

In a **third terminal window or tab**:

```bash
cd ~/RMIProject
java Client
```

**Input Example:**

```
Enter the radius of the circle: 7
```

**Expected Output:**

```
The Area of the circle is 154.0
The Perimeter of the circle is 44.0
```

---

### **Optional Troubleshooting Tips**

* If you get `Connection refused`, check if the `rmiregistry` is running and on the right port.
* If using a firewall or external IP, allow port `4000` and update `java.rmi.server.hostname`.

---

Would you like a **script file to automate** all these steps or a **multi-threaded version** of the client?
