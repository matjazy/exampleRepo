package com.project3.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project3.server.domain.Role;

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
