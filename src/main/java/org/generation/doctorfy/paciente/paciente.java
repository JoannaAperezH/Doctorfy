package org.generation.doctorfy.paciente;

public class paciente {

	private int idPaciente;
	private String ocupacion;
	private int usuario_idUsuario;
	
	private static int total = 0;
	
	//Constructores
	public paciente(String ocupacion, int usuario_idUsuario) {
		super();
		total ++;
		this.idPaciente = total;
		this.ocupacion = ocupacion;
		this.usuario_idUsuario = usuario_idUsuario;
	}
	
	//Getters y setters
	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public int getUsuario_idUsuario() {
		return usuario_idUsuario;
	}

	public void setUsuario_idUsuario(int usuario_idUsuario) {
		this.usuario_idUsuario = usuario_idUsuario;
	}

	@Override
	public String toString() {
		return "paciente [idPaciente=" + idPaciente + ", ocupacion=" + ocupacion + ", usuario_idUsuario="
				+ usuario_idUsuario + "]";
	}
	
	
	
}
