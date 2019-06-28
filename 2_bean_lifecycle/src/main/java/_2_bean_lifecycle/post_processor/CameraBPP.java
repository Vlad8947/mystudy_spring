package _2_bean_lifecycle.post_processor;

import _2_bean_lifecycle.bean.camera.Camera;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CameraBPP implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // В данном методе просто возвращаем бин
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // Находим бин класса фотокамеры
        if(bean instanceof Camera){

            System.out.println("Делаю пробное фото!");
            // Делаем пробное фото
            ((Camera) bean).doPhotograph();
            System.out.println("Отлично! Работает!");
        }
        return bean;

    }
}
