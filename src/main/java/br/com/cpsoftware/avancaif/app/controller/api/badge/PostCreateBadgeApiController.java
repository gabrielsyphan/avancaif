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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PathApiConstants.API_V1_BADGE_CREATE)
public class PostCreateBadgeApiController {

    private final BadgeMapper mapper = BadgeMapper.INSTANCE;
    private final CreateNewBadgeUseCase createNewBadgeUseCase;

    @Autowired
    public PostCreateBadgeApiController(CreateNewBadgeUseCase createNewBadgeUseCase) {
        this.createNewBadgeUseCase = createNewBadgeUseCase;
    }

    @PostMapping
    public ResponseEntity<CreateNewBadgeResponse> createNewBadge(@Valid @RequestBody CreateNewBadgeRequest request) {
        var badge = createNewBadgeUseCase.apply(request.toBadgeEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toCreateNewBadgeResponse(badge));
    }
}
