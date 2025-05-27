package br.com.cpsoftware.avancaif.app.controller.api.badge;

import br.com.cpsoftware.avancaif.app.util.constant.PathApiConstants;
import br.com.cpsoftware.avancaif.domain.usecase.badge.DeleteBadgeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathApiConstants.API_V1_BADGES_DELETE)
public class DeleteBadgeApiController {

    private final DeleteBadgeUseCase deleteBadgeUseCase;

    @Autowired
    public DeleteBadgeApiController(DeleteBadgeUseCase deleteBadgeUseCase) {
        this.deleteBadgeUseCase = deleteBadgeUseCase;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBadge(@PathVariable("id") Long id) {
        deleteBadgeUseCase.apply(id);
        return ResponseEntity.noContent().build();
    }
}
