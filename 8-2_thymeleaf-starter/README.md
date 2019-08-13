Доп инфа и примеры на ресурсе o7planning.org

'#' - предопределенные объекты <br>
'$' - аттрибуты <br>
'@' - ссылки

#### Зависимости

Чтобы включить Thymeleaf в проект, требуется библиотека thymeleaf-starter.
<br>
По умолчанию Spring Boot использует Thymeleaf 2.1, поэтому для 
подключения версии 3 необходимо это явно указать в pom.xml.

Кроме собственно библиотеки, стартер добавляет небольшой 
«мешочек магии» в виде класса ThymeleafAutoConfiguration, что 
избавляет нас от ручного написания бинов конфигурации. А класс 
ThymeleafProperties определяет опции по умолчанию, 
конфигурируемые в файле application.properties.

#### Отображение строк из файлов message.properties и интернационализация

Spring Boot выполняет данное конфигурирование самостоятельно, 
без нашего участия, в рамках «магии Boot». (Подробнее в модуле про thymeleaf)

По умолчанию приложение Spring Boot будет искать файлы сообщений, 
содержащие ключи и значения интернационализации в 
папке src/main/resources.

#### Передача параметров

Для передачи объектов используется в методах model.addAttribute().
Иначе можно создать метод с аннотацией @ModelAttribute("attrName").

#### Валидация полей

Функция #fields.hasErrors() может использоваться для проверки 
наличия каких-либо ошибок. Функция #fields.errors () может 
использоваться для отображения ошибок для определенного поля. 
Имя поля является входным параметром для обеих этих функций. В 
качестве имени поля могут выступать предопределенные константы «*» 
и «all».

#### Упрощение стилизации CSS на основе ошибок 
Аттрибут th:errorclass применительно к тегу поля формы 
(input, select, textarea ...) будет читать имя поля, которое должно 
быть проверено, из любого существующего имени или th: атрибутов 
поля в том же теге, а затем добавит указанный класс CSS в тег, 
если в этом поле есть связанные ошибки.

Пример: <br>
\<input type="text" th:field="*{date}" th:errorclass="error" />

В случае ошибки в поле, date будет отображено, как предписывает 
следующий HTML-код: <br>
\<input type="text" id="date" name="date" value="2017-10-10" class="error" />

#### For Each
Полный синтаксис  th:each включает 2 переменные, переменная элемента (item variable) 
и переменная состояния (state variable).

\<th:block th:each="item, iState : ${items}">

Переменная состояния (State variable) это полезный объект, содержащий информацию текущего состояния цикла, 
например количество элементов цикла, текущий индекс цикла,...

index - Текущий индекс повтора (iteration), начиная с 0.

count - Количество обработанный элементов до настоящего момента.

size - Сумма элементов в списке.

even/odd - Проверяет текущий индекс (index) повтора (iteration) является четным или нечетными.

first - Проверяет является ли настоящий повтор первым или нет?

last - Проверяет является ли настоящий повтор последним или нет?

#### th:insert, th:replace, th:include
th:insert - вставит Fragment становится подтегом целевого тега (Target tag).

th:replace - заменит целевой тег с помощью Fragment.

th:include - вставит дочерний Fragment становит дочерним целевым тегом.

Примечание: Атрибут(attribute) th:include используется в  Thymeleaf 2, и не используется больше в версии Thymeleaf 3.

#### Predefined Objects

В Thymeleaf имеются некоторые предопределенные объекты и вы можете использовать их везде в  Thymeleaf Template. В основном имеются 2 вида объекта это Базовые объекты (Basic Objects), и Утилитарные объекты (Utility Objects):
Эти предопределенные объекты будут ссылаться (reference) в соответствии со стандартом ​​​​​​​ OGNL, начиная с символа ( # ).

##### Basic Objects

##### \#ctx org.thymeleaf.context.IContext/org.thymeleaf.context.IWebContext	
Объект выполняет (implement) интерфейс IContext или IWebContext, в зависимости от среды (Стандартная или Web).
##### \#locale	java.util.Locale	
Объект предоставляет информацию связанную с Locale (Локалом).
##### \#request	javax.servlet.http.HttpServletRequest (Только в среде Web) 
Объект​HttpServletRequest.
##### \#response	javax.servlet.http.HttpServletResponse	(Только в среде​Web) 
Объект​HttpServletResponse.
##### \#session	javax.servlet.http.HttpSession (Только в среде​Web) 
Объект​HttpSession.
##### \#servletContext	javax.servlet.http.ServletContext (Только в среде​Web) 
Объект ServletContext.

##### Utility Objects

##### \#execInfo	org.thymeleaf.expression.ExecutionInfo	
Информация про Template обрабатывается.
##### \#messages	org.thymeleaf.expression.Messages	
Методы для работы с  message.
##### \#uris	org.thymeleaf.expression.Uris	
Методы для​​​​​​​ escape части у URLs/URIs.
##### \#conversions	org.thymeleaf.expression.Conversions	
Методы для выполнения конфигурированного "конверсионного сервиса" (conversion service) (Если имеется).
##### \#dates	javax.servlet.http.HttpSession	
Методы для форматирования объекта java.util.Date, или получения связанной информации как день, месяц, год,..
##### \#calendars	javax.servlet.http.ServletContext	
Похоже на #dates, но с объектом java.util.Calendar.
##### \#numbers	org.thymeleaf.expression.Numbers	
Методы для форматирования числовых объектов (Number).
##### \#strings	org.thymeleaf.expression.Strings	
Методы для​​​​​​​ объектов String. Например contains, startsWith, ...
##### \#objects	org.thymeleaf.expression.Objects	
Методы для объектов в общем.
##### \#bools	org.thymeleaf.expression.Bools	
Методы для оценки boolean.
##### \#arrays	org.thymeleaf.expression.Arrays	
Методы для массивов (array).
##### \#lists	org.thymeleaf.expression.Lists	
Методы для​​​​​​​ lists.
##### \#sets	org.thymeleaf.expression.Sets	
Методы для​​​​​​​ sets.
##### \#maps	org.thymeleaf.expression.Maps	
Методы для​​​​​​​ maps.
##### \#aggregates	org.thymeleaf.expression.Aggregates	
Методы для расчета суммы, среднего значения,.. на коллекции (collection) или массиве (array).
##### \#ids	org.thymeleaf.expression.Ids

