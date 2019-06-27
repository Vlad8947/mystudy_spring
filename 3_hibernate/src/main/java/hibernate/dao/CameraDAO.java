package hibernate.dao;

import hibernate.entity.Camera;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class CameraDAO extends AbstractDAO {

    public List<Camera> getList() {
        return entityManager.createQuery("select c from Camera c", Camera.class).getResultList();
    }

}
