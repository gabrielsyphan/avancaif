package br.com.cpsoftware.avancaif.app.provider.postgres.repository;

import br.com.cpsoftware.avancaif.app.provider.postgres.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    
    UserModel findByUsername(String username);
}
