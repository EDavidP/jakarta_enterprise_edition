//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.11.09 at 06:57:34 PM WET 
//


package generated;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}title"/&gt;
 *         &lt;element ref="{}authors" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{}publicationDate"/&gt;
 *         &lt;element ref="{}newsletter"/&gt;
 *         &lt;element ref="{}edition"/&gt;
 *         &lt;element ref="{}pages"/&gt;
 *         &lt;element ref="{}totalCitation"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "title",
    "authors",
    "publicationDate",
    "newsletter",
    "edition",
    "pages",
    "totalCitation"
})
@XmlRootElement(name = "publication")
@Entity
@Table(name = "publication")
public class Publication implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @XmlTransient
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publication_id")
    private long id;

    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    @ElementCollection
    protected List<String> authors;
    @XmlElement(required = true)
    protected int publicationDate;
    @XmlElement(required = true)
    protected String newsletter;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String edition;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String pages;
    @XmlElement(required = true)
    protected int totalCitation;
    
 
    
    public Long getId() {
        return id; 
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
    


    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the authors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAuthors() {
        if (authors == null) {
            authors = new ArrayList<String>();
        }
        return this.authors;
    }

    /**
     * Gets the value of the publicationDate property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public int getPublicationDate() {
        return publicationDate;
    }

    /**
     * Sets the value of the publicationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPublicationDate(int value) {
        this.publicationDate = value;
    }

    /**
     * Gets the value of the newsletter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewsletter() {
        return newsletter;
    }

    /**
     * Sets the value of the newsletter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewsletter(String value) {
        this.newsletter = value;
    }

    /**
     * Gets the value of the edition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEdition() {
        return edition;
    }

    /**
     * Sets the value of the edition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEdition(String value) {
        this.edition = value;
    }

    /**
     * Gets the value of the pages property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPages() {
        return pages;
    }

    /**
     * Sets the value of the pages property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPages(String value) {
        this.pages = value;
    }

    /**
     * Gets the value of the totalCitation property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public int getTotalCitation() {
        return totalCitation;
    }

    /**
     * Sets the value of the totalCitation property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalCitation(int value) {
        this.totalCitation = value;
    }

}
