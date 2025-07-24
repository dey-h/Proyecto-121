/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parqueo_inteligente.newpackage;

/**
 *
 * @author HP
 */
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AddObjectOutputStream extends ObjectOutputStream {
    public AddObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected void writeStreamHeader() throws IOException {
        reset();
    }
}
