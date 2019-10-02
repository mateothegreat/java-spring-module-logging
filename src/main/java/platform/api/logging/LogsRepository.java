package platform.api.logging;

import org.springframework.data.domain.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface LogsRepository extends PagingAndSortingRepository<Log, Long> {

    Page<Log> getByUuidAndContextOrderByIdDesc(UUID uuid, String context, Pageable pageable);

}
