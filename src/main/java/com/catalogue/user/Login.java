package com.catalogue.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {
                @UniqueConstraint(name = "email_unique", columnNames = "email")
})
public class Login {
        @Id
        @SequenceGenerator(name = "login_sequence", sequenceName = "login_sequence", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "login_sequence")
        private Long id;
        private String email;
        private String password;
}