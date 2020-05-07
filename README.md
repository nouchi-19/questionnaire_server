questionnaire_server
=============
卒研用サーバ

## ローカル動作時

### サーバの起動
使用ポート
* 8080(tomcat)
* 8081(mongo-express)
* 27017(mongo)

```$xslt
cd docker
docker-compose up -d
```

### モックが必要な場合
```$xslt
http://localhost:8080/questionnaire_server/student/api/setup
```

### API仕様
```$xslt
https://docs.google.com/spreadsheets/d/14zEAWLzg6yWcRA9Nh9cr0e7YtiLYbHXHVxTTDrUnl5w/edit?usp=sharing
```

### dbの中身確認（mongo-express）
```$xslt
http://localhost:8081/
```
