# RecipEz CSC207 Project
RecipEz as the name suggests, is an easy, all-in-one recipe generator that lets you type in ingredients one by one and then suggests recipes based on the entered ingredients.


## Specifications 
- Make sure you are using Java 11. The SDK in the project structure must use 'coretto-11' in order to run the project. 
- JUnit 4.13.1 is required to run the unit tests 

## How to Run The Program
``` shell
git clone https://github.com/CSC207-2022F-UofT/course-project-recipez.git
cd course-project-recipez
```
Then to start the RecipEz program, go to the "Main.java" file and click run.

## Design Patterns Used
### 1. Dependency Injection:
- We have used the dependency injection in all of our use cases. Rather than creating the objects inside the classes,we pass them in as instances. One such example from our code is
![Alt text](/Users/shaffaanbinaamir/IdeaProjects/courase-project-recipez/images/Imagess/Dependency Injection.png "Title")
- This has allowed us to create tests easily, as the dependencies can now be mocked.
- Helping this has also allowed us to adhere to clean architecture 

## 6. User Stories With Code
- [Register Use Case] ()
- [Enter ingredient Use case] ()
- [Search Use Case] ()

## About Us

We are the group that planned, developed, and tested the RecipEz project. 

Group members:
- [Eric Karpovits](https://github.com/EricKarpovits)
- [Shaffaan Bin Aamir](https://github.com/Shaffaan)
- [Vishwanath Wimalasena](https://github.com/fishyvishy)
- [Ricky Chen](https://github.com/rickychen175)
- [Seongmin Chang](https://github.com/takeachangs)
- [Jiahao Victor Li](https://github.com/RedFoxity)
- [Samira Dang](https://github.com/fonuxxine)
- [Jacky Yang](https://github.com/Zhuofan-Y)


## Github Features Used
- Issues: In milestone 1, we used the issues page to define the features in our application. As we moved through our implementation, we closed off issues, allowing us to gauge our progress and measure how our project idea changed from its initial conception. 
- Pull Requests: Once a group member pushed substantial contributions to the remote repository, they also opened a pull request in github to allow others to view the code changes. This feature was immensely helpful in managing changes to the main branch, as merging was only permitted with the approval of 3 members. Thus, all changes could be properly assessed by several reviewers to prevent erroneous merging. 
- Merge Conflict Editor: In cases where merge conflicts arose, we made use of the github editor to view the conflicts side-by-side and determine the most prudent course of action. In particular, the gradle daemon presented some merge conflicts when the GSON library was loaded into the recipe-builder branch. We made heavy use of the merge conflict editor to resolve this issue.
- Github CLI: To push, pull, fetch, and perform other git operations, we used the Github CLI. When an erroneuous action was attempted, the error messages provided insightful information, which often times, guided us directly towards a solution.
- .gitignore: Adding our storage file to the gitignore allowed us to avoid a merge conflicts due to differing storage files. 
