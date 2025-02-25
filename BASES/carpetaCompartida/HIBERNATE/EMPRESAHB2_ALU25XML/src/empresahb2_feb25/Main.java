package empresahb2_feb25;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        //Operaciones.NewCurso("Java3",73);
        Operaciones.NewEdicion(12, Date.from(Instant.now().plusSeconds(1234567891)),"Palencia");
    }
}
