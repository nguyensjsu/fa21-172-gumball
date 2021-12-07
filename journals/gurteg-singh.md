# Individual Journal - Gurteg Singh 

## Journal Entry 1 (Week 1: 11/08 - 11/15)
  -My group and I met together to discuss what we wanted to do for this project and what type of company we wanted to mock or create. We also talked about how we wanted to set up the implementation and architecture and decided to split the work as evenly as we could. I decided to research how to encorporate mysql db into our app and using spring security for login and registration. 
  
  ### Challenges
   - There were no challenges this week, as we mostly just met to get an idea of what to do for our project.
   
## Journal Entry 2 (Week 2: 11/15 - 11/22)
  -The team decided to meet again and share our progress on researching ways to implement the various functions. We decided it was time to start implementing and distributed work to those who felt most comfortable with a topic. I decided to go ahead and try to implement a working user registation and login page and have the data stored in a local mysql container. 
  
  ### Challenges
   - Again, since this was just a meeting, there were no challenges this week, besides trying to find a meeting time that worked for everyone due to the upcoming thanksgiving holidays and midterms happening before break.

Journal Entry 3 (Week 3: 11/22 - 11/29)
  - This week, I was able to get a working registration login form that also sent the data from the form to the mysql database. I decided to make a couple of html pages along the way, like homepage and a welcome page, and added the css and styling to make it look nice. I connected mysql to the app with JDBC and made the user class an entity for the database to recorgnize and immediately make into a table in cmpe172 database. I tried to make a basic login page that would authenticate with the data in mysql, but I was unable to do so. I ended up pushing what I had, and passed the login onto Christian who ended up making it work with spring security. 
  
  ### Challenges
   - The biggest challenge for this week was trying to access the user data from mysql database for authentication for login. I tried to find multiple ways to access the data using things like adding a get method for passwords in the user repoisotry, but nothing worked. The problem was solved after I decided to commit what I had and a teammate picked up the issue and solved it using spring security.   


  ### Commits
   - https://github.com/nguyensjsu/fa21-172-gumball/tree/49674b061933e762e71ed1ce4df5d4095ee9beeb
   - https://github.com/nguyensjsu/fa21-172-gumball/tree/04f518f40c7b0aa329bd6ced3813fd7c8006d8cb
   - https://github.com/nguyensjsu/fa21-172-gumball/tree/2b65712bbeb2175eabd7f292ff466e822376004d

![Cards](https://github.com/nguyensjsu/fa21-172-gumball/blob/main/images/gurteg/Nov28_Cards.png "Cards")
![Basic Login](https://github.com/nguyensjsu/fa21-172-gumball/blob/main/images/gurteg/Nov28_BasicLogin.png "Basic Login")
![HomePage](https://github.com/nguyensjsu/fa21-172-gumball/blob/main/images/gurteg/Nov28_HomePage.png "HomePage")


Journal Entry 4 (Week 4: 11/29 - 12/6)
  - This week, there was a lot to do as we were in the final week before project was due and there was a lot to be done. After making a basic login, I added and edited some code to make the registration pages better and redirect to the proper pages. I tried to initially do a kong setup with the db-less mode but the api kept giving me an "Invalid Authentication Credentials" message. I was unable to solve this and had to move on to other parts of the project as we did not have the time to stay on it longer and passed it to a teammate who took a try. Following this, I decided to try to set up a gradle action workflow, but was unable to get that working due to some errors. After this, I worked on trying to deploy to GKE and getting a working instance with GCP MYSQL. While I was eventually able to get a public instance working with our app running locally, I was unable to deploy our app to GKE because my pod kept crashing and restarting. Eventually, I had to withdraw from this and get the project ready for the demo presentation for the final class session without deploying to GKE.
  
  ### Challenges
   - The biggest challenge for this week practially everything I tried to do, but the biggest issue was deploying to GKE. My pod kept crashing after I ran the deployment.yaml file and I believe this was because of the inability of the pod to connect to the mysql container. I couldn't find out a way to make it work due to the various problems that could cause the error it was throwing and after a long amount of time, I had to scrap the deployment.    

  ### Commits
   - https://github.com/nguyensjsu/fa21-172-gumball/commit/f01383471bcdc101081c53a836b836d1f0d8e519
   - https://github.com/nguyensjsu/fa21-172-gumball/commit/f01383471bcdc101081c53a836b836d1f0d8e519
   - https://github.com/nguyensjsu/fa21-172-gumball/commit/f01383471bcdc101081c53a836b836d1f0d8e519
   - https://github.com/nguyensjsu/fa21-172-gumball/commit/e1716a8ae14358bbc78450c33966d7e8995717ed


![DEC5Cards](https://github.com/nguyensjsu/fa21-172-gumball/blob/main/images/gurteg/Dec5_Cards.png "Cards")
![GCPMYSQL](https://github.com/nguyensjsu/fa21-172-gumball/blob/main/images/gurteg/Dec5_GCPMYSQL.png "GCPMYSQL")
![WORKBENCH-SQL](https://github.com/nguyensjsu/fa21-172-gumball/blob/main/images/gurteg/Dec5_GCPMYSQLWorkBench.png "WORKBENCH")
![DEC6CARDS](https://github.com/nguyensjsu/fa21-172-gumball/blob/main/images/gurteg/Dec6_Cards.png "Dec6Cards")







   
