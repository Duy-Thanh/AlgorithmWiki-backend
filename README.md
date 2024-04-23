# AlgorithmWiki-backend

This repository contains backend written in Java with SpringBoot framework. You can check entirely source code here in `backend` directory.

To view Sequence Diagram (in `.png` file or `.uml` file), please check out to `uml` directory

UML Sequence Diagram image file compiled from `uml` by PlantUML

# How to run
Here is the guide to run:

- On Windows:
1) Download Git for Windows. You can download [here](https://gitforwindows.org/)
   **NOTE: When installing, make sure you have checked 'Add to PATH' unless you can't use `git` command directly on command prompt**
2) You can check Git installation by open command prompt, then type `git -v` or `git --version`. If the result like:
`git version 2.44.0.windows.1`

then your Git installation working. If not, re-install Git and read the **NOTE** above!

3) Open Command Prompt. To open command prompt, press combine `Windows + R` (Windows is Windows logo key on your keyboard, that key should be exist on your keyboard), then type `cmd` and press Enter. Then, type the following command:
`git clone https://github.com/Duy-Thanh/AlgorithmWiki-backend "%USERPROFILE%\AlgorithmWiki-backend"`

4) After that, `cd` to the repository directory:
`cd /d "%USERPROFILE%\AlgorithmWiki-backend"`

If you see error like: `The system cannot find the path specified.`, please clone the repository again. Make sure that you `cd` to the corrected directory!

5) Now you're on top of the repository (root directory of repository), you must `cd` to actually backend source code directory by using:
`cd backend`

6) Now you can run by using:
`gradlew.bat bootRun`

And if you prefer using PowerShell, then you can type the following command to start:

`Set-ExecutionPolicy -ExecutionPolicy Unrestricted -Scope CurrentUser -Confirm:$false -Force; ./gradlew bootRun`

And that's it! You're running this application. To check if the application started and running normally, please navigate to `localhost:8080` or `127.0.0.1:8080` on your browser. If any JSON messages show, that's mean application running properly. If you can't navigate or your browser cannot reached, that's mean application not running properly and you should check command prompt or powershell window to find any exceptions.

- On Linux (Debian/Ubuntu):
1) Open Terminal by press combined key `Ctrl + Alt + T`. Then run this command:
`sudo apt-get update && sudo apt install build-essential -y`

2) After that, install OpenJDK (I recommended installing OpenJDK 21):
`sudo apt-get install openjdk-21`

3) Now, you can continue to clone repository:
`git clone https://github.com/Duy-Thanh/AlgorithmWiki-backend ~/AlgorithmWiki-backend`

4) After that, `cd` to the repository
`cd ~/AlgorithmWiki-backend`

5) Now you're on top of the repository (root directory of repository), you must `cd` to actually backend source code directory by using:
`cd backend`

6) Now you can run the application by using:
`chmod a+x gradlew && ./gradlew bootRun`

And that's it! You're running this application. To check if the application started and running normally, please navigate to `localhost:8080` or `127.0.0.1:8080` on your browser. If any JSON messages show, that's mean application running properly. If you can't navigate or your browser cannot reached, that's mean application not running properly and you should check command prompt or powershell window to find any exceptions.
