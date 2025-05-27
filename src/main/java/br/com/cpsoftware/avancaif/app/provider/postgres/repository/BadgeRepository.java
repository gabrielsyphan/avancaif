package br.com.cpsoftware.avancaif.app.provider.postgres.repository;

import br.com.cpsoftware.avancaif.app.provider.postgres.model.BadgeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeRepository extends JpaRepository<BadgeModel, Long> {
}
