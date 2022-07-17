package kz.samgau.library.service.impl;

import kz.samgau.library.model.Category;
import kz.samgau.library.repository.CategoryRepository;
import kz.samgau.library.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl extends BaseServiceImpl<Category, Long> implements CategoryService {

    private final CategoryRepository repo;

    @PostConstruct
    public void init(){
        repository = repo;
    }
}
