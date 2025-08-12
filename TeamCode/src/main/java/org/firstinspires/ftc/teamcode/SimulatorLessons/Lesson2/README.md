# 🤖 Lesson 2: Making Your Robot Move

Welcome to Lesson 2! In this activity, you'll learn two cool ways to make your robot drive on its own—like a self-driving car! Lesson 2 of the VRS simulator has students navigate an "L" shaped course to reach the flag. This means students will need to make the robot

1. Move foward until they reach the end of the first leg.
2. Turn to face the flag
3. Move fowrd until they reach the flag.

Furthermore, this lesson provides two approaches to meet the same goal...with one that introduces the concept of **encoders**.

---

## 🎯 What You'll Learn

- How to make your robot move using **time** (like a stopwatch).
- How to make your robot move using **encoders** (like a built-in measuring tool).
- Which method works better and why.
- What a "variable" is and why you might want to use them.

---

## 🛣️ Start Here: Time-Based Movement

Begin with the **time-based** code. This is the easiest way to get your robot moving and is a continuation of what you've already learned from VRS Lesson 1.

### How it works

- You tell the robot to drive for a certain number of seconds.
- It moves forward, then stops when the time is up.
- Tell your robot to turn towards the flag for a number of milliseconds
- It turns then stops when the time is up.
- Tell the robot to drive for a certain number of seconds
- It moves forward, then stops when the time is up.

### Instructions

1. Go to the [VRS simulator](https://www.vrobotsim.online/levelselector.html) and open **Level 2**.
2. Click **On Bot Java** to open the code editor. (see top left arrow in image below)
3. Copy and paste the [Lesson2_time_based_starter.java](./Lesson2_time_based_starter.java) by deleting the code in the VRS coding window first, then pasting the starter code. (see image below).
4. Follow the starter code from top to bottom and read the comments that explain the different parts of the code. It will also guide you to make changes or add code to fix the robot.
5. Click the **Initialize Program** button, which will turn into a **Run Program** button. Then click the **Run Program** button to start the robot.

If you get stuck or want to see a working example, you can reference the [Lesson2_time_based_the_solution.java](./Lesson2_time_based_the_solution.java) file.

---

## 📏 Next Level: Encoder-Based Movement

Once you're comfortable with time-based movement, try using **encoders**!

### What are encoders?

Encoders are like rulers inside your robot’s motors. They measure how far the wheels turn so your robot can move the exact distance you want.

📐 Example: “Drive forward exactly 24 inches.”

### How it works

- You tell the robot to drive for a certain **distance**.
- It moves forward, then stops when the **distance has been reached**.
- Tell your robot to turn towards the flag for a number of milliseconds
- It turns then stops when the time is up.
- Tell the robot to drive for a certain distance
- It moves forward, then stops when the distance has been reached.

### Instructions

1. Go to the [VRS simulator](https://www.vrobotsim.online/levelselector.html) and open **Level 2**.
2. Click **On Bot Java** to open the code editor. (see top left arrow in image below)
3. Copy and paste the [Lesson2_encoder_based_starter.java](./Lesson2_encoder_based_starter.java) by deleting the code in the VRS coding window first, then pasting the starter code. (see image below).
4. Follow the starter code from top to bottom and read the comments that explain the different parts of the code. It will also guide you to make changes or add code to fix the robot.
5. Click the **Initialize Program** button, which will turn into a **Run Program** button. Then click the **Run Program** button to start the robot.

If you get stuck or want to see a working example, you can reference the [Lesson2_encoder_based_the_solution.java](./Lesson2_encoder_based_the_solution.java) file.

---

## 🆚 Time vs. Encoders

| Feature         | Time-Based Movement        | Encoder-Based Movement       |
|-----------------|----------------------------|------------------------------|
| How it works    | Uses a timer               | Uses motor measurements      |
| Easy to use?    | ✅ Yes                     | ⚠️ A little harder           |
| Accurate?       | ❌ Not always              | ✅ Very accurate             |
| Best for...     | Quick tests                | Real competitions            |

---

## 🚀 How to Run Your Code

1. Open the VRS simulator and go to Level 2.
2. Click **On Bot Java** to open the code editor.
3. Start with the time-based starter file.
4. Test your robot and see how it moves!
5. Then try the encoder-based code and compare the results.

---

## 🖼️ What It Looks Like

![Robot Simulator Screenshot](../VRS_Screenshot.png)

---

## 🔗 More Lessons

- [Lesson 1: Getting Started](../Lesson1)
- [Lesson 3: Advanced Movement](../SimulatorLesson3.java)

---

Have fun programming your robot! You’re one step closer to becoming a robotics pro! 🧠💡
