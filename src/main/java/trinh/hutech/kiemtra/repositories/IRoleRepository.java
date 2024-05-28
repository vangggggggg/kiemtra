package trinh.hutech.kiemtra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import trinh.hutech.kiemtra.entities.Role;

public interface IRoleRepository extends JpaRepository<Role,String>{
    @Query("SELECT COUNT(u) FROM User u WHERE u.role.role_id = :roleId")
    long countByRoleID(@Param("roleId") String roleId);
}
