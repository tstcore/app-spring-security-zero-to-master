package com.tstcore.easybank.services;

import com.tstcore.easybank.entities.Notice;

import java.util.List;

public interface NoticesService {
    List<Notice> findAllActiveNotices();
}
