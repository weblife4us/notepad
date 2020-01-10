package com.pad.note.entity;

import javax.persistence.*;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.pad.note.config.converter.*;


@Entity
@Table(name = "Users", uniqueConstraints = {@UniqueConstraint(columnNames = {"PID"})})
public class Clients {
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
        @Column(name = "Gender", nullable = false) @Convert(converter = PersonTypeConverter.class) private Type type;

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
        private Clients spouse;
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

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getPersonId() {
                return personId;
        }

        public void setPersonId(String personId) {
                this.personId = personId;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getPhoneNumber() {
                return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
        }


        public Type getType() {
                return type;
        }

        public void setType(Type type) {
                this.type = type;
        }

        public boolean isHasProvidedAuthorization() {
                return hasProvidedAuthorization;
        }

        public void setHasProvidedAuthorization(boolean hasProvidedAuthorization) {
                this.hasProvidedAuthorization = hasProvidedAuthorization;
        }

        public boolean isActiveClient() {
                return isActiveClient;
        }

        public void setActiveClient(boolean activeClient) {
                isActiveClient = activeClient;
        }

        public int getYearT1Done() {
                return yearT1Done;
        }

        public void setYearT1Done(int yearT1Done) {
                this.yearT1Done = yearT1Done;
        }

        public Clients getSpouse() {
                return spouse;
        }

        public void setSpouse(Clients spouse) {
                this.spouse = spouse;
        }

        public String getLoginName() {
                return loginName;
        }

        public void setLoginName(String loginName) {
                this.loginName = loginName;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public boolean isHasWebAccess() {
                return hasWebAccess;
        }

        public void setHasWebAccess(boolean hasWebAccess) {
                this.hasWebAccess = hasWebAccess;
        }

public enum Type {
        MALE("Male"), FEMALE("Female"), CORPORATION("Corporation");

        private String title;

        Type(String title) {
                this.title = title;
        }

        public String getTitle() {
                return title;
        }

        public static Type getByTitle(String title) {
                for (Type type : Type.values()) {
                        if (type.getTitle().equals(title)) {
                                return type;
                        }
                }
                return null;
        }
}

}
