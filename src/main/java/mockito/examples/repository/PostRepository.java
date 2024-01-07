package mockito.examples.repository;

import mockito.examples.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<PostEntity,Long> {
    public PostEntity findFirstByUsedId(int id);
}
