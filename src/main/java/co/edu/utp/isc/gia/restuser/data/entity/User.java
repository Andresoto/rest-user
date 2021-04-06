package co.edu.utp.isc.gia.restuser.data.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Andres Soto
 */
@AllArgsConstructor 
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "usuario")
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private String username;
    
    private String password;
    
    private String name;
    
    @Column(nullable = false)
    private String email;
        
    
}
