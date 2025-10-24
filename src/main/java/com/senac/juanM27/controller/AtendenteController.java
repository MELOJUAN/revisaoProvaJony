package com.senac.juanM27.controller;

import com.senac.juanM27.dto.CreateUserDto;
import com.senac.juanM27.dto.LoginUserDto;
import com.senac.juanM27.dto.RecoveryJwtTokenDto;
import com.senac.juanM27.entity.Atendente;
import com.senac.juanM27.service.AtentendeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/atendente")
public class AtendenteController {
    private final AtentendeService atentendeService;


    public AtendenteController(AtentendeService atentendeService) {
        this.atentendeService = atentendeService;
    }
    @GetMapping("/listar")
    public ResponseEntity <List<Atendente>> listarTodos(){
        return ResponseEntity.ok(atentendeService.listarTodos());
    }

    @GetMapping("/listarporid/{id}")
    public ResponseEntity<Atendente> listarPorId (@PathVariable ("id")Integer id){
        return ResponseEntity.ok(atentendeService.listarPorId(id));
    }

    @PostMapping("/criar")
    public  ResponseEntity<Void> criarAtendente (@RequestBody
    CreateUserDto createUserDto){
        atentendeService.criarAtendente(createUserDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<RecoveryJwtTokenDto> loginAtendente(@RequestBody LoginUserDto loginUserDTO){
        return new  ResponseEntity<>(atentendeService.login(loginUserDTO),HttpStatus.OK);


    }
}
