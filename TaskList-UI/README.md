# Task List 

Task List Project

# Contents

The project is simple combination of a front end in vue.js and back end as spring boot application to save tasks date wise and download the excel sheet


# Project setup

Download and Install node.js from https://nodejs.org/en/download/

Check from command line 'npm' 

## Front End 
Change directory /TaskList-UI

Run below
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Run your tests
```
npm run test
```

### Lints and fixes files
```
npm run lint
```

## Back End

Download and Install gradle from https://nodejs.org/en/download/

Check from command line 'gradle' 

optional - If want to run in local machine, download and install oracle 
https://www.oracle.com/database/technologies/oracle19c-windows-downloads.html

Unlocking HR Schema
http://www.rebellionrider.com/how-to-unlock-hr-user-in-oracle-database-19c/


```
gradle
```

### Compiles and hot-reloads for development
```
gradle build --console=plain copyJar
```

###  Once build
```
java -jar Jar/TaskList.jar
```

###  Execute on a browser
```
http://localhost:9000
```

## Windows Service

To run the application as a Windows Service

https://dzone.com/articles/spring-boot-as-a-windows-service-in-5-minutes

### Executable
```
winsw.exe
```

###  Configuration XML
```
winsw.xml
```

###  Rename the files 

Rename the files to your service name and XML 

### Commands to install/uninstall - run on command line 

```
xx.exe install
```

```
xx.exe uninstall
```

Go to 'Services' Look for the service name and start the service

Go to browser and hit the URL