# Healthhub
This is the final project for CSP-584 (Enterprise Web Applications) for Fall 2020 term at Illinois Tech

------

### Things to do before you push to the ```master``` branch

* Make sure you have the latest version of the project on your local machine
* So it is always recommended that you pull the latest copy from the remote ```master``` before you start working on any of the feature on your local machine.
  * This can be done by using following command: ```git pull``` in your git bash.
* Now that you have downloaded the latest version, your local master would be pointing to the latest head of the remote master.
* Start working on a feature.
* Once you are done, and feel like the feature works perfectly, test it thoughly and make a commit. Follow these steps:
  * ```git add .```
  * ```git commit -m "your message"``` (The message should describe what feature will it bring in, if applied this commit)
  * ```git push origin master```
* If in case you mess up or something breaks before you make a commit and you want to revert back again to the latest head of remote master. Follow these steps:
  * ```git stash``` This is delete all the uncommited changes you've made to your local master
  * ```git pull``` This will again fetch the latest working version to your local machine.
