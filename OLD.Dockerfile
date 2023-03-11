# FROM maven:3.8.6-eclipse-temurin-19-alpine
FROM ubuntu

WORKDIR /usr/src/app

# COPY . .

RUN alias ll='ls -la'
RUN apt update && apt install -y xvfb
RUN apt --fix-broken install -y
RUN apt install wget -y
# INSTALL JAVA(jdk19)
RUN wget https://download.oracle.com/java/19/latest/jdk-19_linux-x64_bin.deb
RUN apt-get -qqy install ./jdk-19_linux-x64_bin.deb
RUN update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk-19/bin/java 1919
# install MAVEN
RUN apt install maven -y
# install CHROME
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN apt-get update
RUN apt-get install gdebi-core -y
RUN gdebi -n google-chrome-stable_current_amd64.deb 

ENV START_XVFB false

# RUN mvn -B package --file pom.xml
# RUN mvn install -Dmaven.test.skip=true