package br.com.cpsoftware.avancaif.app.controller.api.badge;

import br.com.cpsoftware.avancaif.app.util.constant.PathApiConstants;
import br.com.cpsoftware.avancaif.domain.entity.badge.BadgeEntity;
import br.com.cpsoftware.avancaif.domain.usecase.badge.RetrieveAllBadgesUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(PathApiConstants.API_V1_BADGES_RETRIEVE_ALL)
public class GetRetrieveAllBadgesApiController {

    private final RetrieveAllBadgesUseCase retrieveAllBadgesUseCase;

    @Autowired
    public GetRetrieveAllBadgesApiController(RetrieveAllBadgesUseCase retrieveAllBadgesUseCase) {
        this.retrieveAllBadgesUseCase = retrieveAllBadgesUseCase;
    }

    @GetMapping
    public ResponseEntity<List<BadgeEntity>> apply() {
        var badges = retrieveAllBadgesUseCase.apply();
        return ResponseEntity.ok(badges);
    }
}
