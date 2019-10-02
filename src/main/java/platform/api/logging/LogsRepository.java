package maa.maas.logging;

import maa.maas.users.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsRepository extends PagingAndSortingRepository<Log, Long> {

    Page<Log> getByUserOrderByIdDesc(User user, Pageable pageable);

}
