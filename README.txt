# Task Title: " Fullstack Software Engineer Exercise "

**Description**:

       Basically, this small exercise is to pull the data from specific number of user ID followed by their different information from one another 

on a website which is GitHub via API through the link provided. Furthermore, once the data is downloaded, it prompts the users to type

an ID that will demonstrate several basic components from each User ID's entire information such as LongIn name, Link to user's profile

Number of repos, Number of followers, Number of following sequentially. The aim of this exercise is to drag data efficeintly in terms of speed

in order not to make users mundane with its latency. Additionally, it also evavualtes a person's capability how to make trade-off between space ( memory)

and time (speed). Most importantly, it calibrate the code's maintainability, effeciency, scalability, portability, and testability.


**Installation**:

I assume you are a user who does not have JVM (Java Virtual Machine) installed on your machine. Here are the steps provided subsequently.

 Step  1. ""Install Java"":

       Visit the official Oracle website (https://www.oracle.com/java/technologies/javase-downloads.html) or OpenJDK website (https://openjdk.java.net/) to download 
     
       the Java Development Kit (JDK). Download the JDK installer for your operating system (Linux or Windows).Follow the installation instructions provided by the 
     
       JDK installer.
    
    !!!! Window User (10 or 11): JDK version:(JDK version 17) is a good choice. It offers performance improvements and long-term support. 
                                 
    !!!! Linix User: 
         
         Distributions: Most major Linux distributions (Ubuntu, Debian, Fedora, CentOS, etc.) come with pre-installed JDKs or provide easy ways to install them.
  
         JDK version: ( JDK 17) is generally recommended. If you're using a specific Linux distribution, you can check its package manager for available JDK 

         versions and installation instructions.

 Step 2. ""Locate JDK Installation Directory"":

     !!!! Window User: After the installation is complete, locate the JDK installation directory. By default, it is installed in the "C:\Program Files\Java\jdk-

                       17.0.x" folder. Take note of this directory path as you will need it for the next steps.


     !!!! Linux User: Use the ""tar"" command to extract the JDK archive. For example, if you downloaded the file to your "Downloads" directory, you can use the 

                      following command:``` tar -xzf ~/Downloads/jdk-17.0.x_linux-x64_bin.tar.gz -C /opt/ (This will extract the JDK files to a new directory, 

                      usually named "jdk-17.0.x", in the "/opt/" directory. You can choose a different directory if you prefer.)

 Step 3. "" Set Up Environment Variables"":

     !!!! Window User: Open the Start menu and search for "Edit the system environment variables". Click on the corresponding result to open the "System Properties"

     dialog. In the "System Properties" dialog, click on the "Environment Variables" button. This will open a new dialog for editing ""Environment Variables"".

     Under the "System Variables" section in the "Environment Variables" dialog, look for the 'Path' variable and click on it. Then click on the "Edit..." button.
    
     In the "Edit environment variable" dialog, click on the "New" button. Then, In the "New Variable Value" field, enter the path to the JDK's "bin" directory. For

     example, if JDK is installed in "C:\Program Files\Java\jdk-17.0.x", then enter the following: "C:\Program Files\Java\jdk-17.0.x\bin" in " New Variable Value".

     Finally, Click "OK" to save the changes and close all open dialogs.
   

     !!!! Linux User: You'll need to set the "JAVA_HOME" environment variable to point to the """JDK installation directory""" and add the JDK's "bin" directory to 

     your "PATH". Next, Open or create the bash configuration file in your home directory using a text editor. For example:```
   
     nano ~/.bashrc

     Add the following lines to the end of the file, replacing the path with your JDK installation directory:

     ``` export JAVA_HOME=/opt/jdk-17.0.x 

         export PATH=$JAVA_HOME/bin:$PATH

     Save and Close the file

 Step 4: "" Verify the Installation""

    !!!! Window User: Open a new Command Prompt window to verify that Java is properly configured. Type the following command: 

         "java -version" and press "Enter".
   
         You should see a message displaying the Java version installed on your system, indicating that Java is properly set up and recognized by your system.

    !!!! Linux User:  Open a new terminal window to verify that Java is properly configured. Type the following command:
     
         ``` java -version

         You should see a message displaying the Java version installed on your system, indicating that Java is properly set up and recognized by your system.

 Step 5: "" Running the Java Application "":

    !!!! Window User: 

    - Download and Extract the Application : Download the .zip file from the GitHub repository using a web browser such as GitHub 

     Desktop.<<<https://github.com/CHHUON-Menglin123/menglin.git>>>

     Use a program like ""WinRAR"" to extract the contents of the .zip file to a directory of your choice. You can right-click on the .zip file, choose the 

     "Extract" option, and select the directory where you want to extract the files.

    - Navigate to the Extracted Folder: In the Command Prompt, navigate to the extracted folder using the cd command. 
 
     For example:``` cd C:\path\to\extracted\folder   (*** Replace*** `C:\path\to\extracted\folder` with the actual path to the extracted folder on your machine.)

    -Run the Java Application: 
     
     In the Command Prompt, execute the following command to run the Java application:

     java -jar <Your_Jar_File_Name>.jar

     Replace <your_jar_file_name> with the actual name of the .jar file, including the file extension.


   
    !!!! Linux User: 
    
    - Download and Extract the Application: Download the .zip file from the GitHub repository using a web browser. 
     
      Link: <<<https://github.com/CHHUON-Menglin123/menglin.git>>>

      Extract the contents of the .zip file using the unzip command in the terminal:``` unzip <your_zip_file_name>.zip

    - Navigate to the Extracted Folder: Open a terminal and navigate to the extracted folder using the `cd` command. For example:```
   
      cd /path/to/extracted/folder   (*** Replace***/path/to/extracted/folder with the actual path to the extracted folder).

    - Run the Java Application:

      In the terminal, execute the following command to run the Java application:``` java -jar <Your_Jar_File_Name>.jar

      Replace `<your_jar_file_name>` with the actual name of the .jar file, including the file extension.

    

 






