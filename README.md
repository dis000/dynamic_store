# dynamic_store
![img_1.png](UntitledDiagram.jpg)
Сборка базы данных через docker
<br>
cd ./src/main/resources
<br>
sudo docker-compose --project-name dynamic-store-db up -d
<br>
<br>
в последующие запуски выполнить команду:
<br>
sudo docker start dynamic-store-db
<br>
<br>
сборка docker контейнера:
<br>
Совершить с помощью maven чистую сборку
<br>
Скопировать jar файл из target в корень
<br>
sudo docker build -t dynamic-store .
<br>
sudo docker run --name dynamic-store --network=host dynamic-store
<br>
<br>
В последующие запуски просто выполнить команду:
<br>
sudo docker start -i dynamic-store