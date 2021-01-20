# 2021-Super-Challenge-Hackathon

## 개발환경 설정
1. 인텔리제이로 `build.gradle` 파일을 연다.
2. 설정창을 연다. (window : `ctrl` + `alt` + `s`, mac : `command` + `,`) 
3. Build, Execution, Deployment -> Build Tools -> Gradle 에서 아래 사진처럼 변경
(Gradle JVM은 java 11 확인)
![image](https://user-images.githubusercontent.com/53253189/104988648-fd1d1f00-5a5b-11eb-8ece-30ecb68cc9bd.png)
4. src/main/java/inti/SAhomepage/SaHomepageApplication.java 의 main 함수를 실행
5. localhost:8080 접속
---

## mysql 연동방법
1. resource/application.properties 파일에서 user와 password에 각자 mysql 서버에 맞는 유저와 비밀번호를 적는다.
![image](https://user-images.githubusercontent.com/53253189/105216058-6bb1c800-5b95-11eb-86a4-aad1ed4ca696.png)
`YOUR USER NAME!`, `YOUR PASSWORD!` 부분을 바꾸면 된다.
