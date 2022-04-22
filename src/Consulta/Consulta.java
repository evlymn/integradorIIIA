package Consulta;

import Medico.Medico;
import Paciente.Paciente;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Consulta {
    int id;
    Medico medico;
    Paciente paciente;
    Date dataConsulta;

    public Consulta(Medico medico, Paciente paciente, Date dataConsulta) {
        this.id = Calendar.getInstance().getTime().hashCode();
        this.medico = medico;
        this.paciente = paciente;
        this.dataConsulta = dataConsulta;
    }

    public int getId() {
        return id;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public String getDataConsultaFormatted() {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(dataConsulta);
    }

    @Override
    public String toString() {

        return String.format("Id:%s Medico: %s, Paciente: %s, Data: %s", getId(), getMedico().getNome(), getPaciente().getNome(), getDataConsultaFormatted());
    }
}
