# 🧠 Lesson 1: Getting Started with Robot Programming

Welcome to your first robotics coding lesson! In Lesson 1, you’ll learn how to write simple code to make your robot move forward and backward. This is the foundation for everything else you'll do in robotics!

---

## 🎯 What You'll Learn

- How to write basic robot code using Java.
- How to make your robot drive forward.
- How to make your robot turn (bonus points).
- How to test your code in the VRS simulator.

---

## 🛠️ What’s in This Folder?

| File Name                  | What It Does                          |
|---------------------------|----------------------------------------|
| `Lesson1_starter_code.java` | A blank-ish file to help you get started. |
| `Lesson1_the_solution.java` | A finished version that shows how it works. |

---

## 🚗 What Does the Robot Do?

In this lesson, your robot will:

1. Drive forward for a few seconds.
2. Stop at the flag.
3. BONUS: make your robot spin in a circle.

It’s like teaching your robot to take a few steps forward!

---

## 🚀 How to Run Your Code

1. Go to the [VRS simulator](https://www.vrobotsim.online/level1.html) and open **Level 1**.
2. Click **On Bot Java** to open the code editor. (see top left arrow in image below)
3. Copy and paste the [Lesson1_starter_code.java](./Lesson1_starter_code.java) by deleting the code in the VRS coding window first, then pasting the starter code. (see image below).
4. Follow the starter code from top to bottom and read the comments that explain the different parts of the code. It will also guide you to make changes or add code to fix the robot.
5. Click the **Initialize Program** button, which will turn into a **Run Program** button. Then click the **Run Program** button to start the robot.

If you get stuck or want to see a working example, you can reference the [Lesson2_starter_the_solution](./Lesson1_the_solution.java) file.

## Common Mistakes

- Spelling and typos. Even the smallest typo can cause a program not to compile or run.
- Using the wrong case (upper/lower). For example, `DcMotor.SetPower(2);` will not work because it should be `DcMotor.setPower(2);`. Did you notice the uppercase "S" vs lowercase "s" difference?
- statements must end with a semicolon. Example: `DcMotor.setPower(2);` will compile, but `DcMotor.setPower(2)` will not.
- missing one or more ending brackets. In Java, as well as some other popular languages, code is grouped in open an close brackets. That means, for ever open bracket `{`, you must have a corresponding end bracket `}`. Examples:

``` java
// This is fine becase we have 2 open brackets and 2 closing brackes
if ( DoYouLikeIceCream === true) {
    if ( DoYouLikeOreos == true) {
        return 'Good, me too';
    }
}

// This will not compile because at least one closing bracket is missing. 
if ( DoYouLikeIceCream === true) {
    if ( DoYouLikeOreos == false) {
        return 'That is ok. Nobody is perfect';
}

```

---

## 🖼️ What It Looks Like

![Robot Simulator Screenshot](../VRS_Screenshot.png)

---

## 🔗 What’s Next?

Once you finish Lesson 1, you’re ready for:

- [Lesson 2: Movement with Time and Encoders](../Lesson2)

---

You’re officially a robot programmer now! Keep going—you’ve got this! 💪🤖
