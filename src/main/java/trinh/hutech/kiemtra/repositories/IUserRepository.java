package trinh.hutech.kiemtra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import trinh.hutech.kiemtra.entities.Role;
import trinh.hutech.kiemtra.entities.User;
import java.util.List;

public interface IUserRepository  extends JpaRepository<User, String> {
    @Query("SELECT u FROM User u WHERE u.isdeleted = :de")
    List<User> findAllByDe(@Param("de") Boolean de);
}
