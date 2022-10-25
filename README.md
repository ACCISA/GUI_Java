# GUI_Java


A GUI Login Interface to practice GUI, data logging and testing new stuff.


![image](https://user-images.githubusercontent.com/39713625/197648440-110f3c78-e366-4d8b-b33e-1a2b8989a5ba.png)

![image](https://user-images.githubusercontent.com/39713625/197648463-0ea89fde-51bf-48bf-ac35-b08b30a9036e.png)




Made by me

# Documentation

This section contains documentation of the methods used in the func.java. In this program, when back-end related methods are used they are called from a file called func.java. This will soon be changed to a folder with back-end methods.

=============================================================================================================================

setCreds(par1, par2)

Sets the login credentions to the specified par1 and par2 using FileWriter.

Arguments--------------
par1 (String): username
par2 (String): password
Return-----------------
void method

-----------------------------------------------------------------------------------------------------------------------------

getCreds()

Gets the credentials that are in the credentials file using string manipulation.

Arguments--------------
None
Return-----------------
ArrayList (0 = username, 1 = password)

-----------------------------------------------------------------------------------------------------------------------------

checkCredsFileExist()

Checks if the credentials file exists when initialize the application. If the file does not exists, it creates one and writes a default login credential.

Arguments--------------
None
Return-----------------
void method

-----------------------------------------------------------------------------------------------------------------------------

checkUpdatedCreds(par1, par2, par3)

When a user wants to edit his credentials, he provides the information. This method verifies the information before modifying the credentials. 

Arguments--------------
par1 (String): new username
par2 (String): new password
par3 (String): new passwordDupe
Return-----------------
int 0: if the the change is sucessful, modifies credentials with setCreds()
int 1: password doesnt match
int 2: username and password are the same as the current credentials

-----------------------------------------------------------------------------------------------------------------------------

getWidth()

Used to get the width of the screen.

Arguments--------------
None
Return-----------------
int width

-----------------------------------------------------------------------------------------------------------------------------

getHeight()

Used to get the height of the screen.

Arguments--------------
None
Return-----------------
int height

-----------------------------------------------------------------------------------------------------------------------------


checkCreds(par1, par2)

Used to verify login information. Reads the credentials file and compares the strings.

Arguments--------------
par1 (String): username
par2 (String): password
Return-----------------
boolean true: if correct credentials
boolean false: if incorrect credentials
