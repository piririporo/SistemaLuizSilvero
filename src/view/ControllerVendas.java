/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.LgsVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class ControllerVendas extends AbstractTableModel {

    private List lstVendas;

    public void setList(List lstVendas) {
        this.lstVendas = lstVendas;
    }
    
    public LgsVendas getBean(int rowIndex) {
        return (LgsVendas) lstVendas.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVendas.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LgsVendas vendas = (LgsVendas) lstVendas.get( rowIndex);
        if ( columnIndex == 0 ){
            return vendas.getLgsIdVendas();
        } else if (columnIndex ==1) {
            return vendas.getLgsDataVendas();        
        } else if (columnIndex ==2) {
            return vendas.getLgsTotal();
        } else if (columnIndex ==3) {
            return vendas.getLgsClientes().getLgsNome();
        }
        return ""; 
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Data";         
        } else if ( columnIndex == 2) {
            return "Total";
        } else if ( columnIndex == 3) {
            return "Cliente";
        } 
        return "";
    }
}
