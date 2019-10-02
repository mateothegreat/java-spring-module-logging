package maa.maas.logging;

import maa.maas.roles.RolesService;
import maa.maas.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LogsService {

    private LogsRepository logsRepository;
    private RolesService rolesService;

    @Autowired
    public LogsService(final LogsRepository logsRepository,
                       final RolesService rolesService) {

        this.logsRepository = logsRepository;
        this.rolesService = rolesService;

    }

    public Log create(User user, String title, String description) {

        Log log = new Log();

        log.setUser(user);
        log.setTitle(title);
        log.setDescription(description);

        return logsRepository.save(log);

    }

    public Page<Log> getByUser(User user, Pageable pageable) {

        return logsRepository.getByUserOrderByIdDesc(user, pageable);

    }

}
