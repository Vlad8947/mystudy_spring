#### Spring Expression Language (SpEL)

    SpEL — мощный язык выражений, который позволяет манипулировать
    графом объекта во время выполнения программы (runtime).

    SpEL входит в состав модуля:
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-expression</artifactId>
    </dependency>

    А модуль входит как зависимость сюда:
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
    </dependency>
    Поэтому мы автоматически получаем функционал SpEL в любом Spring-проекте.
    Spring Boot также включает ее автоматически в недрах стартера spring-boot-starter.

Annotation-based конфигурация // @Value
    public class SomeClass {
        // значение поля
        @Value("#{ systemProperties['user.region'] }")
        private String defaultLocale;

        // эквивалент, но в сеттере
        @Value("#{ systemProperties['user.region'] }")
        public void setDefaultLocale(String defaultLocale) {
            this.defaultLocale = defaultLocale;
        }

        // в методе
        @Autowired
        public void configure(@Value("#{ systemProperties['user.region'] }")
                            String defaultLocale) {
            this.defaultLocale = defaultLocale;
        }
    }
