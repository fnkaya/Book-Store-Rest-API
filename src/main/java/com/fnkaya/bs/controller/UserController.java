package com.fnkaya.bs.controller;

import com.fnkaya.bs.dto.BookDto;
import com.fnkaya.bs.dto.CustomPage;
import com.fnkaya.bs.dto.UserDto;
import com.fnkaya.bs.model.Category;
import com.fnkaya.bs.service.ICategoryService;
import com.fnkaya.bs.service.IUserService;
import com.fnkaya.bs.util.APIPath;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(APIPath.UserPath.CTRL)
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class UserController {

    private final IUserService service;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<CustomPage<UserDto>> getPage(Pageable pageable){
        return ResponseEntity.ok(service.getPage(pageable));
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto){
        return ResponseEntity.ok(service.save(userDto));
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto){
        return ResponseEntity.ok(service.save(userDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.delete(id));
    }
}
