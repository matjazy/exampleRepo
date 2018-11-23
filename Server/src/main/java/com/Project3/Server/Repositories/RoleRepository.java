package com.Project3.Server.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project3.Server.Domain.Role;

/**
 * Repository related to Role model.
 * @author MJazy
 *
 */
@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long>{

	/**
	 * Allows to find role by name.
	 * @param name of sought role.
	 * @return role with relevant name or null.
	 */
	Role findByName(String name);		

}
