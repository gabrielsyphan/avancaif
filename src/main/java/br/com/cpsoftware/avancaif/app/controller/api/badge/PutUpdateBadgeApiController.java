package br.com.cpsoftware.avancaif.app.controller.api.badge;

import br.com.cpsoftware.avancaif.app.controller.api.badge.dto.CreateNewBadgeRequest;
import br.com.cpsoftware.avancaif.app.controller.api.badge.dto.CreateNewBadgeResponse;
import br.com.cpsoftware.avancaif.app.provider.mapstruct.BadgeMapper;
import br.com.cpsoftware.avancaif.app.util.constant.PathApiConstants;
import br.com.cpsoftware.avancaif.domain.usecase.badge.CreateNewBadgeUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathApiConstants.API_V1_BADGES_UPDATE)
public class PutUpdateBadgeApiController {

    private final BadgeMapper mapper = BadgeMapper.INSTANCE;
    private final CreateNewBadgeUseCase createNewBadgeUseCase;

    @Autowired
    public PutUpdateBadgeApiController(CreateNewBadgeUseCase createNewBadgeUseCase) {
        this.createNewBadgeUseCase = createNewBadgeUseCase;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreateNewBadgeResponse> createNewBadge(
            @PathVariable("id") Long id,
            @Valid @RequestBody CreateNewBadgeRequest request) {
        var badge = createNewBadgeUseCase.apply(request.toBadgeEntity(id));
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toCreateNewBadgeResponse(badge));
    }
}
