package com.sofia.repositories;

import com.sofia.entities.HistoryRecord;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface HistoryRecordRepository extends JpaRepository<HistoryRecord, Long> {
}