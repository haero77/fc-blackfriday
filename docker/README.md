```
docker build -t blackfriday-app .
```
- 도커 이미지 빌드

```
docker run -p 8080:8080 blackfriday-app
docker run -p 8085:8080 blackfriday-app # host port 8085로 변경
```
- host의 8080을 8080으로 연결한다.

```
docker start ${CONTAINER_ID}
```

- 데몬으로 컨테이너 실행(백그라운드 실행)