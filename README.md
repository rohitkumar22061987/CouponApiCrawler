# CouponApiCrawler

##Set up steps :

1. Install git on your system using command "sudo apt-get install git"

2. Install the egit plugin for eclipse and GitHub Mylyn Connector as given here : http://www.eclipse.org/egit/download/
(Note: After installation of above 2 plugins create a sample project in your workspace and right click on the project
and then click on : Team>>ShareProject, it should show an option for git there. If it doesn't show git there then close
eclipse and restart using the command "./eclipse -clean") .

3. Install the maven plugin from : http://www.eclipse.org/m2e/

4. Unfortunately the Egit-Maven adapter for eclipse is broken. You will have to first checkout the package using git cli 
and then use File -> Import... -> Existing Maven Projects.
http://stackoverflow.com/questions/4869815/importing-a-maven-project-into-eclipse-from-git (2nd answer in this).

* Watch the following video to learn how to work with Egit on eclipse :
https://www.youtube.com/watch?v=r5C6yXNaSGo
