docker build . -t github_actions

docker run -it --rm -v ${PWD}:/usr/src/app -w /usr/src/app github_actions bash

docker run --rm -p 4444:4444 selenium/standalone-chrome

docker-compose up --build
docker-compose down

$ docker system prune - очистит все неиспользуемые данные(образы none, остановленные контейнеры)


## ERROR: docker endpoint for "default" not found
- Delete .docker directory. Which exists on PATH C:\Users\your-username\.docker
- Restart docker.