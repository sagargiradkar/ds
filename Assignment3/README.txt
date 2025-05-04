- download the mpj file from sourceforge.
- type in terminal : sudo gedit ~/.bashrc
- Add following in the bash:
	export MPJ_HOME="/home/pvg/mpj-v0_44"
	export PATH=$MPJ_HOME/bin:$PATH
- to compile:
	javac -cp "<path of mpj.jar file>" DistributedSum.java
- to run:
	"<path of mpjrun.sh>" -np 4 DistributedSum

To run your **Java MPI** code (`DistributedSum.java`) on **Ubuntu**, follow these steps:

---

### ✅ Prerequisites:

1. **Java JDK** installed:

   ```bash
   sudo apt update
   sudo apt install default-jdk
   ```

2. **MPJ Express (MPI for Java)**:
   MPJ Express is the most commonly used MPI library for Java.

---

### 🔧 Step-by-Step Setup and Execution:

#### 1. **Download and Set Up MPJ Express:**

```bash
cd ~
wget http://sourceforge.net/projects/mpjexpress/files/latest/download -O mpj.tar.gz
tar -xvzf mpj.tar.gz
mv mpj-v*/ mpj
```

#### 2. **Set Environment Variables (temporary or permanent):**

Add to `~/.bashrc`:

```bash
export MPJ_HOME=~/mpj
export PATH=$PATH:$MPJ_HOME/bin
```

Then run:

```bash
source ~/.bashrc
```

---

### 🧪 3. **Compile Your Code:**

Save your file as `DistributedSum.java`, then compile with:

```bash
javac -cp $MPJ_HOME/lib/mpj.jar DistributedSum.java
```

---

### ▶️ 4. **Run with MPJ Express Runtime:**

```bash
mpjrun.sh -np 4 -cp . DistributedSum
```

* `-np 4`: Run with 4 processes (change as needed)
* `-cp .`: Classpath (current directory)
* `DistributedSum`: Main class name

---

### ✅ Example Output:

```text
Number of Processes Entered: 4

Intermediate Sums:
Process 0: 3
Process 1: 7
Process 2: 11
Process 3: 34

Total Sum: 55
```

---

Would you like a shell script to automate this whole setup and run process?
