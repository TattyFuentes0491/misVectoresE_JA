/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class miVecProductos {

    producto lstProductos[];
    int tam;

    public miVecProductos(JTextField jtfNElem) {
        tam = Integer.parseInt(jtfNElem.getText());
        lstProductos = new producto[tam];
        //inicializamos
        for (int i = 0; i < tam; i++) {
            lstProductos[i] = new producto(-1, "", -1);
        }
        JOptionPane.showMessageDialog(null, "Vectores Inicializados!");
    }
    
    public int getPosID(int id) { //metodo buscar
        int i;
        for (i = 0; i < tam; i++) {
            //for(i=0; i<lstProductos.length; i++ ){
            if (lstProductos[i].codP == id) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean setAddProducto(JTextField jtfID, JTextField jtfNomP, JTextField jtfCosto, int posActual) {
        int id, pos;
        boolean agrego=false; 
        id = Integer.parseInt(jtfID.getText());
        pos = getPosID(id);
        if (pos != -1) {
            JOptionPane.showMessageDialog(null, "El idProducto ya se encuentra registrado! - Intente nuevamente!");
            jtfID.setText("");
            jtfID.requestFocus();
            agrego=false;
        } else {
            lstProductos[posActual].codP = Integer.parseInt(jtfID.getText());
            lstProductos[posActual].nomP = jtfNomP.getText();
            lstProductos[posActual].precioU = Float.parseFloat(jtfCosto.getText());
            JOptionPane.showMessageDialog(null, "Producto Ingresado correctamente!.");
            jtfID.setText("");
            jtfNomP.setText(""); 
            jtfCosto.setText(""); 
            jtfID.requestFocus();
            agrego=true;
        }
        return agrego;
    }
    
    //Producto más costoso
    public void getMasCostoso() {
        int i;
        int posM = 0;
        float miMayor = lstProductos[0].precioU;

        for (i = 0; i < lstProductos.length; i++) {
            if (lstProductos[i].precioU > miMayor) {
                miMayor = lstProductos[i].precioU;
                posM = i;
            }
        }
        JOptionPane.showMessageDialog(null,"El producto MAS costoso es ");
        getPos(posM);
    }
    
    //Producto con el menor precio
    public void getMenosCostoso() {
        int i;
        int posM = 0;
        float miMenor = lstProductos[0].precioU;

        for (i = 0; i < lstProductos.length; i++) {
            if (lstProductos[i].precioU < miMenor) {
                miMenor = lstProductos[i].precioU;
                posM = i;
            }
        }
        JOptionPane.showMessageDialog(null,"El producto MENOS costoso es ");
        getPos(posM);
    }
    
    //Mostrar información a partir de la posición
    public void getPos(int pos) {
        String info = "Producto: \n";
        if ((pos >= 0) && (pos < tam)) {
            info += "Código:" + lstProductos[pos].codP + "\n";
            info += "Nombre:" + lstProductos[pos].nomP + "\n";
            info += "Precio" + lstProductos[pos].precioU + "\n";
            JOptionPane.showMessageDialog(null, info);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Esta posición no existe o es invalida!!");
        }
    }
    
    //Promedio de precios
    public void calculos() {
        float prom = 0;
        float sumaTotal = 0;
        for (int i = 0; i < lstProductos.length; i++) {
            sumaTotal = sumaTotal + lstProductos[i].precioU;
        }
        prom = sumaTotal / lstProductos.length;
        JOptionPane.showMessageDialog(null,
                "La suma total de los precios es : " + sumaTotal + " !!!");
        JOptionPane.showMessageDialog(null,
                "El promedio de los precios es : " + prom + " !!!");
    }
    
    public void setEliminarDato(int codPrd) {
        int pos = getPosID(codPrd);
        if (pos != -1) {
            lstProductos[pos].codP = -1;
            lstProductos[pos].nomP = "";
            lstProductos[pos].precioU = -1;
            JOptionPane.showMessageDialog(null,
                    "Elemento borrado!!!");
        }
    }
    
    public void setModificarDato(int pos,
            String nombreP, float totales) {
        lstProductos[pos].nomP = nombreP;
        lstProductos[pos].precioU = totales;
        JOptionPane.showMessageDialog(null, "Elemento modificado!!!");
    }
    
    //Este método registra un dato al JTable
    //teniendo en cuenta el tipo de Persona
    public void setRegistrarFilaJTable(DefaultTableModel miModelo, int Fila, int indiceArray) {
        miModelo.setValueAt(lstProductos[indiceArray].codP, Fila, 0);
        miModelo.setValueAt(lstProductos[indiceArray].nomP, Fila, 1);
        miModelo.setValueAt(lstProductos[indiceArray].precioU, Fila, 2);
    }   
    
    //Este método actualiza el contenido de la fila
    //de un JTable a partir de su modelo de datos 
    //(JTableModel)
    public void setLlenarJTable(JTable tab) {
        int indice = 0; //Este índice recorre los elementos del ArrayList
        int i = 0;  //Este índice para ubicar posición de fila en el JTable
        DefaultTableModel miModelo = new DefaultTableModel();
        miModelo.addColumn("Codigo");
        miModelo.addColumn("Nombre");
        miModelo.addColumn("Precio");
        while (indice < lstProductos.length) {
            miModelo.addRow(new Object[]{"", "", ""});
            setRegistrarFilaJTable(miModelo, i, indice);
            i++;
            indice++;
        }
        tab.setModel(miModelo);
    }
    
}
