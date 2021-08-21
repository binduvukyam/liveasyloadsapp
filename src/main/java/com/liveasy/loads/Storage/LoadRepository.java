package com.liveasy.loads.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.*;

public interface LoadRepository extends JpaRepository<LoadEntity, Long>
{
    @Query("select le from LoadEntity le where le.shipperId=?1")
    public List<LoadEntity> FindByShipperId(String shipperId);
}