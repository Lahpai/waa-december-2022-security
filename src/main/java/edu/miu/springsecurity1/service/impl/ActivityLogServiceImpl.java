package edu.miu.springsecurity1.service.impl;

import edu.miu.springsecurity1.entity.ActivityLog;
import edu.miu.springsecurity1.repository.ActivityLogRepo;
import edu.miu.springsecurity1.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {

    private  final ActivityLogRepo activityLogRepo;
    @Override
    public void save(ActivityLog activityLog) {

    }
}
