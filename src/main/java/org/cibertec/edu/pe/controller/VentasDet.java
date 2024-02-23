package org.cibertec.edu.pe.controller;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ventasdet")
public class VentasDet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdDetalle;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdVenta")
	private VentasCab venta;
}
