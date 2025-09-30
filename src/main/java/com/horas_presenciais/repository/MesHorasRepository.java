package com.horas_presenciais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.horas_presenciais.entity.MesHoras;

public interface MesHorasRepository extends JpaRepository<MesHoras, Long> {
}