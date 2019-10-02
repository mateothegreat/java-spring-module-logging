package platform.api.logging;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class LogsService {

    private LogsRepository logsRepository;

    @Autowired
    public LogsService(final LogsRepository logsRepository) {

        this.logsRepository = logsRepository;

    }

    public Log createForUser(UUID id, String title, String description) {

        Log log = new Log();

        log.setUuid(id);
        log.setContext("USER");
        log.setTitle(title);
        log.setDescription(description);

        return logsRepository.save(log);

    }

    public Page<Log> getByUser(UUID id, Pageable pageable) {

        return logsRepository.getByUuidAndContextOrderByIdDesc(id, "USER", pageable);

    }

}
