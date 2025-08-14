# 🤖 Lesson 3: Turning and Strafing

Welcome to Lesson 3! In this activity, you'll learn how to make your robot **turn** and **strafe**—two essential movements for navigating the field like a pro. Lesson 3 of the VRS simulator challenges students to maneuver around obstacles and align with targets using these advanced techniques.

This lesson introduces:

1. How to rotate your robot using motor power.
2. How to strafe (slide sideways) using mecanum wheels.
3. How to use **encoders** for precise turning and movement.

---

## 🎯 What You’ll Learn

- How to make your robot **turn** using motor direction and power.
- How to make your robot **strafe** using mecanum wheel logic.
- How to use **encoders** to control turning distance.
- Why strafing is useful in tight spaces and autonomous routines.

---

## 🔄 Start Here: Turning with Encoders

Begin with the **encoder-based turning** code. This builds on what you learned in Lesson 2 and introduces rotational movement using motor encoders.

### How it works

- You tell the robot to rotate by a certain number of encoder ticks.
- It turns left or right, then stops when the target is reached.

### Instructions

1. Go to the [VRS simulator](https://www.vrobotsim.online/levelselector.html) and open **Level 3**.
2. Click **On Bot Java** to open the code editor.
3. Copy and paste the [`Lesson3_starter_code.java`](Lesson3_starter_code.java) into the coding window.
4. Follow the comments in the starter code to understand how turning works.
5. Click **Initialize Program**, then **Run Program** to test your robot.

If you get stuck or want to see a working example, check out [`Lesson3_encoder_based_the_solution.java`](Lesson3_encoder_based_the_solution.java).

---

## 🧭 Next Level: Strafing with Mecanum Wheels

Once you're comfortable with turning, try **strafing**—a unique movement that lets your robot slide sideways!

### What is strafing?

Strafing is possible thanks to **mecanum wheels**, which can move in multiple directions depending on how the motors are powered.

🧠 Example: “Slide right to line up with a target.”

### How it works

- You power the motors in a special pattern.
- The robot moves sideways without rotating.

### Instructions

1. Go to the [VRS simulator](https://www.vrobotsim.online/levelselector.html) and open **Level 3**.
2. Copy and paste the [`Lesson3_strafe_the_solution.java`](Lesson3_strafe_the_solution.java) into the coding window.
3. Read the comments to understand how motor power affects strafing.
4. Test your robot and tweak the code to improve accuracy.

---

## 🆚 Turning vs. Strafing

| Feature       | Turning                         | Strafing                          |
|--------------|----------------------------------|-----------------------------------|
| Movement      | Rotates the robot               | Slides sideways                   |
| Uses encoders | ✅ Yes                          | ⚠️ Not always                     |
| Best for...   | Changing direction              | Dodging obstacles or lining up    |

---

## 🚀 How to Run Your Code

1. Open the VRS simulator and go to Level 3.
2. Click **On Bot Java** to open the code editor.
3. Start with the turning starter file.
4. Test your robot and see how it rotates!
5. Then try the strafing code and compare the results.

---

## 🖼️ What It Looks Like  

![Robot Simulator Screenshot](https://github.com/IndecisiveDevices/PreSeasonSandbox/raw/main/TeamCode/src/main/java/org/firstinspires/ftc/teamcode/SimulatorLessons/VRS_Screenshot.png)

---

## 🔗 More Lessons

- [Lesson 1: Getting Started](../Lesson1)
- [Lesson 2: Movement with Time and Encoders](../Lesson2)

---

Keep experimenting and have fun—you're mastering advanced robot movement! 🛠️🧠
