

Помимо pom.xml в стартовый набор входит еще два интересных файла:
MySpringApplication.java – класс начальной загрузки и конфигурации Spring (имя класса строится как функция
от названия проекта по маске %имя_проекта%Application).
application.properties – файл настройки свойств Spring Boot.

Атрибут @SpringBootApplication, в числе прочих, наследуется от атрибутов @Configuration, @ComponentScan,
    @EnableAutoConfiguration.
@Configuration – объявляет класс классом Java-based конфигурации.
@ComponentScan – позволяет выполнять компонентное сканирование.
@EnableAutoConfiguration – это вызов «магии»: она сообщает Spring Boot, что необходимо «угадать», как вы
    хотите настроить Spring, основываясь на добавленных зависимостях.
Поскольку стартер spring-boot-starter-web добавил Tomcat и Spring MVC, автоконфигурация предполагает, что
вы разрабатываете веб-приложение.

-----------------
Стартеры

Стартеры содержат множество зависимостей, необходимых для быстрого запуска проекта с помощью согласованного
и поддерживаемого набора управляемых транзитивных зависимостей.
Все официальные стартеры следуют единой схеме именования: spring-boot-starter-*, где * – конкретный тип
приложения. Эта структура именования призвана помочь, когда вам нужно найти стартер.

spring-boot-starter-web – используется для создания веб-служб RESTful с использованием Spring MVC и
    Tomcat в качестве встроенного контейнера приложений;
spring-boot-starter-jersey – альтернатива Spring-boot-starter-web, в которой используется встроенный сервер
    приложений Jersey, а не Tomcat;
spring-boot-starter-jdbc – реализует пул соединений JDBC, основан на реализации пула JDBC Tomcat.
spring-boot-starter-parent – это специальный стартер, предоставляющий настройки Maven по умолчанию.
    Он также предоставляет раздел управления зависимостями, чтобы вы могли опустить теги версии для
    Spring-зависимостей.

----------------
spring-boot-maven-plugin

По умолчанию, инициализатор Spring Boot в секции <plugins> pom-файла указывает плагин spring-boot-maven-plugin.
Данный плагин решает несколько полезных задач:
    - перепаковывает выходной .jar-файл проекта в исполняемый über-jar, включающий в себя все .jar-файлы
        зависимостей проекта, что очень удобно при развертывании;
    - находит точку входа в проекте – класс, содержащий функцию main(), указывает его в манифесте
        переупакованного .jar-файла (über-jar);
    - при указании .war-упаковки перепаковывает выходной .war-файл проекта в .war-файл, включающий в себя
        все .jar файлы зависимостей;
    - предоставляет определитель версии зависимостей, который устанавливает номер версии для соответствия
        зависимостям Spring Boot, что избавляет вас от необходимости указывать версию зависимостей
        Spring Boot. Кроме того, вы всегда можете переопределить данное поведение и указать версию по
        своему предпочтению.

------------------
application.properties - указание свойств приложения

Например, указываем, что встроенный web-сервер должен слушать HTTP на 80-порту,  (а не на 8080, как указано
по умолчанию)
    server.port=80

Ранее для гибкого указания свойств JDBC-соединения (не посредством Java-конфигурирования) приходилось
описывать бины в файле applicationContext.xml.
Описывать бины в XML по-прежнему можно, если кто привык (нравится XML).

Spring Boot, зная, что вы используете какую-либо реализацию JDBC-драйвера (в нашем примере это H2 Database : com.h2database ), сам создаёт бины DataSource, свойства которых выставляет по умолчанию. Чтобы выставить значения, отличные от используемых по умолчанию, вы можете прописать их в файле свойств.
Например, по умолчанию H2 драйвер использует URL-подключения к in-memory БД «jdbc:h2:mem:testdb». Указываем в файле свойств:
    spring.datasource.url=jdbc:h2:~/spring.h2
    spring.datasource.driver-class-name=org.h2.Driver

Intellij IDEA предоставляет подсказки при указании свойств

------------------
Статический контент (WebJars)

По умолчанию Spring Boot будет отдавать статический контент из каталога /static (или /public, или /resources,
или /META-INF/resources) в classpath, или из каталога ServletContext. Он использует ResourceHttpRequestHandler
из Spring MVC, поэтому вы можете изменить это поведение, добавив свой собственный WebMvcConfigurerAdapter
и переопределив метод addResourceHandlers.
По умолчанию статический контент отображается на корень (/**) веб-приложения, с точки зрения браузера, но
можно настроить иное отображение, используя свойство spring.mvc.static-path-pattern. Например, отображение
статического контента в /resources/** может быть достигнуто следующим образом:
spring.mvc.static-path-pattern=/resources/**

Физическое расположение статического контента можно указать, используя свойство
spring.resources.static-locations. Можно указать список из нескольких локаций.
В дополнение к обычным статическим ресурсам, возможно использование статических ресурсов, упакованных в
формате WebJar. Для этого необходимо дополнить pom.xml соответствующими зависимостями:

<dependencies>
  ...
  <dependency>
    <groupId>org.webjars</groupId>
    <artifactId>jquery</artifactId>
    <version>2.1.1</version>
  </dependency>
  <dependency>
    <groupId>org.webjars</groupId>
    <artifactId>bootstrap</artifactId>
    <version>3.2.0</version>
  </dependency>
  ...
</dependencies>

Далее мы можем ссылаться на эти статические ресурсы следующим образом:
<link rel='stylesheet' href='/webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
<script type="text/javascript" src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>

Заметьте, что версию внешнего ресурса (js-библиотеки, css-файлов) приходится указывать ссылкой на ресурс и
следить, чтобы она соответствовала версии, указанной в зависимости, что неудобно. Решением этой проблемы
является подключение в зависимости локатора JS/CSS библиотек:

    <dependency>
        <groupId>org.webjars</groupId>
        <artifactId>webjars-locator</artifactId>
        <version>RELEASE</version>
    </dependency>

Теперь указание версии можно опустить:
<link rel='stylesheet' href='/webjars/bootstrap/css/bootstrap.min.css'>
<script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>

----------------
Actuator

Spring Boot Actuator предоставляет множество готовых к использованию функций мониторинга для уже
существующего Spring Boot-приложения, избавляя от необходимости реализовывать их самостоятельно. Более
того, набор этих функций можно легко расширить из приложения.
После добавления Actuator к проекту Spring Boot, он регистрирует в приложении набор конечных точек,
доступных через HTTP и JMX.

Стартер:
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
  </dependency>

По умолчанию Actuator ограничивает доступ к конечным точкам, используя Spring Security, при отсутствии
которого доступ блокируется. Решение: или подключить и настроить Spring Security, или отключить проверку
безопасности для Actuator (последний вариант не подходит для продакшена).

Для тестового сценария отключаем проверку безопасности в application.properties:
# по всем конечным точкам сразу
management.security.enabled=false

# или индивидуально
#endpoints.metrics.enabled=true
#endpoints.metrics.sensitive=false

# можно отдавать на отдельном порту
management.port=8081

Конечные точки

/health
    Отображает информацию о состоянии приложения:
    {
      "status": "UP"
    }

    Поведение настраивается имплементацией интерфейса HealthIndicator: (файл HealthCheck.java)

    @Component
    public class HealthCheck implements HealthIndicator {

        @Override
        public Health health() {
            String[] errors = checkForErrors();
            if (errors != null && errors.length>0) {
                return Health.down().withDetail("Errors detected", String.join("\n", errors)).build();
            }
            return Health.up().build();
        }

        public String[] checkForErrors() {
            // пользовательская логика проверки состояния приложения
            //
            return null;
        }
    }

/info
    Информация о приложении. По умолчанию пусто, но легко настраивается свойствами: (файл application.properties)
        info.app.name=Actuator Test Trip
        info.app.description=Spring Boot Actuator Application
        info.app.version=1.2.3

    Результат:
    {
      "app": {
        "description": "Spring Boot Actuator Application ",
        "name": "Actuator Test Trip",
        "version": "1.2.3"
      }
    }

/metrics
    Собирает и отображает информацию о метриках ОС, JVM и самого приложения:
    {
      "mem": 238536,
      "mem.free": 52052,
      "processors": 2,
      "instance.uptime": 1114097,
      "uptime": 1122187,
       ...

/trace
    Лог последних 100 HTTP-запросов:
    [
      {
        "timestamp": 1501180397578,
        "info": {
          "method": "GET",
          "path": "/trace",
          "headers": {
            "request": {
              "accept": "application/json",
              "host": "localhost:8080",
              ...

