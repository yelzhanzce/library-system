package kz.samgau.library.service.impl;

import kz.samgau.library.model.Shelve;
import kz.samgau.library.repository.BookRepository;
import kz.samgau.library.repository.ShelveRepository;
import kz.samgau.library.service.ShelveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ShelveServiceImpl extends BaseServiceImpl<Shelve, Long> implements ShelveService {

    private final ShelveRepository repo;

    @PostConstruct
    public void init(){
        repository = repo;
    }
}
