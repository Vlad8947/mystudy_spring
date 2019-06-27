package hibernate;

import hibernate.dao.CameraDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main( String[] args ) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        final CameraDAO cameraDAO = context.getBean(CameraDAO.class);
        cameraDAO.getList();
    }

}
