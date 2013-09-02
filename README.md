PDM
===

ЗХПД – Защищенное Хранилище Персональный Данных

1.	Сборка
git clone --recursive https://github.com/KorusConsulting/PDM
cd PDM
mvn clean install

В результате успешного выполнения команд будет собран файл /PDM/ear/target/ pdm-ear-<M>.<N>.<K>.ear, -<M>.<N>.<K> - номер версии

2. Требования к ПО
   Glassfish 3.1.2
   mongodb 2.4
   
3. Установка
   3.1 Установить Glassfish 3.1.2 и создать домен.
   3.2 Установить mongodb в соответствии с инструкцией http://docs.mongodb.org/manual/tutorial/install-mongodb-on-linux/
   3.3 Продеплоить pdm-ear-<M>.<N>.<K>.ear в домен сервера Glassfish 3.1.2.
