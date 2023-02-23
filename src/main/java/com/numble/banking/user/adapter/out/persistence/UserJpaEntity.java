package com.numble.banking.user.adapter.out.persistence;

import com.numble.banking.common.domain.BaseTimeEntity;
import com.numble.banking.util.CryptoConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserJpaEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String loginId;

    @Column
    @Convert(converter = CryptoConverter.class)
    private String password;

    public UserJpaEntity(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
}
