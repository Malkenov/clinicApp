package com.clinicApp.clinicApp.entity;

import com.clinicApp.clinicApp.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "приемы")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor_id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient_id;

    @Column
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    private StatusEnum status = StatusEnum.PLANNED;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
