// Import JPA annotations like @Entity, @Id, @GeneratedValue, @ManyToOne, @JoinColumn, etc.
import jakarta.persistence.*;

// Import Lombok annotations to automatically generate boilerplate code (getters, setters, constructors)
import lombok.*;

// Import Java's LocalDate class for date handling
import java.time.LocalDate;

// Marks this class as a JPA entity, meaning it maps to a database table
@Entity

// Lombok annotation to generate getter methods for all fields
@Getter

// Lombok annotation to generate setter methods for all fields
@Setter