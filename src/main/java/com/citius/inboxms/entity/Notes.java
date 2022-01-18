package com.citius.inboxms.entity;

import javax.ws.rs.DefaultValue;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notes")
public class Notes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long notesid;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date sendDate;
	@NotNull(message = "receievr Required")
	private String receiverName;
	private String senderName;
	@Check(constraints = "message<200")
	private String message;
	private String[] reply;
	@DefaultValue("false")
	private String urgencyLevel;
	@DefaultValue("false")
	private boolean deleted;
	@DefaultValue("false")
	private boolean read;

}
