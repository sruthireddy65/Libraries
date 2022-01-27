package com.self.libraries.apacheavro.serde;

import com.self.libraries.apacheavro.generated.Employees;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.io.JsonEncoder;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class EmployeesAvroSerDe {
    public String serializeToJson(Employees employees) throws IOException {
        SpecificDatumWriter<Employees> writer = new SpecificDatumWriter<>();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        JsonEncoder encoder = EncoderFactory.get().jsonEncoder(Employees.getClassSchema(), stream);
        writer.write(employees, encoder);
        encoder.flush();
        return stream.toString("UTF-8");
    }
}
