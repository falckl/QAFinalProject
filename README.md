# QA Final Project - Hotel Room Database System

<details>
<summary>Table of contents</summary>
<ol>
  <li>Getting started with this project</li>
  <li>Why are we doing this? </li>
  <li>My expectations of the challenge </li>
  <li>How did the challenge go? </li>
  <li>Possible improvements for future revisions of the project. </li>
  <li>Postman/API output samples </li>
  <li>Evidence of Database persistance</li>
  <li>Evidence of Tests/Coverage Report</li>
</ol>
</details>

<h3><ins>Built using:</ins></h3>
<ul>
  <li>Java</li>
  <li>Eclipse</li>
  <li>Spring Boot</li>
  <li>Junit</li>
  <li>MySQL</li>
</ul>

<h3><ins>Getting started with this project</ins></h3>

Get a local copy of this project up and running by following the steps below:

1. Make sure you have JDK 11 and MySQL installed
2. Open your terminal/console/command line in the folder/location where you want this project.
3. Clone this repo by copying the following code:
   ```sh
   git clone https://github.com/falckl/QAFinalProject.git
   ```
4. Change directory into the project folder
5. On application.properties, make sure this is set to "= dev" for testing purposes, or to "= production" to make data persist in the database
6. On application-production.properties, make sure to replace the username and password with your own for MySQL, and verify that the schema name matches up.
7. Change directory into the target folder (where the .jar file is located)
8. Run the following command to start the project: 
   ```sh
   java -jar hotel-app-0.0.1-SNAPSHOT.jar
   ```


<h3><ins>Why are we doing this?</ins></h3>
To conclude the DFE Software Development Bootcamp with QA, we are tasked with a final project - which is creating a Spring Boot API with full CRUD functionality (methods for creating, reading, updating, and deleting entities). This should have a sensible back-end package structure and adhere to best practices. Reasonable test-coverage for unit and integration testing should be included, as well as relevant documentation such as a risk assessment. I chose to build a Hotel Room Database System, which can store a specified room with the given features. 

<h3><ins>My expectations of the challenge:</ins></h3>
At first I was very unsure about how the challenge would go, as I was not confident with much of what the specification asked of me, in particular with using git, and making sure that my configurations would work. However, knowing that I had resources available to me as well as a supportive cohort and tutors, the challenge felt doable. I was also unsure of how my choice of project would affect my ability to complete it to a high standard. All in all, I knew that there would be blockers along the way, but was confident that I could work through these and leave this project feeling more confident in my abilities.

<h3><ins>How did the challenge go?</ins></h3>
<h4>&nbsp;&nbsp;&nbsp;&nbspWhat went well?</h4>
Writing functional code with CRUD methods to use on my entity class objects (Room). I ran into some minor bugs throughout this process but was able to fix the vast majority of these without further assistance. I also felt that using Jira was a lot less difficult than expected, and after making a couple of mistakes in git I *think* that I learned to use it to push my code up to GitHub correctly.

<h4>&nbsp;&nbsp;&nbsp;&nbspWhat didn't go as planned?</h4>
As expected, I struggled both with using git to connect my project to GitHub, and had some issues with configuring my code to make it work with Postman. This meant that I spent considerably longer refreshing my knowledge of using git, and had to ask for assistance with the configuration issue which ended up being a simple error in my package structure.

<h3><ins>Possible improvements for future revisions of the project</ins></h3>
Due to not being confident with git, I delayed uploading my code until I was mostly happy with it. In future revisions, I would upload code regularly to ensure that I follow continuous integration principles. Additionally, I would extend functionality beyond the Minimum Viable Product (MVP) by including methods which allow an admin (such as a receptionist) to change the availability of rooms for a specified period of time as guests book these. Ss well as this, I would add the ability to search the database by a guest's requirements to see what is available.

<h3><ins>PostMan/API output samples</ins></h3>

The output for each of my CRUD methods:

<h4><ins>CREATE:</ins></h4>

This is the code in the service class, which uses the repository to save a new room as given:

![image](https://user-images.githubusercontent.com/94963094/152322555-907d148a-add6-4445-beb8-aa1bb88de921.png)

This is the code in the controller class, which uses the method of the service class:

![image](https://user-images.githubusercontent.com/94963094/152323006-81c5fa16-bd0d-4532-aab8-b87ba10890f3.png)

In Postman:

![image](https://user-images.githubusercontent.com/94963094/152329158-aad24f70-8f05-4944-a5ae-c27ec84a1d02.png)

...and inputting this into the body in JSON format:

![image](https://user-images.githubusercontent.com/94963094/152329402-098eef8f-8608-49e1-8a4c-567164a1e995.png)

Returns:

![image](https://user-images.githubusercontent.com/94963094/152329478-13048f56-d614-484b-bc6f-a6bfca872815.png)



<h4><ins>READ:</ins></h4>

<h4>Get All:</h4>

This is the code in the service class, which uses the repository method to get all rooms:

![image](https://user-images.githubusercontent.com/94963094/152323442-ed4685c7-4ebe-4fc4-9ef1-9c26495d6439.png)

This is the code in the controller class, which uses the method of the service class:

![image](https://user-images.githubusercontent.com/94963094/152322962-78c71ea5-f1f0-4d3f-9e03-7ace07b67a4d.png)

In postman:

![image](https://user-images.githubusercontent.com/94963094/152327048-18bcaa0e-7b53-4953-9f74-bb692a8ac0c7.png)

This returns the list of all rooms (the rooms below are those that are uploaded upon starting the application, as well as the room added in the CREATE method above):

![image](https://user-images.githubusercontent.com/94963094/152329853-91b94ed3-0a5c-4e46-8745-0774d2025b23.png)



<h4>Get By Id:</h4>

This is the code in the service class, which uses the repository method to get the requested room:

![image](https://user-images.githubusercontent.com/94963094/152323709-cc47f9f9-f57e-4963-8da4-ce12e85ef758.png)

This is the code in the controller class, which uses the method of the service class and gets the id from the path:

![image](https://user-images.githubusercontent.com/94963094/152323754-e280a867-2eeb-41cc-9d85-2eca5d0123f1.png)

In Postman:

![image](https://user-images.githubusercontent.com/94963094/152328962-b04ef142-ccb5-4a5f-a064-3fce627b2504.png)

This returns:

![image](https://user-images.githubusercontent.com/94963094/152329024-699e3018-4f50-4147-8f35-8f8afb4e525f.png)



<h4><ins>UPDATE:</ins></h4>


This is the code in the service class, which uses the repository method to find and replace a room's attributes:

![image](https://user-images.githubusercontent.com/94963094/152323960-32714d68-d366-4c77-8bb3-2c15ec5a0420.png)

This is the code in the controller class, which uses the method of the service class and gets the id from the path:

![image](https://user-images.githubusercontent.com/94963094/152324097-6d9bec92-6f3a-4934-82db-7878632e3d78.png)

In Postman:

![image](https://user-images.githubusercontent.com/94963094/152330043-3467bce4-646f-4a55-bab5-c5a8b5b48322.png)

...and inputting these changes into the body in JSON format:

![image](https://user-images.githubusercontent.com/94963094/152330130-1aef829e-87f7-46b2-8c68-100714d8c047.png)

Returns:

![image](https://user-images.githubusercontent.com/94963094/152330204-7e0252ca-9cf6-411c-8fd5-c53b68351ba3.png)



<h4><ins>DELETE:</ins></h4>

This is the code in the service class, which uses the repository method to delete a room:

![image](https://user-images.githubusercontent.com/94963094/152324051-fec610f1-1c8f-4551-b8a3-c71aa5996fc9.png)

This is the code in the controller class, which uses the method of the service class and gets the id from the path:

![image](https://user-images.githubusercontent.com/94963094/152390865-9f66a046-7e7c-4991-a23b-4d6d372f3431.png)

In Postman:

![image](https://user-images.githubusercontent.com/94963094/152330352-1426fa7f-c643-4651-9aa6-c20d1c102d68.png)

And the getAll method shows that the room with id 4 is deleted:

![image](https://user-images.githubusercontent.com/94963094/152330658-e6f81a54-a0a2-4b6c-a18f-fcc652072831.png)


<h3>Evidence of Database Persistence </h3>

When starting up the app, the associated database shows a table of the rooms as expected:

![image](https://user-images.githubusercontent.com/94963094/152331960-e852e6e3-b6f8-4e30-a7d4-6a28e0e4ff72.png)

When creating a new room, this can also be seen in MySQL as shown below:

![image](https://user-images.githubusercontent.com/94963094/152332080-a9f4993f-cd25-48ba-bcd4-1486c9fdade9.png)

(The id for this room is 5 as the previously created room with id 4 has been deleted, and id's are generated automatically with auto-incrementation)

<h3><ins>Evidence of Tests/Coverage Report</ins></h3>

An overall test coverage report shows a coverage of 95.1% in the main java file:

![image](https://user-images.githubusercontent.com/94963094/152389417-ecc3bc29-49c8-44bc-bc49-ed315293324e.png)

...with 20 out of 20 tests past with Junit:

![image](https://user-images.githubusercontent.com/94963094/152393332-03366865-8a3a-44fd-b0c6-5765872e0338.png)

Service Layer tests include Unit testing and Integration testing, where the unit testing uses Mockito to create a mock environment with mock beans to test the methods. Controller layer testing includes a Web integration test.

<h3><ins>Link to Jira board</ins></h3>

https://lavinias-site.atlassian.net/jira/software/projects/QP/boards/2



