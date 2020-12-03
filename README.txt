To Run Assignment 5 Follow the steps:


- Extract the Zip and Paste the Tutorial_1 folder under webapps (C:\apache-tomcat-7.0.34\webapps\Tutorial_1)


- In Your MySQL Workbench import the provided SQL files under sql folder
	- MySQL DB Name: bestdeal
	- MySQL DB Password: IllinoisTech2021@


- Open MongoDB Compass and import the reviews.json file


- In your Jupyter Notebook, Upload file named "BestBuyDealMatches.ipynb" and run that file
	- Please note in order to run this file you will require credentials.txt file, get your Twitter developer credentials and paste it in that file
	- After Successfully running that file, it will generate a file named "DealMatches.txt"


- Now in your Jupyter Notebook, upload a file called "ProductRecommender.ipynb" and Run it
	- Please note in order to run this file you will require a file called "Transactionsdata_train.csv" which is present in the root directory.
	- After running this python file, it will generate two files called "Transactionsdata_test.csv" and "matrixFactorizationBasedRecommendations.csv"


- Now that you have setup with everything it is now time to run the apache server


- Open Terminal: 
	- cd C:\apache-tomcat-7.0.34\webapps\Tutorial_1
	- Type: "env-setup-for-tomcat" and enter
	- cd ..
	- cd ..
	- cd bin
	- Type "startup.bat" and press enter


- There you go! We are all good now. 
