package com.example.candyshop;

import org.springframework.data.jpa.repository.JpaRepository;

interface PaymentsCommandRepository extends JpaRepository<PaymentsCommand, Long> {
    
}