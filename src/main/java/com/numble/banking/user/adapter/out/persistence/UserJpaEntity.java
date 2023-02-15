package com.numble.banking.user.adapter.out.persistence;

import com.numble.banking.common.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserJpaEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String loginId;
}
