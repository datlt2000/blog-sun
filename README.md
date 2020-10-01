# blog_sun
blog with spring boot, spring jpa, spring security, spring thymeleaf and jquery, mysql, 
This project is built by maven in eclipse. To run project you have to install tomcat, mysql
mysql host is: {
                user : root
                password: Dat11011000
                }
create database named blog with 2 table :
user(id, name, pass, email)
post(id, title, subtitle, content, authur, category, date_post, img)
or run buildServer.sql file in sun folder
then run class DataSeedingListener.java to set some admin account
