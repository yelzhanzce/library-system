package kz.samgau.library.service.impl;

import kz.samgau.library.model.Library;
import kz.samgau.library.repository.LibraryRepository;
import kz.samgau.library.service.LibraryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class LibraryServiceImpl extends BaseServiceImpl<Library, Long> implements LibraryService {

    private final LibraryRepository repo;

    @PostConstruct
    public void init() {
        repository = repo;
    }
}
