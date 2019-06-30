package spring_mvc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // Возвращает корневую конфигурации приложения (сервисы и дао-уровень)
        return new Class<?>[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Возвращает конфигурации сервлета (веб-уровень, который включает в себя контроллеры)
        return new Class<?>[]{DispatcherServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        // Возвращает путь, на который мэппится данный сервлет
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        // Создание фильтра кодировки, который позволит работать с русскими символами
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        // Создание фильтра, который добавляет поддержку HTTP-методов (например таких, как PUT), необходимых для REST API
        HiddenHttpMethodFilter httpMethodFilter = new HiddenHttpMethodFilter();
        return new Filter[]{characterEncodingFilter, httpMethodFilter};
    }
}