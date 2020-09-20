# Сортировка слиянием #

## Функциональность ##
Программа осуществляет сортировку слиянием нескольких файлов. Входные данные для программы передаются через командную строку.

## Входные данные ##
1. режим сортировки (-a или -d), необязательный, по умолчанию сортируем по возрастанию;
2. тип данных (-s или -i), обязательный (где -s строки, -i целые числа);
3. имя выходного файла, обязательное;
4. остальные параметры – имена входных файлов, не менее одного.

## Запуск программы ##
Для запуска введите в командной строке: **java -jar target\cftTest-1.0-SNAPSHOT.jar [*arguments*]** 

*Где **arguments** это перечисленные аргументы*

*Пример:* java -jar target\cftTest-1.0-SNAPSHOT.jar -i -a D:\Ivan\o.txt D:\\Ivan\\1.txt D:\\Ivan\\2.txt D:\\Ivan\\3.txt

## Особенности реализации ##

## Разбор входных аргументов ##
1. Программа интерпретирует первый файл в аргументах как файл для записи результата работы. Все остальные аргументы, которые лежат в массиве аргументов после файла для записи результатов программа интерпретирует как файлы с входными данными.   

### Проверка входных аргументов ###
1. Если передать в аргументах несколько типов данных (-s, -i), то все аргументы типа -i будут удалены, а дальнейшая работа программы будет продолжена с аргументов -s. Данное допущение было сделано в виду того, что любые числа можно интерпретировать как строи, в то время как строки далеко не всегда можно интерпретировать как числа. Информирование выводится в консоль.
2. Если передать в аргументах несколько режимов сортировки (-a, -d), то все аргументы типа -d будут удалены, сортировка будет осуществляться в режиме -a. Информирование выводится в консоль. 

### Проверка файлов ###
1. Перед началом работы с входными данными программа проверяет входные файлы на пустоту, если файл с входными данными пустой - он удаляется из аргументов. Информирование выводится в консоль.
2. Если аргумент интерпретированный программой как файл с входными данными не пройдет проверку на файл - он будет удален из списка аргументов. Информирование выводится в консоль.
3. Если аргумент интерпретированный программой как файл с входными данными не пройдет проверку на writable - он будет удален из списка аргументов. Информирование выводится в консоль.

### Сортировка ###
1. Если предполагается сортировка по убыванию, то в программе предполагается, что данные во входных файлах также отсортированы по убыванию. 
2. Записи в файлах, которые не прошли проверку на корректный порядок будут удалены. При этом работа с файлом будет продолжена, если в файле есть данные расположение которых верно относительно заданного порядка - эти данные будут учтены при работе алгоритма.
