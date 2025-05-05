package com.pluralsight.spring_demo.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "sessions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Setter @Getter @NoArgsConstructor
public class Session {

    @Column(name = "session_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id Long sessionId;

    private String session_name;
    private String session_description;
    private Integer session_length;

    @ManyToMany
    @JoinTable(
            name="session_speakers",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name="speaker_id"))
    private List<Speaker> speakers;

    public boolean isParameterEmpty(){
        return session_name.isEmpty() ||
                session_description.isEmpty() ||
                session_length.describeConstable().isEmpty();
    }

    public String toString() {
        return "Session{name='" + session_name + "', sessionId=" + sessionId + '}';
    }

}
