docker build . -t github_actions

docker run -it --rm -v ${PWD}:/usr/src/app -w /usr/src/app github_actions bash

docker run --rm -p 4444:4444 selenium/standalone-chrome

docker exec -it <container id/name> bash

docker-compose up --build
docker-compose down

$ docker system prune - очистит все неиспользуемые данные(образы none, остановленные контейнеры)


## ERROR: docker endpoint for "default" not found
- Delete .docker directory. Which exists on PATH C:\Users\your-username\.docker
- Restart docker.



## My image with java, jdk, maven and chrome
- docker pull ubuntu

- alias ll='ls -la'
- apt update && apt install -y xvfb
% - apt update && apt upgrade -y
- apt install wget -y
### install JAVA
- wget https://download.oracle.com/java/19/latest/jdk-19_linux-x64_bin.deb
- apt-get -qqy install ./jdk-19_linux-x64_bin.deb
- update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk-19/bin/java 1919

check result
root@vypc:~# java -version

### install MAVEN 
- apt install maven -y
mvn -version

### install CHROME

docker build . -t my_os
docker build . --no-cache -t my_os
docker run -it --rm -v ${pwd}:/usr/src/app -w /usr/src/app my_os bash
docker run -it --rm --network host -v ${pwd}:/usr/src/app -w /usr/src/app my_os bash

docker build . -t maven_alpine

docker run --rm -p 4444:4444 selenium/standalone-chrome

apt-get install gdebi-core -y
gdebi google-chrome-stable_current_amd64.deb -y

google-chrome-stable --no-sandbox



org.openqa.selenium.SessionNotCreatedException: Could not start a new session. Response code 500. Message: unknown error: Chrome failed to start: exited abnormally.
  (unknown error: DevToolsActivePort file doesn't exist)
  (The process started from chrome location /usr/bin/google-chrome is no longer running, so ChromeDriver is assuming that Chrome has crashed.)
Host info: host: 'a3668913dda7', ip: '172.17.0.2'

apt-get update
apt-get install libgconf-2-4 libappindicator1 -y

docker pull selenium/standalone-chrome