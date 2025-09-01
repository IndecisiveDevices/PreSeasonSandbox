# Student Programming Challenge: Robot Arm & Intake Controls

**Goal:**

Your mission is to program the robot's controller (Gamepad 1) so that different buttons make the robot's arm, wrist, and intake move to specific positions or states. This will allow the robot to pick up game pieces, score them, and get ready for different parts of the game!

**What You Need to Do:**

You'll be working with a special section of the robot's brain (the code!). You need to tell the robot: "IF this button is pressed, THEN do these actions."

**Here are the buttons and what they should make the robot do:**

1.  **Right Bumper Button: "Get Ready to Collect!"**
    *   **Arm:** Move the arm to the **collecting position**.
    *   **Wrist:** Fold the wrist to its **outward position**.
    *   **Intake:** Turn the intake to its **collecting speed**.

2.  **Left Bumper Button: "Clear the Barrier!"**
    *   **Arm:** Move the arm to the position for **clearing the barrier**.
    *   **(Wrist & Intake: Don't change them! They should keep doing whatever they were doing before.)**

3.  **"Y" Button: "Score Sample Low!"**
    *   **Arm:** Move the arm to the position for **scoring in the low area**.
    *   **(Wrist & Intake: Don't change them!)**

4.  **D-Pad Up Button: "Fold Everything In!"** (This is like the robot's starting or safe position)
    *   **Arm:** Move the arm to its **collapsed inside the robot position**.
    *   **Intake:** Turn the intake **off**.
    *   **Wrist:** Fold the wrist to its **inward position**.

5.  **D-Pad Right Button: "Score Specimen High!"**
    *   **Arm:** Move the arm to the position for **scoring the specimen**.
    *   **Wrist:** Fold the wrist to its **inward position**.
    *   **(Intake: Don't change it!)**

6.  **D-Pad Left Button: "Get Ready to Hang!"**
    *   **Arm:** Move the arm to the position for **attaching the hanging hook**.
    *   **Intake:** Turn the intake **off**.
    *   **Wrist:** Fold the wrist to its **inward position**.

7.  **D-Pad Down Button: "Winch Up!"** (Lift the robot after hanging)
    *   **Arm:** Move the arm to the position for **winching the robot**.
    *   **Intake:** Turn the intake **off**.
    *   **Wrist:** Fold the wrist to its **inward position**.

---

**Important Variables You'll Use (Look these up at the top of the code!):**

*   `armPosition`: You'll set this to tell the arm where to go (e.g., `armPosition = NAME_OF_ARM_POSITION;`).
    *   *Look for variables like:* `ARM_COLLAPSED_INTO_ROBOT`, `ARM_COLLECT`, `ARM_CLEAR_BARRIER`, `ARM_SCORE_SPECIMEN`, `ARM_SCORE_SAMPLE_IN_LOW`, `ARM_ATTACH_HANGING_HOOK`, `ARM_WINCH_ROBOT`.
*   `wrist.setPosition()`: You'll use this to control the wrist (e.g., `wrist.setPosition(NAME_OF_WRIST_POSITION);`).
    *   *Look for variables like:* `WRIST_FOLDED_IN`, `WRIST_FOLDED_OUT`.
*   `intake.setPower()`: You'll use this to control the intake (e.g., `intake.setPower(NAME_OF_INTAKE_SPEED);`).
    *   *Look for variables like:* `INTAKE_COLLECT`, `INTAKE_OFF`, `INTAKE_DEPOSIT`.

---

**Hints for Programming:**

*   You'll need to use `if` and `else if` statements.
    *   `if (gamepad1.right_bumper) { ... actions for right bumper ... }`
    *   `else if (gamepad1.left_bumper) { ... actions for left bumper ... }`
    *   ...and so on for each button!
*   Find the "final double" variables at the top of the code. These are your "magic words" for the positions and powers you need to use with `armPosition`, `wrist.setPosition()`, and `intake.setPower()`.
*   Remember that the code inside the curly braces `{ }` after an `if` or `else if` is what happens when that button is pressed.
*   Pay close attention to which actions (arm, wrist, intake) need to change for each button. Sometimes, you only change one or two things!

**Why `else if` is Cool:**

Using `else if` is important because it means if you press the "Right Bumper," the robot will *only* do the "Right Bumper" actions, even if your finger also accidentally bumps the "Left Bumper" at the exact same time. The first "if" that's true gets to do its job, and the rest are skipped for that moment.

---

Good luck, future robot programmers! Think carefully about each button and what it needs to do.
