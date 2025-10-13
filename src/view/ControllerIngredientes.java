/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.LgsIngredientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class ControllerIngredientes extends AbstractTableModel {

    private List lstIngredientes;

    public void setList(List lstUsuarios) {
        this.lstIngredientes = lstUsuarios;
    }
    
    public LgsIngredientes getBean(int rowIndex) {
        return (LgsIngredientes) lstIngredientes.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstIngredientes.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LgsIngredientes produto = (LgsIngredientes) lstIngredientes.get( rowIndex);
        if ( columnIndex == 0 ){
            return produto.getLgsIdIngredientes();
        } else if (columnIndex ==1) {
            return produto.getLgsNome();
        } else if (columnIndex ==2) {
            return produto.getLgsCategoria();        
        } else if (columnIndex ==3) {
            return produto.getLgsDataValidade();
        } 
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "Categoria";
        } else if ( columnIndex == 3) {
            return "Data de Validade";
        } 
        return "";
    }
}
