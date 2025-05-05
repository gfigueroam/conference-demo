package com.pluralsight.spring_demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;

import java.sql.Types;
import java.util.List;

@Entity(name = "speakers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter @Setter @NoArgsConstructor
public class Speaker {

    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private @Id Long speaker_id;

    private String first_name;
    private String last_name;
    private String title;
    private String company;
    private String speaker_bio;

    @Lob
    @JdbcTypeCode(Types.BINARY)
    private byte[] speaker_photo;

    @ManyToMany (mappedBy = "speakers")
    @JsonIgnore
    private List<Session> sessions;

}
