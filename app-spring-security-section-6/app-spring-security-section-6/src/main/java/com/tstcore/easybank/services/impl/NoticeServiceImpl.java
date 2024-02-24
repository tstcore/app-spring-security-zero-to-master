package com.tstcore.easybank.services.impl;

import com.tstcore.easybank.entities.Notice;
import com.tstcore.easybank.repositories.NoticeRepository;
import com.tstcore.easybank.services.NoticesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticesService {
    private final NoticeRepository repository;

    public NoticeServiceImpl(NoticeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Notice> findAllActiveNotices() {
        return repository.findAllActiveDates();
    }
}
