package com.team3.personal_date.api.controller;

import com.team3.personal_date.api.dto.CreateInviteRequest;
import com.team3.personal_date.api.dto.InviteResponse;
import com.team3.personal_date.core.usecase.CreateInviteUseCase;
import com.team3.personal_date.core.usecase.ICreateInviteUseCase;
import com.team3.personal_date.core.usecase.IGetInviteUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/invites")
public class InviteController {

    private final ICreateInviteUseCase createInviteUseCase;
    private final IGetInviteUseCase getInviteUseCase;

    public InviteController(CreateInviteUseCase createMeetUseCase, IGetInviteUseCase getInviteUseCase) {
        this.createInviteUseCase = createMeetUseCase;
        this.getInviteUseCase = getInviteUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<InviteResponse> getInvite(@PathVariable UUID id) {
        return ResponseEntity.ok(getInviteUseCase.getInvite(id));
    }

    @PostMapping
    public ResponseEntity<Void> createInvite(@RequestBody CreateInviteRequest meetRequestDTO) {
        createInviteUseCase.createInvite(meetRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
