package org.cibertec.edu.pe.controller;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ventascab")
public class VentasCab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdVenta;
	private int IdCliente;
	
	@Temporal(TemporalType.DATE)
	private Date fechaVenta;
	private double montoVenta;

}
