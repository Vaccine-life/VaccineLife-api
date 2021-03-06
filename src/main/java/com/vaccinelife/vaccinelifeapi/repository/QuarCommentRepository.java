package com.vaccinelife.vaccinelifeapi.repository;
import com.vaccinelife.vaccinelifeapi.model.QuarComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuarCommentRepository extends JpaRepository<QuarComment, Long> {

    List<QuarComment> findByQuarBoardId(Long id);
    List<QuarComment> findAllByQuarBoardIdOrderByCreatedAtDesc(Long id);
}
