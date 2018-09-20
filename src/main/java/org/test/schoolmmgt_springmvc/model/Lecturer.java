/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.test.schoolmmgt_springmvc.model;

/**
 *
 * @author ASUS
 */
import java.io.Serializable; 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "lecturer")
public class Lecturer implements Serializable {
 
    private static final long serialVersionUID = -3465813074586302847L;
 
    @Id
    private int lid;
 
    @Column
    private String lname;
 
    @Column
    private String lic;
 
    @Column
    private String lgender;
 
    @Column
    private int lcontact;
    
    @Column
    private String lemail;
    
    @Column
    private String subject;

    
    
    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLic() {
        return lic;
    }

    public void setLic(String lic) {
        this.lic = lic;
    }

    public String getLgender() {
        return lgender;
    }

    public void setLgender(String lgender) {
        this.lgender = lgender;
    }

    public int getLcontact() {
        return lcontact;
    }

    public void setLcontact(int lcontact) {
        this.lcontact = lcontact;
    }

    public String getLemail() {
        return lemail;
    }

    public void setLemail(String lemail) {
        this.lemail = lemail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
       
}