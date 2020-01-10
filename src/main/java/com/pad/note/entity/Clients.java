package com.pad.note.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.go2it.frame.config.converter.PersonTypeConverter;
import com.go2it.frame.config.converter.StringToIntAttributeConverter;

@Entity
@Table(name = "Users", uniqueConstraints = {@UniqueConstraint(columnNames = {"PID"})})

public class Clients {
    public class Customer {
        //TODO clarify whether ID is required
        //	@GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id", updatable = false, nullable = false) private int id;
        @Transient
        private int id;
        @Id
        @Column(name = "PID", updatable = false, nullable = false, unique = true, length = 10)
        @Length(max = 10)
        private String personId;
        @Column(name = "PName", nullable = false, length = 100)
        @Length(max = 100)
        private String name;
        @Column(name = "PSecondN", nullable = false, length = 100)
        @Length(max = 100)
        private String secondname;
        @Column(name = "PAge", nullable = false)
        private String age;
        //TODO clarify the best way to do it - circular dependency
        @Column(name = "PPhone", nullable = false, length = 150)
        @Length(max = 50)
        private String phoneNumber;
        @Column(name = "Gender", nullable = false)
        @Convert(converter = PersonTypeConverter.class)
        private Type type;

        //to preserve the String value of enum (default ordinal)

        @Column(name = "Auth")
        @org.hibernate.annotations.Type(type = "numeric_boolean")
        private boolean hasProvidedAuthorization;
        @Column(name = "Gone")
        @org.hibernate.annotations.Type(type = "numeric_boolean")
        private boolean isActiveClient;
        @Column(name = "T1Done", length = 4)
        @Convert(converter = StringToIntAttributeConverter.class)
        private int yearT1Done;
        //TODO check cascade

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "SPID", referencedColumnName = "PID")
        private Customer spouse;
        @Column(name = "LoginName", length = 64)
        @Length(max = 64)
        private String loginName;
        @Column(name = "LoginPW", length = 64)
        @Length(max = 64)
        @JsonIgnore
        private String password;
        @Column(name = "WebAccess", columnDefinition = "boolean")
        @org.hibernate.annotations.Type(type = "numeric_boolean")
        private boolean hasWebAccess;
    }
}